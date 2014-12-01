/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 514
 *  UVa link: http://uva.onlinejudge.org/external/5/514.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 29 12:53:49 2014
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

    void run() {
        int[] ls = new int[1010];
        int max;
        int min;
        int x;
        int flag;
        int n;
        while (true) {
            n = sc.nextInt();
            if (n==0) {
                break;
            }

            while (true) {
                max = sc.nextInt();
                if (max == 0) {
                    break;
                }
                ls[0] = max;
                min = max;
                flag = 0;
                for (int i = 1; i < n; i++) {
                    ls[i] = sc.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    max = min = ls[i];
                    for (int j = i+1; j < n; j++) {
                        if (ls[j] < max) {
                            if (ls[j] < min) {
                                min = ls[j];
                            } else {
                                flag = 1;
                            }
                        }
                    }
                }

                if (flag == 0) {
                    pw.println("Yes");
                } else {
                    pw.println("No");
                }
            }
            pw.println();
        }

    }

}
