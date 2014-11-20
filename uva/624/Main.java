/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 624
 *  UVa link: http://uva.onlinejudge.org/external/6/624.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 22 18:24:47 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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

    int[] ls = new int[30];
    int n = 0;
    int sum = 0;
    int min = 0;

    int cnt(int x) {
        int ans = 0;
        int id = 0;
        while (x>0) {
            if (x%2==1) {
                ans += ls[id];
            }
            x = x>>1;
            id++;
        }
        return ans;
    }

    void print(int x) {
        int id = 0;
        while (x>0) {
            if (x%2==1) {
                pw.printf("%d ", ls[id]);
            }
            x = x>>1;
            id++;
        }
        pw.printf("sum:%d%n", min);
    }

    void run() {
        while (sc.hasNext()) {
            sum = sc.nextInt();
            n = sc.nextInt();
            min = 0;
            for (int i = 0; i < n; i++) {
                ls[i] = sc.nextInt();
                min += ls[i];
            }
            int x = (1<<n) - 1;
            int t = 0;
            //pw.printf("%d %d%n", min, sum);
            if (min <= sum) {
                print(x);
            } else {
                n = x;
                min = 0;
                for (int i = 1; i < n; i++) {
                    t = cnt(i);
                    if (t == sum){
                        min = t;
                        x = i;
                        break;
                    }
                    if ( t < sum && t > min) {
                        min = t;
                        x = i;
                    }
                }
                print(x);
            }
        }

    }

}
