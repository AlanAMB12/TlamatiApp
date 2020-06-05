package mx.ipn.tlamati;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CaracteristicasActivity extends AppCompatActivity {
    Dialog myDialog;
    Dialog myDialog2;
    GridView gridView_carac;
    int[] btnImagescarac = {R.mipmap.boton_ubicacion,R.mipmap.boton_organizacion,
                            R.mipmap.boton_economia,R.mipmap.boton_religion,
                            R.mipmap.boton_agricultura};
    int[] btnImagesagri = {R.mipmap.maiz,R.mipmap.algodon,
            R.mipmap.cacao,R.mipmap.maguey};
    ImageButton btn_regreso_carac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristicas);

        myDialog = new Dialog(this);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        myDialog2 = new Dialog(this);
        myDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        btn_regreso_carac = (ImageButton) findViewById(R.id.btn_regreso_carac);
        btn_regreso_carac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LearnActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        gridView_carac = (GridView) findViewById(R.id.gridview_carac);

        CaracteristicasActivity.CustomAdapter customAdapter = new  CaracteristicasActivity.CustomAdapter();
        gridView_carac.setAdapter(customAdapter);
        //MANDAR A INTENT DESDE UN BOTON
        gridView_carac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    //BOTON UBICACION
                    ShowPopup();
                }
                if(i == 1){
                    //BOTON ORGANIZACION
                    ShowPopupOrganizacion();
                }
                if(i == 2){
                    //BOTON ECONOMIA
                   ShowPopupEconomia();
                }
                if(i == 3){
                    //BOTON RELIGION
                    ShowPopupReligion();
                }
                if(i == 4){
                    //BOTON AGRICULTURA
                   ShowPopupAgricultura();
                }

            }
        });
    }

    private void ShowPopupEconomia() {
        ImageView txtclose;
        TextView textView_economia;

        myDialog.setContentView((R.layout.economia_popup));

        txtclose = (ImageView) myDialog.findViewById(R.id.txtclose_economia);
        textView_economia = (TextView) myDialog.findViewById(R.id.textView_economia);
        String txt_economia="La economía se vio favorecida por muchos motivos entre los que cabe mencionar la importancia del comercio ya que debido a su situación geográfica y características climáticas hizo que una multitud de personas acudieron a los mercados y tianguis, llevando parte de sus productos en busca del intercambio por otros. Los medios de cambio más generalmente aceptados eran: granos de cacao, mantas de algodón, plumas, joyas de oro y pequeños ganchos de cobre.\n" +
                "En casi todos los lugares se organizaba el comercio local que estaba organizado en forma rígida y bien definida. El día de mercado o tianguis, era un día de reunión especial considerado como un día festivo. Los comerciantes locales se llamaban tlanemácac. Además también existía un comercio exterior que se realizaba en ferias anuales a las que acudían comerciantes especializados provenientes de todas partes de Mesoamérica.";
        textView_economia.setText(txt_economia);
        textView_economia.setMovementMethod(new ScrollingMovementMethod());
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.show();
    }

    private void ShowPopupReligion() {
        ImageView txtclose;
        TextView textView_religion;

        myDialog.setContentView((R.layout.religion_popup));

        txtclose = (ImageView) myDialog.findViewById(R.id.txtclose_religion);
        textView_religion = (TextView) myDialog.findViewById(R.id.textView_religion);
        String txt_religion="La religión mexica puede ser calificada como politeísta, pues salta a la luz su multitud de dioses, estos eran inmortales, en el sentido en el que podrían existir para siempre en un futuro, aunque podían morir, resucitar o volver a nacer infinitas veces. Residían en los distintos cielos en lugares específicos de la tierra o en el inframundo. Cada uno de ellos pertenecía a ámbitos específicos de la naturaleza o cultura humana. \n" +
                "\n" +
                "Dos de los dioses más  importantes de la cultura Mexica eran Tezcatlipoca y Quetzalcóatl, los consideraban como los dioses creadores por excelencia; ellos hicieron el universo, o sea,el cielo, la tierra, las aguas, el sol y el fuego, el tiempo y las edades del mundo, y el inframundo, con sus respectivas deidades.";
        textView_religion.setText(txt_religion);
        textView_religion.setMovementMethod(new ScrollingMovementMethod());
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.show();
    }


    private void ShowPopupOrganizacion() {
        ImageView txtclose;
        TextView textView_organizacion;

        myDialog.setContentView((R.layout.organizacion_popup));

        txtclose = (ImageView) myDialog.findViewById(R.id.txtclose_organizacion);
        textView_organizacion = (TextView) myDialog.findViewById(R.id.textView_organizacion);
        String txt_organizacion="La sociedad mexica estaba profundamente dividida. La base de la población estaba constituida por los macehualtin o gente del pueblo. La mayoría se dedicaba a la agricultura y otros a diversas labores, como alfareros, carpinteros, albañiles, herbolarios y otras más.\n" +
                "\n" +
                "Los pipiltin o miembros de la nobleza conformaban la clase dirigente. Gozaban de privilegios y controlaban los altos cargos administrativos, militares y religiosos. \n" +
                "\n" +
                "Al mando supremo de Tenochtitlán replicaba simbólicamente el orden divino y recaía en dos gobernantes: \n" +
                "El tlatoani, era el rey y su poder correspondía al cielo y al ámbito masculino. Era el representante de Tezcatlipoca en este mundo, el máximo dirigente militar, gran sacerdote y juez supremo.\n" +
                "El cihuacóatl, era un ayudante y representaba el poder de la tierra y lo femenino. Suplía en ausencia del tlatoani y se ocupaba de asuntos administrativos, hacendarios y judiciales.";
        textView_organizacion.setText(txt_organizacion);
        textView_organizacion.setMovementMethod(new ScrollingMovementMethod());
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
        TextView textView_ubicacion;

        myDialog.setContentView((R.layout.ubicacion_popup));

        txtclose = (ImageView) myDialog.findViewById(R.id.imgclose_ubicacion);
        textView_ubicacion = (TextView) myDialog.findViewById(R.id.textView_ubicacion);
        String txt_ubi="Los mexicas provenían de un legendario lugar llamado Aztlán “lugar de la blancura”,situado en el noroeste de Mesoamérica. Tras casi dos siglos de peregrinación, en 1325 d.C.  fundaron en un islote en el lago de Texcoco, México-Tenochtitlán, ciudad que llegaría a ser apenas un siglo la más importante de Mesoamérica. Tenochtitlán era una gran ciudad organizada en cuatro grandes calpullis o barrios; se encontraba unida con los pueblos costeros mediante extensas calzadas, al centro de la ciudad se encontraba el espacio sagrado o de habitación de los dioses. El pequeño islote pronto fue ocupado en su totalidad, lo que ocasionó que el área de la tierra firme aumentara, y que áreas próximas del lago se rellenaran con grandes cantidades de piedra y lodo. \n" +
                "\n" +
                "En 1428, se formó la Triple Alianza en la cual estaban Tenochtitlán, Tlacopan y Texcoco. A partir de ese momento, los mexicas comenzaron un ciclo de conquistas sucesivas dominando diversas regiones mesoamericanas, cuyos pueblos estaban obligados a entregar periódicamente tributo. Durante su máximo esplendor, la Triple Alianza controlaba un territorio que comprendía más de 400 pueblos.";
        textView_ubicacion.setText(txt_ubi);
        textView_ubicacion.setMovementMethod(new ScrollingMovementMethod());
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.show();
    }

    private void ShowPopupAgricultura() {
        ImageView txtclose;
        GridView gridView_agri;
        myDialog.setContentView((R.layout.agricultura_popup));

        gridView_agri = (GridView) myDialog.findViewById(R.id.gridview_agri);

        CaracteristicasActivity.CustomAdaptere customAdaptere = new  CaracteristicasActivity.CustomAdaptere();
        gridView_agri.setAdapter(customAdaptere);
        //MANDAR A INTENT DESDE UN BOTON
        gridView_agri.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    //BOTON maiz
                    String txt_maiz="Maíz.\n\n" +
                            "El maíz formaba parte fundamental de la alimentación del pueblo mexica. Era cultivado en enormes cantidades, al punto que lograron almacenarlo en grandes cantidades para cubrir tiempos de cosechas difíciles por condiciones de escasez de lluvias. Así garantizaban el alimento al millón y medio de habitantes que en el año 1519 ocupaba el valle de México.";
                    agriculturePopup(txt_maiz);
                }
                if(i == 1){
                    //BOTON algodon
                    String txt_algodon="Algodón.\n\n" +
                            "Estas plantas arbustivas se cultivan por sus fibras semillares muy aptas para la producción de textiles. Los vestigios de sus frutos y semillas de algodón más antiguos son de hace 5,500 años.\n\n" +
                            "En la época prehispánica los productos hechos con algodón eran muy apreciados. Los mexicas lo utilizaban para elaborar mantas de alto valor y prendas de vestir reservadas a la elite.";
                    agriculturePopup(txt_algodon);
                }
                if(i == 2){
                    //BOTON cacao
                    String txt_cacao="Cacao.\n\n" +
                            "Al sembrar este arbusto, se le coloca al lado de otro árbol que crece en altura y suministra sombra, de suerte que este árbol es como la madre del cacao.\n\n" +
                            "El grano del cacao era un bien muy preciado en la sociedad azteca, no sólo como alimento, sino como medicina contra innumerables enfermedades, como afrodisíaco e incluso como método de pago.";
                    agriculturePopup(txt_cacao);
                }
                if(i == 3){
                    //BOTON maguey
                    String txt_maguey="Maguey.\n\n" +
                            "De la planta del maguey, obtenían fibras para confeccionar vestimentas y una miel que utilizaban como endulzante, con ella preparaban una bebida llamada pulque.\n\n" +
                            "Éste se usa\u00ADba como licor, como intoxicante ritual, y como complemento nutritivo importante.";
                    agriculturePopup(txt_maguey);
                }
            }
        });


        txtclose = (ImageView) myDialog.findViewById(R.id.txtclose_agricultura);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.show();
    }


    private void agriculturePopup(String txt) {
        ImageView txtclose;
        TextView textView_agriculture;

        myDialog2.setContentView((R.layout.agriculture_popup));

        txtclose = (ImageView) myDialog2.findViewById(R.id.txtclose_agriculture);
        textView_agriculture = (TextView) myDialog2.findViewById(R.id.textView_agriculture);
        textView_agriculture.setText(txt);
        textView_agriculture.setMovementMethod(new ScrollingMovementMethod());
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog2.dismiss();
            }
        });

        myDialog2.show();
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return btnImagescarac.length;
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
            View view1 = getLayoutInflater().inflate(R.layout.row_data_large,null);

            ImageView imageView = (ImageView) view1.findViewById(R.id.images_large);
            imageView.setImageResource(btnImagescarac[i]);
            return view1;

        }

    }

    private class CustomAdaptere extends BaseAdapter {

        @Override
        public int getCount() {
            return btnImagesagri.length;
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
            View view1 = getLayoutInflater().inflate(R.layout.row_data_agriculture,null);

            ImageView imageView = (ImageView) view1.findViewById(R.id.images_large_agri);
            imageView.setImageResource(btnImagesagri[i]);
            return view1;

        }

    }


}
