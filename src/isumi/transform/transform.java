package isumi.transform;

import java.io.*;
import java.util.*;

/*
ID: osuisum1
LANG: JAVA
TASK: milk2
*/

public class transform {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		int weidu = Integer.parseInt(f.readLine());
		List<Block> blocks = new ArrayList<Block>();
		for (int i = 0; i < weidu; i++) {
			String inputLine = f.readLine();
			for (int j = 0; j < inputLine.length(); j++) {
				int x = j;
				int y = weidu - i - 1;
				char c = inputLine.charAt(j);
				Block b = new Block(x, y, c);
				blocks.add(b);
			}
		}
		List<Block> rule1 = new ArrayList<Block>();
		List<Block> rule2 = new ArrayList<Block>();
		List<Block> rule3 = new ArrayList<Block>();
		List<Block> rule4 = new ArrayList<Block>();
		List<Block> rule51 = new ArrayList<Block>();
		List<Block> rule52 = new ArrayList<Block>();
		List<Block> rule53 = new ArrayList<Block>();
		List<Block> rule6 = new ArrayList<Block>();
		for (Block b : blocks) {
			Block new1 = new Block(b.x * Math.cos(Math.PI * 90 / 180) + b.y * Math.sin(Math.PI * 90 / 180), b.y * Math.cos(Math.PI * 90 / 180) - b.x * Math.sin(Math.PI * 90 / 180), b.someThing);
			rule1.add(new1);
			Block new2 = new Block(b.x * Math.cos(Math.PI * 180 / 180) + b.y * Math.sin(Math.PI * 180 / 180), b.y * Math.cos(Math.PI * 180 / 180) - b.x * Math.sin(Math.PI * 180 / 180), b.someThing);
			rule2.add(new2);
			Block new3 = new Block(b.x * Math.cos(Math.PI * 270 / 180) + b.y * Math.sin(Math.PI * 270 / 180), b.y * Math.cos(Math.PI * 270 / 180) - b.x * Math.sin(Math.PI * 270 / 180), b.someThing);
			rule3.add(new3);
			Block new4 = new Block(0 - b.x, b.y, b.someThing);
			rule4.add(new4);
		}

		for (Block b : rule4) {
			Block new51 = new Block(b.x * Math.cos(Math.PI * 90 / 180) + b.y * Math.sin(Math.PI * 90 / 180), b.y * Math.cos(Math.PI * 90 / 180) - b.x * Math.sin(Math.PI * 90 / 180), b.someThing);
			rule51.add(new51);
			Block new52 = new Block(b.x * Math.cos(Math.PI * 180 / 180) + b.y * Math.sin(Math.PI * 180 / 180), b.y * Math.cos(Math.PI * 180 / 180) - b.x * Math.sin(Math.PI * 180 / 180), b.someThing);
			rule52.add(new52);
			Block new53 = new Block(b.x * Math.cos(Math.PI * 270 / 180) + b.y * Math.sin(Math.PI * 270 / 180), b.y * Math.cos(Math.PI * 270 / 180) - b.x * Math.sin(Math.PI * 270 / 180), b.someThing);
			rule53.add(new53);
		}
		rule6 = blocks;
		Comparator<Block> compo = (Block c1, Block c2) -> {
			return (int) (Math.round(c1.y) == Math.round(c2.y) ? (Math.round(c1.x) - Math.round(c2.x)) : (Math.round(c2.y) - Math.round(c1.y)));
		};
		rule1.sort(compo);
		rule2.sort(compo);
		rule3.sort(compo);
		rule4.sort(compo);
		rule51.sort(compo);
		rule52.sort(compo);
		rule53.sort(compo);

		// resove output
		List<Block> outPut = new ArrayList<Block>();
		for (int i = 0; i < weidu; i++) {
			String inputLine = f.readLine();
			for (int j = 0; j < inputLine.length(); j++) {
				int x = j;
				int y = weidu - i - 1;
				char c = inputLine.charAt(j);
				Block b = new Block(x, y, c);
				outPut.add(b);
			}
		}

		String outputString = getAsString(outPut);
		String result;
		if(outputString.equals(getAsString(rule1))){
			result = "1";
		}else if(outputString.equals(getAsString(rule2))){
			result = "2";
		}
		else if(outputString.equals(getAsString(rule3))){
			result = "3";
		}
		else if(outputString.equals(getAsString(rule4))){
			result = "4";
		}else if(outputString.equals(getAsString(rule51))||outputString.equals(getAsString(rule52))||outputString.equals(getAsString(rule53))){
			result = "5";
		}else if(outputString.equals(getAsString(blocks))){
			result = "6";
		}else{
			result = "7";
		}
		
		out.println(result);
		out.close();
		
	}

	private static String getAsString(List<Block> input) {
		StringBuffer sb = new StringBuffer();
		for (Block b : input) {
			sb.append(b.someThing);
		}
		return sb.toString();
	}
}

class Block {
	public double x;
	public double y;
	public char someThing;

	public Block(double x, double y, char someThing) {
		super();
		this.x = x;
		this.y = y;
		this.someThing = someThing;
	}

}

