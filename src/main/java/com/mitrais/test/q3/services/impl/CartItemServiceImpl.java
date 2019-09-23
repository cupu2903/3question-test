package com.mitrais.test.q3.services.impl;

import com.mitrais.test.q3.repository.dao.*;
import com.mitrais.test.q3.repository.domain.*;
import com.mitrais.test.q3.services.*;
import com.mitrais.test.q3.services.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
@Service
@Transactional
public class CartItemServiceImpl extends AbstractService<CartItem, CartItemId> implements CartItemService {
    @Autowired
    CartItemDao dao;

    @Override
    protected PagingAndSortingRepository<CartItem, CartItemId> getDao() {
        return dao;
    }

    @Override
    public List<CartItem> findAllItemInCart(String cartId) {
        return dao.findAllItemInCart(cartId);
    }
}
