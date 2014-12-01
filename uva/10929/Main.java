/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10929
 *  UVa link: http://uva.onlinejudge.org/external/109/10929.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 30 15:02:29 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

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
            String s = sc.nextLine();
            if ("0".equals(s)) {
                break;
            }
            BigInteger b = new BigInteger(s);
            if (b.mod(BigInteger.valueOf(11)) == BigInteger.ZERO) {
                pw.println(s + " is a multiple of 11.");
            } else {
                pw.println(s + " is not a multiple of 11.");
            }
        }

    }

}
