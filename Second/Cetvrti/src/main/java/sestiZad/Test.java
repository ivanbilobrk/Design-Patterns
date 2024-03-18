package sestiZad;

public class Test {

	public static void main(String[] args) {
		Sheet s = new Sheet(new Cell[5][5]);
		System.out.println(s);
		
		s.set("A1","2");
		s.set("A3","A1+5");
		s.set("A2","5");
		s.set("A3","A1+A2");
		System.out.println(s);
		System.out.println();
		
		s.set("A1","4");
		s.set("A4","A1+A3");
		System.out.println(s);
		s.set("A4", "A2");
		s.set("A2", "500");
		//s.set("A1", "A3");
		
		System.out.println(s);
	}

}
