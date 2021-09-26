package edu.neu.coe.info6205.sort.elementary;
import edu.neu.coe.info6205.sort.GenericSort;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("ALL")
public class SortTimeTest {
    @Test
    public void test0() {
        // GenericSort<Integer> sorter = new InsertionSort<Integer>();  // sorter rely on n implicitly

        for (int n = 10; n < 100001; n *= 10) {  // run 5 times
            // Random array
            List<Integer> randomArr = new ArrayList<Integer>();
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                randomArr.add(random.nextInt());
            }

            GenericSort<Integer> sorter = new InsertionSort<Integer>();  // sorter rely on n implicitly
            Benchmark<Integer> bm = new Benchmark_Timer<Integer>("Random array timer", b -> {
                sorter.sort(randomArr);
            });

            double ms = bm.run(0, 10);

            System.out.print("Sorted random array within size n = " + n + ", time cost: " + ms + " ms\n");

            // Ordered array
            List<Integer> orderArr = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                orderArr.add(i);
            }

            bm = new Benchmark_Timer<Integer>("Ordered array timer", b -> {
                sorter.sort(orderArr);
            });

            ms = 0;
            ms = bm.run(0, 10);

            System.out.print("Sorted ordered array within size n = " + n + ", time cost: " + ms + " ms\n");

            // Partially-ordered array
            List<Integer> porderArr = new ArrayList<Integer>();
            for (int i = 0; i < n / 2; i++) {
                porderArr.add(i);
            }

            for (int i = n / 2; i < n; i++) {
                porderArr.add(random.nextInt());
            }

            bm = new Benchmark_Timer<Integer>("Partially-ordered array timer", b -> {
                sorter.sort(porderArr);
            });

            ms = 0;
            ms = bm.run(0, 10);

            System.out.print("Sorted partially-ordered array within size  n = " + n + ", time cost: " + ms + " ms\n");

            // Reverse-ordered array
            List<Integer> rorderArr = new ArrayList<Integer>();
            for (int i = n; i > 0; i--) {
                rorderArr.add(i);
            }

            bm = new Benchmark_Timer<Integer>("Partially-ordered array timer", b -> {
                sorter.sort(rorderArr);
            });

            ms = 0;
            ms = bm.run(0, 10);


            System.out.print("Sorted reverse-ordered array within size n = " + n + ", time cost: " + ms + " ms\n");
        }

    }
}

