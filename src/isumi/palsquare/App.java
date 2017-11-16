package isumi.palsquare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class App {
	
	public static void main(String[] args) {
		RadixNum rn = new RadixNum(3, 2);
		int radix = 15;
		for(int i = 1;i<=300;i++){
			int pow = (int) Math.pow(i, 2);
			RadixNum1 powStr = new RadixNum1(pow, radix);
			if(isPalNum(powStr.getRadixStr())){
				System.out.println(new RadixNum1(i, radix).getRadixStr() +" "+ powStr.getRadixStr());
			}
		}
		/*RadixNum rn = new RadixNum(20, 10);
		System.out.println(rn.getRadixStr());*/
		
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

class Digist{
	public Digist pre;
	public Character c;
}

class RadixNum{
	private int radix;
	private Digist last;
	private static Character [] map = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private static Map<Character,Integer> cmap = new HashMap();
	
	static{
		int index = 0;
		for(Character c:map){
			cmap.put(c, index);
			index++;
		}
	}
	
	public RadixNum(int input,int radix){
		this.radix = radix;
		this.last = new Digist();
		last.c = '0';
		for(int i=0;i<input;i++){
			add1(last);
		}
	}
	
	public String getRadixStr(){
		StringBuffer sb = new StringBuffer();
		Digist d = last;
		sb.append(d.c);
		while(d.pre!=null){
			sb.append(d.pre.c);
			d = d.pre;
		}
		return sb.reverse().toString();
	}
	
	private void add1(Digist d){
		int value = cmap.get(d.c);
		int addedValue = value +1;
		if(addedValue>=radix){
			Digist pre = d.pre;
			if(pre == null){
				d.pre = new Digist();
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
