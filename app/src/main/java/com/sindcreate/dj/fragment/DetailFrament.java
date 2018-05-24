//package com.sindcreate.dj.fragment;
//
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.StaggeredGridLayoutManager;
//
//import com.sindcreate.dj.base.Cell;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Double on 2018/5/22.
// */
//public class DetailFragment extends AbsBaseFragment<DetailEntry> {
//    @Override
//    public void onRecyclerViewInitialized() {
//        mBaseAdapter.setData(getCells(mockStaggerData()));
//    }
//
//    @Override
//    public void onPullRefresh() {
//
//    }
//
//    @Override
//    public void onLoadMore() {
//
//    }
//
//    @Override
//    protected RecyclerView.LayoutManager initLayoutManger() {
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        return layoutManager;
//    }
//
//    @Override
//    protected List<Cell> getCells(List<DetailEntry> list) {
//        List<Cell> cells = new ArrayList<>();
//        for (int i=0;i<list.size();i++){
//            cells.add(new DetailCell(list.get(i)));
//        }
//        return cells;
//    }
//
//}
