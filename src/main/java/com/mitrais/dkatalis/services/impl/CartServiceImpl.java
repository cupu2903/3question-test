package com.mitrais.dkatalis.services.impl;

import com.mitrais.dkatalis.repository.dao.*;
import com.mitrais.dkatalis.repository.domain.*;
import com.mitrais.dkatalis.services.*;
import com.mitrais.dkatalis.services.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @since 19/09/2019
 */
@Service
@Transactional
public class CartServiceImpl extends AbstractService<Cart, String> implements CartService {
    @Autowired
    CartDao dao;

    @Override
    protected PagingAndSortingRepository<Cart, String> getDao() {

        return dao;
    }
}

