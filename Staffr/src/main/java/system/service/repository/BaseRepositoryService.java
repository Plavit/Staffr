package system.service.repository;

import org.springframework.transaction.annotation.Transactional;
import system.dao.GenericDao;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public abstract class BaseRepositoryService<T> implements BaseService<T> {

    protected abstract GenericDao<T> getPrimaryDao();

    @Transactional(readOnly = true)
    @Override
    public List<T> findAll() {
        final List<T> result = getPrimaryDao().findAll();
        result.forEach(this::postLoad);
        return result;
    }

    @Transactional(readOnly = true)
    @Override
    public T find(Integer id) {
        final T result = getPrimaryDao().find(id);
        postLoad(result);
        return result;
    }

    @Transactional
    @Override
    public void persist(T instance) {
        Objects.requireNonNull(instance);
        prePersist(instance);
        getPrimaryDao().persist(instance);
    }

    @Transactional
    @Override
    public void persist(Collection<T> instances) {
        Objects.requireNonNull(instances);
        instances.forEach(this::prePersist);
        getPrimaryDao().persist(instances);
    }

    @Transactional
    @Override
    public void update(T instance) {
        Objects.requireNonNull(instance);
        preUpdate(instance);
        getPrimaryDao().update(instance);
        postUpdate();
    }

    @Transactional
    @Override
    public void remove(T instance) {
        getPrimaryDao().remove(instance);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean exists(Integer id) {
        return getPrimaryDao().exists(id);
    }

    // The following methods are hooks intended to be overridden by subclasses, so that the main CRUD methods do not have to be modified

    void prePersist(T instance) {
        // Do nothing, intended for overriding
    }

    void preUpdate(T instance) {
        // Do nothing, intended for overriding
    }

    void postUpdate() {
        // Do nothing, intended for overriding
    }

    void postLoad(T instance) {
        // Do nothing, intended for overriding
    }

}
