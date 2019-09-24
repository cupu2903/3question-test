package com.mitrais.dkatalis.web.dto;

import java.time.*;
import java.util.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
public class CartDto {
    private String cartId;
    private UserSimpleDto users;
    private List<ItemDto> item;
    private LocalDateTime crtDt;

    public UserSimpleDto getUsers() {
        return users;
    }

    public void setUsers(UserSimpleDto users) {
        this.users = users;
    }

    public LocalDateTime getCrtDt() {
        return crtDt;
    }

    public void setCrtDt(LocalDateTime crtDt) {
        this.crtDt = crtDt;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<ItemDto> getItem() {
        return item;
    }

    public void setItem(List<ItemDto> item) {
        this.item = item;
    }
}
