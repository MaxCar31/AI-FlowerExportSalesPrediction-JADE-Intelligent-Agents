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

import EnviarMensaje.Mostrar;
import org.jgap.*;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

public class AG3 {
    public int[] empezar() {
        try {
            Configuration configuracion = new DefaultConfiguration();
            FitnessFunction myFunc = new funcionAptitud3();
            configuracion.setFitnessFunction(myFunc);
            Gene[] genEjemplo = new Gene[24];

            for (int i = 0; i < genEjemplo.length; i++) {
                genEjemplo[i] = new IntegerGene(configuracion, 0, 1);
            }

            Chromosome cromosomaNumero = new Chromosome(configuracion, genEjemplo);
            configuracion.setSampleChromosome(cromosomaNumero);
            configuracion.setPopulationSize(5);

            Genotype population = Genotype.randomInitialGenotype(configuracion);

            Mostrar show = new Mostrar();

            double mejor_aptitud = 0;

            for (int m = 0; m < 7; m++) {
                population.evolve(10);

                IChromosome mejor_individuo = population.getFittestChromosome();

                mejor_aptitud = mejor_individuo.getFitnessValue();
            }


            int[] values = show.obetnerPares(population.getFittestChromosome());

            return new int[]{values[0], values[1], (int) (mejor_aptitud * 100)};
        } catch (InvalidConfigurationException ex) {
            System.out.println("No se pudo ejecutar el AG");
        }

        return new int[] {0, 0, 0};
    }
}
