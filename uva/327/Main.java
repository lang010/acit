/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 327
 *  UVa link: http://uva.onlinejudge.org/external/3/327.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 12 15:16:25 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();
    }
    void release() throws Exception {
	in.close();
	out.close();
    }

    void run() throws Exception {
        String s, l;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int id, sum, v, dx;
        char c, op;
        while (true) {
            s = in.readLine();
            if (s == null) {
                break;
            }

            l = s.replace(" ", "");
            if ("".equals(l)) {
                continue;
            }
            //cs = l.toCharArray();
            map.clear();
            id = 0;
            sum = 0;

            if (l.startsWith("--")) {
                id = 2;
                c = l.charAt(id++);
                v = c - 'a' + 1;
                v--;
            } else if (l.startsWith("++")) {
                id = 2;
                c = l.charAt(id++);
                v = c - 'a' + 1;
                v++;
            } else {
                c = l.charAt(id++);
                v = c - 'a' + 1;
            }
            map.put(c, v);
            sum = v;
            dx = 0;
            while (id<l.length()) {
                if (l.charAt(id) == l.charAt(id+1)) {
                    if (l.charAt(id) == '+') {
                        v++;
                    } else if (l.charAt(id) == '-') {
                        v--;
                    }
                    map.put(c, v);
                    id += 2;
                    if (id >= l.length()) {
                        break;
                    }
                }
                op = l.charAt(id++);
                dx = 0;
                if (id+1 < l.length() && l.charAt(id) == l.charAt(id+1)) {
                    if (l.charAt(id) == '+') {
                        dx = 1;
                    } else {
                        dx = -1;
                    }
                    id += 2;
                }
                c = l.charAt(id++);
                v = c - 'a' + 1 + dx;
                map.put(c, v);
                if (op == '+') {
                    sum += v;
                } else {
                    sum -= v;
                }
            }

            out.printf("Expression: %s%n    value = %d%n", s, sum);
            for (c = 'a'; c <= 'z'; c++) {
                Integer value = map.get(c);
                if (value != null) {
                    out.printf("    %c = %d%n", c, value);
                }
            }
        }

    }

}
