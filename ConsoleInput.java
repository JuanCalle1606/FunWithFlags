import java.util.Scanner;

public class ConsoleInput{

	public static Scanner sc = new Scanner(System.in);

	public static int getInt()
	{
		int temp = 0;
		try{
			// Initialize the Scanner object to use the standard input
        	temp = sc.nextInt();
        	sc.nextLine();
	        // Close the Scanner
		}catch(Exception e)
		{
			refreshScanner();
		}
		return temp;
	}

	public static float getFloat()
	{
		float temp = 0;

		try{
			// Initialize the Scanner object to use the standard input
	        temp = sc.nextFloat();
        }catch(Exception e)
		{
			refreshScanner();
			System.out.println("Error de lectura de numero flotante");
			System.out.println(e);
		}

		return temp;
	}

	public static String getString(){
		String temp = null;

		try{
			// Initialize the Scanner object to use the standard input
	        // Read strings until the End Of File (EOF)
	        //System.out.println("Finaliza con Ctrl-D");
	        //while(sc.hasNext()) {
	            //String s = sc.next();
	        //}
	        temp = sc.nextLine();
	        // Close the Scanner
		}catch(Exception e)
		{
			refreshScanner();
			System.out.println("Error de lectura de cadena");
			System.out.println(e);
		}
		return temp;
	}

	public static void refreshScanner()
	{
		//sc.close();
		sc = new Scanner(System.in);
	}
}