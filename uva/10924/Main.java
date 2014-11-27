/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10924
 *  UVa link: http://uva.onlinejudge.org/external/109/10924.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 28 11:39:17 2014
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

    boolean isPrime(int x) {
        if (x < 3) {
            return true;
        }
        int n = (int) Math.sqrt(x) + 1;
        for (int i = 2; i < n; i++) {
            if (x%i == 0) {
                return false;
            }
        }
        return true;
    }

    void run() {
        while (sc.hasNext()) {
            String s = sc.next();
            int sum = 0;
            char c;
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    sum += c - 'a' + 1;
                }
                if (c >= 'A' && c <= 'Z') {
                    sum += c - 'A' + 27;
                }
            }
            if (isPrime(sum)) {
                pw.println("It is a prime word.");
            } else {
                pw.println("It is not a prime word.");
            }
            //pw.flush();
        }

    }

}
