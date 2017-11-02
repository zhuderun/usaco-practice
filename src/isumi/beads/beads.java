package isumi.beads;

import java.io.*;
import java.util.*;
/*
ID: osuisum1
LANG: JAVA
TASK: beads
*/
public class beads {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		int num = Integer.valueOf(f.readLine());
		String input = f.readLine();
		
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
				leftSize ++ ;
				flg++;
			}
			
			if(flg>=beads.size()){
				max = beads.size();
				break;
			}
			String rightColor = rightStart.color;
			int rightSize = 1;
			while((rightStart.next.color.equals("w")||rightStart.next.color.equals(rightColor)||rightColor.equals("w"))){
				rightStart = rightStart.next;
				if(rightColor.equals("w")){
					rightColor = rightStart.color;
				}
				rightSize ++ ;
			}
			max = (leftSize + rightSize)>max?(leftSize + rightSize):max;
		}
		
		out.println(max>beads.size()?beads.size():max);
		out.close();
		
	}
	
	static class Bead{
		public String color;
		public Bead next;
		public Bead pre;
	}

}
