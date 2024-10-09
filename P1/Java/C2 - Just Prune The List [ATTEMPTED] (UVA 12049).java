import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        
        Scanner scanner = new Scanner(System.in);
        
        Integer T = scanner.nextInt();
        
        for (int i = 0; i < T; i++)
        {
            Integer N = scanner.nextInt();
            Integer M = scanner.nextInt();
            
            Integer numRemoves = 0;
            
            Map<Integer, Integer> nList = new HashMap<Integer, Integer>();
            
            for(int j = 0; j < N; j++)
            {
                Integer nElement = scanner.nextInt();
                
                Integer value = nList.get(nElement);
                
                if(value != null)
                {
                    value++;
                } else {
                    value = 1;
                }
                
                nList.put(nElement, value);
            }
            
            Map<Integer, Integer> mList = new HashMap<Integer, Integer>();
            
            for(int j = 0; j < M; j++)
            {
                Integer mElement = scanner.nextInt();
                
                Integer value = mList.get(mElement);
               
                if(value != null)
                {
                    value++;
                } else {
                    value = 1;
                }
                
                mList.put(mElement, value);
            }
            
            for (Map.Entry<Integer, Integer> entry : nList.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                
                Integer element = mList.get(key);
                
                Integer currRemoves = 0;
                
                if(element == null)
                {
                    currRemoves = value;
                } else {
                    currRemoves = Math.abs(value - element);
                }
                
                numRemoves += currRemoves;
                
                N -= currRemoves;
            }
            
            System.out.println(numRemoves + Math.abs(N-M));
    
        }

        scanner.close();
    }
}