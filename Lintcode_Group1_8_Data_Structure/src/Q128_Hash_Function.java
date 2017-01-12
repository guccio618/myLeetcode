
public class Q128_Hash_Function {
	// by other
	public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long sum = (int)key[0];//sum * 33可能会超出int范围
        for(int i = 1; i < key.length; i++) {
            sum = sum * 33 % HASH_SIZE + (int)key[i];//即使求余，否则超出long范围
        }
        return (int)(sum % HASH_SIZE);
    }
	
	public static void main(String[] args){
		Q128_Hash_Function t = new Q128_Hash_Function();
		char[] key = {'a','b','c','d'};
		System.out.println(t.hashCode(key, 100));
	}
}
