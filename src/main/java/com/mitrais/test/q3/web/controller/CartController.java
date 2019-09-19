package com.mitrais.test.q3.web.controller;

import com.mitrais.test.q3.repository.domain.*;
import com.mitrais.test.q3.services.*;
import com.mitrais.test.q3.web.dto.*;
import com.mitrais.test.q3.web.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    CartItemService cartItemService;
    @Autowired
    ItemService itemService;
    @Autowired
    UsersService usersService;

    @PostMapping("/create")
    public RespGenericDto createCart(@RequestBody AddItemDto dto) {
        Users users = usersService.findByID(dto.getUsersId());
        if (users == null) {
            throw new BadRequestException("Invalid Request");
        }
        String cartId = UUID.randomUUID().toString();
        Cart cart = new Cart();
        cart.setCartId(cartId);
        cart.setCrtDt(LocalDateTime.now());
        cart.setUsersId(users.getUsersId());
        cartService.create(cart);

        CartItem cartItem = new CartItem();
        CartItemId id = new CartItemId();
        id.setCartId(cartId);
        id.setItemCode(dto.getItemCode());
        cartItem.setId(id);
        cartItem.setQty(dto.getQty());
        cartItemService.create(cartItem);
        return new RespGenericDto("Cart Created");
    }

    @PutMapping("/add")
    public RespGenericDto addCart(@RequestBody AddItemDto dto) {
        Users users = usersService.findByID(dto.getUsersId());
        if (users == null) {
            throw new BadRequestException("Invalid Request");
        }
        if (dto.getCartId() == null) {
            throw new BadRequestException("Invalid Cart");
        }
        Cart cart = cartService.findByID(dto.getCartId());
        if (cart == null) {
            throw new ResourceNotFoundException("Cart Not Found");
        }
        CartItem cartItem = new CartItem();
        CartItemId id = new CartItemId();
        id.setCartId(cart.getCartId());
        id.setItemCode(dto.getItemCode());
        cartItem.setId(id);
        cartItem.setQty(dto.getQty());
        cartItemService.create(cartItem);
        return new RespGenericDto("Item Added to Cart");
    }

}
