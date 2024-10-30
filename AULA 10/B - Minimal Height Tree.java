import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        
        while (testCases > 0) {
            int n = scanner.nextInt();
            
            int[] vertices = new int[n];
            for (int i = 0; i < n; i++) {
                vertices[i] = scanner.nextInt();
            }
            
            System.out.println(minimalHeightTree(vertices));
            testCases--;
        }
        
        scanner.close();
    }
	
    public static int minimalHeightTree(int[] vertices) {
        int count = 1;
        int height = 1, current = 0;
        
        for (int i = 1; i < vertices.length; i++) {
            if (vertices[i] < vertices[i - 1]) {
                count--;
                if (count == 0) {
                    height++;
                    count = current;
                    current = 0;
                }
            }
            current++;
        }
        
        return height;
    }
}
