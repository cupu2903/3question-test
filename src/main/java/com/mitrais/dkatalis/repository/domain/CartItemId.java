package com.mitrais.dkatalis.repository.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.*;
import java.util.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
@Embeddable
public class CartItemId implements Serializable {
    @Column(name = "cart_id")
    private String cartId;
    @Column(name = "item_code")
    private String itemCode;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemId that = (CartItemId) o;
        return Objects.equals(getCartId(), that.getCartId()) &&
                Objects.equals(getItemCode(), that.getItemCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCartId(), getItemCode());
    }
}
