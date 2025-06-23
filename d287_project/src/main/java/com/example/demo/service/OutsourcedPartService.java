package com.example.demo.service;

import com.example.demo.domain.Supplier;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface OutsourcedPartService {
        public List<Supplier> findAll();
        public Supplier findById(int theId);
        public void save (Supplier thePart);
        public void deleteById(int theId);
}
