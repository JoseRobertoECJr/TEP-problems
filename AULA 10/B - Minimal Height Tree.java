import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        
        while (testCases > 0) {
            int tam = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            
            int[] ordem = new int[tam];
            String[] entrada = scanner.nextLine().split(" ");
            for (int i = 0; i < tam; i++) {
                ordem[i] = Integer.parseInt(entrada[i]);
            }
            
            System.out.println(minimalHeightTree(ordem));
            testCases--;
        }
        
        scanner.close();
    }
	
    public static int minimalHeightTree(int[] ordem) {
        int contador = 1;
        int altura = 1, atual = 0;
        
        for (int i = 1; i < ordem.length; i++) {
            if (ordem[i] < ordem[i - 1]) {
                contador--;
                if (contador == 0) {
                    altura++;
                    contador = atual;
                    atual = 0;
                }
            }
            atual++;
        }
        
        return altura;
    }
}
