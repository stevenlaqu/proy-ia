package pe.isil.isilrest.services;

import java.util.List;
import java.util.Optional;

public interface BasicCrud <T,T2>{
    void create(T t);
    T update(T t);
    void dalete(T t);

    List<T> findAll();
    Optional<T> findById(T2 t2);
}
