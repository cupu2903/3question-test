package com.mitrais.test.q3.controller;

import com.mitrais.test.q3.services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 20/09/2019
 */

@RunWith(SpringRunner.class)
@WebMvcTest
public class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemService itemService;

    @Test
    public void statusOk() throws Exception{
        Mockito.when(itemService.findAll()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/item")).andExpect(status().isOk());

    }
}
