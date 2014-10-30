
import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    void run() {
	int cnt = in.nextInt();
	String[] c = new String[cnt];
	Map<String, Integer> m = new HashMap<String, Integer>();
	Set<String> s = new HashSet<String>();
	for(int i = 0; i < cnt ; i++) {
	    c[i] = in.next();
	    String n = in.nextLine();
	    n = c[i] + n;
	    if (!s.contains(n)) {
		s.add(n);
		Integer sum = m.get(c[i]);
		if (sum == null) {
		    sum = Integer.valueOf(0);
		}
		sum = sum + 1;
		m.put(c[i], sum);
	    }
	}

	Arrays.sort(c);
	for(int i = 0; i < cnt; i++) {
	    if (i == 0 || !c[i].equals(c[i-1])) {
		System.out.println(c[i] + " " + m.get(c[i]));
	    }
	}
    }

}
