package com.mitrais.dkatalis.services.impl;

import com.mitrais.dkatalis.repository.dao.*;
import com.mitrais.dkatalis.repository.domain.*;
import com.mitrais.dkatalis.services.*;
import com.mitrais.dkatalis.services.common.*;
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
