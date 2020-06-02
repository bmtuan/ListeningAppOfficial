package src.Model;

public class User {
    private String UserName;
    private String UserID;
    private String Password;
    private String Gender;
	private String DateOfBirth;
	public User(){}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public User(String userName, String userID, String password, String dateOfBirth, String gender) {
		UserName = userName;
		UserID = userID;
		Password = password;
		Gender = gender;
		DateOfBirth = dateOfBirth;
	}
	
	public boolean isValid(){
		return !(UserName.equals("") || Password.equals("") || DateOfBirth.equals("") || Gender.equals(""));
	}
    
	@Override
	public String toString() {
		return "User [DateOfBirth=" + DateOfBirth + ", Gender=" + Gender + ", Password=" + Password + ", UserID="
				+ UserID + ", UserName=" + UserName + "]";
	}

    

}