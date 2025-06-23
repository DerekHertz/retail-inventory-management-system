package com.example.demo.service;

import com.example.demo.domain.HandCrafted;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface InhousePartService {
    public List<HandCrafted> findAll();
    public HandCrafted findById(int theId);
    public void save (HandCrafted thePart);
    public void deleteById(int theId);
}
