package com.ndkien98.quanlynhanvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView ;
    SQLDataHandler sqlDataHandler ;
    ListAdapter listAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = this.findViewById(R.id.home_listView);
        sqlDataHandler = new SQLDataHandler(this);
        NhanVien nhanVien = new NhanVien(1,"Nguyen Dac Kien","Ha noi","phong IT","1998",300000,1);
        NhanVien nhanVien1 = new NhanVien(2,"Le Thien Tuan","Ha noi","phong IT","1998",200000,2);
        NhanVien nhanVien2 = new NhanVien(1,"Nguyen Tuan Anh","Ha noi","phong IT","1998",303200,1);
        NhanVien nhanVien3 = new NhanVien(1,"Nguyen Van Dung","Ha noi","phong IT","1998",3023200,2);
        NhanVien nhanVien4 = new NhanVien(1,"Nguyen Duc Minh","Ha noi","phong IT","1998",303400,2);
        NhanVien nhanVien5 = new NhanVien(1,"Nguyen Thi Dung","Ha noi","phong IT","1998",342000,2);
        ArrayList<NhanVien> list = new ArrayList<>();
        list.add(nhanVien);
        list.add(nhanVien1);
        list.add(nhanVien2);
        list.add(nhanVien3);
        list.add(nhanVien4);
        list.add(nhanVien5);

        listAdapter = new ListAdapter(this,list);
        listView.setAdapter(listAdapter);

    }





}
