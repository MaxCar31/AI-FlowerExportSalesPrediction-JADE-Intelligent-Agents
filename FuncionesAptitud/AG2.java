/*
 * Este archivo pertenece al paquete FuncionesAptitud.
 * Contiene la implementación del Algoritmo Genético 2 (AG2) para resolver un problema de optimización.
 * El AG2 utiliza la función de aptitud definida en la clase funcionAptitud2.
 */

package FuncionesAptitud;

import EnviarMensaje.Mostrar; // Importa la clase Mostrar para mostrar resultados
import org.jgap.*; // Importa las clases del framework JGAP
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

public class AG2 {
    // Método principal para iniciar el AG2
    public int[] empezar() {
        try {
            // Configuración del Algoritmo Genético
            Configuration configuracion = new DefaultConfiguration();
            FitnessFunction myFunc = new funcionAptitud2(); // Define la función de aptitud personalizada
            configuracion.setFitnessFunction(myFunc);
            Gene[] genEjemplo = new Gene[24];

            // Creación de genes (variables genéticas)
            for (int i = 0; i < genEjemplo.length; i++) {
                genEjemplo[i] = new IntegerGene(configuracion, 0, 1); // Genes enteros con valores entre 0 y 1
            }

            // Creación de un cromosoma (conjunto de genes) con la configuración
            Chromosome cromosomaNumero = new Chromosome(configuracion, genEjemplo);
            configuracion.setSampleChromosome(cromosomaNumero);
            configuracion.setPopulationSize(5); // Tamaño de la población inicial

            // Creación de la población inicial de genotipos aleatorios
            Genotype population = Genotype.randomInitialGenotype(configuracion);

            Mostrar show = new Mostrar(); // Crea una instancia de la clase "Mostrar" para mostrar resultados

            double mejor_aptitud = 0;

            // Evolución de la población durante 7 generaciones
            for (int m = 0; m < 7; m++) {
                population.evolve(10); // Evoluciona la población durante 10 iteraciones

                // Obtiene el cromosoma más apto de la población
                IChromosome mejor_individuo = population.getFittestChromosome();

                mejor_aptitud = mejor_individuo.getFitnessValue(); // Obtiene el valor de aptitud del mejor individuo
            }

            // Obtiene los valores de los genes del cromosoma más apto
            int[] values = show.obetnerPares(population.getFittestChromosome());

            // Retorna un arreglo con tres valores: valor1, valor2 y aptitud del mejor individuo
            return new int[]{values[0], values[1], (int) (mejor_aptitud * 100)};
        } catch (InvalidConfigurationException ex) {
            System.out.println("No se pudo ejecutar el AG"); // En caso de error, muestra un mensaje
        }

        // En caso de error, retorna un arreglo con valores predeterminados
        return new int[]{0, 0, 0};
    }
}
