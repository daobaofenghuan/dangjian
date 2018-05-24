package com.sindcreate.dj.cell;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.RVBaseCell;
import com.sindcreate.dj.base.RVBaseViewHolder;
import com.sindcreate.dj.model.Entry;
import com.squareup.picasso.Picasso;

/**
 * Created by zhouwei on 17/1/19.
 */

public class ImageCell extends RVBaseCell<Entry> {
    public static final int TYPE = 1;
    public ImageCell(Entry entry) {
        super(entry);
    }

    @Override
    public int getItemType() {
        return TYPE;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.image_cell_layout,null));
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {
        Log.e("zhouwei","ImageCell onBindViewHolder");
        Picasso.with(holder.getItemView().getContext()).load(mData.imageUrl).into(holder.getImageView(R.id.image));
    }

    @Override
    public void releaseResource() {
        super.releaseResource();
        Log.e("zhouwei","ImageCell releaseResource");
    }
}
