package com.example.demo.service;

import com.example.demo.domain.Supplier;
import com.example.demo.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Service
public class OutsourcedPartServiceImpl implements OutsourcedPartService{
    private SupplierRepository partRepository;

    @Autowired
    public OutsourcedPartServiceImpl(SupplierRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<Supplier> findAll() {
        return (List<Supplier>) partRepository.findAll();
    }

    @Override
    public Supplier findById(int theId) {
        Long theIdl=(long)theId;
        Optional<Supplier> result = partRepository.findById(theIdl);

        Supplier thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            // we didn't find the OutSourced id
            //throw new RuntimeException("Did not find part id - " + theId);
            return null;
        }

        return thePart;
    }

    @Override
    public void save(Supplier thePart) {
        partRepository.save(thePart);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        partRepository.deleteById(theIdl);
    }

}
