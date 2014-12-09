/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 492
 *  UVa link: http://uva.onlinejudge.org/external/4/492.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  7 19:58:06 2014
 */
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.run();
        m.release();
    }
    void release() throws Exception {
        bufReader.close();
        pw.close();
    }

    void print(String s, boolean isLast) {
        if (s == null || "".equals(s)) {
            return ;
        }
        char c = s.charAt(0);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            if (isLast) {
                pw.printf("%s", s);
                return ;
            }
            pw.printf("%say", s);
        } else {
            if (isLast) {
                pw.printf("%s", s.substring(1, s.length()));
                return ;
            }
            pw.printf("%s%cay", s.substring(1, s.length()), c);
        }
    }

    void run() throws Exception {
        String s = "";
        while (true) {
            int n = bufReader.read();
            if (n<0) {
                print(s, false);
                break;
            }
            char c = (char) n;
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                s = s + c;
            } else {
                print(s, false);
                s = "";
                pw.printf("%c", c);
            }
        }

    }

}
