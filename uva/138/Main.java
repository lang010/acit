/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 138
 *  UVa link: http://uva.onlinejudge.org/external/1/138.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  6 17:04:29 2014
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

    int[] ls = {
        6,8,
        35,49,
        204,288,
        1189,1681,
        6930,9800,
        40391,57121,
        235416,332928,
        1372105,1940449,
        7997214,11309768,
        46611179,65918161
    };

    void run() {
        for (int k = 0; k < 20; k+=2) {
            pw.printf("%10d%10d%n", ls[k], ls[k+1]);
        }
    }

}
