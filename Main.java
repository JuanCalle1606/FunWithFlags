public class Main {
	/// Esta variable guara los nombre de los paises
	public static String[] paises;
	/// Aqui se guardan todas las banderas
	public static String[][][] banderas;
	/// Indica el numero de bandera que hay
	public static byte nBanderas=0;

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
		trace(txt,true);
	}
	public static void trace(String txt, Boolean ln){
		if(ln)
			System.out.println(txt);
		else
			System.out.print(txt);
	}
	/**
	 * Esta función carga el archivo .csv y guarda los contenidos de las banderas
	 */
	private static void loadFlags(){
		//se limpia el contenido anterior
		Util.clear();
		trace(ConsoleColors.GREEN+"> Cargando datos...");
		//cargamos los archivos
		String[] fileContent = ConsoleFile.read("recursos/info_banderas.csv");
		int length=fileContent.length,index=0;
		trace("> Datos cargados! Procesando...");
		//inicializamos el arreglo al numero de paises que hay
		paises = new String[length/20];
		banderas = new String[length/20][19][27];
		//agregamos los nombre de los paisese y los patrones de la bandera en sus respectivos arreglos
		for (short i=0;i<length;i++){
			//esto ocurre en las lineas que poseen nombres de paises
			if(i%20==0)
			{
				//guardamos el nombre del pais
				paises[i/20]=fileContent[i].substring(0,fileContent[i].indexOf(";"));
				trace("> Cargando bandera de "+paises[i/20]);
				index=0;nBanderas++;
			}
			else{
				banderas[i/20][index]=fileContent[i].split(";");
				Util.replaceColors(banderas[i/20][index]);
				index++;
			}
		}
		trace("> Se cargaron un total de "+nBanderas+" banderas.");
		// Esto de aqui se hace solo para ver que banderas han sido cargadas, luego se borrara
		for (int i=0;i<nBanderas;i++){
			trace("Bandera de "+paises[i]+":\n");
			drawFlag(i);
			trace("\n");
		}

	}
	private static void drawFlag(int index){
		for(byte i=0;i<19;i++)
			for(byte j=0;j<27;j++)
				trace(banderas[index][i][j],j==26?true:false);
	}
}