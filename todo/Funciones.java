package todo;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Funciones {
	
	Scanner s = new Scanner(System.in);
	
	public static void CreaMenu(int nMenu) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduzca el desayuno");
		String desayuno = s.nextLine();
		
		System.out.println("Introduzca el almuerzo");
		String almuerzo = s.nextLine();
		
		System.out.println("Introduzca la cena");
		String cena = s.nextLine();
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("menu" + nMenu + ".txt"));
			
			bw.write(desayuno + "\n");
			bw.write(almuerzo + "\n");
			bw.write(cena + "\n");
			
			bw.close();
			
		} catch (IOException ioe) {
			System.out.println("Se produjo un error inesperado");
		}
	}
	
	public static void LeeMenu(int nMenu) {
		
		for(int i = 1; i < nMenu + 1; i++) {
			
			try {
				BufferedReader br = new BufferedReader(new FileReader("menu" + i + ".txt"));
				
				String linea = "Menu numero: " + i;
			      while (linea != null) {
			        System.out.println(linea);
			        linea = br.readLine();
			      } 
				br.close();
				
			} catch (IOException ioe) {
				System.out.println("Se produjo un error inesperado");
			}
		}
	}
	

	public static void MenuAleatorio0(int nMenu) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("menu" + (int)(Math.random() * nMenu + 1) + ".txt"));
			
			int random = (int)(Math.random() * nMenu + 1);
			
			String linea = "Menu numero: " + random;
		      while (linea != null) {
		        System.out.println(linea);
		        linea = br.readLine();
		      } 
			br.close();
			
		} catch (IOException ioe) {
			System.out.println("Se produjo un error inesperado");
		}
	}
}
