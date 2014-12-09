/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 713
 *  UVa link: http://uva.onlinejudge.org/external/7/713.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  6 14:47:03 2014
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
        int cnt = sc.nextInt();
        for (int k = 0; k < cnt; k++) {
            String s1 = sc.next();
            String s2 = sc.next();
            String s = "";
            for (int i = 0; i < s2.length() || i < s1.length(); i++) {
                if (i < s1.length() && i < s2.length()) {
                    s = s + (char)(s1.charAt(i)+s2.charAt(i)-'0');
                } else {
                    if (i < s1.length()) {
                        s = s + s1.charAt(i);
                    }
                    if (i < s2.length()) {
                        s = s + s2.charAt(i);
                    }
                }
            }
            char u = 0;
            String r = "";
            for (int i = 0; i < s.length(); i++) {
                char c = (char) (s.charAt(i) + u);
                u = 0;
                if (c > '9') {
                    u = 1;
                    c = (char) (c - 10);
                }
                r = r + c;
            }
            if (u>0) {
                r = r + "1";
            }
            int b = 0;
            while (r.charAt(b) == '0') {
                b++;
            }
            int e = r.length()-1;
            while (r.charAt(e) == '0') {
                e--;
            }
            pw.println(r.substring(b, e+1));
        }
    }

}
