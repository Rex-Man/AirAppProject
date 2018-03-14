package com.manre.airappproject.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by manre on 14/03/2018.
 */

public class BaseFragment extends Fragment {



    public BaseFragment  addFragment ( BaseFragment addFragment ,String fragmentTag,int replaceFrameLayout,BaseFragment currentFragment)
    {

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BaseFragment tempFragment= (BaseFragment) fragmentManager.findFragmentByTag(fragmentTag);
        if(tempFragment!=null){
            addFragment = tempFragment;
        }
        if(addFragment.isAdded()){
            currentFragment=addOrShowFragment(fragmentTransaction,addFragment,replaceFrameLayout,fragmentTag,currentFragment);
        }else{
            if(currentFragment!=null && currentFragment.isAdded()){
                fragmentTransaction.hide(currentFragment).add(replaceFrameLayout, addFragment,fragmentTag).commit();
            }else{
                fragmentTransaction.add(replaceFrameLayout, addFragment,fragmentTag).commit();
            }
            currentFragment = addFragment;
        }
        return currentFragment;
    }

    public  BaseFragment addOrShowFragment(FragmentTransaction transaction, BaseFragment fragment, int replaceFrameLayout, String fragmentTag,BaseFragment currentFragment) {
        if(currentFragment == fragment)
            return currentFragment;
        if (!fragment.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
            transaction.hide(currentFragment).add(replaceFrameLayout, fragment,fragmentTag).commit();
        } else {
            transaction.hide(currentFragment).show(fragment).commit();
        }
        currentFragment.setUserVisibleHint(false);
        currentFragment =  fragment;
        currentFragment.setUserVisibleHint(true);
        return currentFragment;
    }
//    private void addFragment(String fTag) {
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        //判断这个标签是否存在Fragment对象,如果存在则返回，不存在返回null
//        Fragment fragment = (BaseFragment) fragmentManager.findFragmentByTag(fTag);
//        // 如果这个fragment不存于栈中
//        if (fragment == null) {
//            //根据RaioButton点击的Button传入的tag，实例化，添加显示不同的Fragment
//            if (fTag.equals("home")) {
//                fragment = new HomeFragment();
//            } else if (fTag.equals("help")) {
//                fragment = new HelpFragment();
//            } else if (fTag.equals("setting")) {
//                fragment = new SettingFragment();
//            }
//            //在添加之前先将上一个Fragment隐藏掉
//            if (currentFragment != null) {
//                transaction.hide(currentFragment);
//            }
//            transaction.add(R.id.main_fram, fragment, fTag);
//            transaction.commit();
//            //更新可见
//            currentFragment = fragment;
//        } else {
//            //如果添加的Fragment已经存在，则将隐藏掉的Fragment再次显示,其余当前
//            transaction = manager.beginTransaction();
//            transaction.show(fragment);
//            transaction.hide(currentFragment);
//            //更新可见
//            currentFragment = fragment;
//            transaction.commit();
//
//
//        }
//
//
//    }


}
