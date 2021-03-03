package CMC;

import java.awt.List;

import CMC.user.DBController;
import CMC.user.UserInteraction;

/**
 * @author Greg Drayton
 */

public class Driver {
	
	// Login use case
	private static void runLogin(UserInteraction ui) {
		System.out.println("Testing login main scenario...");
		ui.login("username", "correctpassword");
		boolean result = ui.getLoginSuccessful();
		System.out.println("Expected result: true, result: " + result);
		
		System.out.println("Testing login alternate scenario 1...");
		ui.login("username", "incorrectpassword");
		boolean result1 = ui.getLoginSuccessful();
		System.out.println("Expected result: false, result: " + result1);
		
		System.out.println("Testing login alternate scenario 2...");
		ui.login("fakeusername", "password");
		boolean result2 = ui.getLoginSuccessful();
		System.out.println("Expected result: false, result: " + result2);
	
		System.out.println("Testing login alternate scenario 3...");
		ui.login("deactuser", "password");
		boolean result3 = ui.getLoginSuccessful();
		System.out.println("Expected result: false, result: " + result3);
	}
	
	//edit info use case
	private static void runViewProfile(UserInteraction ui) {
		System.out.println("Testing view profile main scenario");
		ui.login("username", "correctpassword");
		ui.viewSavedInfo("username");
		boolean result = ui.getDispSavedInfo();
		System.out.println("Expected result: true, result: " + result);
	}
	
	private static void runEditProfile(UserInteraction ui, DBController db) {
		System.out.println("Testing edit profile main scenario");
		ui.login("username", "correctpassword");
		ui.viewSavedInfo("username");
		ui.changeFirstName("Bob");
		ui.changeLastName("Smith");
		ui.changePassword("password123");
		String firstName = db.getFirstName();
		String lastName = db.getLastName();
		String password = db.getPassword();
		System.out.println("Expected first name: Bob, result: " + firstName);
		System.out.println("Expected last name: Smith, result: " + lastName);
		System.out.println("Expected password: password123, result: " + password);
		
		System.out.println("Testing edit profile alternate scenario 1");
		ui.changeFirstName("Greg");
		ui.changeLastName("Drayton");
		ui.changePassword("baseball");
		ui.cancelUpdate();
		String firstName1 = db.getFirstName();
		String lastName1 = db.getLastName();
		String password1 = db.getPassword();
		System.out.println("Expected first name: Bob, result: " + firstName1);
		System.out.println("Expected last name: Smith, result: " + lastName1);
		System.out.println("Expected password: password123, result: " + password1);
		
		System.out.println("Testing edit profile alternate scenario 2");
		ui.changeFirstName(null);
		ui.changeLastName(null);
		ui.changePassword(null);
		boolean result = ui.getDispErrorMessage();
		System.out.println("Expected result: true, result: " + result);
	}
	
	private static void runSearchSchools(UserInteraction ui) {
		System.out.println("Testing search schools main scenario");
		ui.login("username", "correctpassword");
		List results = ui.searchSchool("St. John's University");
		System.out.println("Results for St. John's University search: " + results);
		
		List results1 = ui.searchSchoolByState("Minnesota");
		System.out.println("Results for Minnesota university search: " + results1);
		
		List results2 = ui.searchSchoolByNumStudents(3000);
		System.out.println("Results for universities with 3000 students " + results2);
	}
	
	private static void runViewRecommendedSchools(UserInteraction ui) {
		System.out.println("Testing view 5 recommended schools main scenario");
		ui.login("username", "password");
		ui.viewSchoolInfo("St. John's University");
		List results = ui.viewRecommendedSchool(5);
		System.out.println("Results for 5 recommended schools: " + results);
		
		System.out.println("Testing view 5 recommended schools alternate scenario");
		ui.viewSchoolInfo("St. John's University");
		List results1 = ui.viewRecommendedSchool(5);
		ui.deleteRecommendedSchools();
		System.out.println("Results for 5 recommended schools should be null, actual result: " + results1);
