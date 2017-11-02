/**
 * 
 */
package isumi.milk2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class App {
	/*
	 * 3
		300 1000
		700 1200
		1500 2100
	 */
	
	/*
	 * 300 1200
	 */
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		System.out.println(l);
		l.add(0,100);
		System.out.println(l);
		l.remove(1);
		System.out.println(l);
	}
	
	static class Work{
		
		int start;
		int end;
	}
}
