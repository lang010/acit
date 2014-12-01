/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 694
 *  UVa link: http://uva.onlinejudge.org/external/6/694.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  2 07:06:50 2014
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

    int L = 0;

    int solve(long x) {
        int ans = 0;
        while (x <= L) {
            ans++;
            if (x == 1) {
                break;
            }
            if (x%2 == 1) {
                x = 3*x + 1;
            } else {
                x = x/2;
            }
        }

        return ans;
    }
    void run() {
        int x = 0;
        int cnt = 0;
        while (true) {
            x = sc.nextInt();
            L = sc.nextInt();
            if (x<0 && L<0) {
                break;
            }
            pw.printf("Case %d: A = %d, limit = %d, number of terms = %d%n", ++cnt, x, L, solve(x));
        }

    }

}
