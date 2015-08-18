package br.org.btoffoli.heuristica.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by btoffoli on 17/08/15.
 */
public class NaiveLocalSearch {

    private int numOnibus = 10;
    private int numViagem = 20;


    private List<Onibus> matrizOnibus;
    private List<Viagem> matrizViagem;

    public void buildOnibus() {
        matrizOnibus = new ArrayList<>(numOnibus);

        
    }
}
