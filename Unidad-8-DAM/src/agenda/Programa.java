package agenda;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		//1)Imprimir agenda
		//2)Añadir Contacto
		//3)Eliminar Contacto
		//4)Salir
		
		Agenda a = new Agenda();
		a.cargarAgenda("contactos.bin");
		menu();
		Scanner teclado=new Scanner(System.in);
		int opcion=teclado.nextInt();
		while(opcion!=4) {
			
			switch (opcion) {
			case 1:
				a.imprimirAgenda();
				System.out.println();
				break;
			case 2:
				System.out.println("Datos del contacto: ");
				System.out.println("Nombre: ");
				String nombre=teclado.next();
				System.out.println("Telefono: ");
				String telefono=teclado.next();
				System.out.println("Direccion: ");
				String dir=teclado.next();
				System.out.println("Correo: ");
				String correo=teclado.next();
				a.añadirContacto(new Contacto(nombre, telefono, dir, correo));
				
				break;
			case 3:
				System.out.println("Introduce el contacto que desea borrar: ");
				System.out.println("Nombre: ");
				String nombre1=teclado.next();
				a.borrarContacto(nombre1);
				System.out.println("Contacto Eliminado");
				break;
			case 4:
				a.guardarAgenda("contactos.bin");
				break;
			
			}
			menu();
			opcion=teclado.nextInt();
		}
	}

	private static void menu() {
		System.out.println("Seleccione una opcion: ");
		System.out.println("1.Imprimir agenda");
		System.out.println("2.Añadir Contacto");
		System.out.println("3.Eliminar contacto");
		System.out.println("4.Salir");
		
	}

}
