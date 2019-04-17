import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Piece {
	
		String name; 
		Set <String> types; 
	
	
	public Piece(String name) {
		this.name = name; 
		String[] arr = name.split("\\W+");
		types = new HashSet<String>(Arrays.asList(arr)); 
	}
	
	public String toString() {
		return name; 
	}

}