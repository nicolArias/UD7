package actividades;

import javax.swing.JOptionPane;

public class ActividadesApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numActividad=Integer.parseInt(JOptionPane.showInputDialog("Introduzca # de la actividad:"));
		
		
		
		switch(numActividad) {//Dependiendo de la actividad que el usuario escriba, esta instruccion me permite tener acceso a las clases del proyecto.
		case(1):
			Punto1.notasAlumnos();
			break;
		case(2):
			Punto2.flujoVenta();
			break;
		
		case(3):
			Punto3.stockProductos();
			break;
		
		case(4):
			
			punto4.GestionVentas.gestionVentas();
			break;
		default:
			JOptionPane.showMessageDialog(null, "El número ingresado no coincide con ninguna actividad");
			break;
		}
		

	}	

}
