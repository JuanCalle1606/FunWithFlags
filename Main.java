public class Main {
	public static void main(String[] args){
		//Ponemos la cadena que se usa para "Limpiar la pantalla"
		Util.ClearStr = Util.repeatString(100, "\n");
		Util.clear();
		//mensaje inicial
		trace(ConsoleColors.GREEN + "Por favor maximiza la consola para poder ver mejor el juego" + ConsoleColors.RESET);
	}
	public static void trace(String txt){
		System.out.println(txt);
	}
}