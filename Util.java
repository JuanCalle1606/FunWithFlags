public class Util {

	/// Constiene la cadena que limina la pantalla
	public static String ClearStr;

	public static void showOptions(byte[] flags,byte[] index){
		byte len=(byte)index.length;
		String cFlag="";
		Main.trace("");
		if(len==4){
			cFlag=Main.paises[flags[getPos(index,(byte)0)]];
			Main.trace(ConsoleColors.GREEN+"1. "+ConsoleColors.RESET+addSpaces(cFlag,25),false);
			cFlag=Main.paises[flags[getPos(index,(byte)1)]];
			Main.trace(ConsoleColors.GREEN+"2. "+ConsoleColors.RESET+cFlag);
			cFlag=Main.paises[flags[getPos(index,(byte)2)]];
			Main.trace(ConsoleColors.GREEN+"3. "+ConsoleColors.RESET+addSpaces(cFlag,25),false);
			cFlag=Main.paises[flags[getPos(index,(byte)3)]];
			Main.trace(ConsoleColors.GREEN+"4. "+ConsoleColors.RESET+cFlag);
		}
		else{
			cFlag=Main.paises[flags[getPos(index,(byte)0)]];
			Main.trace(ConsoleColors.GREEN+"1. "+ConsoleColors.RESET+addSpaces(cFlag,25),false);
			cFlag=Main.paises[flags[getPos(index,(byte)1)]];
			Main.trace(ConsoleColors.GREEN+"2. "+ConsoleColors.RESET+addSpaces(cFlag,25),false);
			cFlag=Main.paises[flags[getPos(index,(byte)2)]];
			Main.trace(ConsoleColors.GREEN+"3. "+ConsoleColors.RESET+addSpaces(cFlag,25),false);
			cFlag=Main.paises[flags[getPos(index,(byte)3)]];
			Main.trace(ConsoleColors.GREEN+"4. "+ConsoleColors.RESET+cFlag);
			cFlag=Main.paises[flags[getPos(index,(byte)4)]];
			Main.trace(ConsoleColors.GREEN+"5. "+ConsoleColors.RESET+addSpaces(cFlag,25),false);
			cFlag=Main.paises[flags[getPos(index,(byte)5)]];
			Main.trace(ConsoleColors.GREEN+"6. "+ConsoleColors.RESET+addSpaces(cFlag,25),false);
			cFlag=Main.paises[flags[getPos(index,(byte)6)]];
			Main.trace(ConsoleColors.GREEN+"7. "+ConsoleColors.RESET+addSpaces(cFlag,25),false);
			cFlag=Main.paises[flags[getPos(index,(byte)7)]];
			Main.trace(ConsoleColors.GREEN+"8. "+ConsoleColors.RESET+cFlag);
		}
		Main.trace("");
	}
	public static byte getPos(byte[] index,byte flag){
		byte len=(byte)index.length;
		for(byte i=0;i<len;i++)
			if(index[i]==flag)
				return i;
		return 0;
	}
	private static String addSpaces(String txt,int len){
		String temp=txt;
		while(temp.length()<len)
			temp+=" ";
		return temp;
	}
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
	public static String getSpaces(int index){ 
		return repeatString(63-Main.paises[index].length()," ");
	}
	/**
	* Devuelve una cadena repetida n numero de veces
	*/
	public static String repeatString(int can, String con){ 
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