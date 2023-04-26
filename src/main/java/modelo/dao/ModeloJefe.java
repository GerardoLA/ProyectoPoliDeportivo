package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Date;

import modelo.Conector;
import modelo.bean.Empleado;
import modelo.bean.Monitor;
import modelo.bean.Recepcionista;
import modelo.bean.TecnicoMantenimiento;
import modelo.bean.Trabajo;
import modelo.bean.Usuario;

public class ModeloJefe extends Conector{	
	PreparedStatement pst;
	
	public boolean altaEmpleado(Empleado empleado) throws ClassNotFoundException {
		try {
			conectar();
			pst = getCon().prepareStatement("INSERT INTO empleados (nombre, apellido, dni, edad, antiguedad, id_jefe, id_usuario, id_trabajo)VALUES(?,?,?,?,CURRENT_DATE,?,?,?)");
			pst.setString(1, empleado.getNombre());
			pst.setString(2, empleado.getApellido());
			pst.setString(3, empleado.getDni());
			pst.setInt(4, empleado.getEdad());
			pst.setInt(5, empleado.getId_jefe());
			pst.setString(6, empleado.getUsuario().getId_usuario());
			pst.setInt(7, empleado.getTrabajo().getId_trabajo());
			
			
			pst.execute();
			getCon().close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
}
	
	public boolean bajaempleado(int id_empleado) throws ClassNotFoundException {
		try {
			conectar();
			pst = getCon().prepareStatement("DELETE FROM empleados where id=?");
			pst.setInt(1, id_empleado);
			pst.execute();
			getCon().close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean modificarDatosEmpleado(Empleado empleado) throws ClassNotFoundException {
		try {
			conectar();
			pst = getCon().prepareStatement("UPDATE empleados SET nombre=?,apellido=?, dni=?,edad=?, antiguedad=?, id_jefe=?, id_usuario=?,id_trabajo=? where id_empleado=?");
			pst.setString(1, empleado.getNombre());
			pst.setString(2, empleado.getApellido());
			pst.setString(3, empleado.getDni());
			pst.setInt(4, empleado.getEdad());
			pst.setDate(5, new Date(empleado.getAntiguedad().getTime()));
			pst.setInt(6, empleado.getId_jefe());
			pst.setString(7, empleado .getUsuario().getId_usuario());
			pst.setInt(8, empleado.getTrabajo().getId_trabajo());
			pst.setInt(9, empleado.getId_empleado());
			
			
			pst.execute();
			getCon().close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	
	public Empleado getEmpleado(String dni) throws ClassNotFoundException {
		Empleado empleado = new Empleado();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* from empleados where dni=?");
			pst.setString(1, dni);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			
			empleado.setId_empleado(resultado.getInt("id_empleado"));
			empleado.setNombre(resultado.getString("nombre"));
			empleado.setApellido(resultado.getString("apellido"));
			empleado.setDni(resultado.getString("dni"));
			empleado.setEdad(resultado.getInt("edad"));
			empleado.setAntiguedad(resultado.getDate("antiguedad"));
			empleado.setId_jefe(resultado.getInt("id_jefe"));
			empleado.setUsuario(getUsuario(resultado.getString("id_usuario")));
			empleado.setTrabajo(getTrabajo(resultado.getInt("id_trabajo")));
			
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return empleado;
	}
	
	public Empleado getEmpleado(int id_empleado) throws ClassNotFoundException {
		Empleado empleado = new Empleado();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* from empleados where id_empleado=?");
			pst.setInt(1, id_empleado);
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			
			empleado.setId_empleado(resultado.getInt("id_empleado"));
			empleado.setNombre(resultado.getString("nombre"));
			empleado.setApellido(resultado.getString("apellido"));
			empleado.setDni(resultado.getString("dni"));
			empleado.setEdad(resultado.getInt("edad"));
			empleado.setAntiguedad(resultado.getDate("antiguedad"));
			empleado.setId_jefe(resultado.getInt("id_jefe"));
			empleado.setUsuario(getUsuario(resultado.getString("id_usuario")));
			empleado.setTrabajo(getTrabajo(resultado.getInt("id_trabajo"))); 
			
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empleado;
	}
	
	public ArrayList<Empleado> getEmpleados() throws ClassNotFoundException{
		ArrayList<Empleado>empleados= new ArrayList<>();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT * FROM empleados");
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Empleado empleado = new Empleado();
				empleado.setId_empleado(resultado.getInt("id"));
				empleado.setNombre(resultado.getString("nombre"));
				empleado.setApellido(resultado.getString("apellido"));
				empleado.setDni(resultado.getString("dni"));
				empleado.setEdad(resultado.getInt("edad"));
				empleado.setAntiguedad(resultado.getDate("antiguedad"));
				empleado.setId_jefe(resultado.getInt("id_jefe"));
				empleado.setUsuario(getUsuario(resultado.getString("id_usuario")));
				empleado.setTrabajo(getTrabajo(resultado.getInt("id_trabajo")));
				 
				empleados.add(empleado);
			}
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empleados;
	}
	
	public boolean AltaUsuario(Usuario usuario) throws ClassNotFoundException {
		try {
			conectar();
			pst = getCon().prepareStatement("INSERT INTO usuarios (nombre,contrasena) VALUES  (?,?)");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getContrasena());
			
			
			pst.execute();
			getCon().close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public Usuario getUsuario(String id_usuario) throws ClassNotFoundException {
		Usuario usuario = new Usuario();
		 try {
			 conectar();
			 
			pst = getCon().prepareStatement("SELECT* from usuarios where id=?");
			pst.setString(1, id_usuario);
			
			ResultSet resultado = pst.executeQuery();
			
			resultado.next();
			usuario.setId_usuario(resultado.getString("id"));
			usuario.setNombre(resultado.getString("nombre"));
			usuario.setContrasena(resultado.getString("contrasena"));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public ArrayList<Usuario>getUsuarios() throws ClassNotFoundException{
		ArrayList<Usuario>usuarios = new ArrayList<>();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT * FROM  usuarios");
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId_usuario(resultado.getString("id_usuario"));
				usuario.setNombre(resultado.getString("nombre"));
				usuario.setContrasena(resultado.getString("contrasena"));
				
				usuarios.add(usuario);
				
			}
			getCon().close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return usuarios;
	}
	public Trabajo getTrabajo(int id_trabajo) throws ClassNotFoundException {
		Trabajo trabajo = new Trabajo();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* FROM  trabajos where id =?");
			pst.setInt(1, id_trabajo);
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trabajo;	
	}
	
	public Trabajo getTrabajo(String nombre_trabajo) throws ClassNotFoundException {
		Trabajo trabajo = new Trabajo();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* FROM  trabajos where nombre=?");
			pst.setString(1, nombre_trabajo);
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			
			trabajo.setId_trabajo(resultado.getInt("id"));
			trabajo.setNombre(resultado.getString("nombre"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trabajo;	
	}

	public ArrayList<Trabajo>getTrabajos () throws ClassNotFoundException{
		ArrayList<Trabajo>trabajos=new ArrayList<>();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* from trabajos");
			ResultSet resultado =pst.executeQuery();
			while(resultado.next()) {
				Trabajo trabajo = new Trabajo();
				trabajo.setId_trabajo(resultado.getInt("id"));
				trabajo.setNombre(resultado.getString("nombre"));
				
				trabajos.add(trabajo);
			}
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trabajos;
	}
	
	public Monitor getMonitor(int id_empleado) throws ClassNotFoundException {
		Monitor monitor = new Monitor();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* FROM empleado WHERE id=?");
			pst.setInt(1, id_empleado);
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			
			monitor.setId_empleado(resultado.getInt("id"));
			monitor.setNombre(resultado.getString("nombre"));
			monitor.setApellido(resultado.getString("apellido"));
			monitor.setDni(resultado.getString("dni"));
			monitor.setEdad(resultado.getInt("edad"));
			monitor.setAntiguedad(resultado.getDate("antiguedad"));
			monitor.setId_jefe(resultado.getInt("id_jefe"));
			monitor.setUsuario(getUsuario(resultado.getString("id_usuario")));
			monitor.setTrabajo(getTrabajo(resultado.getInt("id_trabajo")));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return monitor;	
	}
	
	public ArrayList<Monitor>getMonitores() throws ClassNotFoundException{
		ArrayList<Monitor>monitores = new ArrayList<>();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* FROM empleados WHERE id_trabajo=(SELECT id FROM trabajos WHERE nombre='MONITOR'");
			
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next()) {
				Monitor monitor = new Monitor();
				monitor.setId_empleado(resultado.getInt("id"));
				monitor.setNombre(resultado.getString("nombre"));
				monitor.setApellido(resultado.getString("apellido"));
				monitor.setDni(resultado.getString("dni"));
				monitor.setEdad(resultado.getInt("edad"));
				monitor.setAntiguedad(resultado.getDate("antiguedad"));
				monitor.setId_jefe(resultado.getInt("id_jefe"));
				monitor.setUsuario(getUsuario(resultado.getString("id_usuario")));
				monitor.setTrabajo(getTrabajo(resultado.getInt("id_trabajo")));
				
				monitores.add(monitor);
			}
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return monitores;
	}
	
	public Recepcionista getRecepcionista(int id_empleado) throws ClassNotFoundException {
		Recepcionista recepcionista = new Recepcionista();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* FROM empleados where id=?");
			pst.setInt(1, id_empleado);
			
			ResultSet resultado = pst.executeQuery();
			recepcionista.setId_empleado(resultado.getInt("id"));
			recepcionista.setNombre(resultado.getString("nombre"));
			recepcionista.setApellido(resultado.getString("apellido"));
			recepcionista.setDni(resultado.getString("dni"));
			recepcionista.setEdad(resultado.getInt("edad"));
			recepcionista.setAntiguedad(resultado.getDate("antiguedad"));
			recepcionista.setId_jefe(resultado.getInt("id_jefe"));
			recepcionista.setUsuario(getUsuario(resultado.getString("id_usuario")));
			recepcionista.setTrabajo(getTrabajo(resultado.getInt("id_trabajo")));
			getCon().close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recepcionista;	
	}
	
	public ArrayList<Recepcionista>getRecepcionistas() throws ClassNotFoundException{
		ArrayList<Recepcionista>recepcionistas = new ArrayList<>();
		 try {
			 conectar();
			pst = getCon().prepareStatement("SELECT* FROM empleados WHERE id_trabajo=(SELECT id FROM trabajos WHERE nombre='RECEPCIONISTA'");
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Recepcionista recepcionista = new Recepcionista();
				recepcionista.setId_empleado(resultado.getInt("id"));
				recepcionista.setNombre(resultado.getString("nombre"));
				recepcionista.setApellido(resultado.getString("apellido"));
				recepcionista.setDni(resultado.getString("dni"));
				recepcionista.setEdad(resultado.getInt("edad"));
				recepcionista.setAntiguedad(resultado.getDate("antiguedad"));
				recepcionista.setId_jefe(resultado.getInt("id_jefe"));
				recepcionista.setUsuario(getUsuario(resultado.getString("id_usuario")));
				recepcionista.setTrabajo(getTrabajo(resultado.getInt("id_trabajo")));
				
				recepcionistas.add(recepcionista);
			}
			getCon().close();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recepcionistas;
		
	}
	
	public TecnicoMantenimiento getTecnicoMantenimiento(int id_empleado) throws ClassNotFoundException {
		TecnicoMantenimiento tecnicoMantenimiento = new TecnicoMantenimiento();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* FROM empleados WHERE id=?");
			pst.setInt(1, id_empleado);
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			tecnicoMantenimiento.setId_empleado(resultado.getInt("id"));
			tecnicoMantenimiento.setNombre(resultado.getString("nombre"));
			tecnicoMantenimiento.setApellido(resultado.getString("apellido"));
			tecnicoMantenimiento.setDni(resultado.getString("dni"));
			tecnicoMantenimiento.setEdad(resultado.getInt("edad"));
			tecnicoMantenimiento.setAntiguedad(resultado.getDate("edad"));
			tecnicoMantenimiento.setId_jefe(resultado.getInt("id_jefe"));
			tecnicoMantenimiento.setUsuario(getUsuario(resultado.getString("id_usuario")));
			tecnicoMantenimiento.setTrabajo(getTrabajo(resultado.getInt("id_trabajo")));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tecnicoMantenimiento;
	}
	
	public ArrayList<TecnicoMantenimiento>getTecnicosMantenimiento() throws ClassNotFoundException{
		ArrayList<TecnicoMantenimiento>tecnicosMantenimiento = new ArrayList<>();
		
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* FROM Empleados WHERE id_trabajo=(SELECT id FROM trabajos WHERE nombre='MANTENIMIENTO')");
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				TecnicoMantenimiento tecnicoMantenimiento = new TecnicoMantenimiento();
				tecnicoMantenimiento.setId_empleado(resultado.getInt("id"));
				tecnicoMantenimiento.setNombre(resultado.getString("nombre"));
				tecnicoMantenimiento.setApellido(resultado.getString("apellido"));
				tecnicoMantenimiento.setDni(resultado.getString("dni"));
				tecnicoMantenimiento.setEdad(resultado.getInt("edad"));
				tecnicoMantenimiento.setId_jefe(resultado.getInt("id_jefe"));
				tecnicoMantenimiento.setUsuario(getUsuario(resultado.getString("id_usuario")));
				tecnicoMantenimiento.setTrabajo(getTrabajo(resultado.getInt("id_trabajo")));
				
				tecnicosMantenimiento.add(tecnicoMantenimiento);
			}
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tecnicosMantenimiento;
	}
	
}
	

