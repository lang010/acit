/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 256
 *  UVa link: http://uva.onlinejudge.org/external/2/256.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  4 00:32:41 2014
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

    int[][] map = new int[8][50];

    void cnt(int x) {
        int n = (int) Math.pow(10, x);
        x /= 2;
        int mod = (int) Math.pow(10, x);
        int c = 1;
        for (int i = 0; i < n; i++) {
            int l = i/mod;
            int r = i%mod;
            if ((l+r)*(l+r) == i) {
                //pw.printf("%0"+(x+x)+"d%n", i);
                map[x][c++] = i;
            }
        }
        map[x][0] = c;
    }

    void run() {
        cnt(2);
        cnt(4);
        cnt(6);
        cnt(8);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 1; i < map[n/2][0]; i++) {
                pw.printf("%0"+n+"d%n", map[n/2][i]);
            }
        }
    }

}
