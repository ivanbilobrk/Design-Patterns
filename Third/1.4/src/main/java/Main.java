import java.lang.reflect.InvocationTargetException;

import hr.fer.zemris.ooup.lab3.factory.AnimalFactory;
import hr.fer.zemris.ooup.lab3.model.Animal;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Animal a = AnimalFactory.newInstance("Parrot", "Mirko");
		System.out.println(a.greet());
		System.out.println(a.menu());
		System.out.println(a.name());
	}

}
