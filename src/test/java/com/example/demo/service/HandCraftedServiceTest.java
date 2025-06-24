package com.example.demo.service;

import com.example.demo.domain.HandCrafted;
import com.example.demo.repositories.HandCraftedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HandCraftedServiceTest {
    HandCraftedRepository handCraftedRepository;
    InhousePartService inhousePartService;
    @BeforeEach
    void setUp() {
        handCraftedRepository =mock(HandCraftedRepository.class);
        inhousePartService=new InhousePartServiceImpl(handCraftedRepository);
    }

    @Test
    void findAll() {
        HandCrafted part=new HandCrafted();
        List partData=new ArrayList();
        partData.add(part);
        when(handCraftedRepository.findAll()).thenReturn(partData);
        List<HandCrafted> parts=inhousePartService.findAll();
        assertEquals(partData.size(),1);
    }
}
