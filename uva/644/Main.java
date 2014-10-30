
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    void run() {
	List<String> ls = new ArrayList<String>();
	int cnt = 1;
	while (in.hasNext()) {
	    String l = in.nextLine();
	    if (l.equals("") ){
		continue;
	    }
	    if (!l.equals("9")) {
		ls.add(l.trim());
		continue;
	    }

	    boolean ok = true;
	    for (int i = 0; i < ls.size(); i++) {
		for (int j = i+1; j < ls.size(); j++) {
		    if (ls.get(i).startsWith(ls.get(j)) || ls.get(j).startsWith(ls.get(i))) {
			ok = false;
			break;
		    }
		}
		if (!ok) {
		    break;
		}
	    }
	    if (ok) {
		System.out.println("Set " + cnt + " is immediately decodable");
	    } else {
		System.out.println("Set " + cnt + " is not immediately decodable");
	    }
	    ls.clear();
	    cnt++;
	}
    }

}
