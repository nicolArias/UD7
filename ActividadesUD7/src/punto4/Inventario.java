package punto4;

import java.util.Hashtable;

public class Inventario {
	
	protected Hashtable<String,Integer> inventario=new Hashtable<String,Integer>();

	//CONSTRUCTOR POR DEFECTO
	public Inventario() {
		this.inventario.put("chocolate milka",200);
		this.inventario.put("coca cola",200);
		this.inventario.put("colgate chite",200);
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
	
	
	
}
