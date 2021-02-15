package actividades;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Punto2 {
/*2) Crea una aplicación que gestione el flujo de ventas de una caja de supermercado. El programa guardara la cantidades del
	carrito de compra dentro de una lista. Mostrará por pantalla la siguiente informacion:
	• IVA aplicado (21% o 4%)
	• precio total bruto y precio mas IVA.
	• Numero de artículos comprados.
	• Cantidad pagada.
	• Cambio a devolver al cliente.
*/
	
	
	public static void flujoVenta() {
		
		//Cantidad de productos, este valor se usará para crear la lista
		int cantidadProductos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de productos:"));
		
		ArrayList<Double> listaCompra=new ArrayList<>();
		
		double precioProducto;
		int contador=1;
	
		String porcentajeIVA="";
		double precioIVA;//Aqui se sumara el valor del IVA al precio
		double devuelta;
		double sumaPrecios=0;//Sumara el valor de todos los productos
		double valorIVA=0;
		
		do {
			
			//Valor del producto
			precioProducto=Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio producto "+contador+" :"));
			
			//En la lista se añadirá el valor del producto
			listaCompra.add(precioProducto);
			sumaPrecios+=precioProducto;
			 contador++; 
			
			 //El ciclo llegara hasta que se cumpla esta condicion
		}while(contador<=cantidadProductos);
		
		
		porcentajeIVA=JOptionPane.showInputDialog("Indique porcentaje del IVA (21% O 4%):");
		
		//IVA aplicado 21% o 4%
		if(porcentajeIVA.equals("21%")) {
			valorIVA=sumaPrecios*0.21;
			
			System.out.println(valorIVA );
		}else if(porcentajeIVA.equals("4%")) {
			valorIVA=sumaPrecios*0.4;
		}
		
		precioIVA=sumaPrecios+valorIVA;
		double cantidadPaga=Double.parseDouble(JOptionPane.showInputDialog("Cantidad pagada:"));
	
		int contador2=0;
		
		do {
			if(cantidadPaga>=precioIVA) {
				
				devuelta=cantidadPaga-precioIVA;
				//Precio total productos, precio mas el IVA, cantidad productos
				JOptionPane.showMessageDialog(null,"•Valor IVA: "+valorIVA+"\n•Precio total bruto: "+sumaPrecios
						+"\n•Precio mas el IVA: €"+precioIVA+"\n•Cantidad Productos: "
						+cantidadProductos+"\n•Cantidad recibida: €"+cantidadPaga+"\n•Cantidad devuelta: €"+devuelta); 
				
				contador2++;
				
			}else {
				JOptionPane.showMessageDialog(null,"La cantidad no es suficiente para cubrir el costo de los productos");
			}
			
			
		}while(contador2<1);
		
		
		System.out.println(listaCompra.toString());
	}
	
	
}
