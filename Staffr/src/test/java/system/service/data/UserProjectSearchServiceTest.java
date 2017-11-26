package system.service.data;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.business.Project;
import system.business.User;
import system.business.UserProject;
import system.service.repository.UserService;

import java.util.*;

import static org.junit.Assert.*;

public class UserProjectSearchServiceTest{

    @Autowired
    UserService userService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getUsersProjectsFromDate() throws Exception {
        assert(true);
        System.out.println("Hello Dolly");
    }

}