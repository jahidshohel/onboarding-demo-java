package com.eng.onboarding.te.unit;

import com.eng.onboarding.te.ComplexMaths;
import com.eng.onboarding.te.Maths;
import com.eng.onboarding.te.RemoteMaths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathsUnitTest {

    @Mock
    private ComplexMaths complexMaths;
    @Mock
    private RemoteMaths remoteMaths;
    private Maths maths;
    private AutoCloseable closeable;

    @BeforeEach
    public void beforeEach() {
        closeable = MockitoAnnotations.openMocks(this);
        maths = new Maths(complexMaths, remoteMaths);
    }

    @AfterEach
    public void afterEach() throws Exception {
        closeable.close();
    }

    @Test
    public void addTest() {
        long result = maths.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void subtractTest() {
        //write your code here
    }
}
