/* Questão 02:
 * Aluno: Pedro Augusto Dias de Lima             - Matrícula: 20210026400 
 * Aluno: Jorge Alberto Macedo Costa de Oliveira - Matrícula: 20210026886
 */

import java.util.ArrayList;
import java.util.Random;

public class ParImpar {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        ArrayList<Integer> listPar = new ArrayList<Integer>(), listImpar = new ArrayList<Integer>();

        do {
            int numeroRandom = rand.nextInt(30);

            if (numeroRandom == 0) {
                continue;
            }
            if (numeroRandom % 2 == 0 && listPar.size() < 10) {
                listPar.add(numeroRandom);
                continue;
            }
            if (numeroRandom % 2 != 0 && listImpar.size() < 10) {
                listImpar.add(numeroRandom);
                continue;
            }
        } while (listImpar.size() < 10 || listPar.size() < 10);

        System.out.println("Números impares: ");
        listImpar.stream().forEach(System.out::println);

        System.out.println("Números pares: ");
        listPar.stream().forEach(System.out::println);
    }
}
