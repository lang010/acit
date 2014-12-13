/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 167
 *  UVa link: http://uva.onlinejudge.org/external/1/167.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 16 23:00:19 2014
 */
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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

    int[][] map = new int[8][8];
    int[] f = new int[8];
    int[] f1 = new int[17];
    int[] f2 = new int[17];
    int max = 0;
    int sum = 0;

    int dfs(int d) {
        if (d == 8) {
            if (sum > max) {
                max = sum;
            }
            return max;
        }
        for (int i = 0; i < 8; i++) {
            if (f[i] == 0 && f1[8+d-i] == 0 && f2[16-i-d] == 0) {
                f[i] = f1[8+d-i] = f2[16-i-d] = 1;
                sum += map[d][i];
                dfs(d+1);
                sum -= map[d][i];
                f[i] = f1[8+d-i] = f2[16-i-d] = 0;
            }

        }
        return max;
    }

    void run() {
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 8; j++) {
                for (int l = 0; l < 8; l++) {
                    map[j][l] = sc.nextInt();
                }
            }
            max = 0;
            dfs(0);
            pw.printf("%5d%n", max);
        }

    }

}
