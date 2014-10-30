import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    Scanner in = new Scanner(System.in);

    void run() {
	Set<String> set = new HashSet<String>();
	while (in.hasNext()) {
	    String s = in.nextLine().toLowerCase();
	    String[] sl = s.split("[^a-zA-Z]");
	    for (int i = 0; i < sl.length; i++)
		if (!sl[i].equals(""))
		    set.add(sl[i]);
	}
	Object[] ls = set.toArray();
	Arrays.sort(ls);

	for (int i = 0; i < ls.length; i++) {
	    System.out.println(ls[i]);
	}
    }
}
