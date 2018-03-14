package com.manre.airappproject.fragment.home;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import com.manre.airappproject.R;
import com.manre.airappproject.common.GlideImageLoader;
import com.manre.airappproject.fragment.BaseFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    Banner banner;
    TabLayout mHomeSearchConditionTab;
    BaseFragment currentFragment;

    private Fragment homeTabOneWayFragment,homeTabRoundTripFragment;
    private FragmentManager homeSearchManager;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View homeView=inflater.inflate(R.layout.fragment_home, container, false);
        banner =homeView.findViewById(R.id.home_advertisement_banner);
        mHomeSearchConditionTab=homeView.findViewById(R.id.home_search_condition_tab);
        initPicture();
        initSearchTab();
        return homeView;
    }

    /*
     * 广告部分的实现
    */

    private List<Integer> getImages()
    {

        List<Integer> images=new ArrayList<>();
        images.add(R.drawable.advertisement1);
        images.add(R.drawable.advertisement2);
        images.add(R.drawable.advertisement3);
        return images;
    }

    private void initPicture()
    {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(getImages());
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();
    }

    /**
     *  查询机票tab 的实现
     */
    private void initSearchTab()
    {

        mHomeSearchConditionTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition())
                {
                    case 0:
                        currentFragment=addFragment(new HomeTabOneWayFragment(),"TabOneWay",R.id.home_search_condition_tab_form,currentFragment);
                        Toast toast = Toast.makeText(getActivity(),"你点击了tab1", Toast.LENGTH_SHORT);//提示被点击了
                        toast.show();
                        break;
                    case 1:
                        currentFragment=addFragment(new HomeTabRoundTripFragment(),"TabRoundTrip",R.id.home_search_condition_tab_form,currentFragment);
                        Toast toast1 = Toast.makeText(getActivity(),"你点击了tab2", Toast.LENGTH_SHORT);//提示被点击了
                        toast1.show();
                        break;
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mHomeSearchConditionTab.addTab(mHomeSearchConditionTab.newTab().setText(R.string.tab_home_search_one_way),true);
        mHomeSearchConditionTab.addTab(mHomeSearchConditionTab.newTab().setText(R.string.tab_home_search_round_trip));

    }

    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }
}
