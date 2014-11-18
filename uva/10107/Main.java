/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10107
 *  UVa link: http://uva.onlinejudge.org/external/101/10107.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 19 08:01:59 2014
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

    int[] qMax = new int[10010];
    int[] qMin = new int[10010];
    int nMax = 1;
    int nMin = 1;

    void addMin(int x) {
        int id = nMin++;
        qMin[id] = x;
        while (id>1) {
            int p = id/2;
            if (qMin[p]<=qMin[id]) {
                break;
            }
            int t = qMin[p];
            qMin[p] = qMin[id];
            qMin[id] = t;
            id = p;
        }
    }

    void addMax(int x) {
        int id = nMax++;
        qMax[id] = x;
        while (id > 1) {
            int p = id/2;
            if (qMax[p]>=qMax[id]) {
                break;
            }
            int t = qMax[p];
            qMax[p] = qMax[id];
            qMax[id] = t;
            id = p;
        }

    }

    int peekMin() {
        return qMin[1];
    }

    int peekMax() {
        return qMax[1];
    }

    int rmMin() {
        int x = qMin[1];
        qMin[1] = qMin[--nMin];
        int id = 1;
        while (id<nMin) {
            int l = id*2;
            int r = id*2+1;
            if (l < nMin && r < nMin && qMin[l] > qMin[r]) {
                l = r;
            }
            if (l < nMin && qMin[id] > qMin[l]) {
                r = qMin[id];
                qMin[id] = qMin[l];
                qMin[l] = r;
                id = l;
            } else {
                break;
            }
        }
        return x;
    }

    int rmMax() {
        int x = qMax[1];
        qMax[1] = qMax[--nMax];
        int id = 1;
        while (id<nMax) {
            int l = id*2;
            int r = id*2+1;
            if (l<nMax && r<nMax && qMax[l] < qMax[r]) {
                l = r;
            }
            if (l<nMax && qMax[l] > qMax[id]) {
                r = qMax[id];
                qMax[id] = qMax[l];
                qMax[l] = r;
                id = l;
            } else {
                break;
            }

        }
        return x;
    }

    void run() {
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            if (nMin > 1 && x >= peekMin()) {
                addMin(x);
            } else if (nMax > 1 && x <= peekMax()) {
                addMax(x);
            } else {
                addMax(x);
            }
            //pw.printf("%d %d%n", nMax, nMin);
            if (nMin > nMax) {
                x = rmMin();
                addMax(x);
            }
            if (nMax - nMin > 1) {
                x = rmMax();
                addMin(x);
            }
            //pw.printf("%d %d%n", nMax, nMin);
            //pw.flush();
            if (nMax == nMin) {
                x = (peekMax()+peekMin())/2;
            } else {
                x = peekMax();
            }
            pw.println(x);
            //pw.flush();
        }

    }

}
