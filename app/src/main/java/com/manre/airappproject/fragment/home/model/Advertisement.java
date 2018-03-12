package com.manre.airappproject.fragment.home.model;

/**
 * Created by manre on 12/03/2018.
 */

public class Advertisement {
    private String id;
    private String advertiseTitle;
    private String advertisePicPath;
    private byte[] advertisementFile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdvertiseTitle() {
        return advertiseTitle;
    }

    public void setAdvertiseTitle(String advertiseTitle) {
        this.advertiseTitle = advertiseTitle;
    }

    public String getAdvertisePicPath() {
        return advertisePicPath;
    }

    public void setAdvertisePicPath(String advertisePicPath) {
        this.advertisePicPath = advertisePicPath;
    }

    public byte[] getAdvertisementFile() {
        return advertisementFile;
    }

    public void setAdvertisementFile(byte[] advertisementFile) {
        this.advertisementFile = advertisementFile;
    }
}
