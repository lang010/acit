/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10931
 *  UVa link: http://uva.onlinejudge.org/external/109/10931.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  4 09:47:21 2014
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
        while (true) {
            int x = sc.nextInt();
            if (x == 0) {
                break;
            }
            String s = "";
            int c = 0;
            while (x>0) {
                if (x%2 == 1) {
                    c++;
                    s = "1" + s;
                } else {
                    s = "0" + s;
                }
                x = x/2;
            }
            pw.printf("The parity of %s is %d (mod 2).%n", s, c);
        }

    }

}
