/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HENRY
 */
package EnviarMensaje;
import org.jgap.IChromosome;

public class Mostrar {
    // Variables para almacenar valores de genes
    private Integer c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;

    // Método para mostrar la información de un individuo de cromosoma
    public void mostrarIndividuo(IChromosome ind) {
        obtenerValoresGenes(ind);

        String signoX = (c1 == 0) ? "-" : "";
        String signoY = (c6 == 0) ? "-" : "";

        int valorXint = obtenerValorEntero(c2, c3, c4, c5);
        int valorYint = obtenerValorEntero(c7, c8, c9, c10);

        System.out.println(signoX + valorXint + " ; " + signoY + valorYint + "\n");
    }

    // Método para mostrar la información de varios individuos de cromosomas
    public void mostrarTodosIndividuos(IChromosome[] ind) {
        for (IChromosome iChromosome : ind) {
            obtenerValoresGenes(iChromosome);

            String signoX = (c1 == 0) ? "-" : "";
            String signoY = (c6 == 0) ? "-" : "";

            int valorXint = obtenerValorEntero(c2, c3, c4, c5);
            int valorYint = obtenerValorEntero(c7, c8, c9, c10);

            System.out.println(signoX + valorXint + " ; " + signoY + valorYint);
        }
    }

    // Método para obtener los valores de los genes de un individuo
    private void obtenerValoresGenes(IChromosome ind) {
        c1 = (Integer) ind.getGene(0).getAllele();
        c2 = (Integer) ind.getGene(1).getAllele();
        c3 = (Integer) ind.getGene(2).getAllele();
        c4 = (Integer) ind.getGene(3).getAllele();
        c5 = (Integer) ind.getGene(4).getAllele();
        c6 = (Integer) ind.getGene(5).getAllele();
        c7 = (Integer) ind.getGene(6).getAllele();
        c8 = (Integer) ind.getGene(7).getAllele();
        c9 = (Integer) ind.getGene(8).getAllele();
        c10 = (Integer) ind.getGene(9).getAllele();
    }

    // Método para obtener un valor entero a partir de valores de genes
    private int obtenerValorEntero(Integer... genes) {
        StringBuilder valorBinario = new StringBuilder();
        for (Integer gene : genes) {
            valorBinario.append(gene);
        }
        return Integer.parseInt(valorBinario.toString(), 2);
    }

    // Método para obtener un arreglo con pares de valores de genes
    public int[] obetnerPares(IChromosome ind) {
        obtenerValoresGenes(ind);

        int valorXint = obtenerValorEntero(c1, c2, c3, c4, c5);
        int valorYint = obtenerValorEntero(c6, c7, c8, c9, c10);

        if (c6 == 0) {
            valorYint = -valorYint;
        }

        return new int[]{valorXint, valorYint};
    }
}