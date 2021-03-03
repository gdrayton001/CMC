package CMC.user;

import java.awt.List;

public class UserInteraction {
	
	private boolean loginSuccessful = false;
	private boolean dispSavedInfo = false;
	private boolean dispErrorMessage = false;
	private boolean activated = true;
	private List recommendedSchools;

	public void login(String username, String password) {
		// loginSuccessful should be changed to true if username and password are correct
		// if activated = false, login should not be successful
	}

	public boolean getLoginSuccessful() {
		// TODO Auto-generated method stub
		return this.loginSuccessful;
	}

	public void viewSavedInfo(String string) {
		// TODO Auto-generated method stub
		
	}

	public boolean getDispSavedInfo() {
		// TODO Auto-generated method stub
		return this.dispSavedInfo;
	}
	
	public void displaySavedInfo() {
		// add other functionalities here
		this.dispSavedInfo = true;
	}

	public void changeFirstName(String firstName) {
		// TODO Auto-generated method stub
		
	}

	public void changeLastName(String lastName) {
		// TODO Auto-generated method stub
		
	}

	public void changePassword(String password) {
		// TODO Auto-generated method stub
		
	}

	public List searchSchool(String school) {
		// TODO Auto-generated method stub
		return null;
	}

	public List searchSchoolByState(String state) {
		// TODO Auto-generated method stub
		return null;
	}

	public List searchSchoolByNumStudents(int numStudents) {
		// TODO Auto-generated method stub
		return null;
	}

	public void cancelUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getDispErrorMessage() {
		return this.dispErrorMessage;
	}

	public List viewRecommendedSchool(int numSchools) {
		// TODO Auto-generated method stub
		return null;
	}

	public void viewSchoolInfo(String school) {
		// TODO Auto-generated method stub
		
	}

	public void deleteRecommendedSchools() {
		// TODO Auto-generated method stub
		
	}

}
