package bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import dao.PersonaDao;
import dao.ProductoDao;
import vo.ProductoVo;

@ManagedBean
@ViewScoped
public class ProductoBean {
	
	private ProductoVo miProductoVo;
	ProductoDao miProductoDao;
	private String mensaje;
	private String navegacion;
	private ArrayList<ProductoVo> listaPersona=new ArrayList<>();
	
	public ProductoBean() {
		miProductoVo = new ProductoVo();
		miProductoDao = new ProductoDao();
	}

	public void cargarPersonas(){
		listaPersona.clear();
		listaPersona=ProductoDao.obtenerListaProductos();
		if (listaPersona==null) {
		
		}
		}
	
	public void registrarProducto() {
		System.out.println("Registro de Producto");
		mensaje=miProductoDao.agregarProducto(miProductoVo);
		if (mensaje.equalsIgnoreCase("Registro Exitoso")) {
			mensaje="Se ha registrado exitosamente!";	
		}else{
			mensaje="Ocurrió un problema al registrar, verifique nuevamente";	
		}
	}
	
	public void consultarProducto() {
		System.out.println("Consulta de Producto: "+miProductoVo.getID());
		miProductoVo=miProductoDao.consultarProductoIndividual(miProductoVo.getID());
		if (miProductoVo!=null) {
			setMensaje("");
		}else{
			setMensaje("No se encuentra el Producto");
			miProductoVo=new ProductoVo();
		}
	}
	
	public void actualizarProducto(){
		System.out.println("Actualizar Producto");
		setMensaje(miProductoDao.editarProducto(miProductoVo));
	}
	
	public void eliminarProducto(){
		System.out.println("Eliminar Producto");
		setMensaje(miProductoDao.eliminarProducto(miProductoVo));
		miProductoVo=new ProductoVo();
	}
	
	public void listaProductos(){
		System.out.println("Lista De Productos");
		setMensaje(""+miProductoDao.obtenerListaProductos(miProductoVo));
	}

	public ProductoVo getMiProductoVo() {
		return miProductoVo;
	}

	public void setMiProductoVo(ProductoVo miProductoVo) {
		this.miProductoVo = miProductoVo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getNavegacion() {
		return navegacion;
	}

	public void setNavegacion(String navegacion) {
		this.navegacion = navegacion;
	}

}
