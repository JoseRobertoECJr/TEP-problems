import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

		while(scanner.hasNext())
		{
			int M = scanner.nextInt();
			int N = scanner.nextInt();

			char[][] map = new char[M][];
			boolean[][] mapVisited = new boolean[M][];

			for(int i = 0; i < M; i++)
			{
				String input = scanner.next();

				char[] line = input.toCharArray();
				map[i] = line;

				mapVisited[i] = new boolean[line.length];
			}

			int x = scanner.nextInt();
			int y = scanner.nextInt();

			DFS(mapVisited, map, x, y, M, N, 0, map[x][y]);

			int maxCities = 0;
			for(int i = 0; i < M; i++)
			{
				for(int j = 0; j < N; j++)
				{
					if (mapVisited[i][j] || map[x][y] != map[i][j]) continue;

					int numCities = 0;
					numCities = DFS(mapVisited, map, i, j, M, N, numCities, map[x][y]);

					if(numCities > maxCities)
					{
						maxCities = numCities;
					}
				}
			}

			System.out.println(maxCities);
		}
    }

	public static int DFS(boolean[][] visited, char[][] map, int x, int y, int M, int N, int numCities, char landChar) {
        
		visited[x][y] = true;
		numCities++;

		int nextY = y == N - 1 ? 0 : y + 1;
		int prevY = y == 0 ? N - 1 : y - 1;

		// vizinho x-1, y
		if (x > 0 && !visited[x-1][y] && landChar == map[x-1][y])
		{
			numCities = DFS(visited, map, x-1, y, M, N, numCities, landChar);
		}
		
		// vizinho x, y-1
		if (!visited[x][prevY] && landChar == map[x][prevY])
		{
			numCities = DFS(visited, map, x, prevY, M, N, numCities, landChar);
		}

		// vizinho x, y+1
		if (!visited[x][nextY] && landChar == map[x][nextY])
		{
			numCities = DFS(visited, map, x, nextY, M, N, numCities, landChar);
		}

		// vizinho x+1, y
		if (x < M - 1 && !visited[x+1][y] && landChar == map[x+1][y])
		{
			numCities = DFS(visited, map, x+1, y, M, N, numCities, landChar);
		}

		return numCities;
    }
}