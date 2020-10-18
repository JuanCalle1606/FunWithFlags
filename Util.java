public class Util {

	/// Constiene la cadena que limina la pantalla
	public static String ClearStr;

	public static void randomize(byte[] arr,int limit){
		int len=arr.length;
		Boolean isValid=true;
		byte random;
		for(byte i=0;i<len;i++){
			do{
				isValid=true;
				random=(byte)(Math.random()*limit);
				for(byte j=0;j<i;j++){
					if(random==arr[j]){
						isValid=false;
						break;
					}
				}
			}
			while(!isValid);
			arr[i]=random;
		}
	}
	public static String getSpaces(int index) 
	{ 
		return repeatString(63-Main.paises[index].length()," ");
	}
	/**
	* Devuelve una cadena repetida n numero de veces
	*/
	public static String repeatString(int can, String con) 
	{ 
		return new String(new char[can]).replace("\0", con);
	}
	/**
	* Reemplaza los digitos en un arreglo por colores de consola
	*/
	public static void replaceColors(String[] mat){
		for(byte i=0;i<27;i++)
		{
			mat[i]=
			mat[i].equals("1")?
				ConsoleColors.RED_BACKGROUND+"  "+ConsoleColors.RESET
			:mat[i].equals("2")?
				ConsoleColors.BLUE_BACKGROUND+"  "+ConsoleColors.RESET
			:mat[i].equals("3")?
				ConsoleColors.WHITE_BACKGROUND+"  "+ConsoleColors.RESET
			:mat[i].equals("4")?
				ConsoleColors.YELLOW_BACKGROUND+"  "+ConsoleColors.RESET
			:mat[i].equals("5")?
				ConsoleColors.GREEN_BACKGROUND+"  "+ConsoleColors.RESET
			:mat[i].equals("6")?
				ConsoleColors.PURPLE_BACKGROUND+"  "+ConsoleColors.RESET
			:mat[i].equals("7")?
				ConsoleColors.CYAN_BACKGROUND+"  "+ConsoleColors.RESET
			:mat[i].equals("8")?
				ConsoleColors.BLACK_BACKGROUND+"  "+ConsoleColors.RESET
			:ConsoleColors.BLACK_BACKGROUND_BRIGHT+"  "+ConsoleColors.RESET;
		}
	}
	/**
	* Limpia la pantalla
	*/
	public static void clear(){
		Main.trace(ClearStr);
	}
}