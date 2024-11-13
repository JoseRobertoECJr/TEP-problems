#include <stdio.h>
#include <string.h>
int intersections[205];
int visitedRoads[205];
int roadGraph[205][205];
int N, R, c1, c2;

void DFS(int index) {
	visitedRoads[index] = 1;
	for(int i = 0; i < N; i++)
    {
		if(roadGraph[index][i] && visitedRoads[i] == 0)
        {
			DFS(i);
        }
	}
}

int main() {
    while(scanf("%d %d", &N, &R) == 2) {
    	memset(roadGraph, 0, sizeof(roadGraph));

        for(int i = 0; i < N; i++) {
            intersections[i] = 0;
            visitedRoads[i] = 1;
        }

        for(int i = 0; i < R; i++)
        {
            scanf("%d %d", &c1, &c2);
            intersections[c1]++;
            intersections[c2]++;

            roadGraph[c1][c2] = 1;
            roadGraph[c2][c1] = 1;

            visitedRoads[c1] = 0;
            visitedRoads[c2] = 0;
        }

        int isPossible = 1;
        for(int i = 0; i < N; i++) {
            if(intersections[i] % 2 == 1) {
                isPossible = 0;
            }
        }
        if(isPossible == 0)
        {
            puts("Not Possible");
        }
        else
        {
        	int counter = 0;
        	for(int i = 0; i < N && counter <= 1; i++)
            {
                if(visitedRoads[i] == 0)
                {
        			DFS(i), counter++;
                }
            }
        		
        	if(counter == 1)
            {
                puts("Possible");
            }
            else {
                puts("Not Possible");
            }
        }
    }
    return 0;
}