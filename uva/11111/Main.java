/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11111
 *  UVa link: http://uva.onlinejudge.org/external/111/11111.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov  2 17:24:57 2014
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

    int[] ls = new int[10000];
    int n;

    void run() {
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] sl = s.trim().split(" ");
            n = 0;
            //out.flush();
            if ("".equals(s)) {
                continue;
            }

            if (sl.length == 1) {
                out.println(":-( Try again.");
                continue;
            }

            for (int i = 0; i< sl.length; i++) {
                if ("".equals(sl[i])) {
                    continue;
                }

                int id = Integer.valueOf(sl[i]);
                if (id < 0) {
                    ls[n++] = id;
                } else {
                    int sum = 0;
                    int j = n-1;
                    while (j>=0 && ls[j] > 0) {
                        sum += ls[j];
                        j--;
                    }
                    if (j>=0) {
                        if (id>sum && ls[j] == -id) {
                            ls[j] = id;
                            n = j+1;
                        } else {
                            n = -1;
                            break;
                        }
                    } else {
                        n = -1;
                        break;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (ls[i] < 0) {
                    n = -1;
                    break;
                }
            }

            if (n > 0) {
                out.println(":-) Matrioshka!");
            } else {
                out.println(":-( Try again.");
            }
        }
    }

}
