/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 382
 *  UVa link: http://uva.onlinejudge.org/external/3/382.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  2 06:50:41 2014
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

    int prefect(int x) {
        if (x == 1) {
            return -1;
        }

        int s = 1;
        for (int i = 2; i <= x/2; i++) {
            if (x%i == 0) {
                s += i;
                if (s > x) {
                    return 1;
                }
            }
        }
        if (s == x) {
            return 0;
        }
        return -1;
    }

    void run() {
        int x = 0;
        int t = 0;
        String s = null;
        pw.println("PERFECTION OUTPUT");
        while (true) {
            x = sc.nextInt();
            if (x == 0) {
                break;
            }
            t = prefect(x);
            if (t == 0) {
                s = "PERFECT";
            } else if (t>0) {
                s = "ABUNDANT";
            } else {
                s = "DEFICIENT";
            }
            pw.printf("%5d  %s%n", x, s);
        }
        pw.println("END OF OUTPUT");
    }

}
