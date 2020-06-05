package mx.ipn.tlamati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ConquistaActivity extends AppCompatActivity {
    ImageButton btn_regreso_conqu;
    TextView textView_conquista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conquista);
        textView_conquista = (TextView) findViewById(R.id.textView_conquista);
        String txt_conquista = "La Conquista de México-Tenochtitlán consistió en el sometimiento del Estado mexica, a favor del rey Carlos I de España. Tenochtitlán cayó en poder de los conquistadores españoles al mando de Hernán Cortés, después de dos años de importantes intentos militares, políticos y conspirativos, en los que participaron junto con los españoles, los pueblos previamente conquistados como los totonacos y tlaxcaltecas, este proceso se desarrolló de 1519, hasta el 13 de agosto de 1521, cuando cayó la ciudad después de 75 días de sitio.\n" +
                "\n" +
                "Encuentro Cortés-Moctezuma\n" +
                "Entraron los conquistadores a Tenochtitlán el 8 de noviembre de 1519, seguida del encuentro de Moctezuma y Cortés. Moctezuma pensaba que los españoles eran enviados de Quetzalcóatl por lo que les dio importantes obsequios y los hospedó en el templo de Axayacatl.\n" +
                "\n" +
                "Matanza del Templo Mayor\n" +
                "Pedro de Alvarado que se había quedado en Tenochtitlán llevó a cabo una matanza de nativos, de nobles, caciques y jefes de ejército, cuando se encontraban celebrando la fiesta de Tóxcatl en honor a Huitzilopochtli. Ante este acontecimiento la población, se indignó y los españoles se refugiaron en el palacio.\n" +
                "\n" +
                "Muerte de Moctezuma\n" +
                "Al llegar Cortés a Tenochtitlán, liberó a Cuitláhuac, para pacificar los ánimos, consiguió que Moctezuma tratase de apaciguar a los inconformes y que dejasen salir a los españoles de la ciudad, sin conseguirlo, Moctezuma fue asesinado.\n" +
                "\n" +
                "La noche triste\n" +
                "Los españoles, fueron rodeados por la multitud indígena, pronto se habían quedado sin víveres ni agua. La única salida era la retirada, que hicieron en la lluviosa noche del 30 de junio de 1520, conocida como la Noche Triste. En la retirada cayo la mayoría de los españoles ahogados en el lago. Perseguidos por los mexicas, el 7 de julio, cerca de Otumba, los españoles se enfrentaron a los guerreros que los perseguían y los derrotaron.\n" +
                "\n" +
                "Sitio final de Tenochtitlán\n" +
                "Después de su derrota, los españoles y sus aliados tlaxcaltecas se replegaron en Tlaxcala; se volvieron a organizar y atacaron Tenochtitlán. Mientras tanto los habitantes de la capital mexica se estaban muriendo de una serie de enfermedades (viruela, sarampión, gripe, etc.) que prácticamente imposibilitó su defensa.\n" +
                "Cortés mandó traer los navíos y después de un periodo de 75 días, en los que los mexicas pelearon hasta casi su exterminio, fueron derrotados y sometidos a esclavitud." ;
        textView_conquista.setText(txt_conquista);
        textView_conquista.setMovementMethod(new ScrollingMovementMethod());
        btn_regreso_conqu = (ImageButton) findViewById(R.id.btn_regreso_conqu);
        btn_regreso_conqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LearnActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

    }
}
