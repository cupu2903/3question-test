package com.mitrais.dkatalis.services.impl;

import com.mitrais.dkatalis.repository.dao.*;
import com.mitrais.dkatalis.repository.domain.*;
import com.mitrais.dkatalis.services.*;
import com.mitrais.dkatalis.services.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @since 19/09/2019
 */
@Service
@Transactional
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
