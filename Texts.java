/**
 * Esta clase se usa para obtener los textos usados en el juego
 */
public class Texts {

	private static String[] Titles = new String[]{
ConsoleColors.YELLOW+"___________            "+ConsoleColors.BLUE+"  __      __.__  __  .__     "+ConsoleColors.RED+" ___________.__                        \n"+
ConsoleColors.YELLOW+"\\_   _____/_ __  ____  "+ConsoleColors.BLUE+" /  \\    /  \\__|/  |_|  |__  "+ConsoleColors.RED+" \\_   _____/|  | _____     ____  ______\n"+
ConsoleColors.YELLOW+" |    __)|  |  \\/    \\ "+ConsoleColors.BLUE+" \\   \\/\\/   /  \\   __\\  |  \\ "+ConsoleColors.RED+"  |    __)  |  | \\__  \\   / ___\\/  ___/\n"+
ConsoleColors.YELLOW+" |     \\ |  |  /   |  \\"+ConsoleColors.BLUE+"  \\        /|  ||  | |   Y  \\"+ConsoleColors.RED+"  |     \\   |  |__/ __ \\_/ /_/  >___ \\ \n"+
ConsoleColors.YELLOW+" \\___  / |____/|___|  /"+ConsoleColors.BLUE+"   \\__/\\  / |__||__| |___|  /"+ConsoleColors.RED+"  \\___  /   |____(____  /\\___  /____  >\n"+
ConsoleColors.YELLOW+"     \\/             \\/ "+ConsoleColors.BLUE+"        \\/                \\/ "+ConsoleColors.RED+"      \\/              \\//_____/     \\/\n",
ConsoleColors.GREEN+" _____ _     _      "+ConsoleColors.RESET+"  _      _  _____  _     "+ConsoleColors.RED+"  _____ _     ____  _____ ____ \n"+
ConsoleColors.GREEN+"/    // \\ /\\/ \\  /| "+ConsoleColors.RESET+" / \\  /|/ \\/__ __\\/ \\ /| "+ConsoleColors.RED+" /    // \\   /  _ \\/  __// ___\\\n"+
ConsoleColors.GREEN+"|  __\\| | ||| |\\ || "+ConsoleColors.RESET+" | |  ||| |  / \\  | |_|| "+ConsoleColors.RED+" |  __\\| |   | / \\|| |  _|    \\\n"+
ConsoleColors.GREEN+"| |   | \\_/|| | \\|| "+ConsoleColors.RESET+" | |/\\||| |  | |  | | || "+ConsoleColors.RED+" | |   | |_/\\| |-||| |_//\\___ |\n"+
ConsoleColors.GREEN+"\\_/   \\____/\\_/  \\| "+ConsoleColors.RESET+" \\_/  \\|\\_/  \\_/  \\_/ \\| "+ConsoleColors.RED+" \\_/   \\____/\\_/ \\|\\____\\\\____/\n",
ConsoleColors.RED+" ____  __  __  _  _  "+ConsoleColors.RESET+"  _    _  ____  ____  _   _  "+ConsoleColors.RED+"  ____  __      __    ___  ___ \n"
ConsoleColors.RED+"( ___)(  )(  )( \\( ) "+ConsoleColors.RESET+" ( \\/\\/ )(_  _)(_  _)( )_( ) "+ConsoleColors.RED+" ( ___)(  )    /__\\  / __)/ __)\n"
ConsoleColors.RED+" )__)  )(__)(  )  (  "+ConsoleColors.RESET+"  )    (  _)(_   )(   ) _ (  "+ConsoleColors.RED+"  )__)  )(__  /(__)\\( (_-.\\__ \\\n"
ConsoleColors.RED+"(__)  (______)(_)\\_) "+ConsoleColors.RESET+" (__/\\__)(____) (__) (_) (_) "+ConsoleColors.RED+" (__)  (____)(__)(__)\\___/(___/\n"
	};
	
	public static String getTitle(){
		return Titles[(int)(Math.random()*Titles.length)];
	}
}