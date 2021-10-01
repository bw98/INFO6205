package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UF_HWQUPC_Client_Test {

    public static void main(String[] args) {
        // System.out.println("[UF_HWQUPC_Client_Test main()] Assignment 3, Part 2, UF Client");

        int[] ns = {1000000, 10000, 1000, 100, 10, 1};

        for (int n : ns) {
            int links = count(n);
            System.out.println("Successfully connected " + n + " sites by " + links + " connections!");
        }
    }

    private static int count(int n) {
        // System.out.println("[UF_HWQUPC_Client_Test count()] Assignment 3, Part 2, UF Client");

        UF_HWQUPC uf = new UF_HWQUPC(n);
        int linkNum = 0;

        while (!uf.isAllConnected()) {
            int p = genRandomInt(n);
            int q;

            // Make sure p != q
            do {
                q = genRandomInt(n);
            } while (q == p);

            // System.out.println("Generate a pair of site: (" + p + ", " + q + ")");

            if (!uf.connected(p, q)) {
                uf.union(p, q);
                linkNum++;
            }
        }

        return linkNum;
    }

    private static int genRandomInt(int n) {
        return new Random().nextInt(n);
    }
}
