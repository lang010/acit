/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10252
 *  UVa link: http://uva.onlinejudge.org/external/102/10252.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  1 08:09:55 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    int[] cnt = new int[50];
    char[] ls = new char[1100];
    int n = 0;

    void run() {
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            for (int i = 0; i < 50; i++) {
                cnt[i] = 0;
            }
            n = 0;
            for (int i = 0; i < s1.length(); i++) {
                cnt[s1.charAt(i)-'a']++;
            }
            for (int i = 0; i < s2.length(); i++) {
                char c = s2.charAt(i);
                if (cnt[c-'a']>0) {
                    ls[n++] = c;
                    cnt[c-'a']--;
                }
            }
            Arrays.sort(ls, 0, n);
            pw.println(new String(ls, 0, n));
        }

    }

}
