package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Sighting;

/**
 * Servlet implementation class addSightingServlet
 */
@WebServlet("/addSightingServlet")
public class addSightingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSightingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String county = request.getParameter("county");
		String species = request.getParameter("species");
		
		Sighting s = new Sighting(county, species);
		SightingHelper dao = new SightingHelper();
		dao.insertSighting(s);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
