/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 357
 *  UVa link: http://uva.onlinejudge.org/external/3/357.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  2 06:00:46 2014
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

    int max = 30010;
    long[] ls = new long [max];
    int[] ct = { 1, 5, 10, 25, 50 };

    void run() {
        ls[0] = 1;
        for (int i = 0; i < ct.length; i++) {
            for (int j = ct[i]; j < max; j++) {
                ls[j] += ls[j-ct[i]];
            }
        }
        int n = 0;
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            if (ls[n] > 1) {
                pw.printf("There are %d ways to produce %d cents change.%n", ls[n], n);
            } else {
                pw.printf("There is only 1 way to produce %d cents change.%n", n);
            }
        }
    }

}
