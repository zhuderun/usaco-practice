/**
 * 
 */
package isumi.beads;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class App2 {

	public static void main(String[] args) {
					 // wwwbbrwrbrbrrbrbrwrwwrbwrwrrb|wwwbbrwrbrbrrbrbrwrwwrbwrwrrb
		String input = "rrwwwwbb";
		
		List<Bead> beads = new ArrayList<Bead>();
		for(int i=0;i<input.length();i++){
			Bead b  = new Bead();
			b.color = String.valueOf(input.charAt(i));
			beads.add(b);
		}
		int index = 0;
		for(Bead b:beads){
			if(index == 0){
				b.next = beads.get(index+1);
				b.pre = beads.get(beads.size()-1);
			}else if(index == beads.size()-1){
				b.next = beads.get(0);
				b.pre = beads.get(index-1);
			}else{
				b.next = beads.get(index+1);
				b.pre = beads.get(index-1);
			}
			index++;
		}
		int max = 0;
		for(Bead b:beads){
			Bead leftStart = b.pre;
			Bead rightStart = b;
			
			String leftColor = leftStart.color;
			int leftSize = 1;
			int flg = 0;
			while((leftStart.pre.color.equals("w")||leftStart.pre.color.equals(leftColor)||leftColor.equals("w"))&&flg<beads.size()){
				leftStart = leftStart.pre;
				if(leftColor.equals("w")){
					leftColor = leftStart.color;
				}
				flg++;
				leftSize ++ ;
			}
			
			if(flg>=beads.size()){
				max = beads.size();
				break;
			}
			
			String rightColor = rightStart.color;
			int rightSize = 1;
			int rflg = 0;
			while((rightStart.next.color.equals("w")||rightStart.next.color.equals(rightColor)||rightColor.equals("w"))&&(rflg<beads.size()-flg-2)){
				rightStart = rightStart.next;
				if(rightColor.equals("w")){
					rightColor = rightStart.color;
				}
				rightSize ++ ;
				rflg++;
			}
			System.out.println(leftSize + "===" + rightSize);
			max = (leftSize + rightSize)>max?(leftSize + rightSize):max;
			System.out.println(flg + "flg");
		}
		System.out.println(max);
		
	}
	
	static class Bead{
		public String color;
		public Bead next;
		public Bead pre;
	}

}
