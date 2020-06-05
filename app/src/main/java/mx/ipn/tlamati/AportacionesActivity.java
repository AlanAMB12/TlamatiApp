package mx.ipn.tlamati;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class AportacionesActivity extends AppCompatActivity {
    Dialog myDialog;
    GridView gridView_aport;

    int[] btnImagesaport = {R.mipmap.boton_tinte_rojo,R.mipmap.boton_juego_de_pelota,
                            R.mipmap.boton_calendario,R.mipmap.boton_numeracion,
                            R.mipmap.boton_chinampas,R.mipmap.boton_medicina};
    ImageButton btn_regreso_aport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aportaciones);

        myDialog = new Dialog(this);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));



        btn_regreso_aport = (ImageButton) findViewById(R.id.btn_regreso_aport);
        btn_regreso_aport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LearnActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        gridView_aport = (GridView) findViewById(R.id.gridview_aport);

        AportacionesActivity.CustomAdapter customAdapter = new AportacionesActivity.CustomAdapter();
        gridView_aport.setAdapter(customAdapter);
        //MANDAR A INTENT DESDE UN BOTON
        gridView_aport.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    //BOTON TINTE ROJO
                    ShowPopup();
                }
                if(i == 1){
                    //BOTON JUEGO DE PELOTA
                    ShowPopupJuego();
                }
                if(i == 2){
                    //BOTON CALENDARIO AZTECA
                    ShowPopupCalendario();
                }
                if(i == 3){
                    //NUMERACION
                    ShowPopupNumeracion();
                }
                if(i == 4){
                    //CHINAMPAS
                    ShowPopupChinampas();
                }
                if(i == 5){
                    //MEDICINA
                    ShowPopupMedicina();
                }



            }
        });

    }

    private void ShowPopupJuego() {
        ImageView txtclose;
        TextView textView_juegodepelota;

        myDialog.setContentView((R.layout.juegodepelota_popup));

        txtclose = (ImageView) myDialog.findViewById(R.id.txtclose_juegodepelota);
        textView_juegodepelota = (TextView) myDialog.findViewById(R.id.textView_juegodepelota);
        textView_juegodepelota.setText("El juego de pelota representa la cotidiana batalla cósmica entre el día y la noche, entre Quetzalcoatl y Tezcatlipoca, y finalmente, entre Huitzilopochtli y Coyolxauhqui. Es en la arquitectura de la cancha de juego de pelota donde se reviven los mitos ancestrales. La cancha de juego de pelota estaba formada por un área en forma de L con dos grandes muros inclinados, gradas, palcos para los jueces, entre otros. La estructura estaba adornada con altares de calaveras, los tzompantli, que contenían las cabezas de los cautivos decapitados en distintos rituales. Las calaveras de los sacrificados eran ensartadas encima de barras que estaban situadas entre los postes.");
        textView_juegodepelota.setMovementMethod(new ScrollingMovementMethod());
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.show();
    }

    private void ShowPopupCalendario() {
        ImageView txtclose;
        TextView textView_calendario;

        myDialog.setContentView((R.layout.calendario_popup));

        txtclose = (ImageView) myDialog.findViewById(R.id.txtclose_calendario);
        textView_calendario = (TextView) myDialog.findViewById(R.id.textView_calendario);
        textView_calendario.setText("Los mexicas usaban simultáneamente dos calendarios: \n\n" +
                "El calendario de 365 días, llamado xiuhpohualli o “cuenta del año, constaba de 18 “meses” de 20 días cada uno, más cinco días complementarios, lo que en total da los 365 días del año solar. Las 18 meses formaban la serie nahua atlcahualo-izcalli y los 5 días complementarios se llamaban nemontemi. Su función esencial era la programación de la vida diaria, como tiempos de siembra y cosecha.\n\n" +
                "El tonalpohualli o “cuenta de los días” estaba formado por 20 trecenas, que da un total de 260 días. Cada día de este ciclo tenía su nombre propio, que constaba de dos elementos combinados: un número de serie 1-13, y un signo de la serie vigesimal cipactli. Se utilizaba principalmente con fines religiosos y adivinatorios.\n");

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.show();
    }

    private void ShowPopupNumeracion() {
        ImageView txtclose;
        TextView textView_numeracion;

        myDialog.setContentView((R.layout.numeracion_popup));

        txtclose = (ImageView) myDialog.findViewById(R.id.txtclose_numeracion);
        textView_numeracion = (TextView) myDialog.findViewById(R.id.textView_numeracion);
        textView_numeracion.setText("El sistema de numeración de los mexicas era vigesimal y de tipo aditivo. Se empleaban cuatro símbolos diferentes que estaban muy influidos por el cultivo del maíz.\n\n" +
                "Los símbolos utilizados eran: para él “1”, un punto o borrón que representaba una vaina de la semilla del maíz; para el “20”, una bandera de las que se empleaban para marcar los límites de un terreno; para el “400”, el esquema de una planta de maíz; y para el “8000”, una muñeca de maíz.");
        textView_numeracion.setMovementMethod(new ScrollingMovementMethod());
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.show();
    }

    private void ShowPopupChinampas() {
        ImageView txtclose;
        TextView textView_chinampas;

        myDialog.setContentView((R.layout.chinampas_popup));

        txtclose = (ImageView) myDialog.findViewById(R.id.txtclose_chinampas);
        textView_chinampas = (TextView) myDialog.findViewById(R.id.textView_chinampas);
        textView_chinampas.setText("Las chinampas, conocidas también como “jardines flotantes”, eran parcelas rectangulares de tierra en el pantano que se usaban para cultivar alimentos y construir casas. Se construían sobre el lecho pantanoso del lago, estaqueando largos cercados rectangulares de alrededor de 2.5 m de ancho por 30 m de largo. Las estacas se entretejían para formar cercos que más tarde se cubrían con vegetación en descomposición y barro. El agua entre cada parcela formaba un canal. Esto formaba largos patrones rectangulares de chinampas. A fin de irrigar las chinampas, se instalaba un sofisticado sistema de drenaje compuesto por presas, compuertas, y canales. Las chinampas permitían a los aztecas contar con áreas de plantación productivas.");
        textView_chinampas.setMovementMethod(new ScrollingMovementMethod());
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.show();
    }

    private void ShowPopupMedicina() {
        ImageView txtclose;
        TextView textView_medicina;

        myDialog.setContentView((R.layout.medicina_popup));

        txtclose = (ImageView) myDialog.findViewById(R.id.txtclose_medicina);
        textView_medicina = (TextView) myDialog.findViewById(R.id.textView_medicina);
        textView_medicina.setText("La medicina que practicaban fue una profesión vulgar, nacida en el seno de la familia y se hizo hereditaria de padres a hijos. La medicina primitiva fue empírica y mágica, de allí la intervención de sus divinidades, Existieron muchas deidades relacionadas con la medicina, divididas en mayores y menores. De las mayores a la diosa “Tlazolteotl o Centotl”, deidad de la tierra en parte también lo era de la medicina,  “diosa de los medicamentos y de las hierbas medicinales”\n\n" +
                "Para las heridas infectadas usaban emplastos hechos de tortillas de maíz afectado de fungosis, tópicos que aplicaban a la parte enferma cuando se iniciaba la proliferación de hongos en dichas tortillas, aprovechando las propiedades curativas de los hongos aunque estos también junto con el peyote se empleaban con fines rituales y adivinatorios.\n\n" +
                "Los tallos enredados de tumbavaquero hacen suponer que se les recolectaba y preparaba para un uso futuro, para el tratamiento de granos y trastornos gastrointestinales.\n\n" +
                "El atado de tallos de una menta indica su uso medicinal. Plantas de la misma familia, abundantes en la región, se utilizan aún como remedios: el toronjil y el orégano sirven para curar el espanto, los nervios, el insomnio, la indigestión y el dolor de estómago.");
        textView_medicina.setMovementMethod(new ScrollingMovementMethod());
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.show();
    }

    private void ShowPopup() {
        ImageView txtclose;
        TextView textView_tinte;

        myDialog.setContentView((R.layout.custompopup));

        txtclose = (ImageView) myDialog.findViewById(R.id.txtclose_tinte);
        textView_tinte = (TextView) myDialog.findViewById(R.id.textView_tinte);
        textView_tinte.setText("Junto con la plata y el oro, las primeras naves que zarparon del Nuevo Mundo después de la Conquista española transportaban otro tesoro: un colorante natural que producía un rojo tan intenso que los artistas europeos lo adoptaron de inmediato. Este era la grana cochinilla es un pequeño insecto parásito que se alimenta del nopal y se cultivaba en México y Perú durante la época prehispánica. Liberaba un color rojo más intenso y duradero que cualquier otro color disponible en aquel entonces, su demanda era demasiado alta y se utilizaba para suntuosas sedas, terciopelos y tapicería europeos.");
        textView_tinte.setMovementMethod(new ScrollingMovementMethod());
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
               myDialog.dismiss();
            }
        });

        myDialog.show();
    }


    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return btnImagesaport.length;
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
            imageView.setImageResource(btnImagesaport[i]);
            return view1;

        }

    }
}
