package com.mitrais.test.q3.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitrais.test.q3.*;
import com.mitrais.test.q3.repository.domain.*;
import com.mitrais.test.q3.services.*;
import com.mitrais.test.q3.web.controller.*;
import com.mitrais.test.q3.web.dto.*;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 20/09/2019
 */

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CartController.class)
@Import(SecurityConfig.class)
public class CartControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CartService cartService;
    @MockBean
    CartItemService cartItemService;
    @MockBean
    UsersService usersService;

    @Test
    public void createCartIsForbidden() throws Exception {
        Users users = new Users();
        users.setUsersId("1");
        Mockito.when(usersService.findByID("1")).thenReturn(users);
        Cart cart = new Cart();
        Mockito.when(cartService.create(cart)).thenReturn(cart);
        CartItem cartItem = new CartItem();
        Mockito.when(cartItemService.create(cartItem)).thenReturn(cartItem);

        AddItemDto dto = new AddItemDto();
        mockMvc.perform(post("/cart/create")
                .content(new ObjectMapper().writeValueAsString(dto))
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCartCreated() throws Exception {
        AddItemDto reqDto = new AddItemDto();
        reqDto.setUsersId("1");
        reqDto.setItemCode("1");
        reqDto.setQty(1);
        Users users = new Users();
        users.setUsersId("1");
        Mockito.when(usersService.findByID("1")).thenReturn(users);
        Cart cart = new Cart();
        Mockito.when(cartService.create(cart)).thenReturn(cart);
        CartItem cartItem = new CartItem();
        Mockito.when(cartItemService.create(cartItem)).thenReturn(cartItem);

        MvcResult mvcResult = mockMvc.perform(post("/cart/create")
                .content(new ObjectMapper().writeValueAsString(reqDto))
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        assertThat(actualResponseBody)
                .isEqualTo(new ObjectMapper().writeValueAsString(new RespGenericDto<>("Cart Created")));
    }
}
