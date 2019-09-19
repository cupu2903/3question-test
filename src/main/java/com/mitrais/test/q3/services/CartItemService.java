package com.mitrais.test.q3.services;

import com.mitrais.test.q3.repository.*;
import com.mitrais.test.q3.repository.domain.*;

import java.util.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
public interface CartItemService extends IOperations<CartItem, CartItemId> {
    List<CartItem> findAllItemInCart(String cartId);
}
