package com.company;

import java.util.Random;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.AbstractList;

/**
 *  Class Collections
 *  @author George Sapozhkov
 */
public class Collections {
    /**
     * Функция создает тестовый набор значений для проверки метода 'get'
     * @param n длина массива значений
     * @param vals массив для заполнения контейнера
     * @param indices массив индексов из области 0..n-1
     */
    public static void createGetCheck( int n,
                                       LinkedList<Integer> vals,
                                       LinkedList<Integer> indices ) {

        Random rnd = new Random();
        indices.clear();
        vals.clear();

        for ( int i = 0; i < n; i++ ) {
            indices.add(rnd.nextInt(n));
            vals.add(rnd.nextInt());
        }
    }

    /**
     * Проверка метода get
     * @param vals массив случайных значений
     * @param indices массив случайных индексов
     * @return число секунд, потраченное на проверку
     */
    public static double getCheck( LinkedList<Integer> vals,
                                   LinkedList<Integer> indices,
                                   AbstractList<Integer> ar ) {
        int n = vals.size();
        ListIterator<Integer> vals_it = vals.listIterator( 0 );
        ar.clear();
        for ( int i = 0; i < n; i++ ) {
            ar.add( vals_it.next());
        }
        ListIterator<Integer> indices_it = indices.listIterator( 0 );
        long time1 = System.currentTimeMillis();
        for ( int i = 0; i < n; i++ ) {
            ar.get( indices_it.next());
        }
        long time2 = System.currentTimeMillis();
        return (time2 - time1) / 1000.0;
    }

    /**
     * Функция создает тестовый набор значений для проверки метода 'set'
     * @param n длина массива значений
     * @param vals массив для заполнения контейнера
     * @param dontHaveVals массив значений, которых нет в vals
     * @param indices массив случайных индексов
     */
    public static void createSetCheck( int n,
                                       LinkedList<Integer> vals,
                                       LinkedList<Integer> dontHaveVals,
                                       LinkedList<Integer> indices ) {

        Random rnd = new Random();
        indices.clear();
        vals.clear();
        dontHaveVals.clear();

        for ( int i = 0; i < n; i++ ) {
            indices.add(rnd.nextInt(n));
            vals.add(rnd.nextInt());
            dontHaveVals.add(rnd.nextInt());
        }
    }

    /**
     * Проверка метода set
     * @param vals массив случайных значений
     * @param dontHaveVals массив значений, которых нет в vals
     * @param indices массив случайных индексов
     * @return число секунд, потраченное на проверку
     */
    public static double setCheck( LinkedList<Integer> vals,
                                   LinkedList<Integer> dontHaveVals,
                                   LinkedList<Integer> indices,
                                   AbstractList<Integer> ar ) {
        int n = vals.size();
        ListIterator<Integer> vals_it = vals.listIterator( 0 );
        ar.clear();
        for ( int i = 0; i < n; i++ ) {
            ar.add( vals_it.next());
        }
        ListIterator<Integer> indices_it = indices.listIterator( 0 );
        ListIterator<Integer> dontHaveVals_it = dontHaveVals.listIterator( 0 );
        long time1 = System.currentTimeMillis();
        for ( int i = 0; i < n; i++ ) {
            ar.set( indices_it.next(), dontHaveVals_it.next());
        }
        long time2 = System.currentTimeMillis();
        return (time2 - time1) / 1000.0;
    }

    /**
     * Функция создает тестовый набор значений для проверки метода 'add'
     * @param n длина массива значений
     * @param vals массив значений
     * @param indices массив индексов
     */
    public static void createAddCheck( int n, LinkedList<Integer> vals,
                                      LinkedList<Integer> indices ) {

        Random rnd = new Random();
        vals.clear();
        indices.clear();

        for ( int i = 1; i <= n; i++ ) {
            indices.add(rnd.nextInt(i));
            vals.add(rnd.nextInt());
        }
    }

    /**
     * Проверка метода 'add'
     * @param vals массив для последовательного заполнения контейнера
     * @param indices массив случайных (но подходящих) индексов
     * @return число секунд, потраченное на проверку
     */
    public static double addCheck( LinkedList<Integer> vals,
                                  LinkedList<Integer> indices,
                                  AbstractList<Integer> ar ) {
        int n = vals.size();
        ListIterator<Integer> vals_it = vals.listIterator( 0 );
        ListIterator<Integer> indices_it = indices.listIterator( 0 );
        long time1 = System.currentTimeMillis();
        for ( int i = 0; i < n; i++ ) {
            ar.add(indices_it.next(), vals_it.next());
        }
        long time2 = System.currentTimeMillis();
        return (time2 - time1) / 1000.0;
    }

    /**
     * Функция создает тестовый набор значений для проверки метода 'delete'
     * @param n длина массива значений
     * @param vals случайный набор целых чисел
     * @param haveVals случайно переставленный набор целых чисел
     * @param dontHaveVals набор значений, не входящих в vals
     */
    public static void createDeleteObjectCheck( int n, LinkedList<Integer> vals,
                                               LinkedList<Integer> haveVals,
                                               LinkedList<Integer> dontHaveVals
    ) {

        Random rnd = new Random();
        vals.clear();
        haveVals.clear();
        dontHaveVals.clear();

        for ( int i = 0; i < n; i++ ) {
            vals.add(rnd.nextInt());
        }

        ListIterator<Integer> it = vals.listIterator( 0 );
        for ( int i = 0; i < n; i++ ) {
            haveVals.add(rnd.nextInt(i+1), it.next());
        }
        int i = 0;
        while ( i < n ) {
            int val = rnd.nextInt();
            if ( ! vals.contains(val)) {
                dontHaveVals.add(val);
                i++;
            }
        }
    }

    /**
     * Проверка метода 'delete'
     * @param vals массив для заполнения контейнера
     * @param haveVals массив тех же значений в случайном порядке
     * @param dontHaveVals  массив значений, которых нет в vals
     * @return число секунд, потраченное на проверку
     */
    public static double deleteObjectCheck( LinkedList<Integer> vals,
                                           LinkedList<Integer> haveVals,
                                           LinkedList<Integer> dontHaveVals,
                                           AbstractList<Integer> ar ) {
        int n = vals.size();
        ListIterator<Integer> vals_it = vals.listIterator( 0 );
        ar.clear();
        for ( int i = 0; i < n; i++ ) {
            ar.add( vals_it.next() );
        }
        ListIterator<Integer> dontHave_it = dontHaveVals.listIterator( 0 );
        ListIterator<Integer> have_it = haveVals.listIterator( 0 );
        long time1 = System.currentTimeMillis();
        for ( int i = 0; i < n; i++ )
            ar.remove(dontHave_it.next());
        for ( int i = 0; i < n; i++ )
            ar.remove(have_it.next());
        long time2 = System.currentTimeMillis();
        return (time2 - time1) / 1000.0;
    }

    /**
     * Проверка метода indexOf
     * @param vals массив для заполнения контейнера
     * @param haveVals массив тех же значений в случайном порядке
     * @param dontHaveVals массив значений, которых нет в vals
     * @return число секунд, потраченное на проверку
     */
    public static double indexOfCheck( LinkedList<Integer> vals,
                                      LinkedList<Integer> haveVals,
                                      LinkedList<Integer> dontHaveVals,
                                      AbstractList<Integer> ar ) {
        int n = vals.size();
        ListIterator<Integer> vals_it = vals.listIterator( 0 );
        ar.clear();
        for ( int i = 0; i < n; i++ ) {
            ar.add( vals_it.next());
        }
        ListIterator<Integer> haveVals_it = haveVals.listIterator( 0 );
        ListIterator<Integer> dontHaveVals_it = dontHaveVals.listIterator( 0 );
        long time1 = System.currentTimeMillis();
        for ( int i = 0; i < n; i++ ) {
            ar.indexOf( dontHaveVals_it.next());
        }
        for ( int i = 0; i < n; i++ ) {
            ar.indexOf( haveVals_it.next());
        }
        long time2 = System.currentTimeMillis();
        return (time2 - time1) / 1000.0;
    }

    /**
     * Проверка метода lastIndexOf
     * @param vals массив для заполнения контейнера
     * @param haveVals массив тех же значений в случайном порядке
     * @param dontHaveVals массив значений, которых нет в vals
     * @return число секунд, потраченное на проверку
     */
    public static double lastIndexOfCheck( LinkedList<Integer> vals,
                                          LinkedList<Integer> haveVals,
                                          LinkedList<Integer> dontHaveVals,
                                          AbstractList<Integer> ar ) {
        int n = vals.size();
        ListIterator<Integer> vals_it = vals.listIterator( 0 );
        ar.clear();
        for ( int i = 0; i < n; i++ ) {
            ar.add( vals_it.next());
        }
        ListIterator<Integer> haveVals_it = haveVals.listIterator( 0 );
        ListIterator<Integer> dontHaveVals_it = dontHaveVals.listIterator( 0 );
        long time1 = System.currentTimeMillis();
        for ( int i = 0; i < n; i++ ) {
            ar.indexOf( dontHaveVals_it.next());
        }
        for ( int i = 0; i < n; i++ ) {
            ar.indexOf( haveVals_it.next());
        }
        long time2 = System.currentTimeMillis();
        return (time2 - time1) / 1000.0;
    }

    public static void main( String argv[] ) {
        int n = 20000;
        LinkedList<Integer> vals = new LinkedList<Integer>();
        LinkedList<Integer> haveVals = new LinkedList<Integer>();
        LinkedList<Integer> dontHaveVals = new LinkedList<Integer>();
        LinkedList<Integer> indices = new LinkedList<Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        createAddCheck( n, vals, indices );
        System.out.println("Результаты тестирования метода add для " + n + " вызовов:");
        System.out.println( "ArrayList (сек): " + addCheck(vals, indices, array) +
                " LinkedList (сек): " + addCheck(vals, indices, list)
        );
        createDeleteObjectCheck( n, vals, haveVals, dontHaveVals );
        System.out.println("Результаты тестирования метода delete для " +
                ( 2 * n ) + " вызовов:");
        System.out.println( "ArrayList (сек): " +
                deleteObjectCheck(vals, haveVals, dontHaveVals, array) +
                " LinkedList (сек): " +
                deleteObjectCheck(vals, haveVals, dontHaveVals, list)
        );
        createGetCheck( n, vals, indices );
        System.out.println("Результаты тестирования метода get для " + n + " вызовов:");
        System.out.println( "ArrayList (сек): " +
                getCheck( vals, indices, array) +
                " LinkedList (сек): " +
                getCheck( vals, indices, list)
        );
        createSetCheck( n, vals, dontHaveVals, indices );
        System.out.println("Результаты тестирования метода set для " + n + " вызовов:");
        System.out.println( "ArrayList (сек): " +
                setCheck( vals, dontHaveVals, indices, array) +
                " LinkedList (сек): " +
                setCheck( vals, dontHaveVals, indices, list)
        );
        createDeleteObjectCheck( n, vals, haveVals, dontHaveVals );
        System.out.println("Результаты тестирования метода indexOf для " + (2*n) + " вызовов:");
        System.out.println( "ArrayList (сек): " +
                indexOfCheck( vals, haveVals, dontHaveVals, array) +
                " LinkedList (сек): " +
                indexOfCheck( vals, haveVals, dontHaveVals, list)
        );
        createDeleteObjectCheck( n, vals, haveVals, dontHaveVals );
        System.out.println("Результаты тестирования метода lastIndexOf для " + (2*n) + " вызовов:");
        System.out.println( "ArrayList (сек): " +
                lastIndexOfCheck( vals, haveVals, dontHaveVals, array) +
                " LinkedList (сек): " +
                lastIndexOfCheck( vals, haveVals, dontHaveVals, list)
        );
    }
}
