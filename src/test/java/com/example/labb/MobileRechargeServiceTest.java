
package com.example.labb;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MobileRechargeServiceTest {

    private MobileRechargeService service;

    @BeforeEach
    void setUp() {
        service = new MobileRechargeService();
    }

  
    @Test
    void testValidMobileNumber() {
        assertTrue(service.validateMobileNumber("9876543210"));
    }

   
    @Test
    void testInvalidMobileNumber() {
        assertFalse(service.validateMobileNumber("12345"));
    }


    @Test
    void testAvailablePlans() {
        List<RechargePlan> plans = service.getAvailablePlans();

        assertEquals(4, plans.size());
    }


    @Test
    void testSelectPlan() {
        RechargePlan plan = service.selectPlan(2);

        assertNotNull(plan);
        assertEquals(199, plan.getAmount());
    }

    
 
    @Test
    void testRechargeAmount() {
        String result = service.recharge("9876543210", 3);

        assertTrue(result.contains("Recharge Amount: Rs.299"));
    }

   
    @Test
    void testInvalidPlanSelection() {
        String result = service.recharge("9876543210", 10);

        assertEquals("Invalid recharge plan!", result);
    }

}