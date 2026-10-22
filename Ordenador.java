import java.util.Random;
import java.util.Scanner;

public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();
        System.out.print("Digite a quantidade de elementos: ");
        int n = entrada.nextInt();
        Integer[] valores = new Integer[n];
        System.out.println("\nEscolha como gerar os valores:");
        System.out.println("1 - Valores aleatorios");
        System.out.println("2 - Melhor caso");
        System.out.println("3 - Pior caso");
        System.out.print("Opcao: ");
        int opcao = entrada.nextInt();
        switch (opcao) {

            case 1:
                for (int i = 0; i < n; i++) {
                    valores[i] = aleatorio.nextInt(1000);
                }
                break;
            case 2:
                // Melhor caso: ja ordenado
                for (int i = 0; i < n; i++) {
                    valores[i] = i;
                }
                break;
            case 3:
                // Pior caso: ordem decrescente
                for (int i = 0; i < n; i++) {
                    valores[i] = n - i;
                }
                break;
            default:
                System.out.println("Opcao invalida!");
                entrada.close();
                return;
        }

        System.out.println("\nVetor original:");
        for (int i = 0; i < n; i++) {
            System.out.print(valores[i] + " ");
        }

        // Inicio da contagem
        long inicio = System.nanoTime();

        // Ordenacao
        BubbleSort.bubblesort(valores);

        // Fim da contagem
        long fim = System.nanoTime();

        // Calcula o tempo
        long tempoNano = fim - inicio;

        System.out.println("\n\nVetor ordenado:");

        for (int i = 0; i < n; i++) {
            System.out.print(valores[i] + " ");
        }

        System.out.println("\n\nTempo de execucao:");
        System.out.println(tempoNano + " ns");

        entrada.close();
    }