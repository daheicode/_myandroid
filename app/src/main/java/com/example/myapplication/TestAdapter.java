package com.example.myapplication;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TestAdapter extends CommonAdapter<String> {

    private final MainActivity activity;
    private OnAddListener onAddListener;
    private final HashMap<String, ArrayList<String>> hashMap;

    public TestAdapter(Context context, int layoutId, List<String> datas) {
        super(context, layoutId, datas);
        hashMap = new HashMap<>();
        activity = (MainActivity) context;
    }

    @Override
    protected void convert(ViewHolder holder, String s, final int position) {
        final RecyclerView views = (RecyclerView)holder.getView(R.id.recycler);
        views.setTag(position+"");
       /* for (RecyclerView key:hashMap.keySet()) {
            if(key.getTag().equals(position+"")){
                activity.test(views,hashMap.get(views));
            }else{
                final ArrayList<String> datas=new ArrayList<>();
                hashMap.put(position+"",datas);
                activity.test(views,datas);


            }
        }*/
        if(hashMap.get(position+"")!=null){
            activity.test(views,hashMap.get(position+""));
        }else{
            final ArrayList<String> datas=new ArrayList<>();
            hashMap.put(position+"",datas);
            activity.test(views,datas);
        }

        holder.getView(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onAddListener!=null){
                    onAddListener.addListener(views,hashMap.get(position+""));
                }
            }
        });

    }

    public void setOnAddListener(OnAddListener onAddListener){
        if(onAddListener!=null){
            this.onAddListener=onAddListener;
        }
    }
    public interface OnAddListener{
        public void addListener(RecyclerView recyclerView,ArrayList<String> datas);
    }
}
