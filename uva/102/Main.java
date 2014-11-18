/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 102
 *  UVa link: http://uva.onlinejudge.org/external/1/102.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 16 19:11:34 2014
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

    String[] ls = {"BCG", "BGC", "CBG", "CGB", "GBC", "GCB"};
    int[] il = new int[9];

    void run() {
        int min = 0;
        int id = 0;
        char c = 0;
        int cnt = 0;
        while (sc.hasNext()) {
            for (int i = 0; i < 9; i++) {
                il[i] = sc.nextInt();
            }
            min = -1;
            for (int i = 0; i < 6; i++) {
                cnt = 0;
                for (int j = 0; j < 3; j++) {
                    c = ls[i].charAt(j);
                    int dx = j*3;
                    switch (c) {
                    case 'B':
                        cnt += il[dx+1] + il[dx+2];
                        break;
                    case 'C':
                        cnt += il[dx] + il[dx+1];
                        break;
                    case 'G':
                        cnt += il[dx] + il[dx+2];
                        break;
                    default:
                        break;
                    }

                }
                if (min < 0 || cnt < min) {
                    min = cnt;
                    id = i;
                }
            }
            pw.printf("%s %d%n", ls[id], min);
        }

    }

}
