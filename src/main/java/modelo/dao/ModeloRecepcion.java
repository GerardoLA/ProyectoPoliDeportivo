package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Actividad;
import modelo.bean.Alquiler;
import modelo.bean.Cliente;
import modelo.bean.Grupo;
import modelo.bean.Inscripcion;
import modelo.bean.Sala;

public class ModeloRecepcion extends Conector{
	
	PreparedStatement pst;
	
	public boolean crearCliente(Cliente cliente) throws ClassNotFoundException {
		
		try {
			conectar();

			pst = getCon().prepareStatement("INSERT INTO clientes VALUES(?,?,?,?,?,CURRENT_DATE)");
			pst.setString(1, cliente.getDni());
			pst.setString(2, cliente.getNombre());
			pst.setString(3, cliente.getApellido());
			pst.setString(4, cliente.getTelefono());
			pst.setString(5, cliente.getMail());
			pst.execute();
			getCon().close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}

	public boolean eliminarCliente(String dni) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("DELETE FROM clientes where dni=?");
			pst.setString(1, dni);
			pst.execute();
			getCon().close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}
	
	public boolean modificarCliente(Cliente cliente) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("UPDATE clientes SET nombre=?,apellido=?,telefono=?,mail=?, antiguedad=? where dni=?");
			
			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getApellido());
			pst.setString(3, cliente.getTelefono());
			pst.setString(4, cliente.getMail());
			pst.setDate(5, new Date(cliente.getAntiguedad().getTime()));
			pst.setString(6, cliente.getDni());
			
			pst.execute();
			getCon().close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}			
	}
	
	public Cliente getCliente(String dni) throws ClassNotFoundException {
		Cliente cliente = new Cliente();
		
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM clientes WHERE dni=?");
			pst.setString(1, dni);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			
			cliente.setDni(resultado.getString("dni"));
			cliente.setNombre(resultado.getString("nombre"));
			cliente.setApellido(resultado.getString("apellido"));
			cliente.setTelefono(resultado.getString("telefono"));
			cliente.setMail(resultado.getString("mail"));
			cliente.setAntiguedad(resultado.getDate("antiguedad"));
			
			getCon().close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return cliente;
	}
	
	public ArrayList<Cliente>getClientes() throws ClassNotFoundException{
		ArrayList<Cliente>clientes = new ArrayList<>();
		
		try {
			conectar();
			
			pst = getCon().prepareStatement("SELECT * FROM clientes");
			
			
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next()) {
				Cliente cliente = new Cliente();
				cliente.setDni(resultado.getString("dni"));
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setApellido(resultado.getString("apellido"));
				cliente.setTelefono(resultado.getString("telefono"));
				cliente.setMail(resultado.getString("mail"));
				cliente.setAntiguedad(resultado.getDate("antiguedad"));
				
				clientes.add(cliente);
				
			}
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clientes;
	}
	

	
	public boolean crearInscripcion(Inscripcion inscripcion) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("INSERT INTO inscripciones VALUES (?,?,CURRENT_DATE,?)");
			pst.setString(1,inscripcion.getCliente().getDni());
			pst.setString(2,inscripcion.getActividad().getId_actividad());
			pst.setInt(4, inscripcion.getGrupo().getId_grupo());
			
			
			pst.execute();
			getCon().close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}
	
	public boolean eliminarDeActividad(String dni,String id_grupo) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("DELETE FROM inscripciones WHERE dni=? and id_grupo=?");
			pst.setString(1, dni);
			pst.setString(2, id_grupo);
			
			
			pst.execute();
			getCon().close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean realizarReservaPista(Alquiler alquiler) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("INSERT INTO alquileres VALUES (?,?,CURRENT_DATE,?)");
			pst.setString(1, alquiler.getCliente().getDni());
			pst.setInt(2, alquiler.getSala().getId_sala());
			pst.setString(4, alquiler.getHora());
			
			
			pst.execute();
			getCon().close();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}			
	}
	
	public boolean cancelarReservaPista(String dni,int id_sala) throws ClassNotFoundException {
		
		try {
			conectar();

			pst = getCon().prepareStatement("DELETE from alquileres where dni_cliente=? and id_sala=?");
			pst.setString(1, dni);
			pst.setInt(2, id_sala);
			
			pst.execute();
			getCon().close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}
	
	public Actividad getActividad(String id_actividad) throws ClassNotFoundException {
		Actividad actividad = new Actividad();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM actividades WHERE id_actividad=?");
			pst.setString(1, id_actividad);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			actividad.setId(resultado.getString("id_actividad"));
			actividad.setNombreActividad(resultado.getString("nombreActividad"));
			actividad.setPrecio(resultado.getInt("precio"));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actividad;
	}
	
	public Actividad getActividadPorGrupo(String id_grupo) throws ClassNotFoundException {
		Actividad actividad = new Actividad();
		try {
			conectar();

			
			PreparedStatement pt = getCon().prepareStatement("SELECT id_actividad FROM grupos WHERE id_grupo=?");
			pt.setString(1, id_grupo);
			
			
			ResultSet result = pt.executeQuery();
			result.next();
			String id_actividad= result.getString("id_activdad");
			getCon().close();
			
			pst = getCon().prepareStatement("SELECT* FROM actividades WHERE id_actividad=?");
			pst.setString(1, id_actividad);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			actividad.setId(resultado.getString("id_actividad"));
			actividad.setNombreActividad(resultado.getString("nombreActividad"));
			actividad.setPrecio(resultado.getInt("precio"));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actividad;
	}
	
	
	public Inscripcion getInscripcionCliente(String dni) throws ClassNotFoundException {
		Inscripcion inscripcion = new Inscripcion();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM inscripciones WHERE dni=?");
			pst.setString(1,dni);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			inscripcion.setCliente(getCliente(resultado.getString("dni")));
			inscripcion.setActividad(getActividad(resultado.getString("id_actividad")));
			inscripcion.setGrupo(getGrupo(resultado.getString("id_grupo")));
			inscripcion.setFecha(resultado.getDate("fecha"));
			
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inscripcion;
	}
	
	public Inscripcion getInscripcionActividad(String nombreActividad) throws ClassNotFoundException {
		Inscripcion inscripcion = new Inscripcion();
		try {
			conectar();

			
			PreparedStatement pt = getCon().prepareStatement("SELECT id FROM actividades WHERE nombreac=?");
			pt.setString(1, nombreActividad);
			
			
			ResultSet result = pt.executeQuery();
			result.next();
			String id_actividad= result.getString("id");
			getCon().close();
			
			pst = getCon().prepareStatement("SELECT* FROM inscripciones WHERE id_actividad=?");
			pst.setString(1, id_actividad);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			inscripcion.setCliente(getCliente(resultado.getString("dni")));
			inscripcion.setActividad(getActividad(resultado.getString("id_actividad")));
			inscripcion.setGrupo(getGrupo(resultado.getString("id_grupo")));
			inscripcion.setFecha(resultado.getDate("fecha"));
			
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inscripcion;
	}
	
	public ArrayList<Inscripcion>getInscripciones() throws ClassNotFoundException{
		ArrayList<Inscripcion>inscripciones = new ArrayList<>();
		
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT *  FROM inscripciones");
			
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Inscripcion inscripcion = new Inscripcion();
				inscripcion.setCliente(getCliente(resultado.getString("dni")));
				inscripcion.setActividad(getActividad(resultado.getString("id_actividad")));
				inscripcion.setGrupo(getGrupo(resultado.getString("id_grupo")));
				inscripcion.setFecha(resultado.getDate("fecha"));
				
				inscripciones.add(inscripcion);
				getCon().close();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inscripciones;
	}
	
	public Sala getSala(int id_sala) throws ClassNotFoundException {
		Sala sala = new Sala();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM salas WHERE id_sala=?");
			pst.setInt(1, id_sala);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			sala.setId_sala(Integer.parseInt(resultado.getString("id_sala")));
			sala.setCodigo(resultado.getString("codigo"));
			
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sala;
	}
	
	public int getIdSala(String codigo) throws ClassNotFoundException {
		int id_sala=0;
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT id FROM salas WHERE codigo=?");
			pst.setString(1, codigo);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			id_sala=(Integer.parseInt(resultado.getString("id_sala")));
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id_sala;
	}
	
	public ArrayList<Sala> getSalas() throws ClassNotFoundException {
		ArrayList<Sala> salas = new ArrayList<Sala>();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM salas ");
			
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Sala sala = new Sala();
				
				sala.setId_sala(Integer.parseInt(resultado.getString("id_sala")));
				sala.setCodigo(resultado.getString("codigo"));
				
				salas.add(sala);
			}
			
			
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salas;
	}
	
	public Alquiler getAlquiler(String dni_cliente,int id_sala) throws ClassNotFoundException {
		Alquiler alquiler = new Alquiler();
		
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM alquileres WHERE dni_cliente=? AND id_sala=?");
			pst.setString(1, dni_cliente);
			pst.setInt(2, id_sala);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			alquiler.setCliente(getCliente(resultado.getString("dni")));
			alquiler.setSala(getSala(Integer.parseInt(resultado.getString("id_sala"))));
			alquiler.setFecha(resultado.getDate("fecha"));
			alquiler.setHora(resultado.getString("hora"));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alquiler;
	}
	
	public Alquiler getAlquilerSala(int id_sala) throws ClassNotFoundException {
		Alquiler alquiler = new Alquiler();
		
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM alquileres WHERE id_sala=?");
			pst.setInt(1, id_sala);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			alquiler.setCliente(getCliente(resultado.getString("dni")));
			alquiler.setSala(getSala(Integer.parseInt(resultado.getString("id_sala"))));
			alquiler.setFecha(resultado.getDate("fecha"));
			alquiler.setHora(resultado.getString("hora"));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alquiler;
	}
	
	public Alquiler getAlquilerCliente(String dni_cliente) throws ClassNotFoundException {
		Alquiler alquiler = new Alquiler();
		
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM alquileres WHERE dni_cliente=? ");
			pst.setString(1, dni_cliente);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			alquiler.setCliente(getCliente(resultado.getString("dni")));
			alquiler.setSala(getSala(Integer.parseInt(resultado.getString("id_sala"))));
			alquiler.setFecha(resultado.getDate("fecha"));
			alquiler.setHora(resultado.getString("hora"));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alquiler;
	}
	
	public ArrayList<Alquiler>getAlquileres() throws ClassNotFoundException{
		ArrayList<Alquiler>alquileres = new ArrayList<>();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT*  FROM alquileres");
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Alquiler alquiler = new Alquiler();
				alquiler.setCliente(getCliente(resultado.getString("dni")));
				alquiler.setSala(getSala(Integer.parseInt(resultado.getString("id_sala"))));
				alquiler.setFecha(resultado.getDate("fecha"));
				alquiler.setHora(resultado.getString("hora"));
				
				alquileres.add(alquiler);
				getCon().close();
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return alquileres;
	}
	
	public Grupo getGrupo (String id_grupo) throws ClassNotFoundException {
		Grupo grupo = new Grupo();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM  grupos WHERE id_grupo=?");
			pst.setString(1, id_grupo);
			
			ResultSet resultado = pst.executeQuery();
			grupo.setId_grupo(resultado.getInt("id_grupo"));
			grupo.setDias(resultado.getString("dias"));
			grupo.setHorarios(resultado.getString("horario"));
			grupo.setMaxPartic(resultado.getInt("maxpartic"));
			grupo.setNumPartic(resultado.getInt("numpartic"));
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grupo;
	}
	
	
	public ArrayList<Grupo>getGrupos(String id_actividad) throws ClassNotFoundException{
		ArrayList<Grupo>grupos = new ArrayList<>();

		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM grupos WHERE id_actividad=?");
			pst.setString(1, id_actividad);
			
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Grupo grupo= new Grupo();
				grupo.setId_grupo(resultado.getInt("id_grupo"));
				grupo.setDias(resultado.getString("dias"));
				grupo.setHorarios(resultado.getString("horarios"));
				grupo.setMaxPartic(resultado.getInt("maxpartic"));
				grupo.setNumPartic(resultado.getInt("numpartic"));
				grupos.add(grupo);
				getCon().close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grupos;
	}
	
	public ArrayList<Grupo>getGrupos() throws ClassNotFoundException{
		ArrayList<Grupo>grupos = new ArrayList<>();

		try {
			conectar();

			pst = getCon().prepareStatement("SELECT * FROM grupos");
			
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Grupo grupo= new Grupo();
				grupo.setId_grupo(resultado.getInt("id_grupo"));
				grupo.setDias(resultado.getString("dias"));
				grupo.setHorarios(resultado.getString("horarios"));
				grupo.setMaxPartic(resultado.getInt("maxpartic"));
				grupo.setNumPartic(resultado.getInt("numpartic"));
				grupos.add(grupo);
				getCon().close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grupos;
	}
	
	public ArrayList<Actividad> getActividades() throws ClassNotFoundException {
		ArrayList<Actividad> actividades=new ArrayList<Actividad>();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT * FROM actividades");
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Actividad actividad = new Actividad();
				
				actividad.setId(resultado.getString("id_actividad"));
				actividad.setNombreActividad(resultado.getString("nombreActividad"));
				actividad.setPrecio(resultado.getInt("precio"));
				
				actividades.add(actividad);
			}
			
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actividades;
	}

	public String getIdActividad(String id_grupo) throws SQLException, ClassNotFoundException {
		String id_actividad="";

		conectar();

		
		pst=getCon().prepareStatement("SELECT id_actividad FROM inscripciones WHERE id_grupo=?");
		
		pst.setString(1, id_grupo);
		
		try {
			
			ResultSet result=pst.executeQuery();
			result.next();
			id_actividad=result.getString("id_actividad");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id_actividad;
	}
}	
	


