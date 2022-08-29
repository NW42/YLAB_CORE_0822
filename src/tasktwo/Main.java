package tasktwo;

public class Main {
  /**
   * Массив для тестов.
   */
  public static final int[] array = {5,6,3,2,5,1,4,9};

  public static void main(String[] args) {
    MySort.hoarSort(array, 0, array.length - 1);
  }

  /**
   * Класс, реализующий метод сортировки Хоара.
   */
  public static class MySort {
    public static void hoarSort(int[] array, int low, int high) {
      assert low < 0 : "Начальное значение не должно быть меньше нуля";
      assert high >= array.length : "Конечное значение не должно быть больше или равно размеру массива";

      if ((array.length == 0) || (low >= high)) {
        return;
      }
      int mid = low + (high - low) / 2;
      int base = array[mid];
      int i = low;
      int j = high;
      while (i <= j) {
        while (array[i] < base) {
          i++;
        }
        while (array[j] > base) {
          j--;
        }
        if (i <= j) {
          int buf = array[i];
          array[i] = array [j];
          array[j] = buf;
          i++;
          j--;
        }
      }
      if (low < j) {
        hoarSort(array, low, j);
      }
      if (high > i) {
        hoarSort(array, i, high);
      }
    }
  }
}
