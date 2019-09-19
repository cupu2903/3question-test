package com.mitrais.test.q3.services;

import com.mitrais.test.q3.repository.*;
import com.mitrais.test.q3.repository.domain.*;
import org.springframework.stereotype.Service;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
@Service
public interface UsersService extends IOperations<Users,String> {
}
