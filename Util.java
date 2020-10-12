public class Util {

	public static String ClearStr;

	public static String repeatString(int can, String con) 
	{ 
		return new String(new char[can]).replace("\0", con);
	}

	public static void clear(){
		Main.trace(ClearStr);
	}
}