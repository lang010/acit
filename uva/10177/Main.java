
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class Main {
    Scanner in = new Scanner(System.in, "ISO-8859-1");
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run2();
	m.release();
    }
    void release() {
	in.close();
	out.close();
    }

    Map<Integer, Long> m21 = new HashMap<Integer, Long>();
    Map<Integer, Long> m22 = new HashMap<Integer, Long>();
    Map<Integer, Long> m31 = new HashMap<Integer, Long>();
    Map<Integer, Long> m32 = new HashMap<Integer, Long>();
    Map<Integer, Long> m41 = new HashMap<Integer, Long>();
    Map<Integer, Long> m42 = new HashMap<Integer, Long>();

    void run() {
        while (in.hasNext()) {
            int n = in.nextInt();
            long s2, s3, s4, r2, r3, r4;
            long t2, t3, t4;
            Long t = m21.get(n);
            if (t != null ) {
                //out.println(false);
                out.printf("%d %d %d %d %d %d%n", m21.get(n), m22.get(n), m31.get(n), m32.get(n), m41.get(n), m42.get(n));
                continue;
            }
            s2 = s3 = s4 = r2 = r3 = r4 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    t2 = (n-i)*(n-j);
                    if (i == j)
                        s2 += t2;
                    else
                        r2 += t2;
                    for (int k = 0; k < n; k++) {
                        t3 = t2*(n-k);
                        //out.println(t3);
                        if (i == j && i==k)
                            s3 += t3;
                        else
                            r3 += t3;
                        for (int r = 0; r < n; r++) {
                            t4 = t3 * (n-r);
                            if (i == j && i == k && i == r)
                                s4 += t4;
                            else
                                r4 += t4;
                        }
                    }
                }
            }
            m21.put(n, s2); m22.put(n, r2);
            m31.put(n, s3); m32.put(n, r3);
            m41.put(n, s4); m42.put(n, r4);
            out.printf("%d %d %d %d %d %d%n", s2, r2, s3, r3, s4, r4);
        }
    }

    void run2() {
        int i,n;  
        long []s2;
        long s3[];
        long s4[];  
        long r2[],r3[],r4[];  
        s2 = new long[101];
        s3 = new long[101];
        s4 = new long[101];
        r2 = new long[101];
        r3 = new long[101];
        r4 = new long[101];
        s2[0]=0;s3[0]=0;s4[0]=0;  
        for(i=1;i<=100;i++) { 
            s2[i]=s2[i-1]+i*i;  
            s3[i]=s3[i-1]+i*i*i;  
            s4[i]=s4[i-1]+i*i*i*i;  
            r2[i]=(i*(i+1)/2l)*(i*(i+1)/2l)-s2[i];  
            r3[i]=(i*(i+1)/2l)*(i*(i+1)/2l)*(i*(i+1)/2)-s3[i];  
            r4[i]=(i*(i+1)/2l)*(i*(i+1)/2l)*(i*(i+1)/2)*(i*(i+1)/2)-s4[i];  
        }  
        while(in.hasNext()) {
            n = in.nextInt();
            out.printf("%d %d %d %d %d %d\n",s2[n],r2[n],s3[n],r3[n],s4[n],r4[n]);  
        }
    }

}
