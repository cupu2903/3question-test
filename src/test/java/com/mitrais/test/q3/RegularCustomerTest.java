package com.mitrais.test.q3;

import com.mitrais.test.q3.services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * This Module is For All Possible Test and Meet The Requirement for User Type Regular Customer
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 20/09/2019
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegularCustomerTest {


    @Autowired
    MockMvc mockMvc;

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

    @Test
    public void calculateMoreThan100Billed_Groceries_After2Years(){
    }
    @Test
    public void calculateMoreThan100Billed_Groceries_Before2Years(){
    }

    @Test
    public void calculateMoreThan100Billed_NonGroceries_After2Years(){
    }

    @Test
    public void calculateMoreThan100Billed_NonGroceries_Before2Years(){
    }
}
