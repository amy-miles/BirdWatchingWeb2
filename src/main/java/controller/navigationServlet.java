package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Sighting;
/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
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
		String act = request.getParameter("doThisToSighting");
		// after all changes, we should redirect to the viewAllSightings servlet
		// The only time we don't is if they select to add a new item or edit
		String path = "/viewAllSightingsServlet";
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Sighting sightingToDelete = dao.searchForSightingById(tempId);
				dao.deleteSighting(sightingToDelete);
				} catch (NumberFormatException e) {
				System.out.println("Forgot to select a sighting");
				}			
		} else if (act.equals("edit")) {
			try {			
			
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Sighting sightingToEdit = dao.searchForSightingById(tempId);
			request.setAttribute("sightingToEdit", sightingToEdit);
			path = "/edit-sighting.jsp";
			}catch (NumberFormatException e){
				System.out.println("Forgot to select a sighting.");
			}
		} else if (act.equals("add")) {
		path = "/index.html";
		}
		
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
