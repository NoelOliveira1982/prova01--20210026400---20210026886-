# Prova 01 - Linguagem de Programação 1
  Este respositório guarda as respostas dos alunos Pedro Augusto Dias de Lima e Jorge Alberto Macedo Costa de Oliveira da prova 01 da disciplina LP1.
  
# Get Start
~~~powershell
git clone https://github.com/NoelOliveira1982/prova01--20210026400---20210026886-.git
~~~

# Questão 3
## A) 
A classe contabiliza os votos dados pelo usuário e informa o ganhador da eleição

## B) 
Linha 2: import java.lang.* não usado, soluçao: apagar linha do import
Linha 8: Variável "saida" não usada, solução: apagar a declaração da variavel saida
Linha 22: "if (entrada == "222")" comparando String com número, o certo seria if (entrada.equals("222"))
Linha 24: Como o "else" não apresenta condição, qualquer input do usuário irá contar como voto para o candidato 3, soluçao: substituir por "else if (entrada.equals("333"))"

## C)
~~~java
for (int i=0; i<5; i++) {
    entrada = JOptionPane.showInputDialog(s);

    if (entrada.equals("111")) {
        count1++;
    }else if (entrada.equals("222"))
        count2++;
    else if (entrada.equals("333"))
        count3++;
    else {
        votosInvalidos++;
    }
}
~~~
