/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 440
 *  UVa link: http://uva.onlinejudge.org/external/4/440.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 14 22:46:32 2014
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

    int[] ans = new int[200];
    int[] flag = new int[200];

    int cnt(int n) {
        if (ans[n] > 0) {
            return ans[n];
        }
        int m = 0;
        int c, f, s;
        while (true) {
            m++;
            for (int i = 0; i < n; i++) {
                flag[i] = 0;
            }
            s = 0;
            f = -1;
            c = 0;
            while (true) {
                if (flag[s] == 0) {
                    f++;
                    if (f%m == 0) {
                        flag[s] = 1;
                        c++;
                        if (s == 1) {
                            if (c == n) {
                                ans[n] = m;
                                return m;
                            }
                            break;
                        }
                    }
                }
                s++;
                s = s>=n ? s-n : s;
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
