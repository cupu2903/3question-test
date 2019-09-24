package com.mitrais.dkatalis.web.dto;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
public class CheckoutDto extends CartDto {

    private int total;
    private int subtotal;
    private int discountPercent;
    private int discountNominal;
    private int additionalDiscount;

    public int getAdditionalDiscount() {
        return additionalDiscount;
    }

    public void setAdditionalDiscount(int additionalDiscount) {
        this.additionalDiscount = additionalDiscount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountNominal() {
        return discountNominal;
    }

    public void setDiscountNominal(int discountNominal) {
        this.discountNominal = discountNominal;
    }
}
