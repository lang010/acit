/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10115
 *  UVa link: http://uva.onlinejudge.org/external/101/10115.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    String ret;
    List<String> ls = new ArrayList<String>();
    List<String> vs = new ArrayList<String>();

    void run() {

	while (true) {
	    int n = in.nextInt();
	    if (n == 0)
		break;
	    in.nextLine();
	    for (int i = 0; i < n ; i++) {
		String k = in.nextLine();
		String v = in.nextLine();
		ls.add(k);
		vs.add(v);
	    }
	    ret = in.nextLine();
	    for (int i = 0; i < ls.size(); i++) {
		reg(ls.get(i), vs.get(i));
	    }
	    System.out.println(ret);
	    ls.clear();
	    vs.clear();
	}
    }

    void reg(String k, String v) {
	while (true) {
	    int i = ret.indexOf(k);
	    if (i < 0)
		break;
	    //ret = ret.substring(0, i) + v + ret.substring(i+k.length(), ret.length());
	    ret = ret.replaceFirst(k, v);
	}
    }
}
