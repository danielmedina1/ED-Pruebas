package agenda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Agenda {
	private ArrayList<Contacto>lista;

	public Agenda() {
		this.lista = new ArrayList<>();
	}

	public ArrayList<Contacto> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Contacto> lista) {
		this.lista = lista;
	}
	
	public void cargarAgenda(String filename) {
		try {
			FileInputStream fi=new FileInputStream(filename);
			ObjectInputStream is=new ObjectInputStream(fi);
			Contacto c=null;
			while(is!=null) {
				try {
					fi.close();
					is.close();
					c=(Contacto)is.readObject();
					this.añadirContacto(c);
					
				} 
				
				catch (Exception e) {
					is=null;
				}
				
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void guardarAgenda(String filename) {
		try {
			FileOutputStream fo=new FileOutputStream(filename);
			ObjectOutputStream os=new ObjectOutputStream(fo);
			for(Contacto c: this.getLista()) {
				os.writeObject(c);
			}
			fo.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void imprimirAgenda() {
		System.out.println("Los contactos son: ");
		for (Contacto c : this.getLista()) {
			System.out.println(c.getNombre()+" "+c.getTelefono());
		}
	}
	public void añadirContacto(Contacto c) {
		this.getLista().add(c);
	}
	public void borrarContacto(String nombre) {
		for (int i = 0; i < this.getLista().size(); i++) {
			if(this.getLista().get(i).getNombre().equalsIgnoreCase(nombre)) {
				this.getLista().remove(i);
			}
		}
	}
	public static void main(String[] args) {
		Agenda agenda=new Agenda();
		Contacto c=new Contacto("Marta", "12323", "dfsf", "marta@ribera");
		Contacto c1=new Contacto("Carlos", "34235", "fsgsdf", "carlos@ribera");
		Contacto c2=new Contacto("Juan", "256356", "dsg", "juan@ribera");
		
		agenda.añadirContacto(c);
		agenda.añadirContacto(c1);
		agenda.añadirContacto(c2);
		
		agenda.guardarAgenda("contactos.bin");
		
		
		agenda.cargarAgenda("contactos.bin");
		agenda.imprimirAgenda();
		agenda.getLista().clear();
	}

}
