package mx.ipn.tlamati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class CreaYJuegaActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPager viewPager2;
    ViewPager viewPager3;
    Adapter adapter;
    Adaptere adaptere;
    Adapteres adapteres;
    List<Model> models;
    List<Model> models2;
    List<Model> models3;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ImageView im1,im2,imageView5,imageView6,imageView7,imageView2,imageView3,imageView4, imageView8, imageView9;
    int monito1,monito2,monito3,monito4,monito5,traje1,traje2,traje3,traje4,traje5,traje6,gorra1,gorra2,gorra3,gorra4,gorra5,gorra6, bigote;
    int monito,traje,gorra, con_bigote, sin_bigote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_y_juega);
        monito = 1;
        traje = 1;
        gorra = 1;
        con_bigote =1;
        monito1 = R.drawable.monito1;
        monito2 = R.drawable.monito2;
        monito3 = R.drawable.monito3;
        monito4 = R.drawable.monito4;
        monito5 = R.drawable.monito_5;
        traje1 = R.drawable.traje1;
        traje2 = R.drawable.traje2;
        traje3 = R.drawable.traje3;
        traje4 = R.drawable.traje4;
        traje5 = R.drawable.traje5;
        traje6 = R.drawable.traje6;
        gorra1 = R.drawable.gorra1;
        gorra2 = R.drawable.gorra2;
        gorra3 = R.drawable.gorra3;
        gorra4 = R.drawable.gorra4;
        gorra5 = R.drawable.gorra5;
        gorra6 = R.drawable.gorra6;
        bigote = R.drawable.bigote;
        sin_bigote = R.drawable.fondo;
        im1 = (ImageView) findViewById(R.id.im1) ;
        im2 = (ImageView) findViewById(R.id.im2) ;
        imageView2 = (ImageView) findViewById(R.id.imageView2) ;
        imageView3 = (ImageView) findViewById(R.id.imageView3) ;
        imageView4 = (ImageView) findViewById(R.id.imageView4) ;
        imageView5 = (ImageView) findViewById(R.id.imageView5) ;
        imageView6 = (ImageView) findViewById(R.id.imageView6) ;
        imageView7 = (ImageView) findViewById(R.id.imageView7) ;
        imageView8 = (ImageView) findViewById(R.id.imageView8) ;
        imageView9 = (ImageView) findViewById(R.id.imageView9) ;

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MemoramaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(monito == 1){
                    imageView3.setImageResource(monito1);
                    monito++;
                }else if(monito == 2){
                    imageView3.setImageResource(monito2);
                    monito++;
                }else if(monito == 3){
                    imageView3.setImageResource(monito3);
                    monito++;
                }else if (monito==4){
                    imageView3.setImageResource(monito4);
                    monito++;
                }else if (monito==5){
                    imageView3.setImageResource(monito5);
                    monito = 1;
                }
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(gorra == 1){
                    imageView2.setImageResource(gorra1);
                    gorra++;
                }else if(gorra == 2){
                    imageView2.setImageResource(gorra2);
                    gorra++;
                }else if(gorra == 3){
                    imageView2.setImageResource(gorra3);
                    gorra++;
                }else if (gorra==4){
                    imageView2.setImageResource(gorra4);
                    gorra++;
                }else if (gorra==5){
                    imageView2.setImageResource(gorra5);
                    gorra++;
                }else if (gorra==6){
                    imageView2.setImageResource(gorra6);
                    gorra = 1;
                }
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(traje == 1){
                    imageView4.setImageResource(traje1);
                    traje++;
                }else if(traje == 2){
                    imageView4.setImageResource(traje2);
                    traje++;
                }else if(traje == 3){
                    imageView4.setImageResource(traje3);
                    traje++;
                }else if (traje==4){
                    imageView4.setImageResource(traje4);
                    traje++;
                }else if (traje==5){
                    imageView4.setImageResource(traje5);
                    traje++;
                }else if (traje==6){
                    imageView4.setImageResource(traje6);
                    traje = 1;
                }
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(con_bigote==0){
                    imageView9.setImageResource(sin_bigote);
                    con_bigote=1;
                }else if(con_bigote==1){
                    imageView9.setImageResource(bigote);
                    con_bigote=0;
                }
            }
        });




    }
}