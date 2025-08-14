package usermanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;

public class ValidateUserManagement {
	
	@BeforeMethod
	public void setUp() {
		Allure.step("Open Browser");
	}

	@Test
	public void createUser() {
		Allure.step("Create User");
	}
	
	@Test
	public void deleteUser() {
		Allure.step("Delete User");
	}
	
	@Test
	public void activiateUser() {
		Allure.step("Activate User");
	}
	
	@Test
	public void deactivateUser() {
		Allure.step("Deactivate User");
	}
	
	@AfterMethod
	public void teardown() {
		Allure.step("Close Browser");
	}

}
