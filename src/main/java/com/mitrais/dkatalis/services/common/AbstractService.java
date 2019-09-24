package com.mitrais.dkatalis.services.common;

import org.assertj.core.util.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import com.mitrais.dkatalis.repository.*;

import java.io.*;
import java.util.*;

/**
 * This Abstract Class Define all method related to standard IOPerations interface such as FindAll, FindByID, Save, etc
 * This class will have data access object from JpaRepository depending on who's' class extended this class
 * because it's general and dynamic of return value, so i declare dynamic types
 * and have one abstract method to implemented by each entity itself
 * @author Yusuf_AR91@mitrais.com
 * @version 0.4
 * @since 12/09/2019
 */
@Transactional
public abstract class AbstractService<T extends Serializable, ID> implements IOperations<T,ID>{
    @Override
    @Transactional(readOnly = true)
    public T findByID(ID id) {
        return getDao().findById(id).orElse(null);
    }

// read - all

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getDao().findAll(pageable);
    }

    @Override
    public Page<T> findPaginated(final int page, final int size) {
        return getDao().findAll(PageRequest.of(page, size));
    }

    // write

    @Override
    public T create(final T entity) {
        return getDao().save(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(final ID entityId) {
        getDao().deleteById(entityId);
    }

    protected abstract PagingAndSortingRepository<T, ID> getDao();
}
