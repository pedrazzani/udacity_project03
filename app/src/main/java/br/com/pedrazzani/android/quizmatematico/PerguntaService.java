package br.com.pedrazzani.android.quizmatematico;

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

        Pergunta p1 = new Pergunta();
        p1.setPergunta(app.getResources().getString(R.string.pergunta_1));
        p1.setAlternativa1(app.getResources().getString(R.string.pergunta_1_alternativa_1));
        p1.setAlternativa2(app.getResources().getString(R.string.pergunta_1_alternativa_2));
        p1.setAlternativa3(app.getResources().getString(R.string.pergunta_1_alternativa_3));
        p1.setCorreta(app.getResources().getString(R.string.pergunta_1_correta));

        Pergunta p2 = new Pergunta();
        p2.setPergunta(app.getResources().getString(R.string.pergunta_2));
        p2.setAlternativa1(app.getResources().getString(R.string.pergunta_2_alternativa_1));
        p2.setAlternativa2(app.getResources().getString(R.string.pergunta_2_alternativa_2));
        p2.setAlternativa3(app.getResources().getString(R.string.pergunta_2_alternativa_3));
        p2.setCorreta(app.getResources().getString(R.string.pergunta_2_correta));

        Pergunta p3 = new Pergunta();
        p3.setPergunta(app.getResources().getString(R.string.pergunta_3));
        p3.setAlternativa1(app.getResources().getString(R.string.pergunta_3_alternativa_1));
        p3.setAlternativa2(app.getResources().getString(R.string.pergunta_3_alternativa_2));
        p3.setAlternativa3(app.getResources().getString(R.string.pergunta_3_alternativa_3));
        p3.setCorreta(app.getResources().getString(R.string.pergunta_3_correta));

        Pergunta p4 = new Pergunta();
        p4.setPergunta(app.getResources().getString(R.string.pergunta_4));
        p4.setAlternativa1(app.getResources().getString(R.string.pergunta_4_alternativa_1));
        p4.setAlternativa2(app.getResources().getString(R.string.pergunta_4_alternativa_2));
        p4.setAlternativa3(app.getResources().getString(R.string.pergunta_4_alternativa_3));
        p4.setCorreta(app.getResources().getString(R.string.pergunta_4_correta));

        Pergunta p5 = new Pergunta();
        p5.setPergunta(app.getResources().getString(R.string.pergunta_5));
        p5.setAlternativa1(app.getResources().getString(R.string.pergunta_5_alternativa_1));
        p5.setAlternativa2(app.getResources().getString(R.string.pergunta_5_alternativa_2));
        p5.setAlternativa3(app.getResources().getString(R.string.pergunta_5_alternativa_3));
        p5.setCorreta(app.getResources().getString(R.string.pergunta_5_correta));

        Pergunta p6 = new Pergunta();
        p6.setPergunta(app.getResources().getString(R.string.pergunta_6));
        p6.setAlternativa1(app.getResources().getString(R.string.pergunta_6_alternativa_1));
        p6.setAlternativa2(app.getResources().getString(R.string.pergunta_6_alternativa_2));
        p6.setAlternativa3(app.getResources().getString(R.string.pergunta_6_alternativa_3));
        p6.setCorreta(app.getResources().getString(R.string.pergunta_6_correta));

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        Collections.shuffle(lista);

        return lista;
    }

}
