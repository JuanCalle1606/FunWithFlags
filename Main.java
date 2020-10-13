public class Main {
	///esta variable guara los nombre de los paises
	public static String[] paises;

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
	/**
	 * Esta función carga el archivo .csv y guarda los contenidos de las banderas
	 */
	private static void loadFlags(){
		//se limpia el contenido anterior
		Util.clear();
		trace(ConsoleColors.GREEN+"> Cargando banderas...");
		//cargamos los archivos
		String[] fileContent = ConsoleFile.read("recursos/info_banderas.csv");
		String[][] tempArray;
		int length=fileContent.length,index;
		trace("> Datos cargados! Procesando...");
		//inicializamos el arreglo al numero de paises que hay
		paises = new String[length/20];
		//agregamos los nombre de los paisese y los patrones de la bandera en sus respectivos arreglos
		for (int i=0;i<length;i++){
			//esto ocurre en las lineas que poseen nombres de paises
			if(i%20==0)
			{
				//guardamos el nombre del pais
				paises[i/20]=fileContent[i].substring(0,fileContent[i].indexOf(";"));
				trace("> Cargando bandera de "+paises[i/20]);
			}
		}
	}
}