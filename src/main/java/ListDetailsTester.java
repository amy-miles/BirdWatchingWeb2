import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import controller.BirderHelper;
import controller.ListDetailsHelper;
import model.Birder;
import model.ListDetails;
import model.Sighting;

public class ListDetailsTester {

	public static void main(String[] args) {

		Birder amy = new Birder("Amy");
		
		BirderHelper bh = new BirderHelper();		
		
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		Sighting owl = new Sighting("Polk", "Owl");
		Sighting cardinal = new Sighting("Polk", "Cardinal");
		
		List<Sighting> amysSightings = new ArrayList<Sighting>();
			amysSightings.add(owl);
			amysSightings.add(cardinal);
		
		ListDetails amysList = new ListDetails("Amy's List", LocalDate.now(), amy);
		ldh.insertNewListDetails(amysList);
		List<ListDetails> allLists = ldh.getLists();
		for (ListDetails a : allLists) {
			System.out.println(a.toString());

		}

	}
}
