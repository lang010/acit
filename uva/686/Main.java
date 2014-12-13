/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 686
 *  UVa link: http://uva.onlinejudge.org/external/6/686.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 13 14:12:30 2014
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

    int[] ls = new int[40000];
    {
        for (int i = 2; i < 40000; i++) {
            if (ls[i] == 0) {
                for (int j = i+i; j < 40000; j += i) {
                    ls[j] = 1;
                }
            }
        }
    }

    void run() {
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            int ans = 0;
            for (int i = 2; i <= n/2; i++) {
                if (ls[i] == 0 && ls[n-i] == 0) {
                    ans++;
                }
            }
            pw.println(ans);
        }

    }

}
