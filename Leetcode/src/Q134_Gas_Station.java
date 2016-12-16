
public class Q134_Gas_Station {
	/*********************************************************************
	 * Main Idea
	 * The main idea of the algorithm is to have 2 pointers representing 
	 * where the trip starts and where the trip ends. We move the 
	 * "front pointer" if we have "capacity" to do so (i.e. if we have 
	 * extra gas), and we move the "back pointer" if we lack gas to complete
	 * our trip, therefore trying to find a start position that will give
	 * us the extra gas we need.
	 * When the 2 pointers meet, we just check whether we ended up with 
	 * enough gas or not to complete the trip. 
	 *********************************************************************/
	// by other using greedy
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0 || cost == null ||cost.length == 0 || gas.length != cost.length) {
            return -1;        
        }

        int n = gas.length;
        int startIndex = 0;   // 两个指针往两头延伸，直到相遇，判断此时gas是否足够
        int endIndex = 1;
        int totalProfit = gas[startIndex] - cost[startIndex];
        
        while(n > 1 && startIndex != endIndex){
            if(totalProfit >= 0){
                totalProfit += gas[endIndex] - cost[endIndex];
                endIndex = (endIndex + 1) % n;
            }
            else{
                startIndex = (startIndex == 0) ? n - 1 : startIndex - 1;
                totalProfit += gas[startIndex] - cost[startIndex];
            }
        }
        return totalProfit >= 0 ? startIndex : -1;
    }
	
	
	/*************************************************/
	// by other using greedy
	public int canCompleteCircuit2(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0 || cost == null ||cost.length == 0) {
            return -1;        
        }

        int n = gas.length;
        int startIndex = 0;
        int endIndex = 0;
        int totalProfit = gas[startIndex] - cost[startIndex];

        do {
            if(totalProfit >= 0) {
                endIndex = (endIndex+1)%n;
                totalProfit += gas[endIndex] - cost[endIndex];
            } 
            else {
                startIndex = startIndex-1 >= 0 ? startIndex-1 : n-1;
                totalProfit += gas[startIndex] - cost[startIndex];
            }
        } while(startIndex != endIndex);

        return totalProfit >= 0 ? startIndex : -1;
    }
}
