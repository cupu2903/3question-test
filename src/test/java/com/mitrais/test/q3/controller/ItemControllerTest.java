package com.mitrais.test.q3.controller;

import com.mitrais.test.q3.*;
import com.mitrais.test.q3.repository.domain.*;
import com.mitrais.test.q3.services.*;
import com.mitrais.test.q3.util.*;
import com.mitrais.test.q3.web.controller.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
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
@WebMvcTest(controllers = ItemController.class)
@Import(SecurityConfig.class)
public class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemService itemService;

    @MockBean
    ModelMapper mapper;

    @Test
    public void statusOk() throws Exception{
        Mockito.when(itemService.findAll(null)).thenReturn(null);
        mockMvc.perform(get("/item")).andExpect(status().isOk());

    }
}
