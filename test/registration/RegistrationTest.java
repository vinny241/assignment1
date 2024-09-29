/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package registration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */


public class RegistrationTest {

    @Test
    public void testUsernameFormatted() {
        Registration reg = new Registration();
        
        // Test with correctly formatted username
        reg.User = "kyl_1";
        assertEquals("Welcome <user first name>, <user last name>, it is great to see you.", reg.registerUser());
        
        // Test with incorrectly formatted username
        reg.User = "kyle!!!!!!!";
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", reg.registerUser());
    }

    @Test
    public void testPasswordComplexity() {
        Registration reg = new Registration();
        
        // Test with password meeting complexity requirements
        reg.Pass = "Ch&&sec@ke99!";
        assertEquals("Password successfully captured", reg.registerUser());
        
        // Test with password not meeting complexity requirements
        reg.Pass = "password";
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", reg.registerUser());
    }

    @Test
    public void testLoginStatus() {
        Registration reg = new Registration();
        
        // Set up user credentials
        reg.User = "kyl_1";
        reg.Pass = "Ch&&sec@ke99!";
        
        // Test with correct login credentials
        reg.user = "kyl_1";
        reg.pass = "Ch&&sec@ke99!";
        assertTrue(reg.loginUser());
        
        // Test with incorrect login credentials
        reg.user = "kyl_1";
        reg.pass = "incorrect_password";
        assertFalse(reg.loginUser());
    }

    @Test
    public void testUsernameFormattedCheck() {
        Registration reg = new Registration();
        
        // Test with correctly formatted username
        reg.User = "kyl_1";
        assertTrue(reg.checkUsername());
        
        // Test with incorrectly formatted username
        reg.User = "kyle!!!!!!!";
        assertFalse(reg.checkUsername());
    }

    @Test
    public void testPasswordComplexityCheck() {
        Registration reg = new Registration();
        
        // Test with password meeting complexity requirements
        reg.Pass = "Ch&&sec@ke99!";
        assertTrue(reg.checkPasswordComplexity());
        
        // Test with password not meeting complexity requirements
        reg.Pass = "password";
        assertFalse(reg.checkPasswordComplexity());
    }
}
