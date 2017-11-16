package isumi.namenum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
	/*
	 * 位数
	 * 位
	 * 2: A,B,C     5: J,K,L    8: T,U,V
          3: D,E,F     6: M,N,O    9: W,X,Y
          4: G,H,I     7: P,R,S
	 * GPDG GPDH GPDI GPEG GPEH GPEI GPFG GPFH GPFI GRDG GRDH GRDI
		GREG GREH GREI GRFG GRFH GRFI GSDG GSDH GSDI GSEG GSEH GSEI
		GSFG GSFH GSFI HPDG HPDH HPDI HPEG HPEH HPEI HPFG HPFH HPFI
		HRDG HRDH HRDI HREG HREH HREI HRFG HRFH HRFI HSDG HSDH HSDI
		HSEG HSEH HSEI HSFG HSFH HSFI IPDG IPDH IPDI IPEG IPEH IPEI
		IPFG IPFH IPFI IRDG IRDH IRDI IREG IREH IREI IRFG IRFH IRFI
		ISDG ISDH ISDI ISEG ISEH ISEI ISFG ISFH ISFI
		4734
		IDRA
	 */
	
	public static void main(String[] args) throws Exception{
		BufferedReader f = new BufferedReader(new FileReader("D:/git/usaco-practice/src/isumi/namenum/namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D:/git/usaco-practice/src/isumi/namenum/namenum.out")));
		BufferedReader dictf = new BufferedReader(new FileReader("D:/git/usaco-practice/src/isumi/namenum/dict.txt"));
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
		System.out.println(result);
	}

}
