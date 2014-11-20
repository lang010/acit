/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10405
 *  UVa link: http://uva.onlinejudge.org/external/104/10405.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 20 22:29:29 2014
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

    int[][] map = new int[1100][1100];

    void run() {
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            for (int i = 1; i <= s1.length(); i++) {
                for (int j = 1; j <= s2.length(); j++) {
                    map[i][j] = 0;
                    if (s1.charAt(i-1) == s2.charAt(j-1)) {
                        map[i][j] = map[i-1][j-1]+1;
                    }
                    if (map[i][j]<map[i][j-1]) {
                        map[i][j] = map[i][j-1];
                    }
                    if (map[i][j]<map[i-1][j]) {
                        map[i][j] = map[i-1][j];
                    }
                }
            }
            pw.println(map[s1.length()][s2.length()]);
        }

    }

}
