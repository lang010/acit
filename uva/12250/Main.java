/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 12250
 *  UVa link: http://uva.onlinejudge.org/external/122/12250.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 18 10:31:19 2014
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

    Map<String, String> map = new HashMap<String, String>();
    {
        map.put("HELLO", "ENGLISH");
        map.put("HOLA", "SPANISH");
        map.put("HALLO", "GERMAN");
        map.put("BONJOUR", "FRENCH");
        map.put("CIAO", "ITALIAN");
        map.put("ZDRAVSTVUJTE", "RUSSIAN");
    };

    void run() {
        int cnt = 1;
        while (true) {
            String s = sc.next();
            if ("#".equals(s)) {
                break;
            }
            String v = map.get(s);
            if (v == null) {
                v = "UNKNOWN";
            }
            pw.printf("Case %d: %s%n", cnt++, v);
        }

    }

}
