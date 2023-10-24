package lab3;

import java.util.Arrays;


// 3. Удалить в массиве все наибольшие элементы.

public class Main1 {
    public static void main(String[] args){
        int[] arr = new int[]{1, 5, 5, 3, 4, 5};
        int maxNum = arr[0]; // index of element to be removed

        for (var i : arr){ // print of the array
            System.out.print(i + " ");
        }

        System.out.print("\n");

        for (int j : arr) { // finding max num in array
            if (maxNum < j) {
                maxNum = j;
            }
        }

        for (int j = 0; j < arr.length; j++){ // moving all of the max nums to the end of the array
            for (int i = 0; i < arr.length - 1; i++){
                if (arr[i] == maxNum){
                    if (arr[i + 1] != maxNum){
                        arr[i] = arr[i + 1];
                        arr[i + 1] = maxNum;
                    }
                }
            }
        }

        for (var i : arr){ // print of all of the nums except max
            if (i != maxNum){
                System.out.print(i + " ");
            }
        }
    }
}
