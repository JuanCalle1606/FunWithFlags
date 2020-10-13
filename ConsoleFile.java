import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class ConsoleFile{

	public static String[] arrayListToStrings(ArrayList<String> al)
	{
		String []out = new String[al.size()];
		short count = 0;
		for (String token : al) {
			out[count++] = token;
			//System.out.print(token);
		}//System.out.println(); 
		return out;
	}

	public static String[] processLine(String line)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(line,";");

		while (st.hasMoreTokens()){
            tokens.add(st.nextToken()); 
		} 

		return arrayListToStrings(tokens);
	}

		//crea el archivo en disco, retorna la lista de estudiantes
	public static String[] read(String file_name) {
		// crea el flujo para leer desde el archivo
		File file = new File(file_name);
		ArrayList<String> out = new ArrayList<String>(); 
		Scanner scanner;

		try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				out.add(scanner.nextLine());				
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Error no se encuentra el archivo "+file_name);
		}
		return arrayListToStrings(out);
	}

	public static String[] stringToArray(String str){
		StringTokenizer st = new StringTokenizer(str,";");
		String[] out = new String[st.countTokens()];
		byte count = 0;
		while(st.hasMoreTokens()){
			out[count++] = st.nextToken();
			//System.out.print(token);
		}//System.out.println(); 
		return out;
	}

	public static String getPath(String ruta)
	{
		return new File(ruta).getPath();
	}

}