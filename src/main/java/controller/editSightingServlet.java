package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Sighting;

/**
 * Servlet implementation class editSightingServlet
 */
@WebServlet("/editSightingServlet")
public class editSightingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editSightingServlet() {
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
		SightingHelper dao = new SightingHelper();
		String county = request.getParameter("county");
		String species = request.getParameter("species");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Sighting sightingToUpdate = dao.searchForSightingById(tempId);
		sightingToUpdate.setCounty(county);
		sightingToUpdate.setSpecies(species);
		dao.updateSighting(sightingToUpdate);
		getServletContext().getRequestDispatcher("/viewAllSightingsServlet").forward(request, response);
	}

}
