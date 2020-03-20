package todo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ListaCompra {
	
	public static void main(String[] parametro) {
        
		Scanner s = new Scanner(System.in);
		boolean centinela = true;
		int nMenu = 0;
		
		/*Al principio crea un fichero, en el caso de que no exista, en el que guardar el numero de menus disponible, 
		 * para poder mostrarlos en cualquier momento y que no se pierdan
		 */
		File fichero = new File ("nMenus.txt");
		
		if(fichero.exists()) {
			
			
		}	else {
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("nMenus.txt"));
					
					bw.write("0");
					bw.close();
					
				}	catch (IOException ioe) {
						System.out.println("Se produjo un error inesperado");
				}
		}
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("nMenus.txt"));
			
			nMenu = Integer.parseInt(br.readLine());
			
		}	catch (IOException ioe) {
			System.out.println("Se produjo un error inesperado");
	}
		
		do {
			
			System.out.println("Introduzca la opcion que desee:");
			System.out.println("1.Consultar menus");
			System.out.println("2.Añadir menu");
			System.out.println("3.Menu aleatorio");
			System.out.println("4.Salir");
			
			int num = s.nextInt();
			
			switch(num) {
			
			case 1:
				Funciones.LeeMenu(nMenu);
				break;
				
			case 2:
				nMenu++;
				Funciones.CreaMenu(nMenu);
				break;
				
			case 3:
				Funciones.MenuAleatorio0(nMenu);
				break;
				
			case 4:
				centinela = false;
				break;
				
				
			default:
				System.out.println("Lo siento, el numero introducido no es correcto");
			}
			
		} while (centinela);
		
		/*
		 * Al final guarda el nuevo numero de menus disponibles en el fichero correspondiente
		 */
		
		if(fichero.exists()) {
			fichero.delete();
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("nMenus.txt"));
				
				bw.write(String.valueOf(nMenu));
				bw.close();
					
			}	catch (IOException ioe) {
					System.out.println("Se produjo un error inesperado");
				}
					
		}	else {
					
		}
		
    }
}
