package io.github.hyperbora.math;

public class Gcd {
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Gcd g = new Gcd();
        System.out.println(g.gcd(12, 8));
    }
}