package com.mitrais.dkatalis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitrais.dkatalis.repository.dao.*;
import com.mitrais.dkatalis.services.*;
import com.mitrais.dkatalis.web.dto.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.extractProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This Module is For All Possible Test and Meet The Requirement for User Type Affiliate
 *
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 20/09/2019
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AffiliateTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    CartItemService cartItemService;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    CartItemDao dao;

    @Test
    public void createCart() throws Exception {
        AddItemDto dto = new AddItemDto();
        dto.setUsersId("1");
        dto.setItemCode("1");
        dto.setQty(5);
        MvcResult mvcResultCreateCart = mockMvc.perform(post("/cart/create")
                .content(mapper.writeValueAsString(dto))
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
        String createResult = mvcResultCreateCart.getResponse().getContentAsString();
        AddItemDto respCreatedDto = mapper.readValue(createResult, AddItemDto.class);
    }

    @Test
    public void calculateMoreThan100Billed_NonGroceries() throws Exception {

    }

    @Test
    public void calculateLessThan100Billed_NonGroceries() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/checkout/{usersId}/{cartId}",
                "1", "b7516ed8-ea5f-461a-a5b4-0a43f46f1636"))
                .andExpect(status().isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        CheckoutDto checkoutDto = mapper.readValue(contentAsString, CheckoutDto.class);
        // subtotal = 5 x 50 = 250
        // discount employee = 30% x 250 = 75
        // discount per 100$ = 250/100 = 10
        // total = 250 - 85 = 165
        assertThat(checkoutDto.getTotal()).isEqualTo(165);
    }

    @Test
    public void calculateMoreThan100Billed_Groceries() {
    }

    @Test
    public void calculateLessThan100Billed_Groceries() {
    }
}
