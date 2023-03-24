package backtracking.question5;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    //Esta gerando as sequencias de Thue possíveis com os tamanhos possíveis 
    public static void main(String[] args) {
        int genomeSize = scanner.nextInt();

        while (genomeSize > 0) {
            generateGenome("N", genomeSize);

            System.out.println("Prox: ");
            genomeSize = scanner.nextInt();
        }        
    }

    // Método responsável por gerar o genoma com base na sequência de Thue-Morse
    public static void generateGenome(String genome, int genomeSize) {
        // Verifica se o genoma tem o tamanho desejado e se é uma sequência de Thue-Morse
        if(genome.length() == genomeSize && isThueSequence(genome)) {
             // Se o genoma atender às condições acima, imprime o genoma gerado
            System.out.println("> " + genome);
            return;
        }

        // Se o genoma não tiver o tamanho desejado ou não for uma sequência de Thue-Morse,
        // chama o método generateGenome novamente, acrescentando as letras N, O ou P
        // à base do genoma, e executa novamente a verificação acima
        if(isThueSequence(genome)) {
            generateGenome(genome + "N", genomeSize);
            generateGenome(genome + "O", genomeSize);
            generateGenome(genome + "P", genomeSize);
        }
        
    }

    // Método que verifica se um genoma é uma sequência de Thue-Morse
    public static boolean isThueSequence(String genome) {
        if(genome.length() > 1) {
            // Executa um loop para verificar se existem subsequências repetidas de tamanho i
            for(int i = 1; i < genome.length()/2; i++) {
                for (int j = 0; j < genome.length(); j += i ) {
                    if(j + i*2 <= genome.length()) {
                        if(genome.substring(j, j + i).equals(genome.substring(j + i , j + i*2))) {
                            return false;
                        }
                    }
                }
            }
        }
         // Retorna true se o genoma for uma sequência de Thue-Morse ou se o tamanho for 1
         return true;        
    }

}
