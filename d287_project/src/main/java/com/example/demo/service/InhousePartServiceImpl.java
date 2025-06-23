package com.example.demo.service;

import com.example.demo.domain.HandCrafted;
import com.example.demo.repositories.HandCraftedRepository;
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
public class InhousePartServiceImpl implements InhousePartService {
    private HandCraftedRepository partRepository;

    @Autowired
    public InhousePartServiceImpl(HandCraftedRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<HandCrafted> findAll() {
        return (List<HandCrafted>) partRepository.findAll();
    }

    @Override
    public HandCrafted findById(int theId) {
        Long theIdl=(long)theId;
        Optional<HandCrafted> result = partRepository.findById(theIdl);

        HandCrafted thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            // we didn't find the InhousePart id
            //throw new RuntimeException("Did not find part id - " + theId);
            return null;
        }

        return thePart;
    }

    @Override
    public void save(HandCrafted thePart) {
        partRepository.save(thePart);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        partRepository.deleteById(theIdl);
    }

}
