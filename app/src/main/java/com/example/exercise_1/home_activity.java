package com.example.exercise_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class home_activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ListView listView;
    private ListViewAdapter adapter;
    String[]listNama;
    public static ArrayList<ClassNama> classNamaArrayList=new ArrayList<ClassNama>();
    Bundle bundle = new Bundle();
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);
        listNama = new String[]{"Inayah","Ilham","Eris",
                "Fikri","Maul","Intan","Vina","Gita","Vian","Lutfi"};
        listView = findViewById(R.id.mnedit);
        classNamaArrayList = new ArrayList<>();
        for (int i = 0; i < listNama.length;i++)
        {
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
        }
        adapter = new ListViewAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama = classNamaArrayList.get(position).getName();
                bundle.putString("a",nama.trim());
                PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                pm.setOnMenuItemClickListener(home_activity.this);
                pm.inflate(R.menu.popup_menu);
                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(@org.jetbrains.annotations.NotNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), activity_lihatdata.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(), "ini untuk edit kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}