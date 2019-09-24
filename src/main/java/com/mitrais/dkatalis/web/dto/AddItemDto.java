package com.mitrais.dkatalis.web.dto;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
public class AddItemDto extends ItemDto{
    private String cartId;
    private String usersId;

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "AddItemDto{" +
                "cartId='" + cartId + '\'' +
                ", usersId='" + usersId + '\'' +
                '}';
    }
}
