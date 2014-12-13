/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 484
 *  UVa link: http://uva.onlinejudge.org/external/4/484.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 13 15:31:10 2014
 */
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

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

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[] ls = new int[10000];
    int n = 0;

    void run() {
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            Integer v = map.get(x);
            if (v != null) {
                map.put(x, v+1);
            } else {
                ls[n++] = x;
                map.put(x, 1);
            }
        }
        for (int i = 0; i < n; i++) {
            pw.printf("%d %d%n", ls[i], map.get(ls[i]));
        }
    }

}
