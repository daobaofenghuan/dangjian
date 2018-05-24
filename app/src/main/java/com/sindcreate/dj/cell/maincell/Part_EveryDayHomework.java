package com.sindcreate.dj.cell.maincell;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.RVBaseCell;
import com.sindcreate.dj.base.RVBaseViewHolder;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Part_EveryDayHomework  extends RVBaseCell<Entry>{
    //每日一题
    public static final int TYPE = 102;

 public   Part_EveryDayHomework (Entry entry){

     super(entry);
 }

    @Override
    public int getItemType() {
        return TYPE;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_mainactivity_homework,parent,false));
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }
}
