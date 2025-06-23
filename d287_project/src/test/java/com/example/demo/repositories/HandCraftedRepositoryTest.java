package com.example.demo.repositories;

import com.example.demo.domain.HandCrafted;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project: demo
 * Package: com.example.demo.repositories
 * <p>
 * User: carolyn.sher
 * Date: 5/3/2022
 * Time: 11:33 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
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