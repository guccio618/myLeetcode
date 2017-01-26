/********************************************
 * 可以被重写的函数
 * 
 ********************************************/

public class Q12_overrideFunction {
	private int value;
	private int account;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	
	
	@Override
	public String toString() {
		return "Interview0_overrideFunction [value=" + value + ", account=" + account + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account;
		result = prime * result + value;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Q12_overrideFunction other = (Q12_overrideFunction) obj;
		
		if (account != other.account)
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
	
	
	
}
