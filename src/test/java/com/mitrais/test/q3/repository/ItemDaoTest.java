package com.mitrais.test.q3.repository;

import com.mitrais.test.q3.repository.dao.*;
import com.mitrais.test.q3.repository.domain.*;
import com.mitrais.test.q3.web.dto.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 20/09/2019
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemDaoTest {

    @Autowired
    ItemDao dao;

    public void printAllItemByName() {
        String itemName = "item1";
        Page<Item> byItemNameContainingIgnoreCase = dao.findByItemNameContainingIgnoreCase(itemName, null);
        assertThat(byItemNameContainingIgnoreCase).hasSize(5);
    }
}
