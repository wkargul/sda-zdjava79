package pl.sdacademy.podstawy.arrays;

public class MultiDimensional {
    public static void main(String[] args) {

        final int gridSize = 5;
        int[][] grid = new int[gridSize][gridSize];

        int[][] predefinedGrid = new int[][] {
            new int[] { 1, 2, 3},
            new int[] { 4, 5, 6},
            new int[] { 7, 8, 9},
            new int[] { 10, 11, 12}
        };

        int value = 0;
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                final int nextValue = ++value;

                if (nextValue % 2 == 0) {
                    //Warunkowo zakończy iterację
                    continue;

                    //Warunkowo zakończy pętlę
                    //break;
                }

                grid[row][column] = nextValue;

                //Tablica wielowymiarowa to tablica gdzie typem danych też jest tablica
                //int[] rowArray = grid[row];
                //rowArray[column] = nextValue;
            }
        }

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                System.out.printf("%02d ", grid[i][j]);
            }
            System.out.println();
        }
    }
}
