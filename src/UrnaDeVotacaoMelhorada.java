/* Questão 03:
 * Aluno: Pedro Augusto Dias de Lima             - Matrícula: 20210026400 
 * Aluno: Jorge Alberto Macedo Costa de Oliveira - Matrícula: 20210026886
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UrnaDeVotacaoMelhorada {

    private static class Candidato {
        private String codigo;
        private String nome;
        private int quantVotos;

        private Candidato(String nome, String codigo) {
            this.codigo = codigo;
            this.nome = nome;
            this.quantVotos = 0;
        }

        private Candidato(String nome, String codigo, int quantVotos) {
            this.codigo = codigo;
            this.nome = nome;
            this.quantVotos = quantVotos;
        }

        private double getPercentual(int ttlVotos) {
            return (this.quantVotos * 100) / ttlVotos;
        }

        private Candidato addVoto() {
            this.quantVotos++;
            return this;
        }

        private int getQuantVotos() {
            return this.quantVotos;
        }

        @Override
        public String toString() {
            return "Nome: " + this.nome + ". Votos: " + this.quantVotos;
        }
    }

    public static void main(String[] args) {
        int totalVotos = 0, i = 0, votosValidos = 0;
        ArrayList<Candidato> listCandidatos = new ArrayList<Candidato>() {
            {
                add(new Candidato("Maria da Silva", "111"));
                add(new Candidato("Pedro de Araujo", "222"));
                add(new Candidato("José de Sousa", "333"));
            }
        };
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Informe a quantidade de votações: ");
            totalVotos = sc.nextInt();

            while (i < totalVotos) {
                System.out.println("Informe o seu voto: ");
                String votoAux = sc.next();
                listCandidatos = listCandidatos.stream()
                        .map(candidato -> candidato = candidato.codigo.equals(votoAux)
                                ? candidato.addVoto()
                                : candidato)
                        .collect(Collectors.toCollection(ArrayList<Candidato>::new));
                i++;
            }

            votosValidos = listCandidatos.stream().reduce(0, (soma, candidato) -> soma + candidato.quantVotos,
                    Integer::sum);

            System.out.println("O total de votos foi: " + totalVotos);
            System.out.println("O percentual total de votos válidos é: " + (votosValidos * 100) / totalVotos
                    + "%. E o total de votos não válidos foi: " + ((totalVotos - votosValidos) * 100) / totalVotos
                    + "%.");
            for (Candidato candidato : listCandidatos) {
                System.out.println(
                        "Nome: " + candidato.nome + ". Percentual: " + candidato.getPercentual(totalVotos) + "%.");
            }
            Candidato vencedor = listCandidatos.stream().max(Comparator.comparing(Candidato::getQuantVotos)).get();

            if (listCandidatos.stream().filter(candidato -> candidato.getQuantVotos() == vencedor.getQuantVotos())
                    .toArray().length > 1) {
                System.out.println("Houve um empate.");
            } else {
                System.out.println("O vencedor foi: " + vencedor.nome);
            }
        }
    }
}
