/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11462
 *  UVa link: http://uva.onlinejudge.org/external/114/11462.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 27 14:55:59 2014
 */

#include <stdio.h>
#include <string.h>

int ls[110];
int n;

int main() {
    int x;
    int i, j, f;
    while (1) {
        scanf("%d", &n);
        if (n == 0)
            break;
        memset(ls, 0, sizeof(ls));
        for(i = 0; i < n; i++) {
            scanf("%d", &x);
            ls[x]++;
        }
        f = 0;
        for(i = 0; i < 101; i++) {
            for(j = 0; j < ls[i]; j++) {
                if (f == 1)
                    printf(" ");
                else f = 1;
                printf("%d", i);
            }
        }
        printf("\n");
    }
    return 0;
}
