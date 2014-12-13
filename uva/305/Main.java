/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 305
 *  UVa link: http://uva.onlinejudge.org/external/3/305.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 13 14:52:23 2014
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

    int[] ans = new int[20];

    int cnt(int k) {
        if (ans[k] > 0) {
            return ans[k];
        }
        int x = k;
        while (true) {
            int n = k+k;
            int c = -1;
            x++;
            for (int i = 0; i < k; i++) {
                c = (c+x)%n;
                if (c < k) {
                    break;
                }
                c--;
                n--;
            }
            if (n==k) {
                ans[k] = x;
                return x;
            }
        }
    }

    void run() {
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            pw.println(cnt(n));
        }

    }

}
