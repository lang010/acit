
import java.util.Scanner;
import java.util.*;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    void run() {
	Set<String> ig = new HashSet<String>();
	while (true) {
	    String s = in.nextLine().toLowerCase();
	    if (s.equals("::"))
		break;
	    ig.add(s);
	}

	List<String> w = new ArrayList<String>();
	while (in.hasNext()) {
	    String s = in.nextLine().toLowerCase();
	    w.add(s);
	}

	Map<String, List<String>> m = new HashMap<String, List<String>>();
	for (String s : w) {
	    String[] ls = s.split("\\s");
	    for (int i = 0; i < ls.length ; i++) {
		String k = ls[i];
		if (ig.contains(k))
		    continue;
		List<String> l = m.get(k);
		if (l == null) {
		    l = new ArrayList<String>();
		    m.put(k, l);
		}
		l.add(form(ls, i));
	    }
	}
	List<String> keys = new ArrayList<String>(m.keySet());
	Collections.sort(keys);
	for (String s : keys) {
	    if (s.equals(""))
		continue;
	    List<String> ts = m.get(s);

	    //System.out.println(s);
	    for (String t : ts) {
		System.out.println(t);
	    }

	}
    }

    String form(String[] ls, int id) {
	String s = "";

	for (int i = 0; i < ls.length; i++) {
	    if (i>0) {
		s = s + " ";
	    }
	    if (i == id) {
		s = s + ls[i].toUpperCase();
	    } else {
		s = s + ls[i];
	    }
	}
	return s;
    }

}
