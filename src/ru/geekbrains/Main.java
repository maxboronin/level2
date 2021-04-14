package ru.geekbrains;

public class Main {
    private static final int size = 4;
    
    public static void main(String[] args) throws MySizeArrayException {
	    String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "a", "7"},
                {"11", "24", "33", "24"},
                {"12", "32", "63", "14"},
        };

	    System.out.println("Сумма элементов массива: " + sumArray(array));;
    }

    private static int sumArray(String[][] array) throws MySizeArrayException {
        int sum = 0;

        if(array.length != size){
            throw new MySizeArrayException(array.length, size);
        }

        for (int i=0; i<size; i++) {
            if(array[i].length != size){
                throw new MySizeArrayException(array[i].length, size);
            }

            for (int j=0; j < size; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(array[i][j], i, j);
                }
            }
        }

        return sum;
    }

    private static class MySizeArrayException extends Exception {

        public MySizeArrayException(int currentSize, int neededSize) {
            super("Размерность массива (" + currentSize + ") отличается от требуемой:" + neededSize);
        }
    }

    private static class MyArrayDataException extends NumberFormatException {

        public MyArrayDataException(String s, int i, int j) {
            super("Элемент массива '" + s + "' в позиции [" + i + "][" + j + "] не может быть преобразован в Int");
        }
    }
}
