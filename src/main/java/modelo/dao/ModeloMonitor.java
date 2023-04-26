package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Actividad;
import modelo.bean.Grupo;

public class ModeloMonitor extends Conector{
PreparedStatement pst;	

public boolean insertarActividad(Actividad actividad) throws ClassNotFoundException {
try {
	conectar();

	
	pst = getCon().prepareStatement("INSERT INTO  actividades VALUES (?,?,?)");
	pst.setString(1, actividad.getId_actividad());
	pst.setString(2, actividad.getNombreActividad());
	pst.setDouble(3, actividad.getPrecio());
	
	
	pst.execute();
	getCon().close();
	return true;
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return false;
	}		
}

public boolean eliminarActividad(String id_actividad) throws ClassNotFoundException {
	try {
		conectar();

		pst = getCon().prepareStatement("DELETE FROM actividades WHERE id_actividad=?");
		pst.setString(1, id_actividad);
		
		
		pst.execute();
		getCon().close();
		return true;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}	
}

public boolean modificarActividad(Actividad actividad) throws ClassNotFoundException {
	try {
		conectar();

		pst = getCon().prepareStatement("UPDATE actividades SET nombreActividad=?,precio=? WHERE id_Actividad=?");
		pst.setString(1, actividad.getNombreActividad());
		pst.setDouble(2, actividad.getPrecio());
		pst.setString(3, actividad.getId_actividad());
		
		
		pst.execute();
		getCon().close();
		return true;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}

public boolean insertarGrupo(Grupo grupo) throws ClassNotFoundException {
	try {
		conectar();

		pst = getCon().prepareStatement("INSERT INTO grupos VALUES (?,?,?,?,?)");
		pst.setInt(1, grupo.getId_grupo());
		pst.setString(2, grupo.getDias());
		pst.setString(3, grupo.getHorarios());
		pst.setInt(4, grupo.getMaxPartic());
		pst.setInt(5, grupo.getNumPartic());
		
		
		pst.execute();
		getCon().close();
		return true;
		
	} catch (SQLException e) {
		// TODO 	Auto-generated catch block
		e.printStackTrace();
		return false;
	}	
}

public boolean eliminargrupo(int id_grupo) throws ClassNotFoundException {
	try {
		conectar();

		pst = getCon().prepareStatement("DELETE FROM grupos WHERE id_grupo=?");
		pst.setInt(1, id_grupo);
		
		pst.execute();
		getCon().close();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}	
}

public boolean modificarGrupo(Grupo grupo) throws ClassNotFoundException {
	try {
		conectar();

		pst = getCon().prepareStatement("UPDATE grupos SET  dias=?, horarios=?, maxpartic=?,numpartic=? where id_grupo=?");
		pst.setString(1, grupo.getDias());
		pst.setString(2, grupo.getHorarios());
		pst.setInt(3, grupo.getMaxPartic());
		pst.setInt(4, grupo.getNumPartic());
		pst.setInt(5, grupo.getId_grupo());
		
		
		pst.execute();
		getCon().close();
		return true;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}	
}

	public ArrayList<Actividad>getActividades(int id_empleado) throws ClassNotFoundException{
		ArrayList<Actividad>actividades = new ArrayList<>();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT id_actividad FROM imparten WHERE id_empleado=?");
			pst.setInt(1, id_empleado);
		
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				PreparedStatement pt = getCon().prepareStatement("SELECT* FROM actividades WHERE id_actividad=?");
				pt.setString(1, resultado.getString("id_actividad"));
				ResultSet rs = pt.executeQuery();
			
				rs.next();
			
				Actividad actividad = new Actividad(rs.getString("id_actividad"),rs.getString("nombreActividad"),rs.getDouble("precio"));
				actividades.add(actividad);
				
				}
				getCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return actividades;	
	}
	
	public Actividad getActividad(String id_actividad) throws ClassNotFoundException{
		Actividad actividad=null;
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM actividades WHERE id_actividad=?");
			pst.setString(1, id_actividad);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			
			actividad = new Actividad(resultado.getString("id_actividad"),resultado.getString("nombreActividad"),resultado.getDouble("precio"));
			getCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return actividad;	
	}

	public ArrayList<Grupo>getGrupos(int id_empleado) throws ClassNotFoundException{
		ArrayList<Grupo>grupos = new ArrayList<>();
	
		try {
			conectar();

			pst = getCon().prepareStatement("Select id_grupo FROM imparten WHERE id_empleado=?");
			pst.setInt(1, id_empleado);
		
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				PreparedStatement pt = getCon().prepareStatement("SELECT* FROM grupos WHERE id_grupo=?");
				pt.setString(1, resultado.getString("id_grupo"));
				ResultSet rs = pt.executeQuery();
				rs.next();
				
				Grupo grupo = new Grupo();
				grupo.setId_grupo(rs.getInt("id_grupo"));
				grupo.setDias(rs.getString("dias"));
				grupo.setHorarios(rs.getString("horarios"));
				
				grupos.add(grupo);
				
				
				}
				getCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return grupos;
	}
	
	public Grupo getGrupo(int id_grupo) throws ClassNotFoundException{
		Grupo grupo = new Grupo();
	
		try {
			conectar();

			pst = getCon().prepareStatement("Select * FROM grupos WHERE id_grupo=?");
			pst.setInt(1, id_grupo);
		
			
			ResultSet resultado = pst.executeQuery();
			resultado.next() ;
							
			grupo.setId_grupo(resultado.getInt("id_grupo"));
			grupo.setDias(resultado.getString("dias"));
			grupo.setHorarios(resultado.getString("horarios"));
				
			getCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return grupo;
	}
}
