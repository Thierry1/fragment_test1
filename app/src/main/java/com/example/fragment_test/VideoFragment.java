package com.example.fragment_test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VideoFragment() {
        // Required empty public constructor
    }


    /**
     *  1. ViewPager嵌套Fragmment情况       每次会走 setUserVisibleHint()   不是每一次都走start()因为有预加载
     *  不会走onHiddenChanged（）
     *  2.replace()切换Fra'gment    每次切换都会走 onStart()    不会走setUserVisibleHint(),onHiddenChanged()
     *  3.add(),hide(),show()切换Fragment   每次都会走onHiddenChanged()
     *  初始化的时候会走onStart   其他情况不会走onStart() 不会走setUserVisibleHint()
     *
     *
     *
     */

    @Override
    public void onStart() {
        //initData();
        super.onStart();
    }

    //懒加载      只有在ViewPager嵌套Fragment的情况下才会走这个方法
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if(isVisibleToUser){//可见

        }else{//不可见

        }

        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            //当前VideoFragment隐藏了
            hideData();
        }else{
            //当前VideoFragment显示了
            showData();
        }

    }

    private void showData() {
        Log.e("TAG","VideoFragment显示了");  //加载数据

    }

    private void hideData() {
        Log.e("TAG","VideoFragment隐藏了");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoFragment newInstance(String param1, String param2) {
        VideoFragment fragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false);
    }
}