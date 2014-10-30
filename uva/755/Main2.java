import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        String m = "";
        HashMap<Character, Integer> charMAP = new HashMap<Character, Integer>();
        hashMapFill(charMAP);
        int cases = Integer.parseInt(br.readLine());
	long t1, t2=0, t3=0, t4=0;
	long beg, end;
        for (int j = 0; j < cases; j++) {
            if (j > 0) {
                sb.append("\n");
            }

	    beg = System.currentTimeMillis();
            br.readLine();
            int n = Integer.parseInt(br.readLine().trim());
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            Stack<String> list = new Stack<String>();
            for (int i = 0; i < n; i++) {
                String temp = stringMan(br.readLine(), charMAP);
                if (hm.containsKey(temp)) {
                    int ind = hm.get(temp) + 1;
                    hm.remove(temp);
                    hm.put(temp, ind);
                } else {
                    hm.put(temp, 1);
                    list.push(temp);
                }
            }

	    end = System.currentTimeMillis();
	    t1 = end - beg;
	    beg = end;

            String[] arr = new String[list.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.pop();
            }
            Arrays.sort(arr);
            boolean enter = false;
            for (int i = 0; i < arr.length; i++) {
                int number = hm.get(arr[i]);
                if (number > 1) {
                    sb.append(arr[i]).append(" ").append(number).append("\n");
                    enter = true;
                }
            }
            if (!enter) {
                sb.append("No duplicates.\n");
            }

	    //System.out.printf("Time: %d, %d, %d, %d%n", t1, t2, t3, t4);

        }
        System.out.print(sb);
    }

    static String stringMan(String x, HashMap<Character, Integer> hm) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != '-') {
                if ((x.charAt(i) >= 'A' && x.charAt(i) <= 'Z')
		    || (x.charAt(i) >= 'a' && x.charAt(i) <= 'z')) {
                    sb.append(hm.get(x.charAt(i)));
                } else if (x.charAt(i) >= '0' && x.charAt(i) <= '9') {
                    sb.append(x.charAt(i));
                }
            }
        }
        return sb.substring(0, 3) + "-" + sb.substring(3, sb.length());
    }

    static void hashMapFill(HashMap<Character, Integer> hm) {
        for (int i = 0, j = 1, count = 0; i < 26; i++) {
            if (count % 3 == 0) {
                j++;
            }
            if ((char) (i + 65) != 'Q' && (char) (i + 65) != 'Z') {
                char temp = (char) (i + 65);
                hm.put((char) (i + 65), j);
                hm.put((char) (i + 97), j);
                count++;
            }
        }
    }
}
