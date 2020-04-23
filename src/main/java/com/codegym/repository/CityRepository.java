package com.codegym.repository;

import com.codegym.model.City;
import com.codegym.model.Nal;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City,Long> {
    Iterable<City> findAllByNal(Nal nal);

}
