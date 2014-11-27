/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11340
 *  UVa link: http://uva.onlinejudge.org/external/113/11340.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 27 21:38:41 2014
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

    Map<Character, Integer> map = new HashMap<Character, Integer>();
    int sum = 0;
    int n = 0;
    int k,m;
    Integer val = null;

    void run() {
        n = sc.nextInt();
        for (int c = 0; c < n; c++) {
            map.clear();
            sum = 0;
            k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                map.put(sc.next().charAt(0), sc.nextInt());
            }
            m = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < m; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < s.length(); j++) {
                    val = map.get(s.charAt(j));
                    if (val != null) {
                        sum += val;
                    }
                }
            }
            pw.printf("%.2f$%n", sum/100.0);
        }

    }

}
