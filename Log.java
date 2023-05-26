import java.io.*;
//Gamelog
public class Log{
	private static int cnt=1;
	File file=new File("GameLog"+cnt+".txt");
	
	public void writeln(String s){
		PrintWriter out = null;
		try {
			FileWriter writer=new FileWriter(file, true);
			BufferedWriter buffer=new BufferedWriter(writer);
			out = new PrintWriter(buffer);
			out.println(s);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (out != null) {
			out.close();
			}
		} 
		
	}
	public void write(String s){
		PrintWriter out = null;
		try {
			FileWriter writer=new FileWriter(file, true);
			BufferedWriter buffer=new BufferedWriter(writer);
			out = new PrintWriter(buffer);
			out.print(s);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (out != null) {
			out.close();
			}
		} 
		
	}
	
	public void delete(){
		if (file.delete())
			System.out.println("log Deleted");
		else 
			System.out.println("Failed to delete log.");
    } 
	
}	