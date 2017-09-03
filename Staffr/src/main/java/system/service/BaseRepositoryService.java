/**
 * Copyright (C) 2016 Czech Technical University in Prague
 * <p>
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package system.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import system.dao.GenericDao;

import java.util.Collection;

@Transactional
public abstract class BaseRepositoryService<T> implements BaseService<T> {

    protected static final Logger LOG = LoggerFactory.getLogger(BaseRepositoryService.class);

    protected abstract GenericDao<T> getPrimaryDao();

    @Transactional(readOnly = true)
    @Override
    public Collection<T> findAll() {
        return getPrimaryDao().findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public T find(Integer id) {
        return getPrimaryDao().find(id);
    }

    @Override
    public void persist(T instance) {
        getPrimaryDao().persist(instance);
    }

    @Override
    public void persist(Collection<T> instances) {
        getPrimaryDao().persist(instances);
    }

    @Override
    public void update(T instance) {
        getPrimaryDao().update(instance);
    }

    @Override
    public void remove(T instance) {
        getPrimaryDao().remove(instance);
    }

    @Override
    public void remove(Collection<T> instances) {
        getPrimaryDao().remove(instances);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean exists(Integer id) {
        return getPrimaryDao().exists(id);
    }
}
