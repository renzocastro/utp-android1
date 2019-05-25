package com.example.utp_android1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.utp_android1.R;
import com.example.utp_android1.model.User;

import java.util.List;

public class ListUserAdapter extends BaseAdapter {
    private Context mContext ;
    private List<User> mUserList ;

    public ListUserAdapter(Context mContext, List<User> mUserList) {
        this.mContext = mContext;
        this.mUserList= mUserList;
    }

    @Override
    public int getCount() {
        return this.mUserList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mUserList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.mUserList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = View(this.mContext, R.layout.item_Listview,null) ;
//        this.mUserList.get(position).getId() ;
//        this.mUserList.get(position).getUsername() ;
//        this.mUserList.get(position).getFirst_name() ;
//        this.mUserList.get(position).getLast_name() ;
//        this.mUserList.get(position).getEmail() ;
        return null;
    }
}
