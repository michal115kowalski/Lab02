package Zadanie2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Macierze {
    private int degree=0,help=0;
    private int[][] firstMatrix, secondMatrix, addingMatrix, subtractionMatrix, multiplyingMatrix;
    private boolean validIn=false;

    public void mainMatrix() {
        Random valueMatrix = new Random();
        System.out.println("Podaj stopien macierzy:");
        Scanner enterSize = new Scanner(System.in);
        while(!validIn){
            try{
                degree = enterSize.nextInt();
                firstMatrix = new int[degree][degree];
                secondMatrix = new int[degree][degree];
                addingMatrix = new int[degree][degree];
                subtractionMatrix = new int[degree][degree];
                validIn=true;
            }catch (InputMismatchException  | NegativeArraySizeException r){
                System.out.println("Prosze podac liczbe całkowitą, nieujemną ");
                enterSize.next();
            }
        }

        for (int row = 0; row < degree; row++) {
            for (int col = 0; col < degree; col++) {
                firstMatrix[row][col] = valueMatrix.nextInt(21) - 10;
                secondMatrix[row][col] = valueMatrix.nextInt(21) - 10;
                addingMatrix[row][col] = (firstMatrix[row][col] + secondMatrix[row][col]);
                subtractionMatrix[row][col] = (firstMatrix[row][col] - secondMatrix[row][col]);
            }
        }
        System.out.println("Pierwsza macierz:");
        show(firstMatrix);
        System.out.println("Druga macierz: ");
        show(secondMatrix);
        System.out.println("Macierz powstala po dodaniu dwoch macierzy: ");
        show(addingMatrix);
        System.out.println("Macierz powstala po odjeciu dowch macierzy");
        show(subtractionMatrix);
        System.out.println("Mnozenie dwoch macierzy: ");
        multiplication(firstMatrix, secondMatrix);

    }

    public void show(int[][] tab1) {
        for (int[] tab : tab1) {
            for (int number : tab) {
                System.out.print(number + "  ");
            }
            System.out.println("");
        }
    }

    public void multiplication(int[][] tab1, int[][] tab2) {
    multiplyingMatrix=new int[degree][degree];
        for (int i = 0; i < degree; i++) {
            for (int j = 0; j < degree; j++) {
                for( int k=0;k<degree;k++){
                    help+=tab1[i][k]*tab2[k][j];
                }multiplyingMatrix[i][j]=help;
                help=0;
            }
        }
        show(multiplyingMatrix);
    }
}