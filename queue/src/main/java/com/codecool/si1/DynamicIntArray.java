package com.codecool.si1;

// put your code here!
public class DynamicIntArray {

    private int[] currentArray;

    DynamicIntArray(){
        currentArray = new int[0];
    }

    DynamicIntArray(int numOfElements) {
        currentArray = new int [numOfElements];
    }

    public void add(int numToAdd) {
        int[] temp = new int[currentArray.length+1];
        temp[currentArray.length] = numToAdd;
        for (int i = 0; i < currentArray.length; i++) {
            temp[i] = currentArray[i];
        }
        currentArray = temp;
    }

    public void remove(int numToRemove) {
        for (int i = 0; i < currentArray.length; i++) {
            if (currentArray[i] == numToRemove) {
                int[] temp = new int[currentArray.length-1];
                for (int j = 0; j < temp.length; j++) {
                    if (j >= i && i < temp.length) {
                        i++;
                        temp[j] = currentArray[i];
                    } else {
                        temp[j] = currentArray[j];
                    }
                }
                i = currentArray.length;
                currentArray = temp;
            } else if (i == currentArray.length-1) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    public void insert(int index, int numToInsert) {
        int length = currentArray.length;
        int[] temp = new int[length+1];
        if (index > length) {
            index = length;
        } else {
            temp[length] = currentArray[length-1];
        }
        temp[index] = numToInsert;

        int j;
        for (j = 0; j < index; j++) {
            temp[j] = currentArray[j];
        }

        for (int i = 1 + index; i < length; i++) {
            temp[i] = currentArray[j];
            j++;
        }

        currentArray = temp;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int number : currentArray) {
            stringBuilder.append(" " + number);
        }
        return stringBuilder.toString();
    }



}
