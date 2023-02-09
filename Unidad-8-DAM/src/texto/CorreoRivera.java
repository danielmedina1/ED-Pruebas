package texto;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
      
public class CorreoRivera {
	private ArrayList <Correo> listaCorreos;
	       
	public ArrayList<Correo> getListaCorreos() {
		return listaCorreos;
	}         
               
	public void setListaCorreos(ArrayList<Correo> listaCorreos) {
		this.listaCorreos = listaCorreos;
	}

	public CorreoRivera() {
		this.listaCorreos = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		CorreoRivera c=new CorreoRivera();
		Scanner entrada;
		try {
			entrada = new Scanner(new File("AlumnosDAM.csv"));
			entrada.nextLine();
			entrada.nextLine();
			entrada.nextLine();
			entrada.nextLine();
			entrada.nextLine();
			String cadena=" ";
			String linea[];
			while(entrada.hasNext()) {
				cadena=entrada.nextLine();
				linea=cadena.split(";");
				String nombreApe=linea[0];
				String Ape=linea[0];
				String curso=linea[2];
//				System.out.println(nombreApe+" "+curso);
				String nombre = c.getNombre(nombreApe);
				String ape1 = c.getApellido1(Ape);
//				System.out.println(nombre+" "+ape1);
				String correo= curso.toLowerCase()+"_"+nombre+ape1+"@riberadeltajo.es";
//				System.out.println(correo);
				c.getListaCorreos().add(new Correo(nombre, ape1, curso, correo));
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		}
	private String getNombre(String nombreApe) {
		String palabra[]=nombreApe.split(",");
		String nombre=palabra[1].trim().toLowerCase();
		return this.quitaTildes(nombre);
		
	}
	private String getApellido1(String Ape) {
		String palabra[]=Ape.split(" ");
		String ape=palabra[0].trim().toLowerCase();
		return this.quitaTildes(ape);
		}
	
	
	
	private String quitaTildes(String cadena) {
		String palabra[];
		for (int i = 0; i < cadena.length(); i++) {
			if(cadena.charAt(i)=='á') {
				cadena=cadena.replace('á', 'a');
			}
			if(cadena.charAt(i)=='é') {
				cadena=cadena.replace('é', 'e');
			}			if(cadena.charAt(i)=='i') {
				cadena=cadena.replace('í', 'i');
			}
			if(cadena.charAt(i)=='ó') {
				cadena=cadena.replace('ó', 'o');
			}
			if(cadena.charAt(i)=='ú') {
				cadena=cadena.replace('ú', 'u');
			}
			if(cadena.charAt(i)=='ñ') {
				cadena=cadena.replace('ñ', 'n');
			}
			if(cadena.charAt(i)==' ') {
				palabra=cadena.split(" ");
				cadena=palabra[0]+palabra[1];
			}
			
			
		}
		return cadena;
	}
}
	


