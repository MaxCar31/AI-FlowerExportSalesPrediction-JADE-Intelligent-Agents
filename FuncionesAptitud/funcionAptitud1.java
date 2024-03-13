/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesAptitud;

/**
 * @author
 */

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class funcionAptitud1 extends FitnessFunction {
    private double fitness; //La variable que llevará el valor de aptitud

    public funcionAptitud1() {
        fitness = 0;
    }

    @Override
    protected double evaluate(IChromosome cromosoma) {
        Evaluar(cromosoma);
        return fitness;
    }

    private void Evaluar(IChromosome cromosoma) {
        int valorXint = 0;
        int valorYint = 0;

        for (int i = 0; i < 5; i++) {
            valorXint = (valorXint << 1) | (Integer) cromosoma.getGene(i).getAllele();
        }

        for (int i = 5; i < 24; i++) {
            valorYint = (valorYint << 1) | (Integer) cromosoma.getGene(i).getAllele();
        }

        int signoY = (Integer) cromosoma.getGene(5).getAllele();

        if (signoY == 0) {
            valorYint = -valorYint;
        }

        double xPow6 = Math.pow(valorXint, 6);
        double xPow5 = Math.pow(valorXint, 5);
        double xPow4 = Math.pow(valorXint, 4);
        double xPow3 = Math.pow(valorXint, 3);
        double xPow2 = Math.pow(valorXint, 2);

        double functionValue = -0.2585 * xPow6 - 19.338 * xPow5 + 562.55 * xPow4 - 7979.2 * xPow3 + 56266 * xPow2 - 171797 * valorXint - 8038.4;

        if (functionValue > 0) {
            fitness = functionValue;
        } else {
            fitness = 0;
        }
    }
}