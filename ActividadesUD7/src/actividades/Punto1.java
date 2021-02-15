package actividades;

import java.util.Enumeration;
//import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Punto1 {
	/*1) Crea una aplicación que calcule la nota media de los alumnos pertenecientes al curso de programación. Una vez
		calculada la nota media se guardara esta información en un diccionario de datos que almacene la nota media de cada
		alumno. Todos estos datos se han de proporcionar por pantalla.
		
	 */
	
	public static void notasAlumnos() {
		
		//Variables
		int cantidadNotas;
		String nombreAlumno;
		
		double nota;
		int indicador=1;
		
		//Diccionario de datos
		Hashtable<String,Double> datosAlumnos=new Hashtable<String,Double>();
		
		//Cantidad de alumnos
		int cantidadAlumnos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de alumnos de la clase"));
		//Cantidad de notas
		cantidadNotas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de notas que se van a registrar:"));
		
		//Instancia del arreglo notas que tendrá el tamaño que se ingresa por pantalla
		double[] notas=new double[cantidadNotas];
		
		//Ciclo que se repetirá la cantidad de veces que ingresamos en la variable cantidadAlumnos
		for(int i=1;i<=cantidadAlumnos;i++) {
			//Solicitara por un JOptionPane el nombre del alumno
			nombreAlumno=JOptionPane.showInputDialog("Ingrese el nombre del alumno:");
	 
			//Este ciclo recorre el arreglo de notas
			for(int j=0;j<cantidadNotas;j++) {
				
				//Ingresar una nota del alumno que se ingreso
				nota=Double.parseDouble(JOptionPane.showInputDialog("Nota: "+indicador));
				indicador++;
				notas[j]=nota;//Se guarda la nota que se ingreso en la variable nota
				
			}
			
			indicador=1;
			//Este es el diccionario de datos donde se almacena el nombre del alumno y llamará al metodo que calcula la nota media del alumno que ingresamos
			datosAlumnos.put(nombreAlumno,calcularMedia(notas));	
		}
		
		//Llama al metodo que imprime el diccionario de datos
		mostrarMediaAlumnos(datosAlumnos);
	}
	
	//Método que calcula la nota media de cada alumno, va a recibir como parametro un arreglo de la notas de cada alumno
	public static double calcularMedia(double[] notas) {
		
		double suma=0;
		double media;
		
		//Este ciclo recorre el arreglo y en la variable suma va sumando c
		for(int j=0;j<notas.length;j++) {
			suma+=notas[j];
		}
		
		media=suma/notas.length;
		return media;
		
	}
	
	public static void mostrarMediaAlumnos(Hashtable<String,Double> datos) {
		//Interface que tiene unos metodos para los datos del hashtable 'datos'
		Enumeration enumeration=datos.elements();
		
		Enumeration llaves=datos.keys();
		String cadenaLista="";
		
		
		//Este ciclo recorre todos los elementos que se encuentran en 'enumeration'
		while(enumeration.hasMoreElements()) {
			cadenaLista+="\nAlumno: "+llaves.nextElement()+" Media: "+enumeration.nextElement();
		}
		
		
		JOptionPane.showMessageDialog(null,cadenaLista);
	}
	
	
}
