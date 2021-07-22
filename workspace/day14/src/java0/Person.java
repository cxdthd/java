package java0;

public class Person {
	String name;
	int age;
	
	
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


//
//	@Override
//	public boolean equals(Object obj) {
//		if(obj == this){
//			return true;
//		}
//		
//		if (obj instanceof Person){
//			Person person = (Person)obj;
//			return this.name.equals(person.name) && this.age == person.age;
//		}
//		return false;
//	}
	
	
	
	
	
	
}
