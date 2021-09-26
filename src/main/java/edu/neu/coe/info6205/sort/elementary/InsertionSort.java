/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Config;

import java.util.Arrays;

public class InsertionSort<X extends Comparable<X>> extends SortWithHelper<X> {

    /**
     * Constructor for any sub-classes to use.
     *
     * @param description the description.
     * @param N           the number of elements expected.
     * @param config      the configuration.
     */
    protected InsertionSort(String description, int N, Config config) {
        super(description, N, config);
    }

    /**
     * Constructor for InsertionSort
     *
     * @param N      the number elements we expect to sort.
     * @param config the configuration.
     */
    public InsertionSort(int N, Config config) {
        this(DESCRIPTION, N, config);
    }

    public InsertionSort(Config config) {
        this(new BaseHelper<>(DESCRIPTION, config));
    }

    /**
     * Constructor for InsertionSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public InsertionSort(Helper<X> helper) {
        super(helper);
    }

    public InsertionSort() {
        this(BaseHelper.getHelper(InsertionSort.class));
    }

    /**
     * Sort the sub-array xs:from:to using insertion sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort
     * @param to   the index of the first element not to sort
     */
    public void sort(X[] xs, int from, int to) {
        final Helper<X> helper = getHelper();

        // TO BE IMPLEMENTED

        for (int i = from + 1; i < to; i++) {
            for (int j = i; j > from; j--) {
                if (helper.compare(xs, j - 1, j) > 0) {
                    helper.swap(xs, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

//    public void sort(X[] xs, int from, int to) {
//        final Helper<X> helper = getHelper();
//
//        // TO BE IMPLEMENTED
//
//        System.out.print("----------------------\n");
//        System.out.print("\nxs: ");
//        System.out.print(Arrays.toString(xs));
//        System.out.print("----------------------\n");
//
//        for (int i = from + 1; i < to; i++) {
//            if (helper.less(xs[i - 1] , xs[i])) {
//                break;  // greater than max number of sorted sequence, just break
//            }
//
//            X item = xs[i];
//
//            int insert_idx = binarySeach(xs, item, from, i);
//
//            for (int j = i - 1; j >= insert_idx; j--) {
//                helper.swap(xs, j, j + 1);
//            }
//
//            xs[insert_idx] = item;
//
//            System.out.print("----------------------\n");
//            System.out.print("insert_idx: ");
//            System.out.print(insert_idx);
//            System.out.print("\ni: ");
//            System.out.print(i);
//            System.out.print("\nxs: ");
//            System.out.print(Arrays.toString(xs));
//            System.out.print("----------------------\n");
//        }
//
//    }
//
//    private int binarySeach(X[] xs, X item, int left, int right) {
//        final Helper<X> helper = getHelper();
//
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (helper.less(item, xs[mid])) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        return left;
//    }

    public static final String DESCRIPTION = "Insertion sort";

    public static <T extends Comparable<T>> void sort(T[] ts) {
        new InsertionSort<T>().mutatingSort(ts);
    }
}
