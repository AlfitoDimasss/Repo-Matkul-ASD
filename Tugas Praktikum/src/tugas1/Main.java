package tugas1;

import java.util.*;

interface AnArray<T> {
    void printArray();

    T getFirstElement();

    T getLastElement();

    T getMiddleElement();
}

class RegularArray<T> implements AnArray<T> {
    T[] arr;
    int mid;

    RegularArray(T[] arrayTs) {
        arr = arrayTs;
    }

    @Override
    public void printArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T getFirstElement() {
        return arr[0];
    }

    @Override
    public T getLastElement() {
        return arr[arr.length - 1];
    }

    public T getMiddleElement() {
        if (arr.length % 2 == 0) {
            mid = (arr.length / 2) - 1;
            return arr[mid];
        } else {
            mid = arr.length / 2;
            return arr[mid];
        }
    }

}

class ReversedArray<T> implements AnArray<T> {
    T[] arr;
    int mid;

    @SuppressWarnings("unchecked")
    ReversedArray(T[] arrayTs) {
        arr = (T[]) new Object[arrayTs.length];
        ReversedArrays(arrayTs);
    }

    public void ReversedArrays(T[] arrTs) {
        for (int i = 0, j = arrTs.length - 1; i < arrTs.length; i++, j--) {
            arr[i] = arrTs[j];
        }
    }

    @Override
    public void printArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T getFirstElement() {
        return arr[0];
    }

    @Override
    public T getLastElement() {
        return arr[arr.length - 1];
    }

    public T getMiddleElement() {
        if (arr.length % 2 == 0) {
            mid = (arr.length / 2) - 1;
            return arr[mid];
        } else {
            mid = arr.length / 2;
            return arr[mid];
        }
    }

}

public class Main {

    public static void main(String[] args) {
        // Jangan ubah main method
        Scanner scan = new Scanner(System.in);

        Integer[] intArr = new Integer[scan.nextInt()];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = scan.nextInt();
        }

        String[] strArr = new String[scan.nextInt()];
        scan.nextLine();
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = scan.next();
        }

        AnArray<Integer> intRegArr = new RegularArray<Integer>(intArr);
        AnArray<Integer> intRevArr = new ReversedArray<Integer>(intArr);

        AnArray<String> strRegArr = new RegularArray<String>(strArr);
        AnArray<String> strRevArr = new ReversedArray<String>(strArr);

        intRegArr.printArray();
        intRevArr.printArray();
        System.out.println(
                intRegArr.getFirstElement() + " " + intRegArr.getLastElement() + " " + intRegArr.getMiddleElement());
        System.out.println(
                intRevArr.getFirstElement() + " " + intRevArr.getLastElement() + " " + intRevArr.getMiddleElement());

        strRegArr.printArray();
        strRevArr.printArray();
        System.out.println(
                strRegArr.getFirstElement() + " " + strRegArr.getLastElement() + " " + strRegArr.getMiddleElement());
        System.out.println(
                strRevArr.getFirstElement() + " " + strRevArr.getLastElement() + " " + strRevArr.getMiddleElement());

        scan.close();
    }
}
