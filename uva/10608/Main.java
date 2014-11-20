/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10608
 *  UVa link: http://uva.onlinejudge.org/external/106/10608.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 20 23:10:00 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

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

    int N, M;
    int[] visited = new int[30010];
    List<List<Integer>> map = new ArrayList<List<Integer>>(10030);
    {
        for (int i = 0; i < 10030; i++) {
            map.add(new ArrayList<Integer>());
        }
    }

    int dfs(int id) {
        if (visited[id] == 1) {
            return 0;
        }
        int ans = 1;
        visited[id] = 1;
        for (int i = 0; i < map.get(id).size(); i++) {
            ans += dfs(map.get(id).get(i));
        }
        return ans;
    }
    
    void run() {
        int cnt = sc.nextInt();
        for (int i = 0; i < cnt; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            for (int j = 0; j <= N; j++) {
                visited[j] = 0;
                map.get(j).clear();
            }
            int x, y;
            for (int j = 0; j < M; j++) {
                x = sc.nextInt();
                y = sc.nextInt();
                map.get(x).add(y);
                map.get(y).add(x);
            }

            int ans = 0;
            for (int j = 1; j <= N; j++) {
                if (visited[j] == 0) {
                    int r = dfs(j);
                    if (ans < r) {
                        ans = r;
                    }
                }
            }
            pw.println(ans);
        }

    }

}
