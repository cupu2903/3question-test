package com.mitrais.dkatalis.repository;

import com.mitrais.dkatalis.repository.dao.*;
import com.mitrais.dkatalis.repository.domain.*;
import org.junit.Before;
import org.junit.Test;
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


    @Test
    public void shouldReturnFoundItem() {
        Page<Item> byItemNameContainingIgnoreCase = dao.findByItemNameContainingIgnoreCase("a",
                null);
        assertThat(byItemNameContainingIgnoreCase).hasSize(1);

        Page<Item> byItemNameContainingIgnoreCase1 = dao.findByItemNameContainingIgnoreCase("prod",
                null);
        assertThat(byItemNameContainingIgnoreCase1).hasSize(2);
    }
}
