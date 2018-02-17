package com.yopselmopsel.service.dto;

public class PartOrderDTO {
    private Long partPrice;
    private int numberOfGood;
    private String goodName;

    public Long getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(Long partPrice) {
        this.partPrice = partPrice;
    }

    public int getNumberOfGood() {
        return numberOfGood;
    }

    public void setNumberOfGood(int numberOfGood) {
        this.numberOfGood = numberOfGood;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public PartOrderDTO(Long partPrice, int numberOfGood, String goodName) {
        this.partPrice = partPrice;
        this.numberOfGood = numberOfGood;
        this.goodName = goodName;
    }
}

