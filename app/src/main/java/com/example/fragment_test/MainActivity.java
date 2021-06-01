package com.example.fragment_test;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
//两种切换Fragment的方法 两种跳转Fragment的方法   1.add(), show(),hide()          2. replace()

/**
 * replace()    销毁原先的Fragment------replace()------->创建新的Fragment
 * 缺点：耗费性能 效率低
 * 缺点：不会出现Fragment的重叠
 * <p>
 * add();  AFragment   onAttach()--->onCreate()----->OnCreateView()---------->onActivityCreate()---->onStart()-----onResume()
 * <p>
 * hide()  隐藏AFragment             不会执行任何生命周期方法
 * show()  显示AFragment             不会执行任何生命周期方法
 * <p>
 * 优点:效率高
 * 缺点：有时候容易出现Fragment重叠
 */
public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottom_nav;
    private HomeFragment mHomeFrag;
    private VideoFragment mVideFrag;
    private ShopFragment mShopFrag;
    private MineFragment mMineFrag;
    private FragmentManager mFragManager;


    //恢复数据1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView(savedInstanceState);
        //TODO  这是子分支  修复了xxx
        Log.e("TAG","Hello git");
    }

    //实现了xxx功能
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }


    /*
    //恢复数据2
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    //存储数据
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
*/


    private void initView(Bundle saveInstanceSatte) {
        bottom_nav = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottom_nav.setOnNavigationItemSelectedListener(this);
        mFragManager = getSupportFragmentManager();

        if (saveInstanceSatte != null) {  //说明原先的Activity里面存储的有Fragment  就从mFragManager里面根据Fragment的标识获取到对应的Fragment
            mHomeFrag = (HomeFragment) mFragManager.findFragmentByTag("HomdeFra");
            mVideFrag = (VideoFragment) mFragManager.findFragmentByTag("VideoFrg");
            mShopFrag = (ShopFragment) mFragManager.findFragmentByTag("ShopFrg");
            mMineFrag = (MineFragment) mFragManager.findFragmentByTag("MineFrg");
        } else {
            //说明原先的Activity里面没有存储的有Fragment
            mHomeFrag = new HomeFragment();
            mVideFrag = new VideoFragment();
            mShopFrag = new ShopFragment();
            mMineFrag = new MineFragment();
            //  }
            if (!mHomeFrag.isAdded() && !mVideFrag.isAdded() && !mShopFrag.isAdded() && !mMineFrag.isAdded()) {
                mFragManager.beginTransaction().
                        add(R.id.fl_container, mHomeFrag, "HomdeFra").
                        add(R.id.fl_container, mVideFrag, "VideoFrg").
                        add(R.id.fl_container, mShopFrag, "ShopFrg").
                        add(R.id.fl_container, mMineFrag, "MineFrg").
                        hide(mVideFrag).hide(mShopFrag).hide(mMineFrag).
                        show(mHomeFrag).
                        commit();
            }
            //Log.e("AAA", mFragManager.getFragments().size() + "============");
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentTransaction ft = mFragManager.beginTransaction();
        switch (menuItem.getItemId()) {
            case R.id.menu_nav_home:
                ft.hide(mVideFrag).hide(mShopFrag).hide(mMineFrag).show(mHomeFrag);
                break;
            case R.id.menu_nav_video:
                ft.hide(mHomeFrag).hide(mShopFrag).hide(mMineFrag).show(mVideFrag);
                break;
            case R.id.menu_nav_shop:
                ft.hide(mHomeFrag).hide(mVideFrag).hide(mMineFrag).show(mShopFrag);
                break;
            case R.id.menu_nav_mine:
                ft.hide(mHomeFrag).hide(mVideFrag).hide(mShopFrag).show(mMineFrag);
                break;
        }
        ft.commit();
        return true;
    }
}