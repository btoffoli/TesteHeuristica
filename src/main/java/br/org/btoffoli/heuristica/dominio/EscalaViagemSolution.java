package br.org.btoffoli.heuristica.dominio;

import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.operation.distance.DistanceOp;

import java.util.*;

/**
 * Created by bruno on 11/08/15.
 */
public class EscalaViagemSolution {
    public Set<Viagem> listaViagens;
    public Set<Onibus> listaOnibus;
    public double kmMortoTotal;

    public void rodarEscalonamento() {
        for(Viagem viagem : listaViagens) {
            Onibus onibus = sorteiaOnibusValido(viagem);
            associarOnibus(onibus, viagem);
        }
    }

    private Onibus sorteiaOnibusValido(Viagem viagem) {
        Onibus onibusEscolhido = null;
        List<Onibus> onibusNaoSorteados = new ArrayList<Onibus>(listaOnibus.size());
        onibusNaoSorteados.addAll(listaOnibus);


        while(onibusEscolhido == null && !onibusNaoSorteados.isEmpty()) {
            int numSorteio = (int) Math.floor(Math.random() * onibusNaoSorteados.size());
            Onibus onibus = onibusNaoSorteados.remove(numSorteio);
            onibusEscolhido = onibusDisponivelParaViagem(onibus, viagem) ? onibus : null;
        }

        return onibusEscolhido;

    }

    private boolean onibusDisponivelParaViagem(Onibus onibus, Viagem viagem) {
        Date dtHorInit = viagem.dataHoraInicial;
        Date dtHorFim = viagem.dataHoraFinal;

        //Verifica p/ cada viagem já agenda p/ o ônibus se o mesmo já não possui viagem conflitante em horário
        for(Viagem viagem1 : onibus.viagemSet) {
            if ((dtHorInit.after(viagem1.dataHoraInicial) && dtHorInit.before(viagem1.dataHoraFinal)) ||
                    (dtHorFim.after(viagem1.dataHoraInicial) && dtHorFim.before(viagem1.dataHoraFinal)))
                return false;
        }

        return true;
    }

    public void associarOnibus(Onibus onibus, Viagem viagem) {
        if (viagem.onibus == null) {
            viagem.onibus = onibus;
            double kmMortoAteViagem = obterKmMorto(onibus, viagem);
            kmMortoTotal += kmMortoAteViagem;
            onibus.kmMortoPercorrido += kmMortoAteViagem;
            onibus.viagemSet.add(viagem);
            onibus.ultimaPosicao = viagem.pontoFinal;
        }
    }

    private double obterKmMorto(Onibus onibus, Viagem viagem) {
        Point pontoInicial = onibus.ultimaPosicao;
        Point posicaoFinal = viagem.pontoInicio;


//        double distance = JTS.orthodromicDistance(start, end, crs);
//        JTS.or
//        int totalmeters = (int) distance;
//        int km = totalmeters / 1000;
//        int meters = totalmeters - (km * 1000);
//        float remaining_cm = (float) (distance - totalmeters) * 10000;
//        remaining_cm = Math.round(remaining_cm);
//        float cm = remaining_cm / 100;
//
//        System.out.println("Distance = " + km + "km " + meters + "m " + cm + "cm");

        //TODO look for distance unity, i think that isn't kilometers
        return DistanceOp.distance(pontoInicial, posicaoFinal);
    }





}
