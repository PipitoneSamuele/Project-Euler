package utility;

public class MatrixUtility {

    public static <T> void printMatrix(T[][] matrix) {
        if(matrix != null) {
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}
