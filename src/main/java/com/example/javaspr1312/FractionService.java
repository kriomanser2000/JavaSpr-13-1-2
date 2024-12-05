package com.example.javaspr1312;

import org.springframework.stereotype.Service;

@Service
public class FractionService
{
    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
    public int[] simplify(int numerator, int denominator)
    {
        int gcd = gcd(numerator, denominator);
        return new int[]{numerator / gcd, denominator / gcd};
    }
    public int[] add(int n1, int d1, int n2, int d2)
    {
        int numerator = n1 * d2 + n2 * d1;
        int denominator = d1 * d2;
        return simplify(numerator, denominator);
    }
    public int[] subtract(int n1, int d1, int n2, int d2)
    {
        int numerator = n1 * d2 - n2 * d1;
        int denominator = d1 * d2;
        return simplify(numerator, denominator);
    }
    public int[] multiply(int n1, int d1, int n2, int d2)
    {
        int numerator = n1 * n2;
        int denominator = d1 * d2;
        return simplify(numerator, denominator);
    }
    public int[] divide(int n1, int d1, int n2, int d2)
    {
        int numerator = n1 * d2;
        int denominator = d1 * n2;
        return simplify(numerator, denominator);
    }
}
