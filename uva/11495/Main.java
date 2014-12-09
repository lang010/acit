/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11495
 *  UVa link: http://uva.onlinejudge.org/external/114/11495.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  6 15:37:17 2014
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

    int[] ls = new int[100000];
    int[] ll = new int[50000];
    int[] lr = new int[50000];
    int n = 0;

    long merge(int b, int e) {
        if (b+1 >= e ) {
            return 0;
        }
        long ans = 0;
        int mid = (b+e)/2;
        //pw.printf("T %d %d %d%n", b, mid, e);
        ans += merge(b, mid);
        ans += merge(mid, e);
        for (int i = b; i < mid; i++) {
            ll[i-b] = ls[i];
        }
        for (int i = mid; i < e; i++) {
            lr[i-mid] = ls[i];
        }
        int l = 0;
        int ln = mid - b;
        int r = 0;
        int rn = e - mid;
        while (l<ln && r<rn) {
            if (ll[l] < lr[r]) {
                ls[b++] = ll[l++];
                ans += r;
            } else {
                ls[b++] = lr[r++];
                ans += ln - l;
            }
        }
        while (l<ln) {
            ls[b++] = ll[l++];
            ans += rn;
        }
        while (r<rn) {
            ls[b++] = lr[r++];
        }
        //pw.println("R: " + ans);
        return ans;
    }

    void run() {
        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                ls[i] = sc.nextInt();
            }
            long r = merge(0, n)/2;
            //pw.println(r);
            if (r%2 == 1) {
                pw.println("Marcelo");
            } else {
                pw.println("Carlos");
            }
        }

    }

}
