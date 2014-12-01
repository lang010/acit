/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 543
 *  UVa link: http://uva.onlinejudge.org/external/5/543.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  4 23:10:46 2014
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

    boolean prime(int x) {
        int n = (int) Math.sqrt(x) + 1;
        for (int i = 3; i < n; i++) {
            if (x%i == 0) {
                return false;
            }
        }

        return true;
    }

    void run() {
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 3; i <= n/2; i+=2) {
                if (prime(i) && prime(n-i)) {
                    pw.printf("%d = %d + %d%n", n, i, n-i);
                    break;
                }
            }
        }

    }

}
