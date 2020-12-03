package Lesson5;

public class Lesson5 {
    static float[] arr;
    static long a;

    public static void main(String[] args) {
        method1();
        method2();
  //   1. Необходимо написать два метода, которые делают следующее:
  //   1) Создают одномерный длинный массив, например:

  //   static final int size = 10000000;
  //   static final int h = size / 2;
  //   float[] arr = new float[size];

  //   2) Заполняют этот массив единицами;
  //   3) Засекают время выполнения: long a = System.currentTimeMillis();
  //   4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
  //   arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
  //   5) Проверяется время окончания метода System.currentTimeMillis();
  //   6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);

  //   Отличие первого метода от второго:
  //   Первый просто бежит по массиву и вычисляет значения.
  //   Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.

  //           Пример деления одного массива на два:

  //   System.arraycopy(arr, 0, a1, 0, h);
  //   System.arraycopy(arr, h, a2, 0, h);

  //   Пример обратной склейки:

  //   System.arraycopy(a1, 0, arr, 0, h);
  //   System.arraycopy(a2, 0, arr, h, h);

  //   Примечание:
  //   System.arraycopy() – копирует данные из одного массива в другой:
  //   System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
  //   По замерам времени:
  //   Для первого метода надо считать время только на цикл расчета:

  //   for (int i = 0; i < size; i++) {
  //       arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
  //   }

  //   Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
    }
    public static void method1(){
        final int size = 10000000;
        final int h = size / 2;
        arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.println("method1 time: " + (b-a));
    }


    public static void method2(){
        final int size = 10000000;
        final int h = size / 2;
        arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        a = System.currentTimeMillis();
        final float[] a1 = new float[arr.length/2];
        final float[] a2 = new float[arr.length/2];
        System.arraycopy(arr, 0, a1, 0, arr.length/2);
        System.arraycopy(arr, arr.length/2, a2, 0, arr.length/2);
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(a1, 0, arr, 0, arr.length/2);
                System.out.println("Method2 thread1 time: "+(System.currentTimeMillis() - a));
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(a2, 0, arr, arr.length/2, arr.length/2);
                System.out.println("Method2 thread2 time: "+(System.currentTimeMillis() - a));
            }
        }).start();
    }
}
