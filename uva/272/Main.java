/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 272
 *  UVa link: http://uva.onlinejudge.org/external/2/272.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 16 10:24:50 2014
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
        int cnt = 0;
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int id = s.indexOf("\"");
            while (id >= 0) {
                cnt++;
                pw.printf(s.substring(0, id));
                if (cnt%2 == 1) {
                    pw.printf("``");
                } else {
                    pw.printf("''");
                }


                s = s.substring(id+1);
                id = s.indexOf("\"");
            }
            pw.println(s);
        }

    }

}
