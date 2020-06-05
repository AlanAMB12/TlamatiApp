package mx.ipn.tlamati;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class Adaptera extends PagerAdapter {

    private List<Model> models4;
    private LayoutInflater layoutInflater;
    private Context context;
    Dialog myDialog;

    public Adaptera(List<Model> models, Context context) {
        this.models4 = models;
        this.context = context;
    }

    private void ShowPopup(String txt,int position) {
        ImageView txtclose0,txtclose1,txtclose2;
        TextView textView_templot,textView_temploq,textView_templom;
        if(position == 0){
            myDialog.setContentView((R.layout.templom_popup));

            txtclose0 = (ImageView) myDialog.findViewById(R.id.imgclose_templom);
            textView_templom = (TextView) myDialog.findViewById(R.id.textView_templom);
            textView_templom.setText(txt);
            textView_templom.setMovementMethod(new ScrollingMovementMethod());
            txtclose0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myDialog.dismiss();
                }
            });
            myDialog.show();
        }else if(position == 1){
            myDialog.setContentView((R.layout.temploq_popup));

            txtclose1 = (ImageView) myDialog.findViewById(R.id.imgclose_temploq);
            textView_temploq = (TextView) myDialog.findViewById(R.id.textView_temploq);
            textView_temploq.setText(txt);
            textView_temploq.setMovementMethod(new ScrollingMovementMethod());
            txtclose1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myDialog.dismiss();
                }
            });
            myDialog.show();
        }else if(position == 2){
            myDialog.setContentView((R.layout.templot_popup));

            txtclose2 = (ImageView) myDialog.findViewById(R.id.imgclose_templot);
            textView_templot = (TextView) myDialog.findViewById(R.id.textView_templot);
            textView_templot.setText(txt);
            textView_templot.setMovementMethod(new ScrollingMovementMethod());
            txtclose2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myDialog.dismiss();
                }
            });
            myDialog.show();
        }


    }

    @Override
    public int getCount() {
        return models4.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {


        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.item4,null);

        ImageView imageView;

        imageView = (ImageView) view.findViewById(R.id.image4);
        myDialog = new Dialog(context);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        imageView.setImageResource(models4.get(position).getImage());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String txt_tt,txt_tm,txt_tq;
                if(position == 0){
                    txt_tm = "En su cima, contaba con dos templos y una escalinata doble. Los templos estaban dedicados a Tláloc y a Huitzilopochtli. El templo del lado izquierdo honraba a Tláloc, el cual era altamente reverenciado. Su templo estaba decorado en azul y blanco, colores que simbolizaban el agua y la humedad. El templo del lado derecho estaba dedicado a Huitzilopochtli. Estaba pintado de rojo y blanco, en honor a la guerra y a los sacrificios.  El Templo Mayor era muy empinado y tenía una gran altura. Los templos situados encima de la pirámide no podían ser vistos a menos que una persona los observara desde la plataforma.";
                    ShowPopup(txt_tm,0);
                }else if(position == 1){
                    txt_tq = "Este templo es la excepción de todo el conjunto pues tiene una base de forma circular que contrasta con todas las demás de forma rectangular, sin embargo es típica de todas las estructuras dedicadas a Quetzalcóatl dios del conocimiento y de la creación y que se representaba con la forma de la serpiente emplumada.\n" +
                            "\n" +
                            "Durante los dos equinoccios, el sol salía en el medio de los dos templos y apuntaba exactamente hacia el Templo de Quetzalcóatl, \n" +
                            "\n" +
                            " Está dedicada a Ehécatl, el dios del viento, una de las formas del dios Quetzalcoatl. Las estructuras se construyeron en forma circular para facilitar el flujo del viento, evitando así que la estructura funcionara como una barrera que pudiera entorpecer la entrada del dios del viento.\n";
                    ShowPopup(txt_tq,1);
                }else if(position ==2){
                    txt_tt = "Los adoratorios aztecas constituían importantes estructuras religiosas. Dado que los aztecas eran politeístas, cada adoratorio que se construía tenía el propósito de honrar a un dios en particular. Tal es el caso del templo de Tezcatlipoca. La estructura consistía de un edificio rectangular que conducía hacia un cuarto y más pequeño donde había un fuego encendido en su centro para quemar las ofrendas.  Se asemejaba a una pirámide truncada. La parte exterior del templo tenía terrazas y escalones. Algunas de las partes más detalladas y decoradas del templo eran las escalinatas que apuntaban hacia los cielos.";
                    ShowPopup(txt_tt,2);
                }

            }
        });

        ViewPager vp = (ViewPager) container;
        vp.addView (view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
