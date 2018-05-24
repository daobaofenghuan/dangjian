package com.sindcreate.dj;

import android.app.Fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.sindcreate.dj.adapter.MainRecycleAdapter;
import com.sindcreate.dj.fragment.HomePageFragment;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;


import java.util.ArrayList;


import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

ArrayList<Fragment> list=new ArrayList<>();
    MainRecycleAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBarUtils.setWindowStatusBarColor(MainActivity.this,R.color.dj_titalred);
        ButterKnife.bind(this);

        initview();



    }
  public void  initview(){

      HomePageFragment fragment=new HomePageFragment();
      getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment).commit();


  }


}
