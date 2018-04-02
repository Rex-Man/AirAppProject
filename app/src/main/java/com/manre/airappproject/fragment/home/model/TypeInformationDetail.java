package com.manre.airappproject.fragment.home.model;

/**
 * Created by manre on 02/04/2018.
 */

public class TypeInformationDetail {
    private int id;
    private int imageDrawableBigId;//图片的drawableID
    private int informationType; //是属于那一类的informationType信息

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageDrawableBigId() {
        return imageDrawableBigId;
    }

    public void setImageDrawableBigId(int imageDrawableBigId) {
        this.imageDrawableBigId = imageDrawableBigId;
    }

    public int getInformationType() {
        return informationType;
    }

    public void setInformationType(int informationType) {
        this.informationType = informationType;
    }
}
