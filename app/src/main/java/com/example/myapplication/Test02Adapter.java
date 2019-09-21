package com.example.myapplication;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

class Test02Adapter extends CommonAdapter<String> {

    private OnAddListener onAddListener;

    public Test02Adapter(Context context, int layoutId, List<String> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        /*final RecyclerView views = (RecyclerView)holder.getView(R.id.recycler);

        holder.getView(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onAddListener!=null){
                    onAddListener.addListener(views);
                }
            }
        });*/

    }

    public void setOnAddListener(OnAddListener onAddListener){
        if(onAddListener!=null){
            this.onAddListener=onAddListener;
        }
    }
    public interface OnAddListener{
        public void addListener(RecyclerView recyclerView);
    }
}
