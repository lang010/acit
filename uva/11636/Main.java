/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11636
 *  UVa link: http://uva.onlinejudge.org/external/116/11636.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  5 23:46:46 2014
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
        int c = 1;
        int n = 0;
        int t = 0;
        while (true) {
            n = sc.nextInt();
            if (n<=0) {
                break;
            }
            t = 0;
            int cur = 1;
            while (cur < n) {
                cur = 2*cur;
                t++;
            }
            pw.printf("Case %d: %d%n", c++, t);
        }

    }

}
