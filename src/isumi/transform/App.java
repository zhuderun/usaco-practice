/**
 * 
 */
package isumi.transform;

/**
 * @author Administrator
 *  #1: 90 Degree Rotation: The pattern was rotated clockwise 90 degrees.
	#2: 180 Degree Rotation: The pattern was rotated clockwise 180 degrees.
	#3: 270 Degree Rotation: The pattern was rotated clockwise 270 degrees.
	#4: Reflection: The pattern was reflected horizontally (turned into a mirror image of itself by reflecting around a vertical line in the middle of the image).
	#5: Combination: The pattern was reflected horizontally and then subjected to one of the rotations (#1-#3).
	#6: No Change: The original pattern was not changed.
	#7: Invalid Transformation: The new pattern was not obtained by any of the above methods.
 */
public class App {
	
	public static void main(String[] args) {
		//0 1-> 1 0
		//x0 = r*cos(a)  y0 = r*sin(a)
		//x1 = r*cos(b)	 y1 = r*sin(b)
		//a-b =x -> b = a-x
		//==>x1 = r*cos(a-x)  y1 = r*sin(a-x)
		
		int [][] a  = new int[10][10];
		
		
	}

}

class square{
	
}
