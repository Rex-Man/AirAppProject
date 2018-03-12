package com.manre.airappproject.fragment.home.retrofitinterface;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.manre.airappproject.common.Page;
import com.manre.airappproject.common.ResponseEntity;
import com.manre.airappproject.fragment.home.model.*;

/**
 * Created by manre on 12/03/2018.
 */

public interface AdvertisementInterface {

    @GET("getAdvertisementListPage")
    Call<ResponseEntity<Page<Advertisement>>> getAdvertisementListPage(@Query("currentPage") Integer currentPage, @Query("pageSize") Integer pageSize);
}
