import java.io.File;
import utils.Parser;

public class Launcher {

	public static void main(String[] args) {
		
		//File file = new File(args[0]);
		File file = new File("samples/test1.txt");
		
		if(!file.exists()) {
			System.out.println(file.getAbsolutePath()+" not found.");
			return;
		}
		
		try {
			Parser.parseRolls(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
