package com.sindcreate.dj.cell.messagecell;

/**
 * Created by Double on 2018/5/25.
 */



import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.RVBaseCell;
import com.sindcreate.dj.base.RVBaseViewHolder;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Part_message extends RVBaseCell<Entry> {
    //警示教育
    public static final int TYPE = 502;

    public Part_message(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_message_part1_1,parent,false));

       LinearLayout rydown=view.getLinearLayout(R.id.id_message_rlydown);
       // ImageView down=view.getImageView(R.id.id_message_icondown);
        final LinearLayout relativeLayout=view.getLinearLayout(R.id.id_message_nr);
        relativeLayout.setVisibility(View.GONE);



        rydown.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(relativeLayout.getVisibility()==View.VISIBLE)
                 {relativeLayout.setVisibility(View.GONE);}else {
                     relativeLayout.setVisibility(View.VISIBLE);
                 }
             }
         });

        return view;
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
