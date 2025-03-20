package com.example.devforneria.ltable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LTableService {

    @Autowired
    private LTableRepository lTableRepository;

    public List<LTable> findAll() {
        return lTableRepository.findAll();
    }

    public Optional<LTable> findById(Long id) {
        return lTableRepository.findById(id);
    }

    public LTable save(LTable lTable) {
        return lTableRepository.save(lTable);
    }

    public LTable updateLTable(Long id, LTable lTable) {
        LTable existingLTable = lTableRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("mesa não encontrada"));
        existingLTable.setName(lTable.getName());
        existingLTable.setCapacity(lTable.getCapacity());
        existingLTable.setStatus(lTable.getStatus());
        return lTableRepository.save(existingLTable);
    }

    public void deleteById(Long id) {
        lTableRepository.deleteById(id);
    }

}
