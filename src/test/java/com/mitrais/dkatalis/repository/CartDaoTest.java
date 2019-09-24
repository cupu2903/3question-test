package com.mitrais.dkatalis.repository;

import com.mitrais.dkatalis.repository.dao.*;
import com.mitrais.dkatalis.repository.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 24/09/2019
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class CartDaoTest {

    @Autowired
    CartDao cartDao;

    @Test
    public void shouldReturnCartCreated() {
        Cart cart = new Cart();
        cart.setUsersId("1");
        cart.setCrtDt(LocalDateTime.now());
        String cartId = UUID.randomUUID().toString();
        cart.setCartId(cartId);

        Cart save = cartDao.save(cart);
        assertThat(save.getCartId()).isEqualTo(cartId);
        Optional<Cart> cartResult = cartDao.findById(cartId);
        assertThat(cartResult.get().getUsersId()).isEqualTo("1");
    }
}
