

import java.util.List;
import java.util.Scanner;


import controller.SightingHelper;
import model.Sighting;

/**
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Sep 11, 2023
 */
public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static SightingHelper sh = new SightingHelper();

		private static void addSighting() {
			// TODO Auto-generated method stub
			System.out.print("Enter the county: ");
			String county = in.nextLine();
			System.out.print("Enter a species: ");
			String species = in.nextLine();			
			Sighting toAdd = new Sighting(county, species);
			sh.insertSighting(toAdd);

		}

		private static void deleteSighting() {
			// TODO Auto-generated method stub
			System.out.print("Enter the county to delete: ");
			String county = in.nextLine();
			System.out.print("Enter the species to delete: ");
			String species = in.nextLine();			
		
			Sighting toDelete = new Sighting(county, species);
			sh.deleteSighting(toDelete);
		}

		private static void editSighting() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Species");
			System.out.println("2 : Search by County");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Sighting> foundSightings;
			if (searchBy == 1) {
				System.out.print("Enter the species name: ");
				String speciesName = in.nextLine();
				foundSightings = sh.searchForSightingBySpecies(speciesName);
			} else {
				System.out.print("Enter the county: ");
				String countyName = in.nextLine();
				
				foundSightings = sh.searchForSightingByCounty(countyName);
			}

			if (!foundSightings.isEmpty()) {
				System.out.println("Found Results.");
				System.out.println("--------------");
				for (Sighting s : foundSightings) {					
					System.out.println(s.getId() + " : " + s.returnSightingDetails());
				}
				System.out.println("--------------");
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Sighting toEdit = sh.searchForSightingById(idToEdit);
				System.out.println("Retrieved " + toEdit.getCounty() + " from " + toEdit.getSpecies());
				System.out.println("1 : Update Species");
				System.out.println("2 : Update County");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Species: ");
					String newSpecies = in.nextLine();
					toEdit.setSpecies(newSpecies);
				} else if (update == 2) {
					System.out.print("New County: ");
					String newCounty = in.nextLine();
					toEdit.setCounty(newCounty);
				}

				sh.updateSighting(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to Bird Watching! ---");
			while (goAgain) {
				System.out.println("*  Select a sighting:");
				System.out.println("*  1 -- Add a sighting");
				System.out.println("*  2 -- Edit a sighting");
				System.out.println("*  3 -- Delete a sighting");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addSighting();
				} else if (selection == 2) {
					editSighting();
				} else if (selection == 3) {
					deleteSighting();
				} else if (selection == 4) {
					viewTheList();
				} else {
					sh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {

			List<Sighting> allSightings = sh.showAllSightings();
			System.out.println("--------------");
			for(Sighting singleSighting : allSightings){
			System.out.println(singleSighting.returnSightingDetails());
			}
			System.out.println("--------------");
			

		}

	}