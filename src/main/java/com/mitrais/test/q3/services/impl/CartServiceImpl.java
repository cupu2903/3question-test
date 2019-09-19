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

