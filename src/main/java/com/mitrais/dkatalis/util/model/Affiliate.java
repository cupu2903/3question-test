package com.mitrais.dkatalis.util.model;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
public class Affiliate extends RegularCustomer {
    @Override
    public int getDiscount() {
        return 10;
    }
}
