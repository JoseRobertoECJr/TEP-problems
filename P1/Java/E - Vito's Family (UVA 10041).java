import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double numCases = scanner.nextDouble();
        for (int i = 0; i < numCases; i++) {
            
            Double r = scanner.nextDouble();
            ArrayList<Double> houseArrList = new ArrayList<Double>();

            for (int j = 0; j < r; j++) {
                Double relativeHouseNumber = scanner.nextDouble();
                houseArrList.add(relativeHouseNumber);
            }
            
            double totalSum = 0.0;
            for (Double house : houseArrList) {
                totalSum += house;
            }
            
            double vitoHouseNumber = GetMedian(houseArrList);
            
            int totalDistance = 0;
                
            for (Double house : houseArrList) {
                totalDistance += (int)((double)Math.abs(house - vitoHouseNumber));
            }
            
            System.out.println(totalDistance);
        }

        
        scanner.close();
    }
    
    public static double GetMedian(ArrayList<Double> list)
    {
        Collections.sort(list);
        Double median;
        if (list.size() % 2 == 0)
        {
            median = ((double)list.get(list.size()/2) + (double)list.get(list.size()/2 - 1))/2;
        } else 
        {
            median = (double) list.get(list.size()/2);
        }
        
        return (int)Math.round(median);
    }
}
