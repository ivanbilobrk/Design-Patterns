package petiZad;

import java.util.Scanner;

/**
 * Implementacija izvora brojeva koji cita brojeve sa tipkovnice
 *
 */
public class TipkovnickiIzvor extends IzvorBrojeva{

	@Override
	public int getNextNumber() {
		System.out.print("Enter next number: ");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		//sc.close();
		
		try {
			int numberTemp = Integer.parseInt(line);
			if(numberTemp != -1) {
				return Math.abs(numberTemp);
			}
			return -1; 
		} catch(Exception e) {
			return -1;
		}
	}

}
