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
public class App {
	public static void main(String[] args) {
					  //wwwbbrwrbrbrrbrbrwrwwrbwrwrrb
		String input = "wwwbbrwrbrbrrbrbrwrwwrbwrwrrbwwwbbrwrbrbrrbrbrwrwwrbwrwrrb";
		String now = "";
		int nowCount = 0;
		List<PureNead> pureNeads = new ArrayList<PureNead>();
		for(int i=0;i<input.length()-1;i++){
			String newNow = String.valueOf(input.charAt(i));
			if(newNow.equals(now)){
				nowCount++;
			}else{
				System.out.println(now + "===" + nowCount);
				if(!"".equals(now))
					pureNeads.add(new PureNead(now, nowCount));
				now = newNow;
				nowCount = 1;
			}
		}
		
		PureNead old = pureNeads.get(0);
		String combineNead = old.color;
		int combine = old.len;
		for(PureNead p :pureNeads){
			if(!p.equals(old)){
				if(p.color.equals(combineNead)){
					combine = combine + p.len;
				}else if(p.color.equals("w")){
					combine = combine + p.len;
				}else if(combineNead.equals("w")){
					combine = combine + p.len;
					combineNead = p.color;
				}
				else{
					System.out.println(combineNead + "***" + combine);
					combineNead = p.color;
					combine = p.len;
				}
				old = p;
			}
		}
	}
	
	static class PureNead{
		public PureNead(String color, int len) {
			super();
			this.color = color;
			this.len = len;
		}
		public String color;
		public int len;
	}

}
