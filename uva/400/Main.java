
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    void run() {
	int cnt = 0;
	int len = 0;
	List<String> ls = new ArrayList<String>();
	while (in.hasNext()) {
	    ls.clear();
	    len = 0;
	    cnt = in.nextInt();
	    for (int i = 0; i < cnt ; i++) {
		String s = in.next();
		ls.add(s);
		if (len < s.length())
		    len = s.length();
	    }
	    Collections.sort(ls);
	    int r = 62/(len+2);
	    int c = (ls.size()+r-1)/r;
	    for (int i = 0; i < 60; i++)
		System.out.print("-");
	    System.out.println();
	    
	    for (int i = 0; i < c; i++) {
		for (int j = 0; j < r; j++) {
		    int id = c*j+i;
		    if (id >= ls.size())
			break;
		    System.out.printf("%-" + len + "s", ls.get(id));
		    if (j < r-1) {
			System.out.print("  ");
		    }
		}
		System.out.println();
	    }
	}
    }

}
