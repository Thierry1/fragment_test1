package com.example.fragment_test;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Context context) {
        Log.e("TAG","onAttach");
        super.onAttach(context);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e("TAG","onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onStart() {
        Log.e("TAG","onStart");
        super.onStart();
    }


    @Override
    public void onResume() {
        Log.e("TAG","onResume");
        super.onResume();
    }


    @Override
    public void onPause() {
        Log.e("TAG","onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e("TAG","onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.e("TAG","onDestroy");
        super.onDestroy();
    }


    @Override
    public void onDestroyView() {
        Log.e("TAG","onDestroyView");
        super.onDestroyView();
    }


    @Override
    public void onDetach() {
        Log.e("TAG","onDetach");
        super.onDetach();
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG","onCreate");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("TAG","onCreateView");
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}