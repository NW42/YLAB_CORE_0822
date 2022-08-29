package taskone;

import java.util.Arrays;

public class Main {
  /**
   * Размерность квадратного массива.
   */
  public static final int SIZE = 5;

  /**
   * Квадратный массив для работы.
   */
  public static final int[][] array = new int[SIZE] [SIZE];

  public static void main(String[] args) {
    Arrays.stream(array).forEach(x -> Arrays.setAll(x, item -> MyRandom.getRandom()));
    double average = 0;
    var min = Integer.MAX_VALUE;
    var max = Integer.MIN_VALUE;
    for (int[] ints : array) {
      for (int item : ints) {
        if (item > max) {
          max = item;
        }
        if (item < min) {
          min = item;
        }
        average += item;
      }
    }
    average /= SIZE * SIZE;

    System.out.println("Average value = " + average);
    System.out.println("Min value " + min);
    System.out.println("Max value " + max);
  }


  /**
   * Класс кастомного рандома.
   */
  static class MyRandom {
    private static final int DEFAULT_SEED = 5;

    /**
     * Генерация случайного значения.
     *
     * @param seed семечка
     * @return result случайное значение
     */
    public static int getRandom(int seed) {
      Integer offset = new Integer(seed);
      var res = System.identityHashCode(offset) & ((Long) System.nanoTime()).intValue() >> offset;
      return (System.identityHashCode(offset) & 1) == 0 ? res : res >> 1 + 1;
    }

    /**
     * Генерация случайного значения.
     *
     * @return result случайное значение
     */
    public static int getRandom() {
      return getRandom(DEFAULT_SEED);
    }
  }
}
