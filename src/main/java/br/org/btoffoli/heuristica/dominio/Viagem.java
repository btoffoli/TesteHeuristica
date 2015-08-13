package br.org.btoffoli.heuristica.dominio;

import com.vividsolutions.jts.geom.Point;

import java.util.Date;

/**
 * Created by bruno on 11/08/15.
 */
public class Viagem {
    public Point pontoInicio;
    public Point pontoFinal;

    public Date dataHoraInicial;
    public Date dataHoraFinal;

    private Onibus onibus;
    private void associarOnibus(Onibus onibus) {
        if (onibus == null) {
            this.onibus = onibus;
            onibus.viagemSet.add(this);
            onibus.ultimaPosicao = this.pontoFinal;
        }
    }
}
