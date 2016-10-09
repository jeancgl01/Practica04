package com.mtw.juancarlos.listview;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String[] arr = getResources().getStringArray(R.array.OS);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.list_item,
                R.id.label,
                getResources().getStringArray(R.array.OS));

        ListView lista = (ListView) findViewById(R.id.ListView);
        lista.setAdapter(adapter);

    }
}
