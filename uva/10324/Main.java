/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10324
 *  UVa link: http://uva.onlinejudge.org/external/103/10324.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 18 12:16:00 2014
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

    int[] ls = new int[1000001];

    void run() {
        int cnt = 1;
        while (sc.hasNext()) {
            String s = sc.next();
            char[] sl = s.toCharArray();
            ls[sl.length-1] = 0;
            for (int i = sl.length-2; i >= 0; i--) {
                if (sl[i] == sl[i+1]) {
                    ls[i] = ls[i+1]+1;
                } else {
                    ls[i] = 0;
                }
            }
            int n = sc.nextInt();
            pw.printf("Case %d:%n", cnt++);
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int x = Math.min(a, b);
                a = Math.abs(a-b);
                if (ls[x] >= a) {
                    pw.println("Yes");
                } else {
                    pw.println("No");
                }
            }

        }
    }

}
