package mx.ipn.tlamati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{
    GridView gridView;
    int[] btnImages = {R.mipmap.btn_crea_y_juega,R.mipmap.btn_aprende,R.mipmap.btn_conocenos,R.mipmap.btn_descargas};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        //MANDAR A INTENT DESDE UN BOTON
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    //BOTON CREA Y JUEGA
                    Intent intent = new Intent (getApplicationContext(),CreaYJuegaActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);;
                    startActivity(intent);finish();
                }
                if(i == 1){
                    //BOTON APRENDE
                    Intent intent = new Intent (getApplicationContext(),LearnActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);;
                    startActivity(intent);finish();
                }
                if(i == 2){
                    //BOTON CONOCENOS
                    Intent intent = new Intent (getApplicationContext(),ConocenosActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);;
                    startActivity(intent);finish();
                }
                if(i == 3){
                    //BOTON DESCARGAS
                    Intent intent = new Intent (getApplicationContext(),DownloadActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();
        }



            }
        });
    }

    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return btnImages.length;
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
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);

            ImageView imageView = (ImageView) view1.findViewById(R.id.images);
            imageView.setImageResource(btnImages[i]);
            return view1;

        }
    }
}
