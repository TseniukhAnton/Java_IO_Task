package repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    T getById(ID id);

    void deleteById(ID id);

    T update(T t);

    T save(T t);

    List<T> getAll();
}
