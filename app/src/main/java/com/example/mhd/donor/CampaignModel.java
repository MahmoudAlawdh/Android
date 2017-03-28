package com.example.mhd.donor;

/**
 * Created by mhd on 3/27/17.
 *
 * from table
 *  call for donation
 */

public class CampaignModel {

    private int CFDId; //  call for donation id
    private String name;
    private String StartDate;
    private String EndDate;
    private String LocationName;
    private String LLate;
    private String LLong;
    private String BloodType;

    public CampaignModel(int CFDId, String name, String startDate, String endDate, String locationName, String LLate, String LLong, String bloodType) {
        this.setCFDId(CFDId);
        this.setName(name);
        setStartDate(startDate);
        setEndDate(endDate);
        setLocationName(locationName);
        this.setLLate(LLate);
        this.setLLong(LLong);
        setBloodType(bloodType);
    }

    public int getCFDId() {
        return CFDId;
    }

    public void setCFDId(int CFDId) {
        this.CFDId = CFDId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }

    public String getLLate() {
        return LLate;
    }

    public void setLLate(String LLate) {
        this.LLate = LLate;
    }

    public String getLLong() {
        return LLong;
    }

    public void setLLong(String LLong) {
        this.LLong = LLong;
    }

    public String getBloodType() {
        return BloodType;
    }

    public void setBloodType(String bloodType) {
        BloodType = bloodType;
    }
}
