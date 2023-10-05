package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Birder;
import model.ListDetails;
import model.Sighting;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
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
		ListDetailsHelper dao = new ListDetailsHelper();
		
		SightingHelper lih = new SightingHelper();
		BirderHelper bh = new BirderHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		String newListName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String birderName = request.getParameter("birderName");
		//find our add the new shopper
		Birder newBirder = bh.findBirder(birderName);
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		try {
		//items are selected in list to add
		String[] selectedSighting = request.getParameterValues("allSightingsToAdd");
		List<Sighting> selectedSightingInList = new ArrayList<Sighting>();
		for (int i = 0; i < selectedSighting.length; i++) {
			System.out .println(selectedSighting[i]);
			Sighting s =lih.searchForSightingById(Integer.parseInt(selectedSighting[i]));
			selectedSightingInList.add(s);
		}
		listToUpdate.setListOfSightings(selectedSightingInList);
		
		} catch (NullPointerException ex) {
		// no items selected in list - set to an empty list
		List<Sighting> selectedSightingInList = new
		ArrayList<Sighting>();
		listToUpdate.setListOfSightings(selectedSightingInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setTripDate(ld);
		listToUpdate.setBirder(newBirder);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		}
	}

