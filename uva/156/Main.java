
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    void run() {
	List<String> ls = new ArrayList<String>();
	Map<String, String> map = new HashMap<String, String>();
	Map<String, Integer> cntMap = new HashMap<String, Integer>();
	while (true) {
	    String s = in.nextLine();
	    if (s.equals("#"))
		break;
	    String[] sl = s.split(" ");
	    String s2 = null;
	    for (int i = 0; i < sl.length; i++) {
		s2 = sort(sl[i].toLowerCase());
		map.put(sl[i], s2);
		Integer c = cntMap.get(s2);
		if (c == null) {
		    c = 0;
		}
		c = c + 1;
		cntMap.put(s2, c);
		
	    }
	}
	for (String ss : map.keySet()) {
	    if (cntMap.get(map.get(ss)) < 2)
		ls.add(ss);
	}
	Collections.sort(ls);
	for (String ss : ls) {
	    if (ss.equals(""))
		continue;
	    System.out.println(ss);
	    
	}

    }

    String sort(String s) {
	if (s.equals(""))
	    return s;
	char[] cs = s.toCharArray();
	Arrays.sort(cs);
	return new String(cs);
    }
}
