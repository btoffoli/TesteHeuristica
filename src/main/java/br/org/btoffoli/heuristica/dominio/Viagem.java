package br.org.btoffoli.heuristica.dominio;

import com.vividsolutions.jts.geom.Point;

import java.util.Date;

/**
 * Created by bruno on 11/08/15.
 */
public class Viagem implements Cloneable {
    public Point pontoInicio;
    public Point pontoFinal;

    public Date dataHoraInicial;
    public Date dataHoraFinal;

    public Onibus onibus;

}
