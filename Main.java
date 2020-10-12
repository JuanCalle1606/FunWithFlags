public class Main {
	public static void main(String[] args){
		//Ponemos la cadena que se usa para "Limpiar la pantalla"
		Util.ClearStr = Util.repeatString(100, "\n");
		Util.clear();
		//mensaje inicial
		trace(ConsoleColors.GREEN + "Por favor maximiza la consola para poder ver mejor el juego" + ConsoleColors.RESET);
		trace(ConsoleColors.YELLOW+"Pulsa ENTER para iniciar"+ConsoleColors.BLACK);
		ConsoleInput.getString();
		trace(ConsoleColors.RESET);
		loadFlags();
		MainMenu();
	}
	public static void MainMenu(){
		//Menu principal del juego
		trace(Texts.getTitle()+Texts.getMainMenu());
	}
	public static void trace(String txt){
		System.out.println(txt);
	}
	private static void loadFlags(){
		//Esta función cargara el archivo de banderas y lo parseara
		trace("Cargando banderas...");
	}
}