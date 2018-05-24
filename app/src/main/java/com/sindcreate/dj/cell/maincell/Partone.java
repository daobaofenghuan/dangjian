package com.sindcreate.dj.cell.maincell;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.RVBaseCell;
import com.sindcreate.dj.base.RVBaseViewHolder;

import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Partone extends RVBaseCell<Entry> {
    public static final int TYPE = 101;
    public Partone(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.image_cell_layout,parent,false));
     //   return null;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {


    }

    @Override
    public void releaseResource() {
        super.releaseResource();
        Log.e("db_test_cell","Partone releaseResource");
    }
}
