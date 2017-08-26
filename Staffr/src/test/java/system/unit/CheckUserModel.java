/*
 * A set of tests designed to check username errors at login/registration
 */
package sit.ear.semestral.UnitTests;

import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import sit.ear.semestral.model.User;
import sit.ear.semestral.model.Tag;
import sit.ear.semestral.model.CustomTag;
import sit.ear.semestral.model.DefaultTag;
import sit.ear.semestral.model.Category;
import sit.ear.semestral.model.CustomCategory;
import sit.ear.semestral.model.DefaultCategory;
import sit.ear.semestral.model.Account;
import sit.ear.semestral.model.Transaction;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Szeles Marek
 */
public class CheckUserModel {
    
    @BeforeClass
    public static void beforeClass() {
    }

    @AfterClass
    public static void afterClass() {
    }

    User testUser = new User();


    /**
     * Tests passing the Id to a user object
     */
    @Test
    public void checkId_test(){
        long expectedResult = 9999;
        testUser.setId(expectedResult);
        long realResult = testUser.getId();
        assertEquals(expectedResult,realResult);
    }

    /**
     * Tests passing a name to a user object
     */
    @Test
    public void checkName_test(){
        String expectedResult = "testName";
        testUser.setName(expectedResult);
        String realResult = testUser.getName();
        assertEquals(expectedResult,realResult);        
    }

    /**
     * Tests passing a clean, unhashed password to a user object
     */
    @Test
    public void checkUnhashedPass_test(){
        String expectedResult = "rawPass";
        testUser.setPassword(expectedResult);
        String realResult = testUser.getPassword();
        assertEquals(expectedResult,realResult);
    }

    /**
     * Tests setting a user to be admin
     */
    @Test
    public void checkAdminYes_test(){
        boolean start = false;
        boolean expected = true;
        testUser.setAdmin(start);
        testUser.setAdmin(expected);
        assert(testUser.isAdmin());
    }

    /**
     * Tests setting a user not to be admin
     */
    @Test
    public void checkAdminNo_test(){
        boolean start = true;
        boolean expected = false;
        testUser.setAdmin(start);
        testUser.setAdmin(expected);
        assert(!testUser.isAdmin());
    }

    /**
     * Tests Creating a custom tag by the user
     */
    @Test
    public void checkCustomTag_test(){
        CustomTag tstTag = new CustomTag();
        String expectedResult = "testCusTag";
        tstTag.setName(expectedResult);

        List<Tag> tagsList = new ArrayList<Tag>();
        tagsList.add(tstTag);

        testUser.setTags(tagsList);
        System.out.println(testUser.getTags().toArray()[0]);
        assert(testUser.getTags().contains(tstTag));
    }

    /**
     * Tests Creating a custom category by the user
     */
    @Test
    public void checkCustomCategory_test(){
        CustomCategory tstCusCategory = new CustomCategory();
        String expectedResult = "testCusCat";
        tstCusCategory.setName(expectedResult);

        List<Category> catsList = new ArrayList<Category>();
        catsList.add(tstCusCategory);

        testUser.setCategories(catsList);
        System.out.println(testUser.getCategories().toArray()[0]);
        assert(testUser.getCategories().contains(tstCusCategory));
    }

    /**
     * Tests Creating a new account by the user
     */
    @Test
    public void checkAccount_test(){
        Account tstAccount = new Account();
        String expectedResult = "testAccount";
        tstAccount.setName(expectedResult);

        List<Account> accList = new ArrayList<Account>();
        accList.add(tstAccount);

        testUser.setAccounts(accList);
        System.out.println(testUser.getAccounts().toArray()[0]);
        assert(testUser.getAccounts().contains(tstAccount));
    }

    /**
     * Tests Creating a new transaction by the user
     */
    @Test
    public void checkTransaction_test(){
        Transaction tstTrns = new Transaction();

        List<Transaction> tList = new ArrayList<Transaction>();
        tList.add(tstTrns);

        testUser.setTransactions(tList);
        System.out.println(testUser.getTransactions().toArray()[0]);
        assert(testUser.getTransactions().contains(tstTrns));
    }

}
