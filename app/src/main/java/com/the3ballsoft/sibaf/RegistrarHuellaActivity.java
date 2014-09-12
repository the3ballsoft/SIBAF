package com.the3ballsoft.sibaf;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.Toast;

public class RegistrarHuellaActivity extends Activity {

    private ExpandableListAdapter mAdapter;
    private final int TOTAL_GROUP_1 = 3;
    private final int TOTAL_GROUP_2 = 4;
    private final int TOTAL_GROUP_3 = 5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_huella);

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);

        listView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView arg0, View arg1,
                                        int arg2, int arg3, long arg4) {
                Toast.makeText(getBaseContext(), "Undiste en salon",
                        Toast.LENGTH_LONG).show();
                return false;
            }
        });

        listView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {

                Toast.makeText(getBaseContext(), "Undiste en bloque",
                        Toast.LENGTH_LONG).show();
                return false;
            }
        });

        mAdapter = new ExpandableListAdapter(this, new ArrayList<String>(),
                new ArrayList<ArrayList<AbstractGroupItem>>());


        //se agrega la informacion que estara en las listas y se escuchan los eventos
        setupData();
        listView.setAdapter(mAdapter);
    }

    private void setupData() {
        AbstractGroupItem groupItem = null;
        for (int i = 0; i < TOTAL_GROUP_1; i++) {
            groupItem = new BloqueSalonesItem("Salon " + i, "Bloque A");
            mAdapter.addItem(groupItem);
        }
        for (int i = 0; i < TOTAL_GROUP_2; i++) {
            groupItem = new BloqueSalonesItem("Salon " + i, "Bloque A");
            mAdapter.addItem(groupItem);
        }
        for (int i = 0; i < TOTAL_GROUP_3; i++) {
            groupItem = new BloqueSalonesItem("Salon " + i, "Bloque A");
            mAdapter.addItem(groupItem);
        }
    }
}
