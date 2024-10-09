import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Integer n = scanner.nextInt();

        Stack<String> stack = new Stack<>();

        while (scanner.hasNext()) {
            
            String command = scanner.next();
            
            if(command.equals("Kick"))
            {
                if(stack.size() > 0)
                {
                    // desempilha
                    stack.pop();
                }
                
            } else if(command.equals("Test"))
            {
                if(stack.size() > 0)
                {
                    // print do ultimo dorminhoco
                    String dreamer = stack.pop();
                    
                    System.out.println(dreamer);
                    
                    stack.push(dreamer);
                } else {
                    System.out.println("Not in a dream");
                }
            } else { // Sleep command
            
                String dreamer = scanner.next();
                
                stack.push(dreamer);
            }
            
        }

        scanner.close();
    }
}