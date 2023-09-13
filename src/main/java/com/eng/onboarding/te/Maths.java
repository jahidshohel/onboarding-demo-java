package com.eng.onboarding.te;

import java.io.IOException;

public class Maths {
    private final ComplexMaths complexMaths;
    private final RemoteMaths remoteMaths;

    public Maths(ComplexMaths complexMaths, RemoteMaths remoteMaths) {
        this.complexMaths = complexMaths;
        this.remoteMaths = remoteMaths;
    }

    public long add(long a, long b) {
        return a + b;
    }

    public long subtract(long a, long b) {
        if (a >= b) {
            return a - b;
        }
        return b - a;
    }

    public double sqrt(double a) {
        return complexMaths.sqrt(a);
    }

    public long abs(long a) {
        return complexMaths.abs(a);
    }

    public long factorial(int a) {
        try {
            return remoteMaths.factorial(a);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int permutations(int a) {
        try {
            return remoteMaths.permutations(a);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
