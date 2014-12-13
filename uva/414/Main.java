/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 414
 *  UVa link: http://uva.onlinejudge.org/external/4/414.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 13 14:43:05 2014
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
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            sc.nextLine();
            int min = 25;
            int tot = 0;
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                int c = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) != 'X') {
                        c++;
                    }
                }
                if (c < min) {
                    min = c;
                }
                tot += c;
            }
            pw.println(tot - min*n);
        }

    }

}
