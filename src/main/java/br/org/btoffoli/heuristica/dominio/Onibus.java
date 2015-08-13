package br.org.btoffoli.heuristica.dominio;

import com.vividsolutions.jts.geom.Point;

import java.util.Set;

/**
 * Created by bruno on 11/08/15.
 */
public class Onibus {
    public Set<Viagem> viagemSet;
    public String nome;
    public Point ultimaPosicao;
    //TODO talvez fosse interessante utilizar a distancia total p/ fazer parte do modelo do problema, avaliar...
    public long kmMortoPercorrido = 0;
}
