package mx.ipn.tlamati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URI;

public class ConocenosActivity extends AppCompatActivity {
    GridView gridView_conocenos;
    int[] btnImagesconoc = {R.mipmap.boton_facebook,R.mipmap.boton_instagram,
            R.mipmap.boton_twiiter,R.mipmap.boton_correo,R.mipmap.boton_pagina_web};
    // R.mipmap.boton_pagina_web Este bottón queda pendiente, ya que no se ha mandado la info de la pagina web
    //R.mipmap.boton_instagram Este boton, el de instagram tambien XD
    ImageButton btn_regreso_conoc;
    ImageButton btn_enviar;
    EditText textfield;
    EditText mailfield;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conocenos);

        btn_regreso_conoc = (ImageButton) findViewById(R.id.btn_regreso_conoc);
        btn_regreso_conoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        textfield = (EditText) findViewById(R.id.textfield);
        mailfield = (EditText) findViewById(R.id.textfield);
        btn_enviar = (ImageButton) findViewById(R.id.btn_enviar);
        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Correo enviado!",Toast.LENGTH_SHORT).show();
                textfield.setText("");
                mailfield.setText("");
            }
        });
        gridView_conocenos = (GridView) findViewById(R.id.gridview_conocenos);
        ConocenosActivity.CustomAdapter customAdapter = new  ConocenosActivity.CustomAdapter();
        gridView_conocenos.setAdapter(customAdapter);
        //MANDAR A INTENT DESDE UN BOTON
        gridView_conocenos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    //BOTON Face
                    String url = "https://www.facebook.com/tlamatiapp/?modal=admin_todo_tour";
                    Intent webintent = new Intent(Intent.ACTION_VIEW);
                    webintent.setData(Uri.parse(url));
                    startActivity(webintent);
                }
                if(i == 1){
                    //BOTON insta
                    String url = "https://www.instagram.com/tlamati.app/";
                    Intent webintent = new Intent(Intent.ACTION_VIEW);
                    webintent.setData(Uri.parse(url));
                    startActivity(webintent);
                }
                if(i == 2){
                    //BOTON tweet
                    String url = "https://twitter.com/Tlamati2";
                    Intent webintent = new Intent(Intent.ACTION_VIEW);
                    webintent.setData(Uri.parse(url));
                    startActivity(webintent);
                }
                if(i == 3){
                    //BOTON mail
                    String url = "https://mail.google.com/mail/u/1/#inbox";
                    Intent webintent = new Intent(Intent.ACTION_VIEW);
                    webintent.setData(Uri.parse(url));
                    startActivity(webintent);
                }
                if(i == 4){
                    Toast.makeText(getApplicationContext(),"En construcción", Toast.LENGTH_SHORT);
                    //BOTON web
                    /*String url = "http://www.example.com";
                    Intent webintent = new Intent(Intent.ACTION_VIEW);
                    webintent.setData(Uri.parse(url));
                    startActivity(webintent);*/
                }

            }
        });
    }
    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return btnImagesconoc.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            //MOSTRAR LOS BOTONES EN EL GRID
            View view1 = getLayoutInflater().inflate(R.layout.row_data_con,null);
            ImageView imageView = (ImageView) view1.findViewById(R.id.images);
            imageView.setImageResource(btnImagesconoc[i]);
            return view1;

        }

    }
}
