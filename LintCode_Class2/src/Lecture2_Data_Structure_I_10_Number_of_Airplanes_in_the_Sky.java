import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lecture2_Data_Structure_I_10_Number_of_Airplanes_in_the_Sky {
	/***********************************************************/
	// by ninechapter
	public int countOfAirplanes(List<Interval> airplanes) {
		if (airplanes == null || airplanes.size() == 0) {
			return 0;
		}
		// this round of sort is to make sure landing takes place before flying,
		// if
		// they happen at the same time
		Collections.sort(airplanes, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});
		Point[] points = new Point[airplanes.size() * 2];
		for (int i = 0; i < airplanes.size(); i++) {
			points[i * 2] = new Point(airplanes.get(i).start, true);
			points[i * 2 + 1] = new Point(airplanes.get(i).end, false);
		}
		Arrays.sort(points, new Comparator<Point>() {
			public int compare(Point i1, Point i2) {
				return Integer.compare(i1.time, i2.time);
			}
		});
		int res = 0;
		int cur = 0;
		for (Point p : points) {
			if (!p.isStart) {
				cur--;
			} else {
				cur++;
				res = Math.max(res, cur);
			}
		}
		return res;
	}

	class Point {
		int time;
		boolean isStart;

		public Point(int time, boolean isStart) {
			this.time = time;
			this.isStart = isStart;
		}
	}
	
	
	
	/***********************************************************/
	// by Jackie
	public int countOfAirplanes2(List<Interval> airplanes) { 
        if(airplanes.size() == 0){
            return 0;
        }
        int len = airplanes.size();
        int maxRange = 0;
        Interval[] arrays = new Interval[len];
        
        for(int i = 0; i < len; ++i){
            arrays[i] = airplanes.get(i);
            maxRange = Math.max(maxRange, arrays[i].start);
            maxRange = Math.max(maxRange, arrays[i].end);
        }
        
        int[] hours = new int[maxRange + 1];
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < len; ++i){
            for(int j = arrays[i].start; j < arrays[i].end; ++j){
                hours[j]++;
                max = Math.max(max, hours[j]);
            }
        }
        
        for(int i = 0; i < len; ++i){
            if(hours[arrays[i].end] == 0){
                hours[arrays[i].end]++;
                max = Math.max(max, hours[arrays[i].end]);
            }
        }
        
        return max;
    }
}
