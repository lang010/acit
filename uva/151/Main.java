/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 151
 *  UVa link: http://uva.onlinejudge.org/external/1/151.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 13 13:44:46 2014
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

    int[] ans = new int[100];
    int[] flag = new int[100];

    int cnt(int x) {
        if (ans[x] > 0) {
            return ans[x];
        }
        int c = 0;
        int r = 0;
        int s = 0;
        int f = 0;
        while (true) {
            r++;
            for (int i = 0; i < x; i++) {
                flag[i] = 0;
            }
            c = 0;
            s = 0;
            f = -1;
            while (true) {
                if (flag[s] == 0) {
                    f++;
                    if (f%r == 0) {
                        //pw.printf("T: %d %d\n", r, s);
                        //pw.flush();
                        flag[s] = 1;
                        c++;
                        if (s == 12) {
                            if (c == x) {
                                ans[x] = r;
                                return r;
                            } else {
                                break;
                            }
                        }
                    }
                }
                s = (s+1)%x;
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
