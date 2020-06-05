package mx.ipn.tlamati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.animation.ArgbEvaluator;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ArquitecturaActivity extends AppCompatActivity {

    ViewPager viewPager4;
    Adaptera adaptera;
    List<Model> models4;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ImageView imvreg;
    ShowCamera showCamera;
    Camera camera;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arquitectura);
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);

        //abrir camara

        camera = Camera.open();
        showCamera = new ShowCamera(this,camera);
        frameLayout.addView(showCamera);

        models4 = new ArrayList<>();
        models4.add(new Model(R.drawable.templo_mayor));
        models4.add(new Model(R.drawable.templodequetzalcoatl));
        models4.add(new Model(R.drawable.templodetezcatlipoca));
        adaptera = new Adaptera(models4, this);
        viewPager4 = (ViewPager) findViewById(R.id.viewPager4);
        viewPager4.setAdapter(adaptera);
        viewPager4.setPadding(50,0,50,0);
        imvreg = (ImageView) findViewById(R.id.imgvreg);
        imvreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), LearnActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }


}
