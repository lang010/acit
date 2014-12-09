/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 443
 *  UVa link: http://uva.onlinejudge.org/external/4/443.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  6 12:38:14 2014
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

    long max = 2000000001;
    long[] ls = new long[6000];
    int[] pr = { 2, 3, 5, 7 };
    int n = 0;

    int dfs(int d, long cur) {
        if (d >= pr.length) {
            if (cur < max) {
                ls[n++] = cur;
            }
            return 0;
        }

        for (long i = 1; i*cur < max; i *= pr[d]) {
            dfs(d+1, i*cur);
        }

        return 0;
    }

    void run() {
        dfs(0, 1);
        Arrays.sort(ls, 0, n);
        //for (int i = 0; i < n; i++) {
        //pw.printf("%d ", ls[i]);
        //}
        while (true) {
            int id = sc.nextInt();
            if (id == 0) {
                break;
            }
            String s = "th";
            if (id%10 == 1) {
                s = "st";
            }
            if (id%10 == 2) {
                s = "nd";
            }
            if (id%10 == 3) {
                s = "rd";
            }
            if (id%100 == 11 || id%100 == 12 || id%100 == 13) {
                s = "th";
            }

            pw.printf("The %d%s humble number is %d.%n", id, s, ls[id-1]);
        }


    }

}
