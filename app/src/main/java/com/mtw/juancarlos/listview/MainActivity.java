package com.mtw.juancarlos.listview;

import android.content.Context;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Producto> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaProductos = generarLista();

       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.list_item,
                R.id.label,
                getResources().getStringArray(R.array.OS));*/

        MyAdapter adapter = new MyAdapter(MainActivity.this);

        ListView lista = (ListView) findViewById(R.id.ListView);
        lista.setAdapter(adapter);

    }

    private ArrayList<Producto> generarLista(){
        ArrayList<Producto> lista = new ArrayList<Producto>();

        lista.add(new Producto("sony","Sony Xperia SP","Para videojuegos"));
        lista.add(new Producto("iphone","Apple iPhone 7","La mejor opcion"));
        lista.add(new Producto("huawei","Huawei P9","Color Blanco"));
        lista.add(new Producto("samsung","Samsung S6 Edge","Color Nego"));


        return lista;
    }

    private class MyAdapter extends BaseAdapter{
        private Context context;
        private LayoutInflater inflater;
        private ImageView img;
        private TextView tvTitulo, tvSubtitulo;

        public MyAdapter(Context context) {
            this.context = context;
            inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return listaProductos.size();
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

            ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.list_item2,null);

            Producto producto = listaProductos.get(position);

            img = (ImageView) viewGroup.findViewById(R.id.Imagen);
            tvTitulo = (TextView) viewGroup.findViewById(R.id.tvTitulo);
            tvSubtitulo = (TextView) viewGroup.findViewById(R.id.tvSubTitulo);

            img.setImageResource(getResources().getIdentifier(producto.getImagen(), "drawable", "com.mtw.juancarlos.listview"));

            tvTitulo.setText(producto.getNombre());
            tvSubtitulo.setText(producto.getDescripcion());

            return viewGroup;
        }
    }
}
