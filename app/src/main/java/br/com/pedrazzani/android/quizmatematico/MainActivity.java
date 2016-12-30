package br.com.pedrazzani.android.quizmatematico;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getName();

    //Lista de Perguntas
    private List<Pergunta> perguntas;
    //Index para controle das posições da Lista
    private Integer index = 0;
    //Botão
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }

    /**
     * Verifica as Perguntas, selecionando as respostas corretas
     */
    public void verificaPerguntas() {

        int total = perguntas.size();
        int acertos = 0;

        for (Pergunta p : perguntas) {
            acertos = p.estaCorreta() ? (acertos + 1) : acertos;
        }

        //Adiona ação ao bottao
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
        //Muda a Imagem do Botão
        int id = getResources().getIdentifier("@android:drawable/ic_checkmark_holo_light", null, null);
        fab.setImageResource(id);
        Toast.makeText(getApplicationContext(), "Acertos: " + acertos + " / " + total, Toast.LENGTH_LONG).show();
    }


    //Inicia o Quiz
    private void init() {

        Log.v(TAG, "Inicio.");

        //Montas a Lista de Perguntas
        perguntas = new PerguntaService(this).montaPerguntas();

        index = 0;
        Log.v(TAG, "Index: " + index);

        carregaProximaPergunta();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResposta();
                index++;

                try {
                    carregaProximaPergunta();
                } catch (IndexOutOfBoundsException e) {
                    verificaPerguntas();
                }

            }
        });

        int id = getResources().getIdentifier("@android:drawable/ic_media_ff", null, null);
        fab.setImageResource(id);
        Log.v(TAG, "Init Finalizou.");
    }

    public void carregaProximaPergunta() throws IndexOutOfBoundsException {

        Log.v(TAG, "Carregando...");

        Pergunta p = perguntas.get(index);
        Log.v(TAG, "Index: " + index);
        Log.v(TAG, "Pergunta: " + p.getPergunta());

        TextView pergunta = (TextView) findViewById(R.id.pergunta_text_view);
        RadioButton alt_1 = (RadioButton) findViewById(R.id.alternativa_1_radio_button);
        RadioButton alt_2 = (RadioButton) findViewById(R.id.alternativa_2_radio_button);
        RadioButton alt_3 = (RadioButton) findViewById(R.id.alternativa_3_radio_button);

        //Tira a Seleção de todos os RadioButton
        alt_1.setChecked(Boolean.TRUE);
        alt_2.setChecked(Boolean.FALSE);
        alt_3.setChecked(Boolean.FALSE);

        pergunta.setText(p.getPergunta());
        alt_1.setText(p.getAlternativa1());
        alt_2.setText(p.getAlternativa2());
        alt_3.setText(p.getAlternativa3());

        Log.v(TAG, "Pronto...");
    }

    public void addResposta() {
        Log.v(TAG, "Add Resposta... ");

        RadioButton alt_1 = (RadioButton) findViewById(R.id.alternativa_1_radio_button);
        RadioButton alt_2 = (RadioButton) findViewById(R.id.alternativa_2_radio_button);
        RadioButton alt_3 = (RadioButton) findViewById(R.id.alternativa_3_radio_button);
        Pergunta p = perguntas.get(index);

        Log.v(TAG, "Index: " + index);
        Log.v(TAG, "Pergunta: " + p.getPergunta());

        if (alt_1.isChecked()) {
            p.setResposta(alt_1.getText().toString());
            Log.v(TAG, "Resposta: " + alt_1.getText().toString());
        } else if (alt_2.isChecked()) {
            p.setResposta(alt_2.getText().toString());
            Log.v(TAG, "Resposta: " + alt_2.getText().toString());
        } else if (alt_3.isChecked()) {
            p.setResposta(alt_3.getText().toString());
            Log.v(TAG, "Resposta: " + alt_3.getText().toString());
        }

        Log.v(TAG, "Add Resposta... Pronto");
    }
}
