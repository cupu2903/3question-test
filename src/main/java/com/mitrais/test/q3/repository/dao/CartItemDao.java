package com.mitrais.test.q3.repository.dao;

import com.mitrais.test.q3.repository.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
public interface CartItemDao extends JpaRepository<CartItem, CartItemId> {
    @Query(nativeQuery = true, value = "select * from cart_item where cart_id = :cartId")
    List<CartItem> findAllItemInCart(@Param("cartId") String cartId);

}
