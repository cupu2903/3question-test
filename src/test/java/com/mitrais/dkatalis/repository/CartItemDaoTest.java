package com.mitrais.dkatalis.repository;

import com.mitrais.dkatalis.repository.dao.*;
import com.mitrais.dkatalis.repository.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 20/09/2019
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class CartItemDaoTest {

    @Autowired
    CartItemDao cartItemDao;

    @Test
    public void cartIdNotFound() {
        String cartId = "abcd";
        List<CartItem> allItemInCart = cartItemDao.findAllItemInCart(cartId);
        assertThat(allItemInCart).hasSize(0);
        assertThat(allItemInCart).isEmpty();
    }

    @Test
    public void cartItemCreated(){
        String cartId = UUID.randomUUID().toString();
        CartItem cartItem= new CartItem();
        CartItemId id = new CartItemId();
        id.setCartId(cartId);
        id.setItemCode("1");
        cartItem.setId(id);
        cartItem.setQty(2);
        CartItem save = cartItemDao.save(cartItem);
        System.out.println(save.toString());
        assertThat(save.getId().getCartId()).isEqualToIgnoringCase(cartId);
    }

    @Test
    public void findAllItemInCart(){
        List<CartItem> allItemInCart = cartItemDao.findAllItemInCart("1");
        assertThat(allItemInCart).hasSize(1);
    }
}
