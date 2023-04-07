package dynamicProgramming.question4;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static class PipeData {
        public int length, value;

        public PipeData(int length, int value) {
            this.length = length;
            this.value = value;
        }

        public String generateKey() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append(length).append(value).toString();
        }
    }

    public static void main(String args[]) {
        final int quantityOfPipeSizes = scanner.nextInt();
        final int sizeOfProducedPipe = scanner.nextInt();

        HashMap<String, PipeData> orderedPipes = new HashMap<>(quantityOfPipeSizes);
        int maxSolution = 0;

        for(int ind=0 ; ind<quantityOfPipeSizes ; ind++) {
            int length = scanner.nextInt();
            int value = scanner.nextInt();
            
            PipeData pipe = new PipeData(length, value);
            orderedPipes.put(pipe.generateKey(), pipe);
            maxSolution = Math.max(value, maxSolution);
        }
        
        HashMap<String, PipeData> previousSolutions = orderedPipes;
        do {
            HashMap<String, PipeData> currentSolutions = new HashMap<>(
                previousSolutions.size()
            );

            for(String orderedPipeKey : orderedPipes.keySet()) {
                int pipeValue = orderedPipes.get(orderedPipeKey).value;
                int pipeLength = orderedPipes.get(orderedPipeKey).length;

                for(String previousSolutionKey : previousSolutions.keySet()) {
                    PipeData previousSolution = previousSolutions.get(previousSolutionKey);
                    int solutionLength = previousSolution.length + pipeLength;
                    if(solutionLength > sizeOfProducedPipe) continue;
                    
                    int solutionValue = previousSolution.value + pipeValue;
                    PipeData pipe = new PipeData(solutionLength, solutionValue);

                    currentSolutions.put(pipe.generateKey(), pipe);
                    maxSolution = Math.max(solutionValue, maxSolution);
                }
            }

            previousSolutions = currentSolutions;
        } while(!previousSolutions.isEmpty());

        System.out.println(maxSolution);
    }
}