/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 127
 *  UVa link: http://uva.onlinejudge.org/external/1/127.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov  5 08:11:40 2014
 */

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    Scanner in = new Scanner(System.in, "ISO-8859-1");
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();

    }
    void release() {
	in.close();
	out.close();
    }
    String[][] sl = new String[100][100];
    int[] ls = new int[100];
    int n = 0;

    boolean same(int i, int j) {
        String s1 = sl[i][ls[i]-1];
        String s2 = sl[j][ls[j]-1];
        if (s1.charAt(0) == s2.charAt(0) || s1.charAt(1) == s2.charAt(1)) {
            sl[i][ls[i]++] = s2;
            ls[j]--;
            return true;
        }
        return false;
    }

    void print() {
        for (int i = 0; i < n; i++) {
            if (ls[i] > 0) {
                out.printf("(%s, %s) ", i, sl[i][ls[i]-1]);
            }
        }
        /*
        for (int i = 0; i < ls[0]; i++) {
            out.printf(sl[0][i] + " ");
        }
        */
        out.println(n);
        out.flush();
    }

    int move(int id, int dx) {
        int i = id;
        int cnt = 0;
        boolean r = false;
        if (ls[id]<1) {
            return -1;
        }

        while (i>=0 && cnt<dx) {
            i--;
            if (i>=0 && ls[i] > 0) {
                cnt++;
            }
        }
        if (i >= 0 && cnt == dx) {
            if (same(i, id)) {
                r = true;
            }
        }

        if (r) {
            return i;
        }

        return -1;
    }

    void run() {

        while (true) {
            String s = in.nextLine();
            if ("#".equals(s)) {
                break;
            }

            n = 0;
            s = s + " " + in.nextLine();
            String[] ss = s.split(" ");
            for (int i = 0; i < ss.length; i++) {
                if (ss[i].length() == 2) {
                    ls[n] = 1;
                    sl[n++][0] = ss[i];
                }
            }

            int cnt = 0;
            int i,r;
            while (true) {
                cnt = 0;
                for (i = 1; i < n; i++) {
                    r = move(i, 3);
                    if (r>=0) {
                        break;
                    }
                    r = move(i, 1);
                    if (r>=0) {
                        break;
                    }
                }
                //print();
                
                if (i == n) {
                    break;
                }
            }
            
            cnt = 0;
            s = " remaining:";
            for (i = 0; i < n; i++) {
                if (ls[i] > 0) {
                    cnt++;
                    s = s + " " + ls[i];
                }
            }
            if (cnt > 1) {
                s = cnt + " piles" + s;
            } else {
                s = cnt + " pile" + s;
            }
            out.println(s);
        }
    }

}
