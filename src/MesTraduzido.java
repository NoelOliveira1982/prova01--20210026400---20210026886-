/* Questão 01:
 * Aluno: Pedro Augusto Dias de Lima             - Matrícula: 20210026400 
 * Aluno: Jorge Alberto Macedo Costa de Oliveira - Matrícula: 20210026886
 */

import java.util.Scanner;

public class MesTraduzido {

    public static void main(String[] args) {

        int index;
        String idioma_meses[][] = {
                { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
                        "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" },
                { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
                        "November", "December" }
        };

        char escolha_sn = 's';

        try (Scanner input = new Scanner(System.in)) {
            do {
                System.out.println();
                System.out.println("Escolha um idioma:");
                System.out.println("1) Português");
                System.out.println("2) English");
                System.out.print("~> ");
                index = (input.nextInt() - 1);

                if (index == 0) {
                    System.out.println();
                    System.out.println("Escolha o número de um mês do ano para traduzir");
                    System.out.print("~>");
                    index = (input.nextInt() - 1);
                    System.out.println(idioma_meses[0][index]);
                    System.out.println();
                    System.out.println("Deseja consultar outro mês? (S/N)");
                    System.out.print("~>");
                    escolha_sn = input.next().charAt(0);

                } else if (index == 1) {
                    System.out.println();
                    System.out.println("Choose the number of a month to translate");
                    System.out.print("~>");
                    index = (input.nextInt() - 1);
                    System.out.println(idioma_meses[1][index]);
                    System.out.println();
                    System.out.println("Do you wish to check another month? (S/N)");
                    System.out.print("~>");
                    escolha_sn = input.next().charAt(0);
                } else {
                    System.out.println("Escolha uma opção válida!");
                }

            } while (escolha_sn == 's' || escolha_sn == 'S');

        } catch (ArrayIndexOutOfBoundsException erro) {
            System.out.println("Erro: Input inválido!");
        }

    }

}