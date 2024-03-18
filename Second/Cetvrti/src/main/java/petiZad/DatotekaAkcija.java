package petiZad;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Konkretna implementacija akcije koja trenutni slijed brojeva u kolekciji zapisuje u proizvoljnu datoteku zajedno s vremenom zapisa na kraju.
 *
 */
public class DatotekaAkcija extends AkcijaBrojevi{
	
	private String filePath;
	
	public DatotekaAkcija(SlijedBrojeva slijed, String filePath) {
		super(slijed);
		this.filePath = filePath;
	}

	@Override
	public void update() {
		
	    try {
	    	OutputStream os = Files.newOutputStream(Path.of(filePath), LinkOption.NOFOLLOW_LINKS);
	    	
	    	for (var numberLine : super.slijed.getNumbers()) {
	    		os.write((numberLine+"\n").getBytes(StandardCharsets.UTF_8)); 
	    	}
	    	
	    	LocalDateTime currentDateTime = LocalDateTime.now();
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDateTime = currentDateTime.format(formatter);
	        os.write((formattedDateTime+"\n").getBytes(StandardCharsets.UTF_8));  	
	    	os.close();
	    } catch (IOException e) {
	        System.out.println("Greška prilikom pisanja u datoteku.");
	    }
		
		
	}

}
