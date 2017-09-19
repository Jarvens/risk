package com.scorpion.risk.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.scorpion.risk.annotation.RequestLimit;
import com.scorpion.risk.api.entity.DonatorExt;
import com.scorpion.risk.api.entity.DonatorResponse;
import com.scorpion.risk.api.service.DonationService;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.util.HttpUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("api")
public class DonationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DonationController.class);

    @Autowired
    private DonationService donationService;

    /**
     * 根据献血证号查询
     *
     * @param donationId
     * @return
     */
    @ApiOperation(value = "献血接口", notes = "根据献血证号查询献血记录")
    @RequestLimit(count = 20, time = 60000, config = false)
    @RequestMapping(value = "/donation/query", method = RequestMethod.GET)
    public BaseResult query(String donationId) {
        String response = HttpUtil.get(donationId);
        DonatorResponse donatorResponse = JSONObject.parseObject(response, DonatorResponse.class);

        System.out.println(donatorResponse.toString());

        return null;
    }

    /**
     * 将文本数据  donatorId 入库
     *
     * @param path
     * @return
     */
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
