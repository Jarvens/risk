package com.scorpion.risk.api.controller;

import com.scorpion.risk.annotation.RequestLimit;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.util.HttpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2017/9/18.
 */
@RestController
@RequestMapping("api")
public class DonationController {


    /**
     * 根据献血证号查询
     * @param donationId
     * @return
     */
    @RequestLimit(count = 20,time = 60000,config = false)
    @RequestMapping(value = "/donation/query",method = RequestMethod.GET)
    public BaseResult query(String donationId){
        String response = HttpUtil.get(donationId);

        return null;
    }


}
