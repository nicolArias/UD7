package actividades;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Punto3 {
	/*3) Crea una base de datos de 10 artículos para controlar el stock de productos de una tienda por medio de un diccionario
		de datos (articulo:cantidad). El usuario podrá añadir, por medio de interfaz visual artículos nuevos y cantidades de estos. El
		usario podrá consultar la información almacenada en el diccionario referente a un articulo concreto e incluso listar toda
		la información en la terminal del programa.
	*/
	
	//DICCIONARIO DE DATOS DONDE SE ALMACENARÁN LOS PRODUCTOS
	private Hashtable<String,Integer> inventario=new Hashtable<String,Integer>();
	
	//CONSTRUCTOR
	public Punto3() {
		//BD 10 ARTICULOS
				inventario.put("Chocolate Milka",1);
				inventario.put("Coca Cola",2);
				inventario.put("Colgate White",3);
				inventario.put("Crema Pond's",1);
				inventario.put("Pistachos",10);
				inventario.put("Nuez",5);
				inventario.put("Frutos Rojos",8);
				inventario.put("Bananos",9);
				inventario.put("Coco",20);
				inventario.put("Aguacate",15);
	}
	
	//MÉTODO  GET Y SET
	public  Hashtable<String, Integer> getInventario() {
		return inventario;
	}
	public void setInventario(Hashtable<String, Integer> inventario) {
		this.inventario = inventario;
	}
	
	
	public static void stockProductos() {
		int cont=0;
		Punto3 obj=new Punto3();
		obj.menu();
		
	}

	public void menu() {
		
		try {
			String opcion=JOptionPane.showInputDialog("Elija acción a realizar:"
					+ "\n1. Añadir producto"
					+ "\n2. Consultar inventario"
					+ "\n3. Consulta por producto");
			
			//Menú de opciones
			if(opcion.equals("1")) {
				agregarProducto();
			}else if(opcion.equals("2")) {
				allInventario();
			}else if(opcion.equals("3")) {
				prodInventario();
			}else {
				System.out.println("No selecciono ninguna opción");
			}
		}catch(NullPointerException e) {
			System.out.println("Salio de la aplicación");
		}
		
	}
	
	
	public void agregarProducto() {
		
		Hashtable<String,Integer> inv2=inventario;
		
		Enumeration<Integer> enumeration=inv2.elements();
		
		String newProducto=JOptionPane.showInputDialog("Nombre producto:");
		int cantProducto=Integer.parseInt(JOptionPane.showInputDialog("Cantidad Producto:"));
		
		
		
		//NOTA: SE ME ESTA GENERANDO UN CICLO INFINITO, MEJORAR 
		while(enumeration.hasMoreElements()) {
	
			
			//Esta condicion valida si el producto que ingresamos esta en el diccionario para sumar la cantidad que agregamos con la que ya estaba
			if(inventario.containsKey(newProducto)) {
				//Extrae el valor (en este caso un entero) que se encuentra en la llave que ingresamos por teclado
				int cant=inventario.get(newProducto);
				//Sumamos la cantidad que habia con la que ingresamos
				int sumaCantidad=cant+cantProducto;
				inv2.remove(newProducto);
				inv2.put(newProducto,sumaCantidad);
				//setInventario(inv2);
				break;
			}else {
				inv2.put(newProducto, cantProducto);
				break;
			}
		}
	
		menu();
	}
	
	public void allInventario() {
		Enumeration enumeration=getInventario().elements();
		Enumeration llaves=getInventario().keys();
		String  lista="";
		
		while(enumeration.hasMoreElements()) {
			lista+="\n\nProducto: "+llaves.nextElement()+"\nCantidad: "+enumeration.nextElement();
		}
		
		JOptionPane.showMessageDialog(null, lista);
		menu();
	}
	
	public void prodInventario() {
		Enumeration enumeration=getInventario().elements();
		Enumeration llaves=getInventario().keys();
		
		String articulo=JOptionPane.showInputDialog("Ingrese el nombre del producto a consultar:");
		String cadena="";
		while(enumeration.hasMoreElements()) {
			
			if(getInventario().containsKey(articulo)) {
				
				cadena="Producto: "+articulo+"\nCantidad: "+Integer.toString(getInventario().get(articulo));
			
				break;
			}else {
				
				cadena="El artículo ingresado no se encuentra en la bd.";
			}
		}
		
		JOptionPane.showMessageDialog(null, cadena);
		menu();
	}
}
