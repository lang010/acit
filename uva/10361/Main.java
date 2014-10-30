
import java.util.Scanner;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    void run() {
	int cnt = in.nextInt();
	//in.nextLine();
	//in.nextLine();
	for (int i = 0; i < cnt ; i++) {
	    r();
	}
    }

    String readLine() {
	while (true) {
	    String s = in.nextLine();
	    if (!s.equals(""))
		return s;
	}
    }
    void r() {
	String s = readLine();
	//System.out.println(s);
	int f = s.indexOf("<");
	if (f < 0) {
	    System.out.println("Error:" + s);
	    return ;
	}
	String pre = s.substring(0, f);
	s = s.substring(f+1);
	String[] ls = s.split(">");
	System.out.println(ls);
	System.out.println(ls.length);
	for (int k = 0; k < ls.length; k++)
	    System.out.println("ok: " + ls[k]);
	
	String s2 = ls[0];
	String s5 = "";
	if (ls != null && ls.length > 2)
	    s5 = ls[2];
	ls = ls[1].split("<");
	System.out.println(ls.length);
	for (int k = 0; k < ls.length; k++)
	    System.out.println("ok: " + ls[k]);
	
	String s3 = "";
	String s4 = "";
	if (ls != null && ls.length > 0)
	    s3 = ls[0];
	if (ls != null && ls.length > 1)
	    s4 = ls[1];
	System.out.println(pre + s2 + s3 + s4 + s5);

	s = readLine();
	s = s.replace("...", s4+s3+s2+s5);
	System.out.println(s);
	
    }
}
