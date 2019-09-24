package com.mitrais.dkatalis.services;

import com.mitrais.dkatalis.repository.IOperations;
import com.mitrais.dkatalis.repository.domain.*;

import java.util.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
public interface CartItemService extends IOperations<CartItem, CartItemId> {
    List<CartItem> findAllItemInCart(String cartId);
}
