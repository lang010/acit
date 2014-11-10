/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 409
 *  UVa link: http://uva.onlinejudge.org/external/4/409.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    public void run() {
	int k, e;
	int ca = 0;
	Set<String> set = new HashSet<String>();
	List<String> ls = new ArrayList<String>();
	while (true) {
	    ca++;
	    k = in.nextInt();
	    e = in.nextInt();
	    in.nextLine();
	    String s = null;
	    set.clear();
	    for (int i = 0; i < k ; i++) {
		s = in.nextLine();
		set.add(s.trim().toLowerCase());
	    }
	    int max = 0;
	    int cnt = 0;
	    ls.clear();
	    for (int i = 0; i < e; i++) {
		s = in.nextLine();
		String[] sl = s.split("\\W");
		cnt = 0;
		for (int j = 0; j < sl.length; j++) {
		    if (set.contains(sl[j].toLowerCase()))
			cnt++;
		}
		if ( cnt == max )
		    ls.add(s);
		if ( cnt > max ) {
		    ls.clear();
		    ls.add(s);
		    max = cnt;
		}
	    }
	    System.out.println("Excuse Set #" + ca);
	    for (int i = 0; i < ls.size(); i++) {
		System.out.println(ls.get(i));
	    }
		
	    System.out.println();
	    

	    if (!in.hasNext())
		break;
	}
    }
}
