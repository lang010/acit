/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 103
 *  UVa link: http://uva.onlinejudge.org/external/1/103.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 25 23:10:13 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
    Scanner sc = new Scanner(System.in, "ISO-8859-1");
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();
    }
    void release() {
	sc.close();
	pw.close();
    }

    int[][] map = new int[40][15];
    int k = 0;
    int n = 0;

    boolean minor(int j, int i) {
        for (int k = 0; k < n; k++) {
            if (map[j][k] < map[i][k]) {
                return true;
            }
        }
        return false;
    }

    boolean nest(int i, int j) {
        for (int k = 0; k < n; k++) {
            if (map[i][k] >= map[j][k]) {
                return false;
            }
        }
        return true;
    }

    void swap(int i, int j) {
        if (i == j) {
            return ;
        }
        int x = 0;
        for (int k = 0; k <= n; k++) {
            x = map[i][k];
            map[i][k] = map[j][k];
            map[j][k] = x;
        }
        return ;
    }

    void run() {
        while (sc.hasNextInt()) {
            k = sc.nextInt();
            n = sc.nextInt();
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
                map[i][n] = i+1;
                map[i][n+1] = 1;
                map[i][n+2] = -1;
                Arrays.sort(map[i], 0, n);
            }
            for (int i = 0; i < k; i++) {
                for (int j = k-1; j > i; j--) {
                    if (minor(j, j-1)) {
                        swap(j, j-1);
                    }
                }
            }
            for (int i = 0; i < k-1; i++) {
                for (int j = i+1; j < k; j++) {
                    if (nest(i, j) && map[j][n+1] < map[i][n+1] + 1) {
                        map[j][n+1] = map[i][n+1]+1;
                        map[j][n+2] = i;
                    }
                }
            }
            int max = 0;
            int maxI = -1;
            for (int i = 0; i < k; i++) {
                if (max < map[i][n+1]) {
                    max = map[i][n+1];
                    maxI = i;
                }
            }
            max = 1;
            String s = "" + map[maxI][n];
            for (int i = map[maxI][n+2]; i >= 0; i = map[i][n+2]) {
                max++;
                s = map[i][n] + " " + s;
            }
            pw.printf("%d%n%s%n", max, s);
        }

    }

}
