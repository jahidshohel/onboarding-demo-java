package com.eng.onboarding.te.component;

import com.eng.onboarding.te.ComplexMaths;
import com.eng.onboarding.te.Maths;
import com.eng.onboarding.te.RemoteMaths;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathsComponentTest {
    private Maths maths;

    @BeforeEach
    public void beforeEach() {
        ComplexMaths complexMaths = new ComplexMaths();
        RemoteMaths remoteMaths = new RemoteMaths();
        maths = new Maths(complexMaths, remoteMaths);
    }

    @Test
    public void sqrtTest() {
        double result = maths.sqrt(3);
        assertTrue(result>0);
    }

    @Test
    public void absTest() {
        //write your code here
    }
}
