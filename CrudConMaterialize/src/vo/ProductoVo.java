package vo;

public class ProductoVo {
	
	private String ID;
	private String nombre;
	private String descripcion;
	private String tipo;
	private double precio;
	private boolean editar;
	
	public ProductoVo(){
		
	}
	
	public ProductoVo(String ID, String nombre, String descripcion, String tipo, double precio, boolean editar) {
		super();
		this.ID = ID;
		this.nombre = nombre;
		this.descripcion= descripcion;
		this.tipo = tipo;
		this.precio = precio;
		this.editar = editar;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) { 
		this.ID = ID; 
	}
	
	public boolean isEditar() {
		return editar;	
	}
	public void setEditar(boolean editar) {	
		this.editar = editar;
	}
		
	public String getNombre() { 
		return nombre; 
	}
	public void setNombre(String nombre) {	
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getPrecio() { 
		return precio; 
	}
	public void setPrecio(double precio) {
		this.precio = precio;	
	}
	
	

}
