package com.mitrais.test.q3.repository.domain;

import javax.persistence.*;
import java.io.*;
import java.time.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
@Entity
public class Cart implements Serializable {
    @Id
    @Column(name = "cart_id")
    private String cartId;
    @Column(name = "crt_dt")
    private LocalDateTime crtDt;
    @Column(name = "users_id")
    private String usersId;

    private Integer subtotal;
    @Column(name = "discount_nominal")
    private Integer discountNominal;
    @Column(name = "discount_percent")
    private Integer discountPercent;
    private Integer total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", insertable = false, updatable = false)
    private Users users;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public LocalDateTime getCrtDt() {
        return crtDt;
    }

    public void setCrtDt(LocalDateTime crtDt) {
        this.crtDt = crtDt;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getDiscountNominal() {
        return discountNominal;
    }

    public void setDiscountNominal(Integer discountNominal) {
        this.discountNominal = discountNominal;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
