package com.manre.airappproject.fragment.home;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
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
    RecyclerView mRecyclerView;

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
        mRecyclerView=homeView.findViewById(R.id.home_list_button);
        initPicture();
        initSearchTab();
        initEasyButton();
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
                        //currentFragment=addFragment(new HomeTabOneWayFragment(),"TabOneWay",R.id.home_search_condition_tab_form,currentFragment);
                        addFragmentSearch("TabOneWay");
                        Toast toast = Toast.makeText(getActivity(),"你点击了tab1", Toast.LENGTH_SHORT);//提示被点击了
                        toast.show();
                        break;
                    case 1:
                        //currentFragment=addFragment(new HomeTabRoundTripFragment(),"TabRoundTrip",R.id.home_search_condition_tab_form,currentFragment);
                        addFragmentSearch("TabRoundTrip");
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
        if(mHomeSearchConditionTab.getTabAt(0)==null) {
            mHomeSearchConditionTab.addTab(mHomeSearchConditionTab.newTab().setText(R.string.tab_home_search_one_way), true);
        }
        if(mHomeSearchConditionTab.getTabAt(1)==null) {
            mHomeSearchConditionTab.addTab(mHomeSearchConditionTab.newTab().setText(R.string.tab_home_search_round_trip));
        }

    }

    /**
     *  初始化基本功能button
     */
    private void initEasyButton()
    {
        GridLayoutManager layoutManage = new GridLayoutManager(getContext(), 4);
        mRecyclerView.setLayoutManager(layoutManage);



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

    private void addFragmentSearch(String fTag) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //判断这个标签是否存在Fragment对象,如果存在则返回，不存在返回null
        BaseFragment fragment = (BaseFragment) fragmentManager.findFragmentByTag(fTag);
        // 如果这个fragment不存于栈中
        if (fragment == null) {
            //根据RaioButton点击的Button传入的tag，实例化，添加显示不同的Fragment
            if (fTag.equals("TabOneWay")) {
                fragment = new HomeTabOneWayFragment();
            } else if (fTag.equals("TabRoundTrip")) {
                fragment = new HomeTabRoundTripFragment();
            }
            //在添加之前先将上一个Fragment隐藏掉
            if (currentFragment != null) {
                //fragmentTransaction.remove(currentFragment);
                fragmentTransaction.hide(currentFragment);
            }
            fragmentTransaction.add(R.id.home_search_condition_tab_form, fragment, fTag);
            fragmentTransaction.commit();
            //更新可见
            currentFragment = fragment;
        } else {
            //如果添加的Fragment已经存在，则将隐藏掉的Fragment再次显示,其余当前
            fragmentTransaction.hide(currentFragment);
            fragmentTransaction.show(fragment);
            fragmentTransaction.commit();
            //更新可见
            currentFragment = fragment;


        }


    }
}
