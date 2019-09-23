package com.mitrais.test.q3;

import com.mitrais.test.q3.repository.domain.*;
import com.mitrais.test.q3.services.*;
import com.mitrais.test.q3.util.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.*;
import java.util.*;

import static com.mitrais.test.q3.util.model.Employee.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This Module is For All Possible Test and Meet The Requirement for User Type Employee
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 20/09/2019
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {



    @Autowired
    CartService cartService;
    @Autowired
    CartItemService cartItemService;
    @Autowired
    ItemService itemService;
    @Autowired
    UsersService usersService;


    @Test
    public void calculateMoreThan100Billed_NonGroceries(){

    }

    @Test
    public void calculateLessThan100Billed_NonGroceries(){
    }

    @Test
    public void calculateMoreThan100Billed_Groceries(){
    }

    @Test
    public void calculateLessThan100Billed_Groceries(){
    }
}
