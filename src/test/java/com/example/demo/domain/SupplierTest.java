package com.example.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplierTest {

    Supplier op;

    @BeforeEach
    void setUp() {
        op= new Supplier();
    }

    @Test
    void getCompanyName() {
        String name="test company name";
        op.setCompanyName(name);
        assertEquals(name,op.getCompanyName());
    }

    @Test
    void setCompanyName() {
        String name="test company name";
        op.setCompanyName(name);
        assertEquals(name,op.getCompanyName());
    }
}
