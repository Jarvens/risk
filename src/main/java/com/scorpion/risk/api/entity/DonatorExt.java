package com.scorpion.risk.api.entity;

import java.util.List;

/**
 * Created on 2017/9/18.
 */
public class DonatorExt {

    //献血人
    private Donator donator;

    //献血记录
    private List<Donation> donationList;

    public Donator getDonator() {
        return donator;
    }

    public void setDonator(Donator donator) {
        this.donator = donator;
    }

    public List<Donation> getDonationList() {
        return donationList;
    }

    public void setDonationList(List<Donation> donationList) {
        this.donationList = donationList;
    }

    @Override
    public String toString() {
        return "DonatorExt{" +
                "donator=" + donator +
                ", donationList=" + donationList +
                '}';
    }
}
