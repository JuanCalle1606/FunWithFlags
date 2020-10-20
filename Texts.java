/**
 * Esta clase se usa para obtener los textos usados en el juego
 */
public class Texts {

	public static final String CLOSE="Salir";
	public static final String ABOUT="Acerca de";
	public static final String KNOWTF="Banderas conocidas";
	public static final String GAME2="Adivina el país";
	public static final String GAME1="Adivina la bandera";
	public static String[] mainMenu=new String[]{
		GAME2,
		GAME1,
		KNOWTF,
		ABOUT,
		CLOSE
	};
	public static String getMainMenu(){
		String temp="\n";int len=mainMenu.length;
		for(int i=0;i<len;i++){
			temp+="\t"+ConsoleColors.GREEN+(i+1)+". "+ConsoleColors.RESET+mainMenu[i]+"\n";
		}
		return temp;
	}
	public static String[] charCodes=new String[]{
		"ñ"
	};
	private static String[] Titles=new String[]{
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
ConsoleColors.RED+" ____  __  __  _  _  "+ConsoleColors.RESET+"  _    _  ____  ____  _   _  "+ConsoleColors.RED+"  ____  __      __    ___  ___ \n"+
ConsoleColors.RED+"( ___)(  )(  )( \\( ) "+ConsoleColors.RESET+" ( \\/\\/ )(_  _)(_  _)( )_( ) "+ConsoleColors.RED+" ( ___)(  )    /__\\  / __)/ __)\n"+
ConsoleColors.RED+" )__)  )(__)(  )  (  "+ConsoleColors.RESET+"  )    (  _)(_   )(   ) _ (  "+ConsoleColors.RED+"  )__)  )(__  /(__)\\( (_-.\\__ \\\n"+
ConsoleColors.RED+"(__)  (______)(_)\\_) "+ConsoleColors.RESET+" (__/\\__)(____) (__) (_) (_) "+ConsoleColors.RED+" (__)  (____)(__)(__)\\___/(___/\n",
ConsoleColors.BLUE+" ______   __  __     __   __   "+ConsoleColors.YELLOW+"  __     __     __     ______   __  __   "+ConsoleColors.RED+"  ______   __         ______     ______     ______  \n " +
ConsoleColors.BLUE+"/\\  ___\\/\\ \\/\\ \\   /\\ \"-.\\ \\  "+ConsoleColors.YELLOW+" /\\ \\  _ \\ \\   /\\ \\   /\\__  _\\ /\\ \\_\\ \\  "+ConsoleColors.RED+" /\\  ___\\ /\\ \\       /\\  __ \\   /\\  ___\\   /\\  ___\\  \n" +
ConsoleColors.BLUE+"\\ \\  __\\ \\ \\ \\_\\ \\  \\ \\ \\-.  \\ "+ConsoleColors.YELLOW+" \\ \\ \\/ \".\\ \\  \\ \\ \\  \\/_/\\ \\/ \\ \\  __ \\ "+ConsoleColors.RED+" \\ \\  __\\ \\ \\ \\____  \\ \\  __ \\  \\ \\ \\__ \\  \\ \\___  \\ \n " +                       
ConsoleColors.BLUE+"\\ \\_\\    \\ \\_____\\  \\ \\_\\\\\"\\_\\"+ConsoleColors.YELLOW+"  \\ \\__/\".~\\_\\  \\ \\_\\    \\ \\_\\  \\ \\_\\ \\_\\"+ConsoleColors.RED+"  \\ \\_\\    \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\/\\_____\\ \n" +                       
ConsoleColors.BLUE+"  \\/_/     \\/_____/   \\/_/ \\/_/"+ConsoleColors.YELLOW+"   \\/_/   \\/_/   \\/_/     \\/_/   \\/_/\\/_/"+ConsoleColors.RED+"   \\/_/     \\/_____/   \\/_/\\/_/   \\/_____/   \\/_____/ \n",
ConsoleColors.PURPLE+"$$$$$$$$\\ $$\\   $$\\ $$\\   $$\\ "+ConsoleColors.YELLOW+"      $$\\      $$\\ $$$$$$\\ $$$$$$$$\\ $$\\   $$\\  "+ConsoleColors.RED+"     $$$$$$$$\\ $$\\        $$$$$$\\   $$$$$$\\   $$$$$$\\   \n"+
ConsoleColors.PURPLE+"$$  _____|$$ |  $$ |$$$\\  $$ |"+ConsoleColors.YELLOW+"      $$ | $\\  $$ |\\_$$  _|\\__$$  __|$$ |  $$ | "+ConsoleColors.RED+"     $$  _____|$$ |      $$  __$$\\ $$  __$$\\ $$  __$$\\  \n"+
ConsoleColors.PURPLE+"$$ |      $$ |  $$ |$$$$\\ $$ |"+ConsoleColors.YELLOW+"      $$ |$$$\\ $$ |  $$ |     $$ |   $$ |  $$ | "+ConsoleColors.RED+"     $$ |      $$ |      $$ /  $$ |$$ /  \\__|$$ /  \\__| \n"+
ConsoleColors.PURPLE+"$$$$$\\    $$ |  $$ |$$ $$\\$$ |"+ConsoleColors.YELLOW+"      $$ $$ $$\\$$ |  $$ |     $$ |   $$$$$$$$ | "+ConsoleColors.RED+"     $$$$$\\    $$ |      $$$$$$$$ |$$ |$$$$\\ \\$$$$$$\\   \n"+
ConsoleColors.PURPLE+"$$  __|   $$ |  $$ |$$ \\$$$$ |"+ConsoleColors.YELLOW+"      $$$$  _$$$$ |  $$ |     $$ |   $$  __$$ | "+ConsoleColors.RED+"     $$  __|   $$ |      $$  __$$ |$$ |\\_$$ | \\____$$\\  \n"+
ConsoleColors.PURPLE+"$$ |      $$ |  $$ |$$ |\\$$$ |"+ConsoleColors.YELLOW+"      $$$  / \\$$$ |  $$ |     $$ |   $$ |  $$ | "+ConsoleColors.RED+"     $$ |      $$ |      $$ |  $$ |$$ |  $$ |$$\\   $$ | \n"+
ConsoleColors.PURPLE+"$$ |      \\$$$$$$  |$$ | \\$$ |"+ConsoleColors.YELLOW+"      $$  /   \\$$ |$$$$$$\\    $$ |   $$ |  $$ | "+ConsoleColors.RED+"     $$ |      $$$$$$$$\\ $$ |  $$ |\\$$$$$$  |\\$$$$$$  | \n"+
ConsoleColors.PURPLE+"\\__|       \\______/ \\__|  \\__|"+ConsoleColors.YELLOW+"      \\__/     \\__|\\______|   \\__|   \\__|  \\__| "+ConsoleColors.RED+"     \\__|      \\________|\\__|  \\__| \\______/  \\______/  \n"
	};
	private static String[] ExitTitle=new String[]{
		ConsoleColors.GREEN+"   _   _____             _                              _                    __       	 					\n"+
        ConsoleColors.GREEN+"  (_) / ___/______ _____(_)__ ____   ___  ___  ____    (_)_ _____ ____ _____/ /  /\\_/\\			\n"+
        ConsoleColors.GREEN+" / / / (_ / __/ _ `/ __/ / _ `(_-<  / _ \\/ _ \\/ __/   / / // / _ `/ _ `/ __/_/  ( o.o )			\n"+
        ConsoleColors.GREEN+"/_/  \\___/_/  \\_,_/\\__/_/\\_,_/___/ / .__/\\___/_/   __/ /\\_,_/\\_, /\\_,_/_/ (_)  	 > ^ <			\n"+
        ConsoleColors.GREEN+"                                  /_/             |___/     /___/              "
	};
	public static String getAdCountry(){
		return
		ConsoleColors.GREEN+" Listo para jugar?\n\n"+
		ConsoleColors.GREEN+" Objetivo:"+ConsoleColors.RESET+"Te mostraremos una bandera y debes adivinar el pais\n\n"+
		ConsoleColors.GREEN+" Escoge la dificultad:\n\n"+
		"  "+ConsoleColors.GREEN+"1. Facil:"+ConsoleColors.RESET+" Te daremos 4 opciones posibles para que te sea mas facil acertar.\n"+
		"  "+ConsoleColors.YELLOW+"2. Normal:"+ConsoleColors.RESET+" Te daremos 8 opciones posibles para que haya mas dificultad.\n"+
		"  "+ConsoleColors.RED+"3. Dificil:"+ConsoleColors.RESET+" No te daremos opciones si no que tienes que escribir tu mismo la respuesta.\n";
	}
	public static String getAdFlag(){
		return
		"\t"+ConsoleColors.GREEN+"Listo para conocer las banderas del mundo?\n\n"+
		ConsoleColors.PURPLE+"Objetivo:"+ConsoleColors.YELLOW+"Te mostraremos 4 Banderas y tu tienes que adivinar el pais "+ConsoleColors.RESET;
	}
	public static String getExit(){
		return ExitTitle[0];
        

	}
	public static String getTitle(){
		return Titles[(int)(Math.random()*Titles.length)];
	}
}