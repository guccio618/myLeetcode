
public class Q223_Rectangle_Area {
	/***************************************************************/
	// by Jackie
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left1 = Math.min(A, C);
        int right1 = Math.max(A, C);
        int top1 = Math.max(B, D);
        int bottom1 = Math.min(B, D);
        int area1 = (right1 - left1) * (top1 - bottom1);
        
        int left2 = Math.min(E, G);
        int right2 = Math.max(E, G);
        int top2 = Math.max(F, H);
        int bottom2 = Math.min(F, H);
        int area2 = (right2 - left2) * (top2 - bottom2);
        
        int left3 = Math.max(left1, left2);
        int right3 = Math.min(right1, right2);
        int top3 = Math.min(top1, top2);
        int bottom3 = Math.max(bottom1, bottom2);
        int area3 = (right3 - left3) * (top3 - bottom3);
        
        if(right3 < left3 || top3 < bottom3){
            area3 = 0;
        }
        
        return area1 + area2 - area3;
    }
	
	
	
	/***************************************************************/
	// by Jackie
	public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
        int leftSide_A = Math.min(A, C);
        int rightSide_A = Math.max(A, C);
        int topSide_A = Math.max(B, D);
        int downSide_A = Math.min(B, D);
        int leftSide_B = Math.min(E, G);
        int rightSide_B = Math.max(E, G);
        int topSide_B = Math.max(F, H);
        int downSide_B = Math.min(F, H);
        int area = 0;
        
        if(leftSide_A >= rightSide_B || leftSide_B >= rightSide_A || topSide_A <= downSide_B || topSide_B <= downSide_A){
            area = 0;
        } else {
            int left = Math.max(leftSide_A, leftSide_B);
            int right = Math.min(rightSide_A, rightSide_B);
            int up = Math.min(topSide_A, topSide_B);
            int down = Math.max(downSide_A, downSide_B);
            int length = right - left;
            int height = up - down;
            area = length * height;
        }

        int length_A = Math.abs(A - C);
        int heigth_A = Math.abs(B - D);
        int area_A = length_A * heigth_A;
        
        int length_B = Math.abs(E - G);
        int heigth_B = Math.abs(F - H);
        int area_B = length_B * heigth_B;
        
        return area_A + area_B - area;
        
    }
}
