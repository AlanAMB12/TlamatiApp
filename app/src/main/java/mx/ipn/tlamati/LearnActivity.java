package mx.ipn.tlamati;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.unity3d.player.UnityPlayerActivity;

public class LearnActivity extends AppCompatActivity {
    GridView gridView_learn;
    int[] btnImageslearn = {R.mipmap.boton_caracteristicas,R.mipmap.boton_aportaciones,R.mipmap.boton_conquista_de_tenochtitlan,R.mipmap.boton_arquitectura};
    ImageButton btn_regreso_learn;

    private int CAMERA_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        btn_regreso_learn = (ImageButton) findViewById(R.id.btn_regreso_learn);
        btn_regreso_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        gridView_learn = (GridView) findViewById(R.id.gridview_learn);

        LearnActivity.CustomAdapter customAdapter = new LearnActivity.CustomAdapter();
        gridView_learn.setAdapter(customAdapter);
        //MANDAR A INTENT DESDE UN BOTON
        gridView_learn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    //BOTON CARACTERISTICAS
                    Intent intent = new Intent (getApplicationContext(),CaracteristicasActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();
                }
                if(i == 1){
                    //BOTON APORTACIONES
                    Intent intent = new Intent (getApplicationContext(),AportacionesActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();

                }
                if(i == 2){
                    //BOTON CONQUISTA DE TENOCHTITLAN
                    Intent intent = new Intent (getApplicationContext(),ConquistaActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();

                }
                if(i == 3){
                    //BOTON ARQUITECTURA
                    if(ContextCompat.checkSelfPermission(LearnActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                        Intent intent = new Intent (getApplication(), UnityPlayerActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    } else{
                        requestCameraPermission();
                    }


                }



            }
        });

    }

    private void requestCameraPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
            new AlertDialog.Builder(this)
                    .setTitle("Permiso necesario")
                    .setMessage("Permiso para escanear piramide")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                     ActivityCompat.requestPermissions(LearnActivity.this,new String[] {Manifest.permission.CAMERA},  CAMERA_PERMISSION_CODE);

                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        }else{
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CAMERA},  CAMERA_PERMISSION_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CAMERA_PERMISSION_CODE){
           if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
               Toast.makeText(this,"Permiso aceptado",Toast.LENGTH_SHORT).show();
              /* Intent intent = new Intent (getApplicationContext(),ArquitecturaActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
               startActivity(intent);
               finish();*/
           } else{
               Toast.makeText(this,"Permiso denegado",Toast.LENGTH_SHORT).show();
           }
        }
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return btnImageslearn.length;
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
            imageView.setImageResource(btnImageslearn[i]);
            return view1;

        }
    }
}
