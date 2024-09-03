package uz.pdp.online.matritsaniosinshtartibidachiqarish.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GeneratingAndSortingService {

    public int[][] generateMatrix(int rowLength, int columnLength) {

        int[][] matrix = new int[rowLength][columnLength];

        Random random = new Random();

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                matrix[i][j] = random.nextInt(50); // 1 dan 50 gacha bo'lgan sonlar orasidan random son aniqlimiz.
            }
        }

        return matrix;
    }

    public List<List<Integer>> sortMatrixAndGetAsList(int[][] matrix,int rowLength, int columnLength) {

/////////////////////////////////////////// Matritsani bittalik massivga olib o'tyapman
        int[] ints = new int[rowLength * columnLength];
        int k = 0;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                ints[k++] = matrix[i][j];
            }
        }

////////////////////////////////////  Selection sorting orqali sort qilyapman

        /** Nima uchun Selection sort ishlatdim. Agar men to'ridan to'ri matritsani o'zidan turib
         * sort qilganimda O(n^2) amal bajarilardi bu degani Kattaroq datalarda osilib qolardi
         * yani vaqtdan va hotiradan yutqazardik. Shuning uchun selection sort bizaga
         * O(!n) yani n ning faktorialicha amal bajariladi bu bilan sortingning ancha yeggilatishimiz mumkin
         */

        int minPointer, bufer;

        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                minPointer = i;
                if (ints[minPointer] > ints[j]) {
                    minPointer = j;
                }

                bufer = ints[i];
                ints[i] = ints[minPointer];
                ints[minPointer] = bufer;

            }
        }

///////////////////////////////////// So'rtlangan 1 talik massivni 2 talik massivga ilon usuli bo'yicha olib o'tyapman
        int[][] sortedMatrix = new int[rowLength][columnLength];
        int p=0;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (i % 2 == 0) {
                    sortedMatrix[i][j] = ints[p++];
                } else {
                    sortedMatrix[i][columnLength - 1 - j] = ints[p++];
                }
            }
        }
        return getAsList(sortedMatrix, rowLength, columnLength);
    }

    public List<List<Integer>> getAsList(int[][] ints, int rowLength, int columnLength) {

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < rowLength; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < columnLength; j++) {
                row.add(ints[i][j]);
            }
            matrix.add(row);
        }

        return matrix;
    }
}
