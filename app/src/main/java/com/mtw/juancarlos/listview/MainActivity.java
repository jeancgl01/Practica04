package com.mtw.juancarlos.listview;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arr = getResources().getStringArray(R.array.OS);
       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.list_item,
                R.id.label,
                getResources().getStringArray(R.array.OS));*/

        MyAdapter adapter = new MyAdapter();

        ListView lista = (ListView) findViewById(R.id.ListView);
        lista.setAdapter(adapter);

    }

    private class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return arr.length;
            //return 0;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {



            return null;
        }
    }
}
