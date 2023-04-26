package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.bean.Usuario;
import modelo.dao.ModeloLogin;

/**
 * Servlet implementation class Desktop
 */
@WebServlet("/Desktop")
public class Desktop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Desktop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		Usuario usuarioLogueado = (Usuario) session.getAttribute("usuarioLogueado");
//		
//		
//		
//		
//		if (usuarioLogueado == null) {
//			response.sendRedirect("Login.jsp");
		
		String contrasena = request.getParameter("contrasena");
		String nombre = request.getParameter("nombre");
		
		ModeloLogin ml = new ModeloLogin();
		Usuario usuario = ml.getContrasena(nombre);
		HttpSession session= request.getSession();
		
		if(usuario.getContrasena().equals(contrasena)){
			try {
				session.setAttribute("id_empleado", ml.getIdEmpleado(usuario.getId_usuario()));
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(usuario.getId_usuario().contains("MON")){
				response.sendRedirect("MenuMonitor");
			}
			else if(usuario.getId_usuario().contains("REC")){
				response.sendRedirect("MenuRecep");
			}
			else if(usuario.getId_usuario().contains("MAN"))  {
				response.sendRedirect("MenuMantenimi");
			}
			else if(usuario.getId_usuario().contains("JEF")) {
				response.sendRedirect("MenuJef");
			}
		}
		else {
			response.sendRedirect("Login.jsp");
		}
	
		
		}
	}


