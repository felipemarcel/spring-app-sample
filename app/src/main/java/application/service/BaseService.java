package application.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseService<T> {

    T save(T t);

    List<T> findAll(PageRequest request);

    T findById(Long id);

    void delete(Long id);

    T update(Long id, T t);
}
