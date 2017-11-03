package isumi.transform;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Administrator #1: 90 Degree Rotation: The pattern was rotated
 *         clockwise 90 degrees. #2: 180 Degree Rotation: The pattern was
 *         rotated clockwise 180 degrees. #3: 270 Degree Rotation: The pattern
 *         was rotated clockwise 270 degrees. #4: Reflection: The pattern was
 *         reflected horizontally (turned into a mirror image of itself by
 *         reflecting around a vertical line in the middle of the image). #5:
 *         Combination: The pattern was reflected horizontally and then
 *         subjected to one of the rotations (#1-#3). #6: No Change: The
 *         original pattern was not changed. #7: Invalid Transformation: The new
 *         pattern was not obtained by any of the above methods.
 */
/*
 * x = cos(a) * r y = sin(a) * r a-g = b x1 = cos(b) * r y1 = sin(b) * r x1 =
 * cos(a-g)*r y1 = sin(a-g) * r x1 = (cosa*cosg + sina*sing)*r x/r*cosg +
 * y/r*sing y1 = (sina*cosg - cosa*sing)*r y/r*cosg - x/r*sing
 */
public class App {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader f = new BufferedReader(new FileReader("D:/git/usaco-practice/src/isumi/transform/transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D:/git/usaco-practice/src/isumi/transform/transform.out")));
		int weidu = Integer.parseInt(f.readLine());
		// resove input
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
			double r = Math.sqrt(b.x * b.x + b.y * b.y);
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
			double r = Math.sqrt(b.x * b.x + b.y * b.y);
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
		if(outputString.equals(getAsString(blocks))){
			result = "6";
		}else if(outputString.equals(getAsString(rule1))){
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
		}else{
			result = "7";
		}
		
	}

	private static String getAsString(List<Block> input) {
		StringBuffer sb = new StringBuffer();
		for (Block b : input) {
			sb.append(b.someThing);
		}
		return sb.toString();
	}

}

//class Block {
//	public double x;
//	public double y;
//	public char someThing;
//
//	public Block(double x, double y, char someThing) {
//		super();
//		this.x = x;
//		this.y = y;
//		this.someThing = someThing;
//	}
//
//}
