/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 112
 *  UVa link: http://uva.onlinejudge.org/external/1/112.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov  6 21:31:26 2014
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

    boolean t = false;
    int sum = 0;
    int r = 0;
    
    String str = "";
    int idT = 1;

    String nextT() {
        while (true) {
            if (idT >= str.length()) {
                str = in.nextLine();
                idT = 0;
            }

            char c = str.charAt(idT);
            if (c == '-' || (c >= '0' && c <= '9')) {
                break;
            }

            idT++;
            if (c == '(') {
                return "(";
            }
            if (c == ')') {
                return ")";
            }
        }
        String s = "";
        while (idT < str.length()) {
            char c = str.charAt(idT);
            if (c == '-' || (c >= '0' && c <= '9')) {
                s = s+c;
                idT++;
            } else {
                break;
            }
        }
        //out.println("Number: " + s);
        return s;
    }

    int tree() {

        String s = nextT();
        if ("".equals(s)) {
            return 0;
        }
        if (s.equals("(")) {
            s = nextT();
            if (s.equals(")")) {
                return 0;
            }
            int v = Integer.valueOf(s);
            sum += v;
            int rd = tree();
            int ld = tree();
            nextT();
            if (rd < ld) {
                rd = ld;
            }
            if (rd == 0 && sum == r) {
                t = true;
            }
            //out.println(rd + ":" + r + ": " + sum + ": " + v);

            sum -= v;
            return rd+1;
        }
        return -1;
    }

    void run() {
        while (in.hasNext()) {
            r = in.nextInt();
            sum = 0;
            t = false;
            tree();
            if (t) {
                out.println("yes");
            } else {
                out.println("no");
            }
        }

    }

}
