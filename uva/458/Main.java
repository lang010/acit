/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 458
 *  UVa link: http://uva.onlinejudge.org/external/4/458.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 16 09:31:53 2014
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
        while (sc.hasNext()) {
            String l = sc.nextLine();
            for (int i = 0; i < l.length(); i++) {
                pw.printf("%c", (char) (l.charAt(i)-7));
            }
            pw.println();
        }
    }

}
