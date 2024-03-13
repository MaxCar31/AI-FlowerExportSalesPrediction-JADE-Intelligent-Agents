/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesAptitud;

/**
 *
 * @author HENRY
 */
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class funcionAptitud2 extends FitnessFunction {
    private double fitness; //La variable que llevará el valor de aptitud
    public funcionAptitud2() {
        fitness = 0;
    }

    @Override
    protected double evaluate(IChromosome cromosoma) {
        Evaluar(cromosoma);
        return fitness;//agregar comprobacion de si es 50
    }

    private void Evaluar(IChromosome cromosoma) {
        int valorXint = 0;
        int valorYint = 0;


        //PARA X
        for (int i = 0; i < 5; i++) {
            valorXint = (valorXint << 1) | (Integer) cromosoma.getGene(i).getAllele();
        }


        //PARA Y
        for (int i = 5; i < 24; i++) {
            valorYint = (valorYint << 1) | (Integer) cromosoma.getGene(i).getAllele();
        }

        int signoY = (Integer) cromosoma.getGene(5).getAllele();

        if (signoY == 0) {
            valorYint = -valorYint;
        }

        double functionValue = 3884.7 * valorXint - 173594;

        if (functionValue > 0) {
            fitness = functionValue;
        } else {
            fitness = 0;
        }
    }
}
