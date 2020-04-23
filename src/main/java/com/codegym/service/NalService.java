package com.codegym.service;

import com.codegym.model.City;
import com.codegym.model.Nal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NalService {
    public Iterable<Nal> findAll(Pageable pageable);
    public Nal findById(Long id);
    public void save(Nal nal);
    public void remove(Long id);
}
