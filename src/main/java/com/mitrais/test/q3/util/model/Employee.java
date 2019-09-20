package com.mitrais.test.q3.util.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
@Data
@Builder
@NoArgsConstructor
public class Employee extends RegularCustomer {

    @Override
    public int getDiscount() {
        return 30;
    }
}
