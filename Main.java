public class Main {
	/// Esta variable guara los nombre de los paises
	public static String[] paises;
	/// Aqui se guardan todas las banderas
	public static String[][][] banderas;
	/// Indica el numero de bandera que hay
	public static byte nBanderas=0;

	/// Guarda los indices de las banderas que se conocen
	public static byte[] kBanderas;

	public static void main(String[] args){
		//Ponemos la cadena que se usa para "Limpiar la pantalla"
		Util.ClearStr = Util.repeatString(250, "\n");
		Util.clear();
		//mensaje inicial
		trace(ConsoleColors.GREEN + "Por favor maximiza la consola para poder ver mejor el juego" + ConsoleColors.RESET);
		trace(ConsoleColors.YELLOW+"Pulsa ENTER para iniciar"+ConsoleColors.BLACK,false);
		ConsoleInput.getString();
		trace(ConsoleColors.RESET);
		loadFlags();
		while(MainMenu())
			trace("",false);

		ConsoleInput.getString();
	}
	public static Boolean MainMenu(){
		//Se limpia lo anterior
		Util.clear();
		//Menu principal del juego
		trace(Texts.getTitle()+Texts.getMainMenu());
		int option = choose(false);
		while(!(option>0&&option<=Texts.mainMenu.length)){
			option = choose(true);
		}
		switch(Texts.mainMenu[option-1]){
			case Texts.KNOWTF:
				return showAllFlags();
			case Texts.CLOSE:
				return close();
			case Texts.ABOUT:
				return about();
		}
		return true;
	}
	private static Boolean showAllFlags(){
		Util.clear();
		if(kBanderas[0]==0){
			trace("\t"+ConsoleColors.RED+"Ups!"+ConsoleColors.RESET+", aun no conoces ninguna bandera, empieza a jugar para que sepamos que banderas conoces!\n\n");
			enter();
			return true;
		}
		byte[] tempFlags=new byte[kBanderas[0]];
		byte index=0;
		for(byte j=0;j<nBanderas;j++){
			if(kBanderas[j+1]==1){
				tempFlags[index++]=j;
			}
		}
		for(int i=0;i<index-(index%2==0?0:1);i+=2){
			trace(paises[tempFlags[i]]+":"+Util.getSpaces(tempFlags[i])+paises[tempFlags[i+1]]+":\n");
			drawTwoFlags(tempFlags[i],tempFlags[i+1]);
			trace("\n");
		}
		if(index%2!=0){
			trace(paises[tempFlags[index-1]]+":\n");
			drawFlag(tempFlags[index-1]);
			trace("\n");
		}
		enter();
		return true;
	}
	public static Boolean about(){
		Util.clear();
		trace(Texts.getTitle());
		trace("  "+ConsoleColors.GREEN+"Fun With Flags Ha sido creado por: \n"+
			ConsoleColors.YELLOW+"    -Juan Pablo Calle"+ConsoleColors.CYAN+" (https://github.com/JuanCalle1606)\n"+
			ConsoleColors.YELLOW+"    -Andres Camilo Gomez Orozco"+ConsoleColors.CYAN+ " (https://github.com/AndresCGO)\n"+
			ConsoleColors.GREEN+"\n  Diseño de las banderas ha sido realizado por distintos contribuidores en:\n"+
			ConsoleColors.YELLOW+"    https://github.com/xaca/banderas_java/blob/master/recursos/info_banderas.csv\n"
			);
		enter();		
		return true;
	}
	public static Boolean close(){
		Util.clear();
		trace("\t"+ConsoleColors.GREEN+" Gracias por jugar!. "+ConsoleColors.RESET+" Pulsa ENTER para salir."+ConsoleColors.BLACK);
		return false;
	}
	public static int choose(Boolean chooseError){
		if(chooseError){
			Util.clear();
			trace(Texts.getTitle()+Texts.getMainMenu());
			trace(ConsoleColors.RED+"Opción invalida, ingresa otra.");
		}
		trace(ConsoleColors.YELLOW+"Escoge una opción: "+ConsoleColors.RESET, false);
		return ConsoleInput.getInt();
	}
	public static void enter(){
		trace(ConsoleColors.RESET+"Pulsa ENTER para Continuar"+ConsoleColors.BLACK,false);
		ConsoleInput.getString();
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
		paises=new String[length/20];kBanderas=new byte[(length/20)+1];
		banderas=new String[length/20][19][27];
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
	}
	private static void drawFlag(int index){
		for(byte i=0;i<19;i++)
			for(byte j=0;j<27;j++)
				trace(banderas[index][i][j],j==26?true:false);
	}
	private static void drawTwoFlags(int index1, int index2){
		for(byte i=0;i<19;i++){
			for(byte j=0;j<27;j++)
				trace(banderas[index1][i][j],false);
			trace("\t\t",false);
			for(byte j=0;j<27;j++)
				trace(banderas[index2][i][j],j==26?true:false);
		}
	}
}