package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;

import vo.ProductoVo;

public class ProductoDao {
	
	public String agregarProducto(ProductoVo miProducto) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "INSERT INTO productos (ID,nombre,descripcion,tipo,precio)"
				+ "  VALUES (?,?,?,?,?)";

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miProducto.getID());
			preStatement.setString(2, miProducto.getNombre());
			preStatement.setString(3, miProducto.getDescripcion());
			preStatement.setString(4, miProducto.getTipo());
			preStatement.setString(5, miProducto.getPrecio()+"");
			preStatement.execute();

			resultado = "Registro Exitoso";

		} catch (SQLException e) {
			System.out.println("No se pudo registra El producto: " + e.getMessage());
			resultado = "No se pudo registrar";
		} finally {
			conexion.desconectar();
		}

		return resultado;
	}
	
	public static  ArrayList<ProductoVo> obtenerListaProductos() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		ProductoVo miProducto = new ProductoVo();
		ArrayList<ProductoVo> listaProductos = null;

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM productos ";

		try {
			if (connection != null) {
				listaProductos = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				while (result.next() == true) {
					miProducto = new ProductoVo();
					miProducto.setID(result.getString("ID"));
					miProducto.setNombre(result.getString("nombre"));
					miProducto.setDescripcion(result.getString("descripcion"));
					miProducto.setTipo(result.getString("tipo"));
					miProducto.setPrecio(Double.parseDouble(result.getString("Precio")));
					listaProductos.add(miProducto);
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del Producto: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaProductos;
	}
	
	public String editarProducto(ProductoVo Producto) {
		String resultado = "";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();
		try {
			String consulta = "UPDATE productos "
					+ " SET nombre = ? , descripcion=? , tipo=? , precio=? "
					+ " WHERE ID= ? ";
			PreparedStatement preStatement = connection.prepareStatement(consulta);

			preStatement.setString(1, Producto.getNombre());
			preStatement.setString(2, Producto.getDescripcion());
			preStatement.setString(3, Producto.getTipo());
			preStatement.setString(4, Producto.getPrecio() + "");
			preStatement.setString(5, Producto.getID());
			preStatement.executeUpdate();

			resultado = "Se ha Actualizado el Producto satisfactoriamente";

			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "No se pudo actualizar el producto";
		}
		return resultado;
	}
	
	public String eliminarProducto(ProductoVo Producto) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();

		String resp = "";
		try {
			String sentencia = "DELETE FROM productos WHERE ID= ? ";

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.setString(1, Producto.getID());

			statement.executeUpdate();

			resp = "Se ha eliminado exitosamente";
			statement.close();
			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resp = "No se pudo eliminar";
		}
		return resp;
	}
	
	public ProductoVo consultarProductoIndividual(String ID) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		ProductoVo miProducto = null;
		System.out.println("ID: "+ID);

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM productos where ID = "+ID;

		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				if (result.next() == true) {
					miProducto = new ProductoVo();
					miProducto.setID(result.getString("ID"));
					miProducto.setNombre(result.getString("nombre"));
					miProducto.setDescripcion(result.getString("descripcion"));
					miProducto.setTipo(result.getString("tipo"));
					miProducto.setPrecio(Double.parseDouble(result.getString("precio")));
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del Producto: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return miProducto;
	}

	public String obtenerListaProductos(ProductoVo miProductoVo) {
		return null;
	}

}
