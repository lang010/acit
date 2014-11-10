/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 540
 *  UVa link: http://uva.onlinejudge.org/external/5/540.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov  6 07:51:41 2014
 */

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

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

    Queue<Integer> qu = new LinkedList<Integer>();
    Map<Integer, Queue<Integer>> quMap = new HashMap<Integer, Queue<Integer>>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    void run() {
        int n, i, j, k;
        int cnt = 0;
        while (in.hasNext()) {
            qu.clear();
            quMap.clear();
            map.clear();
            n = in.nextInt();
            if (n == 0) {
                break;
            }
            for (i = 0; i < n; i++) {
                k = in.nextInt();
                Queue<Integer> q = new LinkedList<Integer>();
                quMap.put(i, q);
                for (j = 0; j < k; j++) {
                    int id = in.nextInt();
                    map.put(id, i);
                }
            }
            out.printf("Scenario #%d%n", ++cnt);
            while (in.hasNext()) {
                String s = in.next();
                if ("STOP".equals(s)) {
                    break;
                } else
                if ("ENQUEUE".equals(s)) {
                    Integer id = in.nextInt();
                    Integer t = map.get(id);
                    Queue<Integer> q = quMap.get(t);
                    if (q.size() < 1) {
                        qu.add(t);
                    }
                    q.add(id);
                } else if ("DEQUEUE".equals(s)) {
                    Integer t = qu.peek();
                    Queue<Integer> q = quMap.get(t);
                    Integer id = q.remove();
                    out.println(id);
                    if (q.size() < 1) {
                        qu.remove();
                    }
                }
            }
            out.println();
        }

    }

}
