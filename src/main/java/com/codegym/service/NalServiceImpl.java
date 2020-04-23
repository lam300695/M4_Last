package com.codegym.service;

import com.codegym.model.Nal;
import com.codegym.repository.NalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NalServiceImpl implements NalService {

    @Autowired
    NalRepository nalRepository;

    @Override
    public Page<Nal> findAll(Pageable pageable) {
        return nalRepository.findAll(pageable);
    }

    @Override
    public Nal findById(Long id) {
        return nalRepository.findOne(id);
    }

    @Override
    public void save(Nal nal) {
        nalRepository.save(nal);
    }

    @Override
    public void remove(Long id) {
        nalRepository.delete(id);
    }
}
