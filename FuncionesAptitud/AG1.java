package FuncionesAptitud;

import EnviarMensaje.Mostrar; // Importa una clase llamada "Mostrar" desde el paquete "EnviarMensaje"
import org.jgap.*;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

public class AG1 {
    public int[] empezar() {
        try {
            // Configuración del algoritmo genético
            Configuration configuration = new DefaultConfiguration();
            FitnessFunction myFunc = new funcionAptitud1(); // Define la función de aptitud personalizada
            configuration.setFitnessFunction(myFunc);
            Gene[] genEjemplo = new Gene[24];
            // Creación de genes (variables genéticas)
            for (int i = 0; i < genEjemplo.length; i++) {
                genEjemplo[i] = new IntegerGene(configuration, 0, 1); // Genes enteros con valores entre 0 y 1
            }
            // Creación de un cromosoma (conjunto de genes) con la configuración
            Chromosome NumCromosomas = new Chromosome(configuration, genEjemplo);
            configuration.setSampleChromosome(NumCromosomas);
            configuration.setPopulationSize(5); // Tamaño de la población inicial
            // Creación de la población inicial de genotipos aleatorios
            Genotype population = Genotype.randomInitialGenotype(configuration);

            double MejorScore = 0;
            Mostrar show = new Mostrar(); // Crea una instancia de la clase "Mostrar"

            // Evolución de la población durante 6 generaciones
            for (int m = 0; m < 7; m++) {
                population.evolve(10); // Evoluciona la población durante 10 iteraciones

                // Obtiene el cromosoma más apto de la población
                IChromosome mejor_individuo = population.getFittestChromosome();

                MejorScore = mejor_individuo.getFitnessValue(); // Obtiene el valor de aptitud del mejor individuo
            }

            // Obtiene los valores de los genes del cromosoma más apto
            int[] values = show.obetnerPares(population.getFittestChromosome());

            // Retorna un arreglo con tres valores: valor1, valor2 y aptitud del mejor individuo
            return new int[]{values[0], values[1], (int) (MejorScore * 100)};
        } catch (InvalidConfigurationException ex) {
            System.out.println("No se pudo ejecutar el AG"); // En caso de error, muestra un mensaje
        }

        // En caso de error, retorna un arreglo con valores predeterminados
        return new int[]{0, 0, 0};
    }
}
