package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Actividad;
import modelo.bean.Grupo;
import modelo.bean.Inscripcion;
import modelo.dao.ModeloRecepcion;

/**
 * Servlet implementation class InscribirEnActividad
 */
@WebServlet("/InscribirEnActividad")
public class InscribirEnActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscribirEnActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloRecepcion modRec = new ModeloRecepcion();
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		
		try {
			grupos=modRec.getGrupos();
			actividades=modRec.getActividades();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("dni", request.getParameter("dni"));
		request.setAttribute("grupos", grupos);
		request.setAttribute("actividades", actividades);
		
		
		request.getRequestDispatcher("InscribirClienteForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		ModeloRecepcion modRec = new ModeloRecepcion();
		
		Inscripcion inscripcion = new Inscripcion();
		
		try {
			inscripcion.setCliente(modRec.getCliente(request.getParameter("dni")));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			inscripcion.setActividad(modRec.getActividadPorGrupo(request.getParameter("actividad")));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			inscripcion.setGrupo(modRec.getGrupo(request.getParameter("actividad")));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			modRec.crearInscripcion(inscripcion);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
