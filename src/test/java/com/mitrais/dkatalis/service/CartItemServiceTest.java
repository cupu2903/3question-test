package com.mitrais.dkatalis.service;

import com.mitrais.dkatalis.repository.domain.*;
import com.mitrais.dkatalis.services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 20/09/2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartItemServiceTest {

    @Autowired
    CartItemService cartItemService;

    @Test
    public void shouldReturnAllItemInCart(){
        List<CartItem> a = cartItemService.findAllItemInCart("1");
        List<CartItem> b = cartItemService.findAllItemInCart("2");
        assertThat(a).hasSize(1);
        assertThat(b).hasSize(2);
    }


}
