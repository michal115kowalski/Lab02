package Zadanie2;

import java.util.*;
import java.lang.Math;

public class Zadania {
    private int lenghArray=0;
    private double[] array;
    private double[] automaticNumbers=new double[]{2,3,3.5,4,4.5,5};
    private double variance,help=0,average;
    private boolean validIn=false;
    public void statisticData() {
        Random numberGenerator = new Random();
        System.out.println("Podaj ilosc elemtnow tablicy: ");
        Scanner enterData = new Scanner(System.in);
        while(!validIn){
            try {
                lenghArray = enterData.nextInt();
                array = new double[lenghArray];
                if(lenghArray==0) throw new IllegalArgumentException("Wielkosc tablicy musi być wieksza niz 0");
                validIn=true;
            }catch (InputMismatchException | NegativeArraySizeException |IllegalArgumentException e){
                System.out.println("Liczba elementow musi byc liczba naturalna większa od 0");
                enterData.next();
            }
        }


        System.out.println("Elementy tablicy: ");
        for (int i = 0; i < lenghArray; i++) {
            array[i] = automaticNumbers[numberGenerator.nextInt(6)];
            System.out.println(array[i]);
        }
        average=averageArray(array);

        System.out.println("Srednia wartosc elementow tablicy to: "+average+
                "\nWartosc maksymalna to: "+maxValue(array)+
                "\nWartosc minimalna w tablicy to: "+minValue(array)+
                "\nWartości wyzsze niz srednia: ");
        for(double e:higherAverage(array)) System.out.println(e);
        System.out.println("Wartości niższe niż średnia: ");
        for (double e:lowerAverage(array)) System.out.println(e);
        System.out.println("Odchylenie standardowe wynosi: "+standardDeviation(array));
    }


    public double averageArray(double[] array){
        return Arrays.stream(array).average().getAsDouble();
    }
    public double maxValue(double[] array){
        return Arrays.stream(array).max().getAsDouble();
    }
    public double minValue(double[] array){
        double a=Arrays.stream(array).min().getAsDouble();
        return a;
    }
    public double[] higherAverage(double[]array) {
        return (Arrays.stream(array)
                .filter(x -> x > average)
                .toArray());
    }
    public double[] lowerAverage(double[]array){
        return Arrays.stream(array)
                .filter(x->x<average)
                .toArray();
    }
    public double standardDeviation(double[]array){
        for(double x:array){
            help+=(Math.pow((x-average),2));
        }variance=help/average;
        return Math.sqrt(variance);
    }

}

