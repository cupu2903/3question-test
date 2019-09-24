package com.mitrais.dkatalis.web.controller;

import com.mitrais.dkatalis.repository.domain.*;
import com.mitrais.dkatalis.services.*;
import com.mitrais.dkatalis.web.dto.*;
import com.mitrais.dkatalis.web.exception.*;
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
        RespGenericDto<AddItemDto> respDto = new RespGenericDto<>();
        dto.setCartId(cartId);
        respDto.setMessage("Cart Created");
        respDto.setData(dto);
        return respDto;
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
