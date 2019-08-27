import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.Arrays.stream;

public class MaxPathSum {
    public static void main(String[] args) throws Exception {
        
        int[][] pyramid = Files.lines(Paths.get("/Users/gretabaceviciute/Desktop/pyramidTask/src/main/java/numbers.txt"))
                .map(string -> stream(string.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);

        boolean isEvenNumber = false;
        int sum = 0;
        int column = 0;

        for (int row = 0; row < pyramid.length; row++) {
            int value = pyramid[row][column];

            if (row == 0 && column == 0) {
                isEvenNumber = isEvenCheck(pyramid[row][column]);
                sum += value;
                column = 0;

            } else {
                if (isEvenNumber) {

                    if (!isEvenCheck(value) && !isEvenCheck(pyramid[row][column + 1])) {
                        if (value > pyramid[row][column + 1]) {
                            sum += value;
                        } else {
                            sum += pyramid[row][column + 1];
                            column += 1;
                        }

                    } else if (!isEvenCheck(value)) {
                        sum += value;
                    } else {
                        sum += pyramid[row][column + 1];
                        column += 1;
                    }
                    isEvenNumber = false;

                } else {
                    if (isEvenCheck(value) && isEvenCheck(pyramid[row][column + 1])) {
                        if (value > pyramid[row][column + 1]) {
                            sum += value;
                        } else {
                            sum += pyramid[row][column + 1];
                            column += 1;
                        }

                    } else if (isEvenCheck(value)) {
                        sum += value;
                    } else {
                        sum += pyramid[row][column + 1];
                        column += 1;
                    }
                    isEvenNumber = true;
                }
            }
        }

        System.out.println("Final total: " + sum);
    }

    public static boolean isEvenCheck(int value) {
        return value % 2 == 0;
    }
}
