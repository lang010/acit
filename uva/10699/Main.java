/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10699
 *  UVa link: http://uva.onlinejudge.org/external/106/10699.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 18 15:38:28 2014
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

    int max = 1000000;
    int[] ls = new int[max+1];
    {
        for (int i = 2; i < max; i++) {
            if (ls[i] == 0) {
                ls[i] = 1;
                for (int j = i+i; j <= max; j += i) {
                    ls[j]++;
                }
            }
        }
    };

    void run() {
        while (true) {
            int x = sc.nextInt();
            if (x == 0) {
                break;
            }
            pw.printf("%d : %d%n", x, ls[x]);
        }

    }

}
