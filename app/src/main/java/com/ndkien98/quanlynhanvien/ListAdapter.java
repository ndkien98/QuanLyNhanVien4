package com.ndkien98.quanlynhanvien;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<NhanVien> list;
    public ListAdapter(Activity activityI,ArrayList arrayList){
        this.activity=activityI;
        this.list=arrayList;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = this.activity.getLayoutInflater();

        view =inflater.inflate(R.layout.items,null);

        TextView home_TXT_name =view.findViewById(R.id.home_txt_fullName);
        TextView home_TXT_ngaySinh = view.findViewById(R.id.home_txt_ngaySinh);
        TextView home_TXT_phongBan = view.findViewById(R.id.home_txt_phongBan);

        home_TXT_name.setText(list.get(i).getHoTen());
        home_TXT_ngaySinh.setText(list.get(i).getNamSinh());
        home_TXT_phongBan.setText(list.get(i).getPhongBan());
        return view;
    }
}
