
public class Le_302_Smallest_Rectangle_Enclosing_Black_Pixels {
	// by other using binary search
		public int minArea(char[][] image, int x, int y) {
		    int tmp=x;
		    x=y;
		    y=tmp;
		    int left=binarysearch(image,0,x,false,false);
		    int right=binarysearch(image,x,image[0].length-1,false,true);
		    int up=binarysearch(image,0,y,true,false);
		    int down=binarysearch(image,y,image.length-1,true,true);
		    return (right-left+1)*(down-up+1);
		}
		
		public int binarysearch(char[][] image,int lower,int upper,boolean isv,boolean isup) {
		    int x=0;
		    int y=0;
		    while(lower<=upper)
		    {
		        int mid=lower+(upper-lower)/2;
		        if(explore(image,mid,!isv)) 
		        {
		            if(isup) lower=mid+1;
		            else upper=mid-1;
		        }
		        else 
		        {
		            if(isup) upper=mid-1;
		            else lower=mid+1;
		        }
		    }
		    return isup?lower-1:upper+1;
		}
		
		public boolean explore(char[][] image,int val,boolean isv) {
		    int x=0,y=0;
		    if(isv) x=val;
		    else y=val;
		    int len=isv?image.length:image[0].length;
		    for(int i=0;i<len;i++)
		    {
		        if(isv) y=i;
		        else x=i;
		        if(image[y][x]=='1') return true;
		    }
		    return false;
		}
		
		
		
		/*****************************************************************/
		// by Jackie using DFS
		private int left = 0, right = 0, up = 0, down = 0;
	    
	    public int minArea2(char[][] image, int x, int y) {
	        if(image == null || image.length == 0 || image[0].length == 0){
	            return 0;
	        }
	        
	        int row = image.length, col = image[0].length;
	        left = right = y;
	        up = down = x;
	        boolean[][] visited = new boolean[row][col];
	        
	        traver(image, visited, x, y);
	        return (right - left + 1) * (up - down + 1);
	    }
	    
	    public void traver(char[][] image, boolean[][] visited, int x, int y){
	        if(visited[x][y] == true){
	            return;
	        }
	        
	        visited[x][y] = true;
	        left = Math.min(left, y);
	        right = Math.max(right, y);
	        up = Math.max(up, x);
	        down = Math.min(down, x);
	        int[] dx = {1, -1, 0, 0};
	        int[] dy = {0, 0, 1, -1};
	        
	        for(int i = 0; i < 4; i++){
	            int newX = x + dx[i];
	            int newY = y + dy[i];
	            
	            if(newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length && image[newX][newY] == '1'){
	                traver(image, visited, newX, newY);
	            }
	        }
	    }
}
