package petiZad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Konkretna implementacija jednog izvora brojeva koji cita iz datoteke
 *
 */
public class DatotecniIzvor extends IzvorBrojeva{
	
	private Path p;
	private List<String> lines;
	private int position;
	
	public DatotecniIzvor(String pathFile) throws IOException {
		super();
		p = Path.of(pathFile);
		lines = Files.readAllLines(p);
		position = 0;
		
	}

	@Override
	public int getNextNumber() {
		if(position < lines.size()) {
			try {
				int number = Integer.parseInt(lines.get(position++));
				if(number == -1) {
					return -1;
				} else {
					return Math.abs(number);
				}
			} catch(Exception e) {
				return -1;
			}
		} else {
			return -1;
		}
	}
	
}
