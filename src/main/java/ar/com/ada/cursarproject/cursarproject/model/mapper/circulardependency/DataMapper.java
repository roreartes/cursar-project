package ar.com.ada.cursarproject.cursarproject.model.mapper.circulardependency;

import java.util.List;

public interface DataMapper<D, E> {

    E toEntity(D dto);
    D toDto(E entity);
    List<E> toEntity(List<D> dtoList);
    List<D> toDto(List<E> entityList);
}
