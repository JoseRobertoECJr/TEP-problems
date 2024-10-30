import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
		
		int numCases = scanner.nextInt();
		
		for(int i = 0; i < numCases; i++)
		{
			int N = scanner.nextInt();
			int M = scanner.nextInt();

			Map<Integer, Set<Integer>> friends = new HashMap<>();
			Map<Integer, Boolean> visited = new HashMap<>();
			for (int j = 1; j <= N; j++) {
				friends.put(j, new HashSet<>());
				visited.put(j, false);
			}
			
			for(int j = 0; j < M; j++)
			{
				int firstFriend = scanner.nextInt();
				int secondFriend = scanner.nextInt();
				
				friends.get(firstFriend).add(secondFriend);
				friends.get(secondFriend).add(firstFriend);
			}

			int maxGroup = 0;
			for (int friend = 1; friend <= N; friend++) {
				if (visited.get(friend)) continue;

				int group = 0;
				group = DFS(visited, friends, friend, group);

				if(group > maxGroup)
				{
					maxGroup = group;
				}
			}

			System.out.println(maxGroup);
		}
    }

    public static int DFS(Map<Integer, Boolean> visited, Map<Integer, Set<Integer>> friends, int friend, int group) {
        
		visited.put(friend, true);
		group++;

        for (int secondFriend : friends.get(friend)) {
            if (visited.get(secondFriend)) continue;

            group = DFS(visited, friends, secondFriend, group);
        }

		return group;
    }
}
