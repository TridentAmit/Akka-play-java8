package optional;

import java.util.Optional;

import model.Car;
import model.Insurance;
import model.Person;

public class Main {
	public static void main(String[] args) {
		Insurance i = new Insurance();
		i.setName("SBI");
		Insurance i1 = new Insurance();
		i1.setName("HDFC");
		Car c = new Car();
		Car c1 = null;
		c.setInsurance(Optional.ofNullable(i));
		//System.out.println(c.getInsurance().orElse(i1));
		Person p = new Person();
		p.setCar(Optional.ofNullable(c1));
		String s = getCarInsuranceNmae(Optional.ofNullable(p));
		System.out.println(s);
		
	}
	private static String getCarInsuranceNmae(Optional<Person> person) {
		return person.flatMap(Person::getCar)
					 .flatMap(Car::getInsurance)
					 .map(Insurance::getName)
					 .orElse("Unknown");
		
	}

}
