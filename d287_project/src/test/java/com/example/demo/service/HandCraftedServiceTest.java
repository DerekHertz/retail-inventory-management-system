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

/**
 * Project: demo
 * Package: com.example.demo.service
 * <p>
 * User: carolyn.sher
 * Date: 5/3/2022
 * Time: 11:36 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
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