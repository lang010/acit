/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 477
 *  UVa link: http://uva.onlinejudge.org/external/4/477.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 14 08:00:48 2014
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

    char[] flags = new char[3000];
    double[][] values = new double[3000][4];
    int n = 0;

    boolean cnt(double x, double y, int id) {
        double[] val = values[id];
        if (flags[id] == 'c') {
            //pw.printf("%d %f %f %f%n", id, x, y, val[2]*val[2]);
            if ((val[0]-x)*(val[0]-x) + (val[1]-y)*(val[1]-y) <= val[2]*val[2]) {
                return true;
            }
        } else {
            if (x>=val[0] && x<=val[2] && y<=val[1] && y>=val[3]) {
                return true;
            }
        }
        return false;
    }

    void run() {
        double x, y;
        while (true) {
            String s = sc.next();
            if (s.equals("r")) {
                flags[n] = 'r';
                values[n][0] = sc.nextDouble();
                values[n][1] = sc.nextDouble();
                values[n][2] = sc.nextDouble();
                values[n][3] = sc.nextDouble();
                n++;
            } else if (s.equals("c")) {
                flags[n] = 'c';
                values[n][0] = sc.nextDouble();
                values[n][1] = sc.nextDouble();
                values[n][2] = sc.nextDouble();
                n++;
            } else {
                break;
            }
        }
        int cnt = 0;
        int f = 0;
        while (true) {
            x = sc.nextDouble();
            y = sc.nextDouble();
            if (Math.abs(x-9999.9) < 1e-6 && Math.abs(y-9999.9) < 1e-6) {
                break;
            }
            cnt++;
            f = 0;
            for (int i = 0; i < n; i++) {
                if (cnt(x, y, i)) {
                    f = 1;
                    pw.printf("Point %d is contained in figure %d%n", cnt, i+1);
                }
            }
            if (f == 0) {
                pw.printf("Point %d is not contained in any figure%n", cnt);
            }
        }
    }

}
