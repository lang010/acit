/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 458
 *  UVa link: http://uva.onlinejudge.org/external/4/458.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 16 09:31:53 2014
 */

#include <stdio.h>

int main() {
    char c;
    while ((c=getchar()) != EOF) {
        if (c == '\n') {
            putchar(c);
        } else {
            putchar(c-7);
        }
    }

    return 0;
}
