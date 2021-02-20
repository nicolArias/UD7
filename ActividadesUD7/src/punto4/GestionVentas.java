package punto4;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class GestionVentas {

	Inventario inventario=new Inventario();
		
	public void gestionVentas() {
		menu();
		
	}
	
	public void menu() {
		
		try {
		String opcion=JOptionPane.showInputDialog("Elija acción a realizar:"
				+ "\n1.Venta Producto"
				+ "\n2. Añadir producto"
				+ "\n3. Consultar inventario"
				+ "\n4. Consulta por producto");
		
		//Menú de opciones
		if(opcion.equals("1")) {
			validarProducto();
		}else if(opcion.equals("2")) {
			inventario.agregarProducto();
		}else if(opcion.equals("3")) {
			System.out.println(inventario.allInventario());
			menu();
		}else if(opcion.equals("4")) {
			System.out.println(inventario.prodInventario());
			menu();
		}else {
		System.out.println("No selecciono ninguna opción");
		}
		}catch(NullPointerException e) {
			System.out.println("Salio de la aplicación");
		}

	}
	
	public void validarProducto() {
		Hashtable<String,Integer> inv=inventario.getInventario();
		Enumeration<String> llaves=inv.keys();
		
		Enumeration<Integer> enumeration=inv.elements();
		String nombreProd=JOptionPane.showInputDialog("Ingrese nombre producto");
		int cantProducto=Integer.parseInt(JOptionPane.showInputDialog("Cantidad Producto:"));
		
		while(llaves.hasMoreElements()) {
			
			//Esta condicion valida si el producto que ingresamos esta en el diccionario para restar la cantidad que agregamos con la que ya estaba
			if(inv.containsKey(nombreProd) && cantProducto<enumeration.nextElement()) {
				//Extrae el valor (en este caso un entero) que se encuentra en la llave que ingresamos por teclado
				int cant=inv.get(nombreProd);
				//Restamos la cantidad que habia con la que ingresamos
				int restInventario=cant-cantProducto;
				inv.remove(nombreProd);
				inv.put(nombreProd,restInventario);
				inventario.setInventario(inv);
				ventaProd(cantProducto);
				break;
			}else {
				JOptionPane.showMessageDialog(null, "El producto que desea comprar no se encuentra en Stock");
				menu();
				break;
			}
		}	
	}
	
	public void ventaProd(int cantidad) {
		
		ArrayList<Double> listaCompra=new ArrayList<>();
		
		double precioProducto;
		int cant=cantidad;
		double sumaPrecios=0;//Sumara el valor de todos los productos

		
		//Valor del producto
		precioProducto=Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio del producto:"));
			
		//En la lista se añadirá el valor del producto
		listaCompra.add(precioProducto);
		sumaPrecios+=precioProducto*cantidad;
		
		String addProd=JOptionPane.showInputDialog("Desea comprar otro producto: SI/NO");
		if(addProd.equalsIgnoreCase("SI")) {
			validarProducto();
		}else {
			calculos(sumaPrecios,cantidad);
			
		}

	}	
		
	public void calculos(double sumPrecios,int cantidad) {	
		
		String porcentajeIVA="";
		double precioIVA;//Aqui se sumara el valor del IVA al precio
		double devuelta,valorIVA=0;
		
		porcentajeIVA=JOptionPane.showInputDialog("Indique porcentaje del IVA (21% O 4%):");
		
		//IVA aplicado 21% o 4%
		if(porcentajeIVA.equals("21%")) {
			valorIVA=sumPrecios*0.21;
			
			System.out.println(valorIVA );
		}else if(porcentajeIVA.equals("4%")) {
			valorIVA=sumPrecios*0.4;
		}
		
		precioIVA=sumPrecios+valorIVA;
		
		double cantidadPaga=Double.parseDouble(JOptionPane.showInputDialog("Cantidad pagada:"));
	
		int contador2=0;
		
		do {
			if(cantidadPaga>=precioIVA) {
				
				devuelta=cantidadPaga-precioIVA;
				//Precio total productos, precio mas el IVA, cantidad productos
				JOptionPane.showMessageDialog(null,"•Valor IVA: "+valorIVA+"\n•Precio total bruto: "+sumPrecios
						+"\n•Precio mas el IVA: €"+precioIVA+"\n•Cantidad Productos: "
						+cantidad+"\n•Cantidad recibida: €"+cantidadPaga+"\n•Cantidad devuelta: €"+devuelta); 
				
				contador2++;
				
			}else {
				JOptionPane.showMessageDialog(null,"La cantidad no es suficiente para cubrir el costo de los productos");
			}
			
			
		}while(contador2<1);
		menu();
	
	}
	
	
	
		


}
