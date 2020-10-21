import java.util.*;
public class Main {
	/// Contenido original del archivo
	public static String[] fileContent;
	/// Esta variable guarda los nombre de los paises
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
		//debugFlags();
		while(MainMenu())
			trace("",false);

		ConsoleInput.getString();
	}
	public static Boolean MainMenu(){
		//Se limpia lo anterior
		Util.clear();
		//Menu principal del juego
		trace(Texts.getTitle()+Texts.getMainMenu());
		int option = choose(false,true,Texts.mainMenu.length);
		switch(Texts.mainMenu[option-1]){
			case Texts.GAME1:
				return adivinarBandera();
			case Texts.GAME2:
				return adivinarPais(true,(byte)0);
			case Texts.KNOWTF:
				return showAllFlags();
			case Texts.CLOSE:
				return close();
			case Texts.ABOUT:
				return about();
		}
		return true;
	}
	private static byte repeatGame=0;
	private static Boolean adivinarPais(Boolean init,byte dif){
		Util.clear();
		trace(init?Texts.getAdCountry():"");
		repeatGame=init?(byte)0:(byte)(repeatGame-1);
		byte dificultad=init?(byte)choose(3):dif;
		Util.clear();
		byte[] randomFlags=new byte[8];
		Boolean isCorrect=false;
		String respuesta="";
		Util.randomize(randomFlags,nBanderas);
		trace(ConsoleColors.CYAN+"Intenta adivinar de que pais es esta bandera:\n");
		drawFlag(randomFlags[0]);
		trace("\n");
		switch(dificultad){
			case 3:
				trace(ConsoleColors.BLACK_BRIGHT+"No coloques tildes ni caracteres especiales(solo se soporta la ñ).\nEscribe 0 o \"salir\" para salir.\n");
				trace(ConsoleColors.YELLOW+"Ingresa tu respuesta: "+ConsoleColors.RESET,false);
				respuesta=Util.validateInput(ConsoleInput.getString().toLowerCase());
				if(respuesta.equals(pais(randomFlags[0]).toLowerCase()))
					isCorrect=true;
				else if(respuesta.equals("0")||respuesta.equals("salir"))
					return true;
				break;
			case 2:
			case 1:{
				byte[] randomIndex=new byte[4*dificultad];
				Util.randomize(randomIndex,4*dificultad);
				Util.showOptions(randomFlags,randomIndex);
				byte opcion=(byte)(choose(4*dificultad+1)-1);
				respuesta=pais(randomFlags[Util.getPos(randomIndex,opcion)]);
				if(opcion==randomIndex[0])
					isCorrect=true;
				else if(opcion==4*dificultad)
					return true;
			}
		}
		Util.clear();
		if(isCorrect){
			trace(ConsoleColors.GREEN+"\tCorrecto! esta es la bandera de "+respuesta);
			knowFlag(randomFlags[0]);
		}
		else
			trace(ConsoleColors.RED+"\tIncorrecto! esta no es la bandera de "+respuesta);
		enter();Util.clear();
		if(repeatGame==0){
			trace(Texts.getAdCountryContinue());
			byte repeat=(byte)choose(3);
			if(repeat==1)
				repeatGame=(byte)1;
			else if(repeat==2)
				repeatGame=(byte)5;
		}
		if(repeatGame>0)
			adivinarPais(false,dificultad);
		return true;
	}
	private static Boolean adivinarBandera(){
		Util.clear();
		int i=0;
		Boolean respuesta=false;
		trace(Texts.getAdFlag());
		byte[] randomFlags=new byte[nBanderas];
		Util.randomize(randomFlags,nBanderas);
		int[] opciones={randomFlags[0],randomFlags[1],randomFlags[2],randomFlags[3]};
		desorganizararray(opciones);
		trace("\n Cual es la bandera de "+pais(randomFlags[0])+" :");
		trace("1.                                                              2.\n");
		drawTwoFlags(opciones[0],opciones[1]);
		trace("\n");
		trace("3.                                                              4.\n");
		drawTwoFlags(opciones[2],opciones[3]);
		trace("\n\n");
		int opcion=choose(4);
		 switch(opcion){
			case 1:
				if(randomFlags[0]==opciones[0])
					respuesta=true;
				break;
			case 2:
				if(randomFlags[0]==opciones[1])
					respuesta=true;
				break;
			case 3:
				if(randomFlags[0]==opciones[2])
					respuesta=true;
				break;
			case 4:
				if(randomFlags[0]==opciones[3])
					respuesta=true;
				break;
		}
		if(respuesta==true){
			trace("\n \t"+ConsoleColors.GREEN+"Correcto. Esa es la bandera de "+pais(randomFlags[0]));
			knowFlag(randomFlags[0]);
		}
		else
			trace("\n \t"+ConsoleColors.RED+"Incorrecto. Esa no es la bandera de "+pais(randomFlags[0]));
		enter();
		return true;
	}
	public static int[] desorganizararray(int[] array){
		Random rgen = new Random(); 			
		for (int i=0; i<array.length; i++) {
			int randomPosition = rgen.nextInt(array.length);
			int temp = array[i];
			array[i] = array[randomPosition];
			array[randomPosition] = temp;
		}
		return array;
	}
	/**
	 * Esta función se llama cuando un jugador adivina una bandera y la agrega a banderas conocidas.
	 */
	private static void knowFlag(byte index){
		if(kBanderas[index+1]==0){
			kBanderas[index+1]=1;
			kBanderas[0]++;
		}
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
			trace(pais(tempFlags[i])+":"+Util.getSpaces(tempFlags[i])+pais(tempFlags[i+1])+":\n");
			drawTwoFlags(tempFlags[i],tempFlags[i+1]);
			trace("\n");
		}
		if(index%2!=0){
			trace(pais(tempFlags[index-1])+":\n");
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
		trace(Texts.getExit());
		trace("\t"+ConsoleColors.RESET+" Pulsa ENTER para salir."+ConsoleColors.BLACK);
		return false;
	}
	/**
	 * Le pedimos al usuario un numero entre 1 y un numero dado
	 */
	public static int choose(int limit){
		return choose(false,false,limit);
	}
	/**
	 * Con esta función pedimos al usuario un numero positivo sin limite.
	 */
	public static int choose(){
		return choose(false,false,0);
	}
	public static int choose(Boolean chooseError,Boolean isMainMenu,int limit){
		if(chooseError){
			if(isMainMenu){
				Util.clear();
				trace(Texts.getTitle()+Texts.getMainMenu());
			}
			trace(ConsoleColors.RED+"Opción invalida, ingresa otra.");
		}
		trace(ConsoleColors.YELLOW+"Escoge una opción: "+ConsoleColors.RESET, false);
		int temp=ConsoleInput.getInt();
		while(temp==0||(limit>0&&(temp>limit||temp<1))){
			temp=choose(true,isMainMenu,0);
		}
		return temp;
	}
	public static void enter(){
		trace(ConsoleColors.RESET+"\nPulsa ENTER para Continuar"+ConsoleColors.BLACK,false);
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
	public static String pais(byte index){
		return Util.convertToValid(paises[index]);
	}
	/**
	 * Esta función carga el archivo .csv y guarda los contenidos de las banderas
	 */
	private static void loadFlags(){
		//se limpia el contenido anterior
		Util.clear();
		trace(ConsoleColors.GREEN+"> Cargando datos...");
		//cargamos los archivos
		fileContent = ConsoleFile.read("recursos/info_banderas.csv");
		int length=fileContent.length,index=0;
		trace("> Datos cargados! Procesando...");
		//inicializamos el arreglo al numero de paises que hay
		paises=new String[length/20];kBanderas=new byte[(length/20)+1];
		banderas=new String[length/20][19][27];
		//agregamos los nombre de los paisese y los patrones de la bandera en sus respectivos arreglos
		for (short i=0;i<length;i++){
			//esto ocurre en las lineas que poseen nombres de paises
			if(i%20==0){
				//guardamos el nombre del pais
				paises[i/20]=fileContent[i].substring(0,fileContent[i].indexOf(";"));
				trace("> Cargando bandera de "+pais((byte)(i/20)));
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
	private static void debugFlags(){
		for(byte i=0;i<nBanderas-(nBanderas%2==0?0:1);i+=2){
			trace(pais(i)+":"+Util.getSpaces(i)+pais((byte)(i+1))+":\n");
			drawTwoFlags(i,i+1);
			trace("\n");
		}
		if(nBanderas%2!=0){
			trace(pais((byte)(nBanderas-1))+":\n");
			drawFlag(nBanderas-1);
			trace("\n");
		}
	}
}
