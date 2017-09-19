package com.scorpion.risk.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.scorpion.risk.annotation.RequestLimit;
import com.scorpion.risk.api.entity.Donation;
import com.scorpion.risk.api.entity.DonationResponse;
import com.scorpion.risk.api.entity.Donator;
import com.scorpion.risk.api.entity.DonatorExt;
import com.scorpion.risk.api.entity.DonatorResponse;
import com.scorpion.risk.api.service.DonationService;
import com.scorpion.risk.api.service.DonatorService;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.util.HttpUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2017/9/18.
 */
@RestController
@ApiModel(value = "献血者")
@RequestMapping("api")
public class DonationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DonationController.class);

    @Autowired
    private DonationService donationService;

    @Autowired
    private DonatorService donatorService;

    /**
     * 根据献血证号查询
     *
     * @param certificateId
     * @param name
     * @param mobile
     * @return
     */
    @ApiOperation(value = "根据身份证|姓名|手机号查询数据")
    @RequestLimit(count = 20, time = 60000, config = false)
    @RequestMapping(value = "/donation/query", method = RequestMethod.GET)
    public BaseResult query(String certificateId, String name, String mobile) {
        return donationService.findByCondition(certificateId, name, mobile);
    }

    /**
     * 调用滨江数据 初始化
     *
     * @return
     */
    @ApiIgnore
    @RequestMapping(value = "/donation/dataInit", method = RequestMethod.GET)
    public BaseResult dataInit() {

        //当前时间
        Long startTime = System.currentTimeMillis();

        //查询所有献血证ID
        List<String> idList = donationService.findAll();
        //循环调用接口
        for (int i = 0; i < idList.size(); i++) {
            String id = idList.get(i);
            LOGGER.info("【接口调用开始:第" + i + "次】" + "【开始时间:" + startTime + "】");
            String response = HttpUtil.get(id);
            if (null == response) {
                continue;
            }
            //献血者对象
            DonatorResponse doResponse = JSONObject.parseObject(response, DonatorResponse.class);
            //献血记录对象
            List<DonationResponse> donationResponseList = doResponse.getDonationList();
            //TODO  录入献血人信息
            Donator donator = new Donator();
            donator.setAbo(doResponse.getABO());
            donator.setDonorId(doResponse.getDonorId());
            donator.setName(doResponse.getName());
            donator.setSex(doResponse.getSex());
            donator.setAge(doResponse.getAge());
            donator.setCertificateId(doResponse.getCertificateID());
            donator.setCertificateType(doResponse.getCertificateType());
            donator.setMobileTelePhone(doResponse.getMobileTelePhone());
            donator.setTelePhone(doResponse.getTelePhone());
            donator.setDonationTotalVolumes(doResponse.getDonationTotalVolumes());
            donator.setLastDonationDate(donator.getLastDonationDate());
            donatorService.add(donator);
            //TODO  录入献血记录
            if (null != donationResponseList && donationResponseList.size() > 0) {
                for (DonationResponse donationResponse : donationResponseList) {
                    Donation donation = new Donation();
                    donation.setDonationId(donationResponse.getDonationID());
                    donation.setDonationDate(donationResponse.getDonationDate());
                    donation.setCollectionType(donationResponse.getCollectionType());
                    donation.setDonationVolumes(donationResponse.getDonationVolumes());
                    donation.setDonatorId(donator.getId());
                    donationService.add(donation);
                }
            }
            Long endTime = System.currentTimeMillis();
            LOGGER.info(
                    "【接口调用结束:第" + i + "次】" + "【结束时间:" + endTime + "】" + "耗时:" + ((endTime - startTime) / 1000) + "秒");
        }
        return null;
    }

    /**
     * 将文本数据  donatorId 入库
     *
     * @param path
     * @return
     */
    @ApiIgnore
    @RequestMapping(value = "/donation/importDonatorTxt", method = RequestMethod.GET)
    public BaseResult importDonatorTxt(String path) throws IOException {
        File file = new File("/Users/kunlun/Downloads/报销记录/" + path);
        List<String> donationIdList = new ArrayList<>();
        if (file.isFile() && file.exists()) {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strLine = line.split(",");
                String[] ids = strLine[8].toString().split("/");
                if (ids.length != 0) {
                    donationIdList.addAll(Arrays.asList(ids));

                }
            }
            LOGGER.info("idList:" + donationIdList);
            LOGGER.info("献血证编号数量:" + donationIdList.size());
        }
        return donationService.addDonationId(donationIdList);
    }


}
