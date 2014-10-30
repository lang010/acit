
import java.util.Scanner;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    int N;
    int[] g = new int[1100];
    int[] s = new int[1100];
    boolean[] f1 = new boolean[1100];
    boolean[] f2 = new boolean[1100];
    int cnt = 0;

    void run() {
	while (true) {
	    N = in.nextInt();
	    if (N == 0)
		break;
	    read(s);
	    cnt++;
	    System.out.println("Game " + cnt + ":");
	    
	    while (true) {
		if (!read(g))
		    break;
		proc();
	    }
	}
    }

    boolean read(int[] g) {
	boolean t = false;
	for (int i = 0; i < N ; i++) {
	    g[i] = in.nextInt();
	    if (g[i] != 0) {
		t = true;
	    }
	}
	return t;
    }

    void proc() {
	int first = 0;
	int sec = 0;
	for (int i = 0; i < N ; i++) {
	    f1[i] = f2[i] = true;
	    if (s[i] == g[i]) {
		f1[i] = f2[i] = false;
		first++;
	    }
	}
	for (int i = 0; i < N; i++) {
	    if (!f1[i])
		continue;
	    for (int j = 0; j < N ; j++) {
		if (f1[i] && f2[j] && s[i] == g[j]) {
		    f1[i] = f2[j] = false;
		    sec++;
		}
	    }
	}
	System.out.printf("    (%d,%d)\n", first, sec);
	
    }

}
