/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 336
 *  UVa link: http://uva.onlinejudge.org/external/3/336.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 29 13:46:01 2014
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

    int max = 60;
    Map<Integer, Integer> idMap = new HashMap<Integer, Integer>();
    int[][] map = new int[max][max];
    int[] vis = new int[max];

    int dfs(int d, int id) {
        if (vis[id] >= d) {
            return 0;
        }
        vis[id] = d;
        int ans = 1;
        for (int i = 1; i < max; i++) {
            if (map[id][i]>0) {
                ans += dfs(d-1, i);
            }
        }

        return ans;
    }
    void run() {
        int cnt = 1;
        int idLen;
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            idMap.clear();
            idLen = 1;
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < max; j++) {
                    map[i][j] = 0;
                }
            }
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                Integer xId = idMap.get(x);
                if (xId == null) {
                    xId = idLen++;
                    idMap.put(x, xId);
                }
                Integer yId = idMap.get(y);
                if (yId == null) {
                    yId = idLen++;
                    idMap.put(y, yId);
                }

                map[xId][yId] = map[yId][xId] = 1;
            }
            while (true) {
                int b = sc.nextInt();
                int t = sc.nextInt();
                if (b == 0 && t == 0) {
                    break;
                }
                int c = 0;
                Integer bId = idMap.get(b);
                if (bId == null) {
                    bId = 0;
                }
                for (int i = 0; i < idLen; i++) {
                    vis[i] = 0;
                }
                //pw.printf("%d %d %d%n", bId, t, idLen);
                dfs(t+1, bId);
                for (int i = 1; i < idLen; i++) {
                    if (vis[i] == 0) {
                        c++;
                    }
                }
                pw.printf("Case %d: %d nodes not reachable from node %d with TTL = %d.%n", cnt++, c, b, t);
            }
        }
    }

}
