import java.util.HashMap;
import java.util.Map;

public class Q166_Fraction_to_Recurring_Decimal {
	public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        } else if(denominator == 0){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
            sb.append("-");
        }
        
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);
        
        sb.append(num / denom);
        num %= denom;
        
        if(num == 0) {
            return sb.toString();
        }
        
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();   // 记录余数以及此余数后头第一个avail的位置
        map.put(num, sb.length());   
        
        while(num > 0) {
            num *= 10;           // 将小数点后的第一位乘10
            sb.append(num / denom);
            num %= denom;
            
            if(map.containsKey(num)) {
                int pos = map.get(num);
                sb.insert(pos, "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }
        }
        
        return sb.toString();
    }
	
	
	// by other
	public String fractionToDecimal2(int numerator, int denominator) {
		boolean isNegative = ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) ? true : false;
		long numeratorL = Math.abs((long) numerator);
		long denominatorL = Math.abs((long) denominator);
		Map<Long, Integer> previousRemains = new HashMap<Long, Integer>();
		StringBuilder sb = new StringBuilder();
		long quotian = numeratorL / denominatorL;
		sb.append(quotian);

		numeratorL %= denominatorL;

		if (numeratorL != 0) {
			sb.append(".");
		}

		int quotianIndex = 0;
		while (numeratorL != 0) {
			numeratorL *= 10;        // 将小数点后的第一位乘10
			quotian = Math.abs(numeratorL / denominatorL);
			if (!previousRemains.containsKey(numeratorL)) {
				sb.append(quotian);
				previousRemains.put(numeratorL, quotianIndex++);  // 记录下某一数字第一次出现的位置
			} 
			else {
				int firstIndex = 1 + previousRemains.get(numeratorL) + sb.indexOf(".");
				sb.insert(firstIndex, '(');    // 如果重复，则在此数字第一次出现的地方前后加上“（）”
				sb.append(")");
				break;
			}
			numeratorL %= denominatorL;
		}

		if (isNegative) {
			sb.insert(0, "-");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Q166_Fraction_to_Recurring_Decimal t = new Q166_Fraction_to_Recurring_Decimal();
		System.out.println(t.fractionToDecimal(2, 3));
	}
}
