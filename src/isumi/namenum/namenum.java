package isumi.namenum;

import java.io.*;
import java.util.*;

/*
ID: osuisum1
LANG: JAVA
TASK: namenum
*/

public class namenum {
	
	public static void main(String[] args) throws Exception {
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		BufferedReader dictf = new BufferedReader(new FileReader("namenumdict.txt"));
		String num = f.readLine();
		List<String> result = new ArrayList<String>();
		Map<Character,Character> rule = new HashMap();
		String ruleStr = "ABCDEFGHIJKLMNOPRSTUVWXY";
		for(int i=0;i<ruleStr.length();i++){
			int value = i/3 +2;
			rule.put(ruleStr.charAt(i), String.valueOf(value).charAt(0));
		}
		
		dictf.lines().forEach((s)->{
			if(num.length() == s.length()){
				boolean canadd = false;
				for(int i=0;i<s.length();i++){
					if(!(rule.containsKey(s.charAt(i))&&rule.get(s.charAt(i)).equals(num.charAt(i)))){
						canadd = false;
						break;
					}
					canadd = true;
				}
				if(canadd){
					result.add(s);
				}
			}
		});;
		if(result.isEmpty()){
			out.println("NONE");
		}else{
			for(String r:result){
				out.println(r);
			}
		}
		out.close();
	}

}
