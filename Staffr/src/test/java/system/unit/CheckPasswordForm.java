/*
 * A set of tests designed to check username errors at login/registration
 */
package system.unit;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * This is a template prepared to test a password form and its possible invalid inputs
 * @author Szeles Marek
 */

public class CheckPasswordForm {
    
    @BeforeClass
    public static void beforeClass() {
    }

    @AfterClass
    public static void afterClass() {
    }

 
    /**
     * Tests the password checking function.
     * Checks if a request to pass a blank password returns the desired 
     * error message.
     */
    /*
    @Test
    public void checkPassword_emptyBoth_test(){
        String expectedResult = "You need to choose your password!";         
        String realResult = Main.Handlers.CheckPassword.checkPasswords("", "");        
        assertEquals(expectedResult,realResult);        
    }
    */
     /**
     * Tests the password checking function.
     * Checks if a request to pass a blank password returns the desired 
     * error message.
     */
     /*
    @Test
    public void checkPassword_emptyFirst_test(){
        String expectedResult = "You need to choose your password!";         
        String realResult = Main.Handlers.CheckPassword.checkPasswords("", "askjdfhaslkfja");        
        assertEquals(expectedResult,realResult);        
    }*/
    
     /**
     * Tests the password checking function.
     * Checks if a request to pass a blank confirm password field returns 
     * the desired error message.
     */
     /*
    @Test
    public void checkPassword_emptySecond_test(){
        String expectedResult = "You need to re-enter your password to proceed.";         
        String realResult = Main.Handlers.CheckPassword.checkPasswords("asdfasdasdff", "");        
        assertEquals(expectedResult,realResult);        
    }*/
    
     /**
     * Tests the password checking function.
     * Checks if a request to pass password and confirm password fields 
     * with different values returns the desired error message.
     */
     /*
    @Test
    public void checkPassword_bothDifferent_test(){
        String expectedResult = "You need to re-enter your password to proceed.";         
        String realResult = Main.Handlers.CheckPassword.checkPasswords("asdfasdfasdf", "fsadfsdfadsf");        
        assertEquals(expectedResult,realResult);        
    }*/
    
     /**
     * Tests the password checking function.
     * Checks if a request to pass password shorter than 8 characters
     * returns the desired error message.
     */
     /*
    @Test
    public void checkPassword_shorterThan8_test(){
        String expectedResult = "Password too short! Minimum: 8, Given: 2";         
        String realResult = Main.Handlers.CheckPassword.checkPasswords("as", "askjdfhaslkfja");        
        assertEquals(expectedResult,realResult);        
    }*/
    
     /**
     * Tests the password checking function.
     * Checks if a request to pass a valid password request succeeds.
     */
     /*
    @Test
    public void checkPassword_bothTheSame_test(){
        String expectedResult = "OK";         
        String realResult = Main.Handlers.CheckPassword.checkPasswords("lolololo", "lolololo");        
        assertEquals(expectedResult,realResult);        
    }*/
    
}
