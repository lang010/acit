/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10152
 *  UVa link: http://uva.onlinejudge.org/external/101/10152.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov  1 21:01:04 2014
 */

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    Scanner in = new Scanner(System.in, "ISO-8859-1");
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();

    }
    void release() {
	in.close();
	out.close();
    }

    int[] ls = new int[300];
    String[] init = new String[300];
    String[] goal = new String[300];

    void run() {
        int cnt = in.nextInt();
        for (int i = 0; i < cnt; i++) {
            int n = in.nextInt();
            in.nextLine();
            for (int j = 0; j < n; j++) {
                init[j] = in.nextLine();
            }
            for (int j = 0; j < n; j++) {
                goal[j] = in.nextLine();
                for (int k = 0; k < n; k++) {
                    if (init[k].equals(goal[j])) {
                        ls[k] = j;
                        break;
                    }
                }
            }
            int max = -1;
            int id = -1;
            while (true) {
                max = ls[0];
                id = -1;
                for (int j = 1; j < n; j++) {
                    if (max > ls[j]) {
                        if (id < 0 || ls[id] < ls[j]) {
                            id = j;
                        }

                    }
                    if (max < ls[j]) {
                        max = ls[j];
                    }
                }
                if (id < 0) {
                    break;
                }
                max = ls[id];
                out.println(goal[max]);
                for (int j = id; j > 0; j--) {
                    ls[j] = ls[j-1];
                }
                ls[0] = max;
            }
            out.println();
        }
        

    }

}
