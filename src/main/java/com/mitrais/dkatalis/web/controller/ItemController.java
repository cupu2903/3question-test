package com.mitrais.dkatalis.web.controller;

import com.mitrais.dkatalis.repository.domain.*;
import com.mitrais.dkatalis.services.*;
import com.mitrais.dkatalis.util.*;
import com.mitrais.dkatalis.web.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    ModelMapper mapper;

    @GetMapping
    public Page<ItemDto> getAllItem(Pageable pageable) {
        if (pageable == null) {
            // to prevent load all item at the first time.
            // if the page and size not passed on parameter, Default Limit to 20 item.
            pageable = PageRequest.of(0, 20);
        }
        Page<Item> all = itemService.findAll(pageable);
        return all.map(mapper::asItemDtoFromItem);
    }
}
