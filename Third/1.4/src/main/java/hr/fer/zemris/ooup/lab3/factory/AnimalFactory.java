package hr.fer.zemris.ooup.lab3.factory;

import hr.fer.zemris.ooup.lab3.model.Animal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AnimalFactory {
	
	public static Animal newInstance(String animalKind, String name) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<Animal> clazz = null;
		clazz = (Class<Animal>)Class.forName("hr.fer.zemris.ooup.lab3.model.plugins."+animalKind);
		
		Constructor<?> ctr = clazz.getConstructor(String.class);
		
		Animal animal = (Animal)ctr.newInstance(name);
		
		return animal;
		
	}
	
}
