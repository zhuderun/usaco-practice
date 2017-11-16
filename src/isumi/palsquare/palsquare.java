package isumi.palsquare;
import java.io.*;
import java.util.*;
/*
ID: osuisum1
LANG: JAVA
TASK: milk2
*/
public class palsquare {
	
	public static void main(String[] args) throws Exception {
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		int radix = Integer.valueOf(f.readLine());
		for(int i = 1;i<=300;i++){
			int pow = (int) Math.pow(i, 2);
			RadixNum1 powStr = new RadixNum1(pow, radix);
			if(isPalNum(powStr.getRadixStr())){
				out.println(new RadixNum1(i, radix).getRadixStr() +" "+ powStr.getRadixStr());
			}
		}
		out.close();
	}
	
	private static boolean isPalNum(String num){
		String pre = num + "";
		String after = new StringBuffer(pre).reverse().toString();
		if(pre.equals(after)){
			return true;
		}
		return false;
	}

}



class Digist1{
	public Digist1 pre;
	public Character c;
}

class RadixNum1{
	private int radix;
	private Digist1 last;
	private static Character [] map = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private static Map<Character,Integer> cmap = new HashMap();
	
	static{
		int index = 0;
		for(Character c:map){
			cmap.put(c, index);
			index++;
		}
	}
	
	public RadixNum1(int input,int radix){
		this.radix = radix;
		this.last = new Digist1();
		last.c = '0';
		for(int i=0;i<input;i++){
			add1(last);
		}
	}
	
	public String getRadixStr(){
		StringBuffer sb = new StringBuffer();
		Digist1 d = last;
		sb.append(d.c);
		while(d.pre!=null){
			sb.append(d.pre.c);
			d = d.pre;
		}
		return sb.reverse().toString();
	}
	
	private void add1(Digist1 d){
		int value = cmap.get(d.c);
		int addedValue = value +1;
		if(addedValue>=radix){
			Digist1 pre = d.pre;
			if(pre == null){
				d.pre = new Digist1();
				d.pre.c = '1';
				d.c = '0';
			}else{
				d.c = '0';
				add1(d.pre);
			}
		}else{
			d.c = map[addedValue];
		}
	}

	
	
}