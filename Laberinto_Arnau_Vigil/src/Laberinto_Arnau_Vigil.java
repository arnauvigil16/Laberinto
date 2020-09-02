

import java.util.*;




public class Laberinto_Arnau_Vigil {
	
	public static int FILES = 15;
	public static int COLUMNES = 30;
	static ArrayList<String> lista_movimientos = new ArrayList<String>();
	static Scanner teclat = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vidas = 5;		
		int fPer = 1;
		int cPer = 1;
		int fSalida = 13;
		int cSalida = 28;	
		
		char piqueta_caracter = '/';
		char bombas_caracter = 'B';
		char muro_caracter = '#';
		
		boolean piqueta = false;
		String movimiento = null;
		

		char [][] laberinto_oculto = {{'�', '�', '�', '�', '�', '�', '�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�'},
									  {'�', ' ', '#', '#', ' ', '#', ' ','#',' ','#',' ',' ',' ',' ','#',' ','#',' ','#',' ',' ','#',' ','#','#',' ',' ',' ',' ','�'},
									  {'�', ' ', ' ', ' ', ' ', '#', ' ',' ',' ','#','#','#',' ','#',' ',' ',' ',' ',' ',' ','#','#',' ',' ',' ',' ','#',' ',' ','�'},
									  {'�', '#', ' ', '#', ' ', '#', ' ','#',' ',' ',' ',' ','#','#',' ','#','#','#',' ',' ',' ',' ','#','#',' ','#','#',' ','#','�'},
									  {'�', ' ', ' ', ' ', '#', ' ', ' ','#',' ','#',' ',' ',' ',' ',' ','#',' ',' ',' ','#','#',' ',' ','#',' ',' ','#',' ',' ','�'},
									  {'�', ' ', '#', ' ', ' ', '#', ' ',' ','#',' ','#','#','#','#',' ','#',' ','#','#',' ',' ','#',' ',' ',' ','#','#','#',' ','�'},
									  {'�', ' ', '#', ' ', '#', ' ', '#',' ','#',' ',' ','#',' ',' ',' ','#','#',' ',' ',' ','#','#','#',' ','#',' ','#',' ',' ','�'},
									  {'�', '#', ' ', ' ', '#', ' ', ' ',' ',' ',' ','#',' ','#','#',' ',' ','#',' ','#',' ',' ','#',' ','#',' ',' ',' ',' ','#','�'},
									  {'�', '#', '#', ' ', '#', '#', ' ','#',' ','#',' ',' ',' ','#','#',' ',' ',' ',' ','#',' ','#',' ',' ','#','#',' ',' ',' ','�'},
									  {'�', ' ', '#', ' ', ' ', ' ', '#','#',' ',' ',' ','#',' ',' ','#',' ','#',' ','#',' ',' ',' ',' ','#',' ',' ','#','#',' ','�'},
									  {'�', ' ', ' ', ' ', '#', ' ', ' ',' ','#',' ',' ','#',' ','#',' ',' ',' ','#',' ',' ','#','#',' ',' ',' ','#','#',' ',' ','�'},
									  {'�', '#', ' ', '#', ' ', ' ', '#','#',' ','#',' ',' ','#','#',' ','#',' ','#','#',' ','#','#','#',' ',' ',' ','#',' ','#','�'},
									  {'�', ' ', ' ', '#', '#', ' ', ' ',' ',' ','#',' ','#',' ','#',' ','#',' ','#','#',' ',' ',' ',' ','#','#',' ','#',' ',' ','�'},
									  {'�', '#', ' ', ' ', ' ', '#', ' ','#',' ',' ',' ','#',' ',' ',' ','#',' ','#',' ',' ','#',' ',' ','#',' ',' ',' ','#',' ','�'},
									  {'�', '�', '�', '�', '�', '�', '�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�'},
		};
		
		char [][] laberinto_visible = {{'�', '�', '�', '�', '�', '�', '�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�'},
									  {'�', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','�'},
									  {'�', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','�'},
									  {'�', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','�'},
									  {'�', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','�'},
									  {'�', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','�'},
									  {'�', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','�'},
									  {'�', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','�'},
									  {'�', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','�'},
									  {'�', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','�'},
									  {'�', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','�'},
									  {'�', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','�'},
									  {'�', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','�'},
									  {'�', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','�'},
									  {'�', '�', '�', '�', '�', '�', '�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�'},
};

			laberinto_visible[fPer][cPer]= 'P';
			laberinto_oculto[fSalida][cSalida]= 'S';
			
			elemento(laberinto_oculto, muro_caracter);
			elemento(laberinto_oculto, piqueta_caracter);
			elemento(laberinto_oculto, bombas_caracter);
			introducion_juego();
			System.out.println();
			imprimirLaberinto(laberinto_oculto);
			//imprimirLaberinto(laberinto_visible);
		
		while (vidas != 0 && (laberinto_visible[fPer][cPer]) != (laberinto_oculto[fSalida][cSalida]) ) {	
			
		laberinto_visible[fPer][cPer] = ' ';

		movimiento = pregunta(movimiento);
	
		
		switch(movimiento) {
			case "arriba":
				//Si la siguiente casella es una piqueta
				
				if (laberinto_oculto[fPer - 1][cPer] == '/') {
					piqueta = piqueta(fPer,cPer,piqueta);
					laberinto_oculto[fPer - 1][cPer] = ' ';
					fPer = fPer - 1;
				}
				
				// Si la siguiente casilla es un muro interior
				
				else if (laberinto_oculto[fPer - 1][cPer] == '#') {
					if (piqueta == true) {
						laberinto_oculto[fPer - 1][cPer] = ' ';	
					}
					else {
					System.out.println(" ");
					System.out.println("No puedes pasar por aqui!");
					System.out.println(" ");
					laberinto_visible[fPer - 1][cPer] = '#';
					}
				} 
				
				// Si la siguiente casilla es un muro exterior
				
				else if (laberinto_oculto[fPer - 1][cPer] == '�') {
					System.out.println("No te puedes escapar por los muros exteriores!!");
				}
				
				
				// Si la siguiente casilla es una bomba
				
				else if (laberinto_oculto[fPer - 1][cPer] == 'B') {
					vidas = bombas(vidas);		
					laberinto_oculto[fPer - 1][cPer] = ' ';
					fPer = fPer - 1;
					
				}
				
				//  avanza
				
				else {
					fPer = fPer - 1;		
				}
					break;
					
			case "abajo":
				if (laberinto_oculto[fPer + 1][cPer] == '/') {
					piqueta = piqueta(fPer,cPer,piqueta);
					laberinto_oculto[fPer + 1][cPer] = ' ';
					fPer = fPer + 1;
				}
				
				else if (laberinto_oculto[fPer + 1][cPer] == '�') {
					System.out.println("No te puedes escapar por los muros exteriores!!");
				}
				
				
				else if (laberinto_oculto[fPer + 1][cPer] == '#') {
					
					if (piqueta == true) {
						laberinto_oculto[fPer + 1][cPer] = ' ';
					}
					
					else {
					System.out.println(" ");
					System.out.println("No puedes pasar por aqui!");
					System.out.println(" ");
					laberinto_visible[fPer + 1][cPer] = '#';
					}
					
				}
				
				else if (laberinto_oculto[fPer + 1][cPer] == 'B') {
					vidas = bombas(vidas);
					
					laberinto_oculto[fPer + 1][cPer] = ' ';
					fPer = fPer + 1;	
				}
				
				else {
					fPer = fPer + 1;
				}
					break;
					
					
			case "derecha":
				if (laberinto_oculto[fPer][cPer + 1] == '/') {
					piqueta = piqueta(fPer,cPer,piqueta);
					laberinto_oculto[fPer][cPer +1] = ' ';
					cPer = cPer + 1;
				}
					
				else if (laberinto_oculto[fPer][cPer + 1] == '�') {
					System.out.println("No te puedes escapar por los muros exteriores!!");
				}
				
				else if (laberinto_oculto[fPer][cPer + 1] == '#') {
					
					if (piqueta == true) {
						laberinto_oculto[fPer][cPer +1] = ' ';
					}
					
					else {
					System.out.println(" ");
					System.out.println("No puedes pasar por aqui!");
					System.out.println(" ");
					laberinto_visible[fPer][cPer + 1] = '#';
					}
				}
				
				else if (laberinto_oculto[fPer][cPer + 1] == 'B') {
					vidas = bombas(vidas);
					laberinto_oculto[fPer][cPer + 1] = ' ';
					cPer = cPer + 1;							
				}
				else {
					cPer = cPer + 1;
				}
					break;
					
					
			case "izquierda":
				if (laberinto_oculto[fPer][cPer - 1] == '/') {
					piqueta = piqueta(fPer,cPer,piqueta);
					laberinto_oculto[fPer][cPer - 1] = ' ';
					cPer = cPer - 1;
				}
				
				else if (laberinto_oculto[fPer][cPer - 1] == '�') {
					System.out.println("No te puedes escapar por los muros exteriores!!");
				}
				
				else if (laberinto_oculto[fPer][cPer - 1] == '#') {
					
					if (piqueta == true) {
						laberinto_oculto[fPer][cPer - 1] = ' ';
					}
					else {
					System.out.println(" ");
					System.out.println("No puedes pasar por aqui!");
					System.out.println(" ");
					laberinto_visible[fPer][cPer - 1] = '#';
					}
				}
				else if (laberinto_oculto[fPer][cPer - 1] == 'B') {
					vidas = bombas(vidas);
					laberinto_oculto[fPer][cPer - 1] = ' ';				
					cPer = cPer - 1;		
				}			
				else {
					cPer = cPer - 1;
				}
				break;
				
				
			case "ayuda":
					ayuda(fPer,cPer,fSalida,cSalida);
					System.out.println("");
					break;
					
					
			default:
				System.out.println("");
				System.out.println("La palabra o caracter introducido no es correcto");
				System.out.println("");
				break;	
		}
		
		System.out.println("");
		System.out.println("Vidas: " + vidas);
		System.out.println("");
		
		laberinto_visible[fPer][cPer]='P';
		
		imprimirLaberinto(laberinto_visible);
		
		laberinto_visible[fPer][cPer]='P';


		}
		
		teclat.close();
		
		if (vidas == 0) {
			System.out.println("GAME OVER!");
			System.out.println(" ");
			System.out.println("Has perdido todas la vidas!");
			System.out.println(" ");
			lista_movimiento();
		}
		
		else {
		System.out.println(" ");
		System.out.println("ENHORABUENA!!");
		System.out.println("Has encontrado la salida!");
		System.out.println("Eres libre!");
		System.out.println(" ");
		lista_movimiento();
		}
	
	}
	
	
	private static void lista_movimiento() {
		System.out.println("Movimientos del Jugador: ");
		
		for(int i = 0; i < lista_movimientos.size();i++) {
			
			System.out.print(lista_movimientos.get(i) + " ");
			System.out.print("");
			
		}
	}
	
	private static void ayuda(int filaPersonatge, int columnaPersonatge, int filaSalida, int columnaSalida) {
		if(filaPersonatge == filaSalida && columnaPersonatge < columnaSalida ) {
			System.out.println("La salida esta hacia la derecha");
		}
		else if (filaPersonatge > filaSalida && columnaPersonatge == columnaSalida) {
			System.out.println("La salida esta hacia abajo");
		}
		else if (filaPersonatge < filaSalida && columnaPersonatge < columnaSalida) {
			System.out.println("La salida esta hacia abajo a la derecha");
		}
		
	}

	private static void introducion_juego(){
			
			System.out.println(" ");
			System.out.println("Bienvenido al juego del laberinto!!");
			System.out.println("Tendras que escapar para ganar!");
			System.out.println("Pero cuidado! Hay bombas por el camino!");
			System.out.println(" ");
			System.out.println("Las reglas son sencillas:");
			System.out.println("1. Para ganar tienes que llegar a la meta");
			System.out.println("2. El laberinto esta oculto, cada vez que te topes con un muro, aparecera ");
			System.out.println("3. Cuidado con las bombas, son aleatorias! Si te explotan 5 bombas, perderas todas las vidas");
			System.out.println("4. Hay una piqueta oculta por el laberinto, si la consigues, podras romper todos los muros");
			System.out.println("5. Al final de cada partida, ganes o pierdas, se mostrara un listado con todos los movimientos que has realizado ");
			System.out.println("6. Hay una comanda que indica hacia donde esta la salida, usala si estas muy perdido! ");
		}
	
	private static char [][] imprimirLaberinto(char [][] laberinto) {

		for ( FILES =0; FILES < laberinto.length; FILES++) {
		    for ( COLUMNES = 0; COLUMNES < laberinto[FILES].length; COLUMNES++){
		     System.out.print("");
		     System.out.print (laberinto[FILES][COLUMNES] + " ");
		     
		     System.out.print("");
		    }
		  System.out.println();
		 }
		
		return laberinto;
	}
	
	private static char [][] elemento(char Mapa[][], char elemento) {
		int random = 0;
		int max = 0;
		
		for ( FILES =0; FILES < Mapa.length; FILES++) {
		    for ( COLUMNES = 0; COLUMNES < Mapa[FILES].length; COLUMNES++){
		    	
		    if (elemento == '/') {		
		    	if (Mapa[FILES][COLUMNES] == ' ') {
					random = (int)(Math.random() * 50);
					if (random == 1 && max <= 0) {
						Mapa[FILES][COLUMNES] = '/';
						max++;
					}
				}
		    }
		    
		    else if (elemento == 'B'){
		    	if (Mapa[FILES][COLUMNES] == ' ') {
					random = (int)(Math.random() * 20);
					if (random == 5) {
						Mapa[FILES][COLUMNES] = 'B';
						max++;
					}
				}    	
		    }
		    	    
			}			
		}	
		return Mapa;		
	}
	
	private static String pregunta (String movimiento) {
			
			System.out.println();
			System.out.print("Introduce la orden: (arriba | abajo | derecha | izquierda | ayuda) ");
			movimiento = teclat.nextLine().toLowerCase();
			lista_movimientos.add(movimiento);
			System.out.println("");
			
			return movimiento;
		}
		
	private static boolean piqueta ( int fPer, int cPer, boolean piqueta ) {
		
			System.out.println(" ");
			System.out.println("Has encontrado la piqueta!");
			System.out.println("Tienes el poder supremo!");
			System.out.println("Puedes destruir todos los muros!");
			System.out.println(" ");
			piqueta = true;
			
		
		return piqueta;
		
	}
	
	private static int bombas (int vidas) {
		System.out.println(" ");
		System.out.println("Te has comido una bomba!");
		System.out.println("Has perdido una vida!");
		System.out.println(" ");
		
		vidas--;
		
		return vidas;

	}
	
}