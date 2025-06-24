package com.example.demo.repositories;

import com.example.demo.domain.HandCrafted;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HandCraftedRepositoryTest {
    HandCraftedRepository handCraftedRepository;
    @BeforeEach
    void setUp() {
        handCraftedRepository =mock(HandCraftedRepository.class);
    }
    @Test
    void findAll() {
        HandCrafted part=new HandCrafted();
        List partData=new ArrayList();
        partData.add(part);
        when(handCraftedRepository.findAll()).thenReturn(partData);
        List<HandCrafted> parts=(List<HandCrafted>) handCraftedRepository.findAll();
        assertEquals(partData.size(),1);
    }
}
