package com.mitrais.test.q3.web.controller;

import com.mitrais.test.q3.repository.domain.*;
import com.mitrais.test.q3.services.*;
import com.mitrais.test.q3.util.*;
import com.mitrais.test.q3.util.model.*;
import com.mitrais.test.q3.web.dto.*;
import com.mitrais.test.q3.web.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    CartService cartService;
    @Autowired
    CartItemService cartItemService;
    @Autowired
    UsersService usersService;

    @Autowired
    ModelMapper mapper;

    @GetMapping("/{usersId}/{cartId}")
    public CheckoutDto getCheckout(@PathVariable("cartId") @NotNull String cartId,
                                   @PathVariable("usersId") @NotNull String usersId) {
        Users users = usersService.findByID(usersId);
        if (users == null) {
            throw new BadRequestException("Invalid Request");
        }
        Cart cart = cartService.findByID(cartId);
        if (cart == null) {
            throw new ResourceNotFoundException("Cart Not Found");
        }
        List<CartItem> allItemInCart = cartItemService.findAllItemInCart(cartId);
        if (allItemInCart == null) {
            throw new ResourceNotFoundException("Cart Is Empty");
        }
        List<ItemDto> ldo = new ArrayList<>();
        allItemInCart.stream().map(item -> mapper.asItemDto(item)).forEachOrdered(itemDto -> {
            itemDto.setSubtotal(itemDto.getPrice() * itemDto.getQty());
            ldo.add(itemDto);
        });

        int subtotal = 0;
        for (ItemDto itemDto : ldo) {
            subtotal += itemDto.getSubtotal();
        }
        CheckoutDto respDto = new CheckoutDto();
        respDto.setCartId(cartId);
        respDto.setCrtDt(cart.getCrtDt());
        respDto.setItem(ldo);
        respDto.setSubtotal(subtotal);
        respDto.setUsers(mapper.asUserDto(users));

        RegularCustomer customer;
        switch (users.getUsersType()) {
            case "1":
                customer = new Employee();
                break;
            case "2":
                customer = new Affiliate();
                break;
            default:
                customer = new RegularCustomer();
                break;
        }

        respDto.setDiscountPercent(customer.getDiscount());
        int discount = (customer.getDiscount() * subtotal) / 100;
        int total = subtotal - discount;
        int additionalDiscount = (total / 100) * 5; // to prevent no 4
        total -= additionalDiscount;
        respDto.setDiscountNominal(discount);
        respDto.setAdditionalDiscount(additionalDiscount);
        respDto.setTotal(total);

        return respDto;


    }
}
