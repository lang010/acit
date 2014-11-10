/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 537
 *  UVa link: http://uva.onlinejudge.org/external/5/537.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */
import java.util.Scanner;

public class Main {
    Scanner in = new Scanner(System.in);
    int nCase;
    public void run() {
	nCase = in.nextInt();
	in.nextLine();
	for ( int i = 0; i < nCase; i++) {
	    System.out.println("Problem #" + (i+1));
	    test();
	    //if (i < nCase - 1 )
	    System.out.println();
	    
	}
    }

    double i, u, p;
    
    public void test() {
	String s = in.nextLine();
	i = u = p = -1e20;

	parse(s);
	if (i < -1e19) {
	    if (u == 0)
		i = 0;
	    else i = p/u;
	    System.out.println(String.format("I=%.2fA", i));
	} else if (u < -1e19) {
	    if (i == 0)
		u = 0;
	    else u = p/i;
	    System.out.println(String.format("U=%.2fV", u));
	} else if (p < -1e19) {
	    p = u*i;
	    System.out.println(String.format("P=%.2fW", p));
	}
    }

    public void parse(char c, String s) {
	    double v = 1;
	    int e = 0;
	    for (e = 0; e < s.length(); e++) {
		char x = s.charAt(e);
		if (x == 'k') {
		    v *= 1000;
		    break;
		} else if (x == 'M') {
		    v *= 1000000;
		    break;
		} else if (x == 'm') {
		    v *= 0.001;
		    break;
		} else if (x == 'A') {
		    break;
		} else if (x == 'V') {
		    break;
		} else if (x == 'W') {
		    break;
		}
	    }
	    s = s.substring(0, e);

	    //System.out.println(ls[1]);
	    v *= Double.parseDouble(s);
	    
	    if (c == 'I')
		i = v;
	    if (c == 'U')
		u = v;
	    if (c == 'P')
		p = v;
    }

    public void parse(String s) {
	String[] ls = s.split("=");
	if (ls.length > 1) {
	    parse(ls[0].charAt(ls[0].length()-1), ls[1]);
	    parse(ls[1].charAt(ls[1].length()-1), ls[2]);
	}
    }


    public static void main(String[] args) {
	// Testing.
	Main m = new Main();
	m.run();
    }

}
