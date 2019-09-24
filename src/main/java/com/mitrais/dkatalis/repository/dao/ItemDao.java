package com.mitrais.dkatalis.repository.dao;

import com.mitrais.dkatalis.repository.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
public interface ItemDao extends JpaRepository<Item, String> {

    Page<Item> findByItemNameContainingIgnoreCase(String itemName, Pageable pageable);
}
