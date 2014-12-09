/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 445
 *  UVa link: http://uva.onlinejudge.org/external/4/445.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  5 23:16:40 2014
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
        while (sc.hasNextLine()) {
            String ss = sc.nextLine();
            if ("".equals(ss)) {
                pw.println();
                continue;
            }
            int s = 0;
            for (int i = 0; i < ss.length(); i++) {
                char c = ss.charAt(i);
                if (c<='9' && c>='0') {
                    s += c - '0';
                } else {
                    if (c == '!') {
                        pw.println();
                        s = 0;
                        continue;
                    }
                    if (c == 'b') {
                        c = ' ';
                    }
                    for (int j = 0; j < s; j++) {
                        pw.printf("%c", c);
                    }
                    s = 0;
                }
            }

            pw.println();
        }

    }

}
