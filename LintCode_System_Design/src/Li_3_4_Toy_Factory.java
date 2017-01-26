interface Toy {
	void talk();
}

class Dog implements Toy {
	@Override
	public void talk() {
		System.out.println("Wow");
	}
}

class Cat implements Toy {
	@Override
	public void talk() {
		System.out.println("Meow");
	}
}

public class Li_3_4_Toy_Factory {
	public Toy getToy(String type) {
		if (type == null) {
			return null;
		}
		
		if (type.equalsIgnoreCase("Dog")) {
			return new Dog();
		} else if (type.equalsIgnoreCase("Cat")) {
			return new Cat();
		}
		return null;
	}
}
