
/********************************************
 * 自定义异常
 * 
 *********************************************/

public class Q11_myException {
	private int account = 0;
	private int value = 0;
	
	public Q11_myException(){};
	
	public void setAccount(int account) throws DataFormationException {
		if(account < 0 || account > 100){
			throw new DataFormationException("account ID inputs error");
		} else {
			this.account = account;
		}
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public static void main(String[] args){
		Q11_myException t = new Q11_myException();
		try {
			t.setAccount(50);
			System.out.println(t);
			t.setAccount(200);
		} catch (DataFormationException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}
}

class DataFormationException extends Exception {
	public DataFormationException(String message){
		super(message);
	}
}
