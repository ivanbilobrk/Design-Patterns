package petiZad;

import java.io.IOException;

public class Test {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		IzvorBrojeva i1 = new TipkovnickiIzvor();
		
		IzvorBrojeva i2 = new DatotecniIzvor("izvor.txt");
		SlijedBrojeva slijed = new SlijedBrojeva(i2);
		
		AkcijaBrojevi a1 = new DatotekaAkcija(slijed, "brojevi.txt");
		AkcijaBrojevi a2 = new SumaAkcija(slijed);
		AkcijaBrojevi a3 = new ProsjekAkcija(slijed);
		AkcijaBrojevi a4 = new MedijanAkcija(slijed);
		
		slijed.attach(a1);
		slijed.attach(a2);
		slijed.attach(a3);
		slijed.attach(a4);
		
		slijed.kreni();
		
	}
}
