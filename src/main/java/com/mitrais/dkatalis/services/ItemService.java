package com.mitrais.dkatalis.services;

import com.mitrais.dkatalis.repository.*;
import com.mitrais.dkatalis.repository.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
public interface ItemService extends IOperations<Item, String> {

    Page<Item> findByItemNameContainingIgnoreCase(String itemName, Pageable pageable);
}
