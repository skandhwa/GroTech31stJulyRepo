package TestData;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJOMapper.CreateUser;

public class POJOImplementation {
	
	
	public static String createUserData() throws JsonProcessingException
	{
	
	CreateUser emp=new CreateUser();
	emp.setName("Harry");
	emp.setId(4567);
	emp.setJob("Manager");
	emp.setSalary(89000f);
	
	ObjectMapper obj=new ObjectMapper();
	
    String empJSON=	obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
	
	return empJSON;
	
	
	
	
	
	
	
	
	
	}
	
	
	

}
