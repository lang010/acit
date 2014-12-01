/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10260
 *  UVa link: http://uva.onlinejudge.org/external/102/10260.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  1 08:27:44 2014
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
    {
        map.put('B', 1);
        map.put('F', 1);
        map.put('P', 1);
        map.put('V', 1);

        map.put('C', 2);
        map.put('G', 2);
        map.put('J', 2);
        map.put('K', 2);
        map.put('Q', 2);
        map.put('S', 2);
        map.put('X', 2);
        map.put('Z', 2);

        map.put('D', 3);
        map.put('T', 3);

        map.put('L', 4);

        map.put('M', 5);
        map.put('N', 5);

        map.put('R', 6);
    }

    void run() {
        long ans = 0;
        while (sc.hasNext()) {
            String s = sc.next();
            ans = 0;
            Integer pre = null;
            for (int i = 0; i < s.length(); i++) {
                Integer t = map.get(s.charAt(i));
                if (t != null && t != pre) {
                    ans = ans * 10 + t;
                }
                pre = t;
            }
            if (ans > 0) {
                pw.println(ans);
            } else {
                pw.println();
            }

        }

    }

}
