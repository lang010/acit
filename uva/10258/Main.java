/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10258
 *  UVa link: http://uva.onlinejudge.org/external/102/10258.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 27 22:44:39 2014
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

    int[] id = new int[100];
    int[] so = new int[100];
    int[] pe = new int[100];
    int[][] sub = new int[100][10];
    int T = 0;

    void run() {
        T = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        while (T>0) {
            T--;
            for (int i = 0; i < 100; i++) {
                id[i] = -1;
                so[i] = 0;
                pe[i] = 0;
                for (int j = 0; j < 10; j++) {
                    sub[i][j] = 0;
                }
            }

            while (sc.hasNextLine()) {
                String ss = sc.nextLine().trim();
                //pw.println(ss);
                //pw.flush();
                if ("".equals(ss)) {
                    break;
                }
                String[] ls = ss.split("\\s+");
                int x = Integer.valueOf(ls[0])-1;
                int s = Integer.valueOf(ls[1])-1;
                int t = Integer.valueOf(ls[2]);
                id[x] = x;
                if (ls[3].charAt(0) == 'C') {
                    if (sub[x][s]>=0) {
                        so[x]++;
                        pe[x] += t + sub[x][s]*20;
                        sub[x][s] = -1;
                    }
                } else if (sub[x][s]>=0 && ls[3].charAt(0) == 'I') {
                    sub[x][s]++;
                }
            }
            for (int i = 0; i < 100; i++) {
                int max = i;
                for (int j = i+1; j < 100; j++) {
                    if (so[j] > so[max]) {
                        max = j;
                        continue;
                    }
                    if (so[j] == so[max] && pe[j] < pe[max]) {
                        max = j;
                        continue;
                    }
                    if (so[j] == so[max] && pe[j] == pe[max]) {
                        if (id[max]<0 || (id[j] < id[max] && id[j]>=0)) {
                            max = j;
                        }
                    }

                }
                if (id[max] < 0) {
                    break;
                }
                if (i != max) {
                    int t = id[i];
                    id[i] = id[max];
                    id[max] = t;
                    t = so[i];
                    so[i] = so[max];
                    so[max] = t;
                    t = pe[i];
                    pe[i] = pe[max];
                    pe[max] = t;
                }

            }

            int c = 0;
            while (id[c]>=0) {
                pw.printf("%d %d %d%n", id[c]+1, so[c], pe[c]);
                c++;
            }
            if (T>0) {
                pw.println();
            }

        }

    }

}
