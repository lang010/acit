/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 673
 *  UVa link: http://uva.onlinejudge.org/external/6/673.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov  1 21:30:32 2014
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

    void run() {
        int cnt = in.nextInt();
        in.nextLine();
        int n;
        char[] ls = new char[300];
        for (int i = 0; i < cnt; i++) {
            String s = in.nextLine();
            n = 0;
            char c;
            for (int j = 0; j < s.length(); j++) {
                c = s.charAt(j);
                if (c == '(' || c == '[') {
                    ls[n++] = c;
                } else {
                    if (c == ')' && n > 0 && ls[n-1] == '(') {
                        n--;
                    } else if (c == ']' && n > 0 && ls[n-1] == '[') {
                        n--;
                    } else {
                        n++;
                        break;
                    }
                }
            }
            if (n>0) {
                out.println("No");
            } else {
                out.println("Yes");
            }
        }

    }

}
