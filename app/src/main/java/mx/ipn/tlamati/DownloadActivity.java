package mx.ipn.tlamati;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class DownloadActivity extends AppCompatActivity {
    ImageButton btn_sopa;
    ImageButton btn_completa;
    ImageButton btn_tripas;
    ImageButton btn_crucigrama;
    ImageButton btn_piramide;
    ImageButton btn_regreso;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        //BOTON REGRESAR AL MAIN ACTIVITY
        btn_regreso = (ImageButton) findViewById(R.id.btn_regreso);
        btn_regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        //BOTONES DE DESCARGA

        btn_sopa = (ImageButton) findViewById(R.id.btn_sopa);
        btn_sopa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download("sopa_de_letras");

                Toast.makeText(getApplicationContext(), "se ha iniciado la descarga", Toast.LENGTH_SHORT).show();
            }
        });

        btn_completa = (ImageButton) findViewById(R.id.btn_completa);
        btn_completa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download("completa_la_palabra");
                Toast.makeText(getApplicationContext(), "se ha iniciado la descarga", Toast.LENGTH_SHORT).show();
            }
        });

        btn_tripas = (ImageButton) findViewById(R.id.btn_tripas);
        btn_tripas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download("tripas_de_gato");
                Toast.makeText(getApplicationContext(), "se ha iniciado la descarga", Toast.LENGTH_SHORT).show();
            }
        });

        btn_piramide = (ImageButton) findViewById(R.id.btn_piramide);
        btn_piramide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download("piramide");
                Toast.makeText(getApplicationContext(), "se ha iniciado la descarga", Toast.LENGTH_SHORT).show();
            }
        });

        btn_crucigrama = (ImageButton) findViewById(R.id.btn_crucigrama);
        btn_crucigrama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                download("crucigrama");
                Toast.makeText(getApplicationContext(), "se ha iniciado la descarga", Toast.LENGTH_SHORT).show();
            }
        });

    }
    // DATOS DEL ARCHIVO PARA DESCARGAR
    public void download(final String name){
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child(name+".pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFiles(DownloadActivity.this,name,".pdf",DIRECTORY_DOWNLOADS,url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    //NOTIFICACION DESCARGA Y DESCARGAR ARCHIVO
    public void downloadFiles(Context context, String fileName, String fileExtension, String destinationDirectory, String url){

        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        downloadManager.enqueue(request);

    }
}
