public class Util {

	public static String ClearStr;
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
			mat[i]=
			mat[i]=="1"?
				ConsoleColors.RED_BACKGROUND
			:mat[i]=="2"?
				ConsoleColors.BLUE_BACKGROUND
			:mat[i]=="3"?
				ConsoleColors.WHITE_BACKGROUND
			:mat[i]=="4"?
				ConsoleColors.YELLOW_BACKGROUND
			:mat[i]=="5"?
				ConsoleColors.GREEN_BACKGROUND
			:mat[i]=="6"?
				ConsoleColors.PURPLE_BACKGROUND
			:mat[i]=="7"?
				ConsoleColors.CYAN_BACKGROUND
			:ConsoleColors.BLACK_BACKGROUND;
	}
	/**
	* Limpia la pantalla
	*/
	public static void clear(){
		Main.trace(ClearStr);
	}
}