package punto4;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Inventario {
	
	protected Hashtable<String,Integer> inventario=new Hashtable<String,Integer>();

	//CONSTRUCTOR POR DEFECTO
	public Inventario() {
		this.inventario.put("chocolate milka",200);
		this.inventario.put("coca cola",200);
		this.inventario.put("colgate white",200);
		this.inventario.put("crema conds",200);
		this.inventario.put("pistachos",200);
		this.inventario.put("nuez",200);
		this.inventario.put("frutos Rojos",200);
		this.inventario.put("bananos",200);
		this.inventario.put("coco",200);
		this.inventario.put("aguacate",200);
		this.inventario.put("lapiz",150);
		this.inventario.put("libreta",200);
		this.inventario.put("arroz",200);
		this.inventario.put("pipas",200);
		this.inventario.put("agua",180);
		this.inventario.put("manzana",290);
		this.inventario.put("leche",200);
		this.inventario.put("zumo",400);
		this.inventario.put("pan",200);
		this.inventario.put("pollo",200);	
	}
	
	public Inventario(Hashtable<String,Integer> inv) {
		this.inventario=inv;
	}

	//MÉTODOS GET Y SET
	public Hashtable<String, Integer> getInventario() {
		return inventario;
	}

	public void setInventario(Hashtable<String, Integer> inventario) {
		this.inventario = inventario;
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
	
		
	}
	
	public String allInventario() {
		Enumeration enumeration=getInventario().elements();
		Enumeration llaves=getInventario().keys();
		String  lista="";
		
		while(enumeration.hasMoreElements()) {
			lista+="\n\nProducto: "+llaves.nextElement()+"\nCantidad: "+enumeration.nextElement();
		}
		
		return lista;
	}
	
	public String prodInventario() {
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
		
		return cadena;
	}
	
}
