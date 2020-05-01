package com.example.otrointentomas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    ListView listView;
    String mTitulo[] = {"Juani", "Pepi", "Nestor", "Akrokto"};
    String mDescripcion[] = {"Quiere huevos", "Verduras", "Papel de vater", "darte la mano"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitulo, mDescripcion);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(ThirdActivity.this, "Descripción de Juani", Toast.LENGTH_SHORT).show();
                }
                if(position == 1){
                    Toast.makeText(ThirdActivity.this, "Descripción de Pepi", Toast.LENGTH_SHORT).show();
                }
                if(position == 2){
                    Toast.makeText(ThirdActivity.this, "Descripción de Nestor", Toast.LENGTH_SHORT).show();
                }
                if(position == 3){
                    Toast.makeText(ThirdActivity.this, "Descripción de Akrokto", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDescripcion[];
        int rTmgs[]; //Imagenes del perfil de las personas

        MyAdapter (Context c, String title[], String descripcion[]){
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescripcion = descripcion;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);

            TextView titulo = row.findViewById(R.id.textView1);
            TextView descripcion = row.findViewById(R.id.textView2);

            titulo.setText(rTitle[position]);
            descripcion.setText(rDescripcion[position]);

            return row;
        }

    }

}
