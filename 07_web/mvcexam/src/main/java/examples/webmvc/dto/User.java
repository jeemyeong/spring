package examples.webmvc.dto;

public class User {
	private String nmae;
	private String email;
	private int age;
	public String getNmae() {
		return nmae;
	}
	public void setNmae(String nmae) {
		this.nmae = nmae;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [nmae=" + nmae + ", email=" + email + ", age=" + age + "]";
	}
	
	
}
