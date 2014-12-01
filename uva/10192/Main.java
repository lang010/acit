/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10192
 *  UVa link: http://uva.onlinejudge.org/external/101/10192.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  4 11:29:03 2014
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

    int[][] map = new int[150][150];

    void run() {
        int c = 0;
        while (true) {
            String s1 = sc.nextLine();
            if ("#".equals(s1)) {
                break;
            }
            String s2 = sc.nextLine();
            for (int i = 1; i <= s1.length(); i++) {
                for (int j = 1; j <= s2.length(); j++) {
                    if (s1.charAt(i-1) == s2.charAt(j-1)) {
                        map[i][j] = map[i-1][j-1] + 1;
                    } else {
                        map[i][j] = map[i-1][j] > map[i][j-1] ? map[i-1][j] : map[i][j-1];
                    }
                }
            }
            pw.printf("Case #%d: you can visit at most %d cities.%n", ++c, map[s1.length()][s2.length()]);
        }

    }

}
