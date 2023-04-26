package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Grupo;
import modelo.dao.ModeloMonitor;

/**
 * Servlet implementation class InsertarGrupo
 */
@WebServlet("/InsertarGrupo")
public class InsertarGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarGrupo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("InsertarGrupoForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		ModeloMonitor modMon = new ModeloMonitor();
		
		Grupo grupo = new Grupo (Integer.parseInt(request.getParameter("id_grupo")),request.getParameter("dias"),request.getParameter("horas"),Integer.parseInt(request.getParameter("maxPartic")),Integer.parseInt(request.getParameter("numPartic")));
		
		try {
			modMon.insertarGrupo(grupo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("VerGrupos").forward(request, response);
	}

}
