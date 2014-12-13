/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10131
 *  UVa link: http://uva.onlinejudge.org/external/101/10131.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 14 08:50:48 2014
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

    int[] wl = new int[1500];
    int[] sl = new int[1500];
    int[] il = new int[1500];
    int[] max = new int[1500];
    int[] pre = new int[1500];
    int n = 0;

    void print(int id) {
        if (max[id] > 0) {
            print(pre[id]);
        }
        pw.println(il[id]);
    }

    void run() {
        while (sc.hasNext()) {
            wl[n] = sc.nextInt();
            sl[n] = sc.nextInt();
            il[n] = n+1;
            n++;
        }
        for (int i = 0; i < n; i++) {
            int minI = i;
            for (int j = i; j < n; j++) {
                if (wl[minI] > wl[j]) {
                    minI = j;
                }
            }
            if (minI != i) {
                int t = wl[i];
                wl[i] = wl[minI];
                wl[minI] = t;
                t = sl[i];
                sl[i] = sl[minI];
                sl[minI] = t;
                t = il[i];
                il[i] = il[minI];
                il[minI] = t;
            }
        }
        int maxI = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (wl[j]<wl[i] && sl[j]>sl[i]) {
                    if (max[i] < max[j]+1) {
                        max[i] = max[j]+1;
                        pre[i] = j;
                        if (max[i] > max[maxI]) {
                            maxI = i;
                        }
                    }
                }
            }
        }
        pw.println(max[maxI]+1);
        print(maxI);
    }
}
