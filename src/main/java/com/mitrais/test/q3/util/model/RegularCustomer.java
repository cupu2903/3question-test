package com.mitrais.test.q3.util.model;

import com.mitrais.test.q3.repository.domain.*;
import com.mitrais.test.q3.services.*;

import java.time.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
public class RegularCustomer extends Users implements DiscountService {

    @Override
    public int getDiscount() {
        LocalDateTime alreadyTwoYears = getRegDate().plusYears(2);
        if (alreadyTwoYears.isBefore(LocalDateTime.now())) {
            return 5;
        }else{
            return 0;
        }
    }
}
