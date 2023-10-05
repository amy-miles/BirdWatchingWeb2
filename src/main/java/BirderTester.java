import java.util.List;

import controller.BirderHelper;
import model.Birder;

/**
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Oct 4, 2023
 */
public class BirderTester {

	
	public static void main(String[] args) {


		Birder amy = new Birder("Amy");
		BirderHelper bh = new BirderHelper();
		bh.insertBirder(amy);
		List<Birder> allBirders = bh.showAllBirders();
		for(Birder b: allBirders) {
		System.out.println(b.toString());
		}

	}

}
