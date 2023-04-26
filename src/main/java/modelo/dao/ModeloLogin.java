package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Conector;
import modelo.bean.Usuario;

public class ModeloLogin extends Conector {
	 
	PreparedStatement pst ;
	
	public Usuario getContrasena(String nombre) {
		
		Usuario usuario=new Usuario();;
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT * from usuarios where nombre=?");
			pst.setString(1, nombre);
			ResultSet resultado =pst.executeQuery();
			resultado.next();
			usuario.setId_usuario(resultado.getString("id_usuario"));
			usuario.setNombre(resultado.getString("nombre"));
			usuario.setContrasena(resultado.getString("contrasena"));
			
			getCon().close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;	
	}
	
	public Usuario getNombre(String contrasena) throws ClassNotFoundException, SQLException {
		Usuario usuario = new Usuario();
		conectar();
		pst = getCon().prepareStatement("SELECT* from usuarios where contrasena =?");
		pst.setString(1, contrasena);
		ResultSet resultado = pst.executeQuery();
		resultado.next();
		usuario.setNombre(resultado.getString("nombre"));
		usuario.setId_usuario(resultado.getString("id_usuario"));
		usuario.setContrasena(resultado.getString("contrasena"));
		getCon().close();
return usuario;
}
	
	public int getIdEmpleado(String id_usuario) throws ClassNotFoundException, SQLException {
		int id_empleado=0;
		conectar();
		pst = getCon().prepareStatement("SELECT  id from empleados where id_usuario=?");
		pst.setString(1, id_usuario);
		ResultSet resultado = pst.executeQuery();
		resultado.next();
		id_empleado = resultado.getInt("id");
		getCon().close();
		return id_empleado;
	}
	
}
