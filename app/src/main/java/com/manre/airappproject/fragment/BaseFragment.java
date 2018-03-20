package com.manre.airappproject.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by manre on 14/03/2018.
 */

public class BaseFragment extends Fragment {



//    public BaseFragment  addFragment ( BaseFragment addFragment ,String fragmentTag,int replaceFrameLayout,BaseFragment currentFragment)
//    {
//
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        BaseFragment tempFragment= (BaseFragment) fragmentManager.findFragmentByTag(fragmentTag);
//        if(tempFragment!=null){
//            addFragment = tempFragment;
//        }
//        if(addFragment.isAdded()){
//            currentFragment=addOrShowFragment(fragmentTransaction,addFragment,replaceFrameLayout,fragmentTag,currentFragment);
//        }else{
//            if(currentFragment!=null && currentFragment.isAdded()){
//                fragmentTransaction.hide(currentFragment).add(replaceFrameLayout, addFragment,fragmentTag).commit();
//            }else{
//                fragmentTransaction.add(replaceFrameLayout, addFragment,fragmentTag).commit();
//            }
//            currentFragment = addFragment;
//        }
//        return currentFragment;
//    }
//
//    public  BaseFragment addOrShowFragment(FragmentTransaction transaction, BaseFragment fragment, int replaceFrameLayout, String fragmentTag,BaseFragment currentFragment) {
//        //if(currentFragment == fragment)
//        //    return currentFragment;
//        if (!fragment.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
//            transaction.hide(currentFragment).add(replaceFrameLayout, fragment,fragmentTag).commit();
//        } else {
//            transaction.hide(currentFragment).show(fragment).commit();
//        }
//        currentFragment.setUserVisibleHint(false);
//        currentFragment =  fragment;
//        currentFragment.setUserVisibleHint(true);
//        return currentFragment;
//    }



}
