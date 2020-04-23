package com.codegym.service;

import com.codegym.model.City;
import com.codegym.model.Nal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
    public Iterable<City> findAll();
    public City findById(Long id);
    public void save(City city);
    public void remove(Long id);

    Iterable<City> findAllByNal(Nal nal);
}
