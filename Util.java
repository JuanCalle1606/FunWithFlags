public class Util {

	public static String repeatString(int can, String con) 
	{ 
		return new String(new char[can]).replace("\0", con);
	}
}