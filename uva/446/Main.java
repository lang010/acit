/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 446
 *  UVa link: http://uva.onlinejudge.org/external/4/446.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 16 23:25:08 2014
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

    void run() {
        int x, y, z;
        int n = sc.nextInt();
        String s;
        String s1, s2;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt(16);
            s = sc.next();
            y = sc.nextInt(16);
            if ("+".equals(s)) {
                z = x + y;
            } else {
                z = x - y;
            }
            s1 = Integer.toString(x, 2);
            x = 13 - s1.length();
            s2 = Integer.toString(y, 2);
            y = 13 -s2.length();
            pw.printf("%0"+x+"d%s %s %0"+y+"d%s = %d%n", 0, s1, s, 0, s2, z);
        }

    }

}
