import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
		
		String inputHeaderStr;
		while(!(inputHeaderStr = scanner.nextLine()).equals("0 0"))
		{
            StringBuilder result = new StringBuilder();
            List<Integer> orderedTasks = new ArrayList<>();
            
			String[] inputHeader = inputHeaderStr.split(" ");
			
			int taskQnt = Integer.parseInt(inputHeader[0]);
			int edgeQnt = Integer.parseInt(inputHeader[1]);
			
			Map<Integer, Boolean> visited = new HashMap<>();
			for (int i = 1; i <= taskQnt; i++) {
				visited.put(i, false);
			}
			
			Map<Integer, Set<Integer>> tasksDependencies = new HashMap<>();
			for (int i = 0; i < edgeQnt; i++) {
				
				String inputTasksStr = scanner.nextLine();
				String[] inputTasks = inputTasksStr.split(" ");

				int task0 = Integer.parseInt(inputTasks[0]);
				int task1 = Integer.parseInt(inputTasks[1]);

				tasksDependencies.putIfAbsent(task0, new HashSet<>());
				tasksDependencies.get(task0).add(task1);
			}

			for (int task = 1; task <= taskQnt; task++) {
				if (visited.get(task)) continue;
				DFS(orderedTasks, visited, tasksDependencies, task);
			}

			Collections.reverse(orderedTasks);
			for (int task : orderedTasks) {
				result.append(task).append(" ");
			}

			System.out.println(result.toString().trim());
		}
    }

    public static void DFS(List<Integer> orderedTasks, Map<Integer, Boolean> visited, Map<Integer, Set<Integer>> tasksDependencies, int task) {
        visited.put(task, true);

        if (!tasksDependencies.containsKey(task)) {
            orderedTasks.add(task);
            return;
        }

        for (int subTask : tasksDependencies.get(task)) {
            if (visited.get(subTask)) continue;

            DFS(orderedTasks, visited, tasksDependencies, subTask);
        }

        orderedTasks.add(task);
    }
}