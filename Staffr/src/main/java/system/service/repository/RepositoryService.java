package system.service.repository;

import java.util.Collection;
import java.util.List;

/**
 * Defines basic CRUD operations for repository-based services.
 *
 * @param <T> Type handled by this service
 */
public interface RepositoryService<T> {

    List<T> findAll();

    T find(Integer id);

    void persist(T instance);

    void persist(Collection<T> instances);

    void update(T instance);

    void remove(T instance);

    /**
     * Checks whether an instance with the specified id exists.
     *
     * @param id Instance identifier
     * @return Whether a matching instance exists
     */
    boolean exists(Integer id);
}
