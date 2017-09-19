package com.scorpion.risk.api.entity;

import java.util.List;

/**
 * Created on 2017/9/19.
 */
public class ApiResponse {

    private Donator donator;

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
        return "ApiResponse{" +
                "donator=" + donator +
                ", donationList=" + donationList +
                '}';
    }
}
