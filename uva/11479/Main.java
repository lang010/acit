/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11479
 *  UVa link: http://uva.onlinejudge.org/external/114/11479.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 14 09:17:53 2014
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

    long[] ls = new long[3];

    void run() {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            ls[0] = sc.nextLong();
            ls[1] = sc.nextLong();
            ls[2] = sc.nextLong();
            Arrays.sort(ls);
            pw.printf("Case %d: ", i+1);
            if (ls[0]+ls[1] <= ls[2] || ls[0] <= 0) {
                pw.println("Invalid");
                continue;
            }
            if (ls[0] == ls[1] && ls[1] == ls[2]) {
                pw.println("Equilateral");
                continue;
            }
            if (ls[0] == ls[1] || ls[1] == ls[2]) {
                pw.println("Isosceles");
            } else {
                pw.println("Scalene");
            }
        }

    }

}
