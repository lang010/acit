#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int G[100][100];
int N;
int degree[100];
int link[1100];
int ln;

void dfs(int id) {
    for(int i = 1; i <= 50; i++) {
        if (G[id][i] > 0) {
            G[id][i]--;
            G[i][id]--;
            dfs(i);
        }
    }
    link[ln++] = id;
}

int main() {
    int T;
    int x,y,i;
    scanf("%d", &T);
    for( int k = 0; k < T; k++) {
        if (k>0)
            printf("\n");
        memset(G, 0, sizeof(G));
        memset(degree, 0, sizeof(degree));
        ln = 0;
        scanf("%d", &N);
        for(int i = 0; i < N; i++) {
            scanf("%d%d", &x, &y);
            degree[x]++;
            degree[y]++;
            G[x][y]++;
            G[y][x]++;
        }
        int ok = 1;
        for(i = 0; i <= 50; i++) {
            if (degree[i]%2 == 1) {
                ok = 0;
                break;
            }
        }
        printf("Case #%d\n", k+1);
        if (ok) {
            dfs(x);
            //printf("TT: %d\n", ln);
            if (ln != N+1)
                ok = 0;
            else {
                for(i = 0; i < N; i++)
                    printf("%d %d\n", link[i], link[i+1]);
            }
        }
        if (ok == 0) {
            printf("some beads may be lost\n");
        }
    }

    return 0;
}
