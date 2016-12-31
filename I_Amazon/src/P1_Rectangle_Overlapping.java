
	//important Special case : [(1,1),(3,3)]
	// for the handling of special test case which rectangle points are
	// actually leftBottom and rightTop
	// change these points into leftTop and rightBottom
	// TODO
	// change [(1,1),(3,3)] into [(1,3),(3,1)]


public class P1_Rectangle_Overlapping {
	public static boolean overlap(Rectangle a, Rectangle b) {
		if(a == null || b == null) {
			return false;
		}
		
		int topLeft_x1 = Math.min(a.topLeft.x, a.bottomRight.x);
		int topLeft_y1 = Math.max(a.topLeft.y, a.bottomRight.y);
		int bottomRight_x1 = Math.max(a.topLeft.x, a.bottomRight.x);
		int bottomRight_y1 = Math.min(a.topLeft.y, a.bottomRight.y);
		
		int topLeft_x2 = Math.min(b.topLeft.x, b.bottomRight.x);
		int topLeft_y2 = Math.max(b.topLeft.y, b.bottomRight.y);
		int bottomRight_x2 = Math.max(b.topLeft.x, b.bottomRight.x);
		int bottomRight_y2 = Math.min(b.topLeft.y, b.bottomRight.y);
		
		// 有等于号
		if(topLeft_x1 >= bottomRight_x2 || topLeft_x2 >= bottomRight_x1 || bottomRight_y1 >= topLeft_y2 || bottomRight_y2 >= topLeft_y1) {
			return false;
		} else {
			return true;
		}
	}

	
	
	
	
	
	
	/********************** main function **************************/

	public static void main(String[] args) {
//		P1_Rectangle_Overlapping overlapping = new P1_Rectangle_Overlapping();
//		System.out.println(overlapping.overlap(new Rectangle(new rectangleVertex(1, 1), new rectangleVertex(3, 3)),
//				new Rectangle(new rectangleVertex(1, 3), new rectangleVertex(3, 1))));
//		
//		System.out.println(overlapping.overlap2(new Rectangle(new rectangleVertex(1, 1), new rectangleVertex(3, 3)),
//				new Rectangle(new rectangleVertex(1, 3), new rectangleVertex(3, 1))));
//		
//		System.out.println("**********************");
//		
//		System.out.println(overlapping.overlap(new Rectangle(new rectangleVertex(1, 1), new rectangleVertex(3, 3)),
//				new Rectangle(new rectangleVertex(1, 3), new rectangleVertex(3, 1))));
//		
//		System.out.println(overlapping.overlap2(new Rectangle(new rectangleVertex(1, 1), new rectangleVertex(3, 3)),
//				new Rectangle(new rectangleVertex(1, 3), new rectangleVertex(3, 1))));
		
		
		
		
		
		
		P1_Rectangle_Overlapping testcase = new P1_Rectangle_Overlapping();
		System.out.println("1:");
		System.out.println(testcase.overlap(new Rectangle(new rectangleVertex(1, 1), new rectangleVertex(3, 3)), new Rectangle(new rectangleVertex(3, 4), new rectangleVertex(5, 3))));
		System.out.println(false);
		
		System.out.println("2:");
		System.out.println(testcase.overlap(new Rectangle(new rectangleVertex(1, 1), new rectangleVertex(4, 4)), new Rectangle(new rectangleVertex(2, 2), new rectangleVertex(3, 3))));
		System.out.println(true);
		
		System.out.println("3:");
		System.out.println(testcase.overlap(new Rectangle(new rectangleVertex(-5, 40), new rectangleVertex(-4, 30)), new Rectangle(new rectangleVertex(-5, 35), new rectangleVertex(-2, 2))));
		System.out.println(true);
		
		System.out.println("4:");
		System.out.println(testcase.overlap(new Rectangle(new rectangleVertex(-5, 40), new rectangleVertex(-4, 30)), new Rectangle(new rectangleVertex(-10, 35), new rectangleVertex(-2, 2))));
		System.out.println(true);
		
		System.out.println("5:");
		System.out.println(testcase.overlap(new Rectangle(new rectangleVertex(-5, 40), new rectangleVertex(-4, 30)), new Rectangle(new rectangleVertex(-10, 50), new rectangleVertex(-2, 2))));
		System.out.println(true);
		
		System.out.println("6:");
		System.out.println(testcase.overlap(new Rectangle(new rectangleVertex(5, 40), new rectangleVertex(4, 30)), new Rectangle(new rectangleVertex(10, 50), new rectangleVertex(2, 2))));
		System.out.println(true);
		
		System.out.println("7:");
		System.out.println(testcase.overlap(new Rectangle(new rectangleVertex(5, -40), new rectangleVertex(4, -30)), new Rectangle(new rectangleVertex(10, -50), new rectangleVertex(2, -2))));
		System.out.println(true);
	}
}


class rectangleVertex {
	int x;
	int y;

	public rectangleVertex(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Rectangle {
	rectangleVertex topLeft;
	rectangleVertex bottomRight;

	public Rectangle(rectangleVertex topLeft, rectangleVertex bottomRight) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}
}
