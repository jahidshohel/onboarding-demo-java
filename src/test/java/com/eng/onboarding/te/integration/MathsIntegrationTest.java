package com.eng.onboarding.te.integration;

import com.eng.onboarding.te.ComplexMaths;
import com.eng.onboarding.te.Maths;
import com.eng.onboarding.te.RemoteMaths;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathsIntegrationTest {
    private Maths maths;

    @BeforeEach
    public void beforeEach() {
        ComplexMaths complexMaths = new ComplexMaths();
        RemoteMaths remoteMaths = new RemoteMaths();
        maths = new Maths(complexMaths, remoteMaths);
    }

    @Test
    public void factorialTest() {
        long result = maths.factorial(4);
        assertEquals(24, result);
    }

    @Test
    public void permutationsTest() {
        //write your code here
    }
}
