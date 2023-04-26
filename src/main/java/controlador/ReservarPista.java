package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Alquiler;
import modelo.dao.ModeloRecepcion;

/**
 * Servlet implementation class ReservarPista
 */
@WebServlet("/ReservarPista")
public class ReservarPista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservarPista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloRecepcion modRec = new ModeloRecepcion();
		
		request.setAttribute("dni", request.getParameter("dni"));
		try {
			request.setAttribute("salas", modRec.getSalas());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("ReservarPista.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		ModeloRecepcion modRec = new ModeloRecepcion();
		
		Alquiler alquiler = new Alquiler();
		
		try {
			alquiler.setCliente(modRec.getCliente(request.getParameter("dni")));
			alquiler.setSala(modRec.getSala(Integer.parseInt(request.getParameter("sala"))));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alquiler.setHora(request.getParameter("horas"));
		
		try {
			modRec.realizarReservaPista(alquiler);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("VerReservas").forward(request, response);
	}

}
