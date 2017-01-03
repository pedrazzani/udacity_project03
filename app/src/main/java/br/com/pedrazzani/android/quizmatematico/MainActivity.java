package br.com.pedrazzani.android.quizmatematico;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getName();
    private LayoutInflater inflater;

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

    //Inicia o Quiz
    private void init() {

        Log.v(TAG, "Inicio.");

        inflater = LayoutInflater.from(getApplicationContext());

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

    /**
     * Preenche os dados no layout para a Próxima pergunta do Quiz
     *
     * @throws IndexOutOfBoundsException
     */
    public void carregaProximaPergunta() throws IndexOutOfBoundsException {

        Log.v(TAG, "Carregando...");

        Pergunta p = perguntas.get(index);
        Log.v(TAG, "Index: " + index);
        Log.v(TAG, "Pergunta: " + p.getPergunta());
        Log.v(TAG, "Pergunta: " + p.getTipo());

        switch (p.getTipo()) {
            case RADIO: {
                createRadioLayout(p);
                break;
            }
            case EDIT: {
                createEditLayout(p);
                break;
            }
            case CHECK: {
                createCheckLayout(p);
                break;
            }
        }

        Log.v(TAG, "Pronto...");
    }
    //Cria o Layout para as views CheckBox
    private void createCheckLayout(Pergunta p) {

        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.content_check, null);
        TextView textView = (TextView) inflater.inflate(R.layout.content_pergunta, null);

        LinearLayout layout = (LinearLayout) findViewById(R.id.content_pergunta);
        layout.removeAllViews();
        layout.addView(textView);
        layout.addView(linearLayout);

        CheckBox alt_1 = (CheckBox) linearLayout.findViewById(R.id.alternativa_1_checkbox);
        CheckBox alt_2 = (CheckBox) linearLayout.findViewById(R.id.alternativa_2_checkbox);
        CheckBox alt_3 = (CheckBox) linearLayout.findViewById(R.id.alternativa_3_checkbox);

        //Seta o primeiro RadioButton
        alt_1.setChecked(Boolean.FALSE);
        alt_2.setChecked(Boolean.FALSE);
        alt_3.setChecked(Boolean.FALSE);

        //Carrega os Views com as Informações do Quiz
        textView.setText(p.getPergunta());
        alt_1.setText(p.getAlternativa1());
        alt_2.setText(p.getAlternativa2());
        alt_3.setText(p.getAlternativa3());
    }

    //Carrega os dados da pergunta no Layout
    private void createEditLayout(Pergunta p) {
        Log.v(TAG, "Criando Layout Edit...");

        EditText editText = (EditText) inflater.inflate(R.layout.content_edit, null);
        TextView textView = (TextView) inflater.inflate(R.layout.content_pergunta, null);

        LinearLayout layout = (LinearLayout) findViewById(R.id.content_pergunta);
        layout.removeAllViews();
        layout.addView(textView);
        layout.addView(editText);

        textView.setText(p.getPergunta());
        editText.setText("");

        Log.v(TAG, "Criando Layout Edit... FEITO");
    }

    //Carrega os dados da pergunta no Layout
    private void createRadioLayout(Pergunta p) {

        RadioGroup radioGroup = (RadioGroup) inflater.inflate(R.layout.content_radio, null);
        TextView textView = (TextView) inflater.inflate(R.layout.content_pergunta, null);

        LinearLayout layout = (LinearLayout) findViewById(R.id.content_pergunta);
        layout.removeAllViews();
        layout.addView(textView);
        layout.addView(radioGroup);

        RadioButton alt_1 = (RadioButton) radioGroup.findViewById(R.id.alternativa_1_radio_button);
        RadioButton alt_2 = (RadioButton) radioGroup.findViewById(R.id.alternativa_2_radio_button);
        RadioButton alt_3 = (RadioButton) radioGroup.findViewById(R.id.alternativa_3_radio_button);

        //Seta o primeiro RadioButton
        alt_1.setChecked(Boolean.TRUE);
        alt_2.setChecked(Boolean.FALSE);
        alt_3.setChecked(Boolean.FALSE);

        //Carrega os Views com as Informações do Quiz
        textView.setText(p.getPergunta());
        alt_1.setText(p.getAlternativa1());
        alt_2.setText(p.getAlternativa2());
        alt_3.setText(p.getAlternativa3());

    }

    //Gerencia o Tipo de View para direcionar para computar a resposta
    public void addResposta() {

        Log.v(TAG, "Add Resposta... ");
        Pergunta p = perguntas.get(index);

        switch (p.getTipo()) {
            case RADIO: {
                radioResposta(p);
                break;
            }
            case EDIT: {
                editResposta(p);
                break;
            }
            case CHECK: {
                checkResposta(p);
                break;
            }
        }
        Log.v(TAG, "Add Resposta... Pronto");

    }

    //Computa resposta
    private void radioResposta(Pergunta p) {
        RadioButton alt_1 = (RadioButton) findViewById(R.id.alternativa_1_radio_button);
        RadioButton alt_2 = (RadioButton) findViewById(R.id.alternativa_2_radio_button);
        RadioButton alt_3 = (RadioButton) findViewById(R.id.alternativa_3_radio_button);

        if (alt_1.isChecked()) {
            p.setResposta(alt_1.getText().toString());
        } else if (alt_2.isChecked()) {
            p.setResposta(alt_2.getText().toString());
        } else if (alt_3.isChecked()) {
            p.setResposta(alt_3.getText().toString());
        }
    }

    //Computa resposta
    private void checkResposta(Pergunta p) {
        CheckBox alt_1 = (CheckBox) findViewById(R.id.alternativa_1_checkbox);
        CheckBox alt_2 = (CheckBox) findViewById(R.id.alternativa_2_checkbox);
        CheckBox alt_3 = (CheckBox) findViewById(R.id.alternativa_3_checkbox);


        StringBuilder resp = new StringBuilder();
        if (alt_1.isChecked()) {
            resp.append(alt_1.getText().toString());
        }
        if (alt_2.isChecked()) {
            if (resp.length() > 0) resp.append(",");
            resp.append(alt_2.getText().toString());
        }

        if (alt_3.isChecked()) {
            if (resp.length() > 0) resp.append(",");
            resp.append(alt_3.getText().toString());
        }

        p.setResposta(resp.toString());
    }

    //Computa resposta
    private void editResposta(Pergunta p) {
        EditText edit = (EditText) findViewById(R.id.content_edit);
        p.setResposta(edit.getText().toString());
    }
}
