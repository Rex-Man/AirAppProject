package com.manre.airappproject.fragment.home.model;

import java.util.List;

/**
 * Created by manlimeng on 2018/3/29.
 */

public class TypeInformation {
    private Long id;
    private List<TypeInformationDetail> typeInformationDetails;
    private int chooseFregment;// 是需要选择哪一个fregment,
    private String title;//显示的标题是什么

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TypeInformationDetail> getTypeInformationDetails() {
        return typeInformationDetails;
    }

    public void setTypeInformationDetails(List<TypeInformationDetail> typeInformationDetails) {
        this.typeInformationDetails = typeInformationDetails;
    }

    public int getChooseFregment() {
        return chooseFregment;
    }

    public void setChooseFregment(int chooseFregment) {
        this.chooseFregment = chooseFregment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
