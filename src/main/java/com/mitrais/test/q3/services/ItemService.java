package com.mitrais.test.q3.services;

import com.mitrais.test.q3.repository.*;
import com.mitrais.test.q3.repository.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
public interface ItemService extends IOperations<Item, String> {

    Page<Item> findByItemNameContainingIgnoreCase(String itemName, Pageable pageable);
}
