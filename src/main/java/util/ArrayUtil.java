package util;

public class ArrayUtil {

    public static void deleteByIndex(Object[] array, int index, int size) {
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
    }

    public static void print(Object[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }
}
