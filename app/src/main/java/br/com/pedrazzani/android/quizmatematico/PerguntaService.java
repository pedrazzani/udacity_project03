package br.com.pedrazzani.android.quizmatematico;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pedrazzani on 26/12/2016.
 */

public class PerguntaService {

    private AppCompatActivity app;

    public PerguntaService(AppCompatActivity appCompatActivity) {
        app = appCompatActivity;
    }

    public List<Pergunta> montaPerguntas() {
        List<Pergunta> lista = new ArrayList<>();
        Resources resources = app.getResources();


        Pergunta p1 = new Pergunta();
        p1.setPergunta(resources.getString(R.string.pergunta_1));
        p1.setAlternativa1(resources.getString(R.string.pergunta_1_alternativa_1));
        p1.setAlternativa2(resources.getString(R.string.pergunta_1_alternativa_2));
        p1.setAlternativa3(resources.getString(R.string.pergunta_1_alternativa_3));
        p1.setCorreta(resources.getString(R.string.pergunta_1_correta));
        p1.setTipo(Pergunta.Tipos.valueOf(resources.getString(R.string.pergunta_1_tipo)));

        Pergunta p2 = new Pergunta();
        p2.setPergunta(resources.getString(R.string.pergunta_2));
        p2.setAlternativa1(resources.getString(R.string.pergunta_2_alternativa_1));
        p2.setAlternativa2(resources.getString(R.string.pergunta_2_alternativa_2));
        p2.setAlternativa3(resources.getString(R.string.pergunta_2_alternativa_3));
        p2.setCorreta(resources.getString(R.string.pergunta_2_correta));
        p2.setTipo(Pergunta.Tipos.valueOf(resources.getString(R.string.pergunta_2_tipo)));

        Pergunta p3 = new Pergunta();
        p3.setPergunta(resources.getString(R.string.pergunta_3));
        p3.setAlternativa1(resources.getString(R.string.pergunta_3_alternativa_1));
        p3.setAlternativa2(resources.getString(R.string.pergunta_3_alternativa_2));
        p3.setAlternativa3(resources.getString(R.string.pergunta_3_alternativa_3));
        p3.setCorreta(resources.getString(R.string.pergunta_3_correta));
        p3.setTipo(Pergunta.Tipos.valueOf(resources.getString(R.string.pergunta_3_tipo)));

        Pergunta p4 = new Pergunta();
        p4.setPergunta(resources.getString(R.string.pergunta_4));
        p4.setAlternativa1(resources.getString(R.string.pergunta_4_alternativa_1));
        p4.setAlternativa2(resources.getString(R.string.pergunta_4_alternativa_2));
        p4.setAlternativa3(resources.getString(R.string.pergunta_4_alternativa_3));
        p4.setCorreta(resources.getString(R.string.pergunta_4_correta));
        p4.setTipo(Pergunta.Tipos.valueOf(resources.getString(R.string.pergunta_4_tipo)));

        Pergunta p5 = new Pergunta();
        p5.setPergunta(resources.getString(R.string.pergunta_5));
        p5.setAlternativa1(resources.getString(R.string.pergunta_5_alternativa_1));
        p5.setAlternativa2(resources.getString(R.string.pergunta_5_alternativa_2));
        p5.setAlternativa3(resources.getString(R.string.pergunta_5_alternativa_3));
        p5.setCorreta(resources.getString(R.string.pergunta_5_correta));
        p5.setTipo(Pergunta.Tipos.valueOf(resources.getString(R.string.pergunta_5_tipo)));

        Pergunta p6 = new Pergunta();
        p6.setPergunta(resources.getString(R.string.pergunta_6));
        p6.setAlternativa1(resources.getString(R.string.pergunta_6_alternativa_1));
        p6.setAlternativa2(resources.getString(R.string.pergunta_6_alternativa_2));
        p6.setAlternativa3(resources.getString(R.string.pergunta_6_alternativa_3));
        p6.setCorreta(resources.getString(R.string.pergunta_6_correta));
        p6.setTipo(Pergunta.Tipos.valueOf(resources.getString(R.string.pergunta_6_tipo)));

        Pergunta p7 = new Pergunta();
        p7.setPergunta(resources.getString(R.string.pergunta_7));
        p7.setAlternativa1(resources.getString(R.string.pergunta_7_alternativa_1));
        p7.setAlternativa2(resources.getString(R.string.pergunta_7_alternativa_2));
        p7.setAlternativa3(resources.getString(R.string.pergunta_7_alternativa_3));
        p7.setCorreta(resources.getString(R.string.pergunta_7_correta));
        p7.setTipo(Pergunta.Tipos.valueOf(resources.getString(R.string.pergunta_7_tipo)));

        Pergunta p8 = new Pergunta();
        p8.setPergunta(resources.getString(R.string.pergunta_8));
        p8.setAlternativa1(resources.getString(R.string.pergunta_8_alternativa_1));
        p8.setAlternativa2(resources.getString(R.string.pergunta_8_alternativa_2));
        p8.setAlternativa3(resources.getString(R.string.pergunta_8_alternativa_3));
        p8.setCorreta(resources.getString(R.string.pergunta_8_correta));
        p8.setTipo(Pergunta.Tipos.valueOf(resources.getString(R.string.pergunta_8_tipo)));

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p7);
        lista.add(p8);
        Collections.shuffle(lista);

        return lista;
    }

}
