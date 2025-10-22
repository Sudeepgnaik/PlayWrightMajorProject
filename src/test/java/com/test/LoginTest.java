package com.test;

import org.testng.annotations.Test;

import com.pages.Admin;
import com.pages.DeleteUserPage;
import com.pages.EditUserPage;
import com.pages.LoginPage;
import com.pages.SearchPage;

public class LoginTest extends BaseTest {
	@Test
    public void testValidLogin() throws InterruptedException {
        // Initialize page objects with Playwright's Page
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("Admin", "admin123");

     
        Admin adminPage = new Admin(page);
        
        String employeeName = "joker john selvam";
        String newUsername = "sudeep555";
        String newPassword = "Jellyfish@123";
        String confirmPassword = "Jellyfish@123";
        String userRole = "Admin";
        String status = "Enabled";
 
        adminPage.admininput(employeeName, newUsername, newPassword, confirmPassword, userRole, status);
        SearchPage searchPage = new SearchPage(page);
        searchPage.searchUser("sudeep000", "Admin", "Enabled");
        EditUserPage editUserPage = new EditUserPage(page);
        editUserPage.editUserStatus("Disabled");
        searchPage.searchUser(newUsername, userRole, "Disabled");

        // Step 6: Delete the user
        DeleteUserPage deleteUserPage = new DeleteUserPage(page);
        deleteUserPage.deleteUser();

	}
}
