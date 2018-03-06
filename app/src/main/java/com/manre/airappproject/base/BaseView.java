package com.manre.airappproject.base;

/**
 * Created by manre on 28/02/2018.
 */

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

}