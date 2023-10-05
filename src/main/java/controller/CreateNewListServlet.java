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
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SightingHelper sh = new SightingHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String birderName =	request.getParameter("birderName");
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year),
					Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedSightings =	request.getParameterValues("allSightingsToAdd");
		List<Sighting> selectedSightingsInList = new ArrayList<Sighting>();
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedSightings != null && selectedSightings.length > 0)
		{
		for(int i = 0; i<selectedSightings.length; i++) {
			System.out.println(selectedSightings[i]);
			Sighting s = sh.searchForSightingById(Integer.parseInt(selectedSightings[i]));
			selectedSightingsInList.add(s);
		}
		}
		Birder birder = new Birder(birderName);
		ListDetails sld = new ListDetails(listName, ld, birder);
	
		sld.setListOfSightings(selectedSightingsInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(sld);
		System.out.println("Success!");
		System.out.println(ld.toString());
		getServletContext().getRequestDispatcher("/viewAllSightingsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
