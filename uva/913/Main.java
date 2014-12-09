/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 913
 *  UVa link: http://uva.onlinejudge.org/external/9/913.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  7 21:15:15 2014
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
        while (sc.hasNextLong()) {
            long l = sc.nextLong();
            l = (l+1)*(l+1)/2-1;
            long s = 3*l - 6;
            pw.println(s);
        }

    }

}
