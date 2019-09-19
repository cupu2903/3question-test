package com.mitrais.test.q3.services.impl;

import com.mitrais.test.q3.repository.dao.*;
import com.mitrais.test.q3.repository.domain.*;
import com.mitrais.test.q3.services.*;
import com.mitrais.test.q3.services.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.*;
import java.util.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @since 19/09/2019
 */
public class ItemServiceImpl extends AbstractService<Item, String> implements ItemService {

    @Autowired
    ItemDao dao;
    @Override
    protected PagingAndSortingRepository<Item, String> getDao() {
        return dao;
    }

    @Override
    public Page<Item> findByItemNameContainingIgnoreCase(String itemName, Pageable pageable) {
        return dao.findByItemNameContainingIgnoreCase(itemName,pageable);
    }
}
