public class Artist{
	
	private String firstName;
	private String lastName;
	private int fashionabilityCoeff;
	
	public Artist(){
		firstName="";
		lastName="";
		fashionabilityCoeff = 0;
	}
	public Artist(String fName, String lName, int fCoeff){
		firstName=fName;
		lastName=lName;
		fashionabilityCoeff = fCoeff;
	}	
	
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public int getFashionabilityCoeff(){
		return f1ashionabilityCoeff;
	}
	public void setFirstName(String fName){
		firstName=fName;
	}
	public void setLastName(String lName){
		lastName=lName;
	}
	public void setFashionabilityCoeff(int fCoeff){
		fashionabilityCoeff=fCoeff;
	}
}