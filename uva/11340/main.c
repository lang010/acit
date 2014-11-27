/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11340
 *  UVa link: http://uva.onlinejudge.org/external/113/11340.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 27 21:38:41 2014
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int map[1000];
int n,k,m;
int sum;
char s[10010];

int main() {
    int i, j, c;
    char ch;
    scanf("%d", &n);
    for (c = 0; c < n; c++) {
        scanf("%d", &k);
        memset(map, 0, sizeof(map));
        for (i = 0; i < k; i++) {
            scanf(" %c%d", &ch, &sum);
            map[ch+500] = sum;
            //printf("%c - %d\n", ch, sum);
        }
        sum = 0;
        scanf("%d", &m);
        for (i = 0; i < m+1; i++) {
            gets(s);
            j = 0;
            while (s[j] != 0) {
                sum += map[s[j++]+500];
            }
        }
        printf("%.2lf$\n", sum/100.0);
    }

    return 0;
}
