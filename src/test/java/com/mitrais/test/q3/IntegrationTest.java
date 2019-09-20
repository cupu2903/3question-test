package com.mitrais.test.q3;

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

import static com.mitrais.test.q3.util.model.Employee.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 20/09/2019
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    CartService cartService;
    @MockBean
    CartItemService cartItemService;
    @MockBean
    ItemService itemService;


    @Test
    public void employeeMoreThan100Billed(){
    }
}
