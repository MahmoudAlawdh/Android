package com.example.mhd.donor;

/**
 * Created by mhd on 3/27/17.
 *
 * from table donation records
 *
 *
 *
 */

public class MyAppointmentModel {

    private int DonationId;
    private int DonorCivilId;
    private String DDate;
    private String DonationDestination;
    private String DnBloodType;

    public MyAppointmentModel(int donationId, int donorCivilId, String DDate, String donationDestination, String dnBloodType) {
        setDonationId(donationId);
        setDonorCivilId(donorCivilId);
        this.setDDate(DDate);
        setDonationDestination(donationDestination);
        setDnBloodType(dnBloodType);
    }

    public int getDonationId() {
        return DonationId;
    }

    public void setDonationId(int donationId) {
        DonationId = donationId;
    }

    public int getDonorCivilId() {
        return DonorCivilId;
    }

    public void setDonorCivilId(int donorCivilId) {
        DonorCivilId = donorCivilId;
    }

    public String getDDate() {
        return DDate;
    }

    public void setDDate(String DDate) {
        this.DDate = DDate;
    }

    public String getDonationDestination() {
        return DonationDestination;
    }

    public void setDonationDestination(String donationDestination) {
        DonationDestination = donationDestination;
    }

    public String getDnBloodType() {
        return DnBloodType;
    }

    public void setDnBloodType(String dnBloodType) {
        DnBloodType = dnBloodType;
    }
}
