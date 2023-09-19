package lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Employee implements Cloneable {
	
	private String name;
	private int no; 
	private int age;
	private String state;
	private int zip;
	private String[] advisors;
	
	public Employee() {
		name = null;
		no = 0;
		age = 0;
		state = null;
		zip = 0;
		advisors = new String[3];
	}

	
	
	
	public Employee(Object obj) { // Copy all instances of and obj if the obj is instance of class Employee and not null;
		if(obj == null) return; 
		if(obj instanceof Employee) {
			Employee e = (Employee) obj;
			this.name = e.name;
			this.no = e.no;
			this.age = e.age;
			this.state = e.state;
			this.zip = e.zip;
			this.advisors = e.advisors;	
		}		
	}
	
	
	public Employee clone() { //takes the answer obj and takes a clone of the Employee obj but returns the answer obj.
		Employee answer;
		try {
			answer = (Employee) super.clone();
			answer.name = name;
			answer.no = no;
			answer.age = age;
			answer.state = state;
			answer.zip = zip;
			answer.advisors = advisors;  }
		catch(CloneNotSupportedException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException ("This class does not implement Cloneable.");
		}
		return answer;
		
	}
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public int getZip() {
		return zip;
	}



	public void setZip(int zip) {
		this.zip = zip;
	}



	public String[] getAdvisors() {
		return advisors;
	}



	public void setAdvisors(String[] advisors) {
		this.advisors = advisors;
	}
	
	
	
	public String toString() { // takes the object Employee and formats it into a String.
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < advisors.length; i++) {
			sb.append(advisors[i]+',');
		}
		String str = sb.toString();
		return "" + name + ", " + no + ", " + age + ", " + state + ", " + zip  + ", " + str  + "";
	}
	
	
// TODO make to String method return the employee no of the advisors[].
	
	public boolean equals(Object obj) { // if parameter is instanceof Employee it will check all the instance variables to be == to eachother.
		if(obj instanceof Employee)
		{
			Employee candid = (Employee) obj;
			return(candid.name == name) && (candid.no == no) && (candid.age == age) && (candid.state == state)
					&& (candid.zip == zip) && (candid.advisors == advisors);
		}
		else {
		return false;
		}
	}
 
	
	
	public static String[] getAllAdvisors(Employee e1, Employee e2) {
		String[] emp1 = e1.getAdvisors();
		String [] emp2 = e2.getAdvisors();
		//String[] mergedArray = null;
		int alen = emp1.length;
		int blen = emp2.length;
		//if(e1 == null || e2 == null) { return null; }
		String[] result = new String[alen + blen];
		System.arraycopy(emp1, 0, result, 0, alen);
		System.arraycopy(emp2, 0, result, blen, alen);
		ArrayList<String> aListAdvisors = new ArrayList<String>();
		if(e1 == null || e2 == null) { return null; }
		
		for(int i = 0; i < result.length; i++) {
			if(!aListAdvisors.contains(result[i]) ) {
				aListAdvisors.add(result[i]);
			} 
		}
		result = aListAdvisors.toArray(new String[aListAdvisors.size()]);
		
		return result;
		


		}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Employee.getAllAdvisors();
		String [] advBr = {"Jon", "Wil", "Ben"};
		String [] advJo = {"Brady", "Ret", "Ben"};
		Employee e = new  Employee();
		Employee e3 = new  Employee();
		Employee e4 = new Employee();
		Employee e5 = new  Employee();
		Employee e6 = new Employee();
		e.setName("Brady");
		e.setAge(18);
		e.setNo(123);
		e.setZip(87112);
		e.setState("NM");
		e.setAdvisors(advBr);
		e3 = e.clone();
		e3.setAdvisors(advJo);
		e3.setName("Jon");	
		e3.setNo(1);
		//e3.getNo();
		
		System.out.println(e.clone());
		Employee e2 = new Employee(e);
		//e.toString();
		System.out.println(e2);
		System.out.println(Arrays.toString(e3.getAdvisors()));
		System.out.println(Arrays.toString(e.getAdvisors()));
		System.out.println(e.equals(e));
		System.out.print(Arrays.toString(Employee.getAllAdvisors(e, e3)));
		
		//System.out.println(Employee.getAllAdvisors(e, e2));
		
	}

}
