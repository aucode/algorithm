package au.code.sparse;

/**
 * @Project algorithm
 * @Description: SparseArray
 * @Author
 * @Explain
 * @Date 2021-04-11 15:59
 */
public class SparseArray {
    public static void main(String[] args) {

        //创建一个11*11的棋盘，用二维数组表示 ：0：无棋子，1：黑色棋子，2：白色棋子
        int chessArray[][] = new int[11][11];

        //设置棋子。
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;

        //遍历输出二为数组棋盘
        System.out.println("二维数组棋盘：");
        for (int[] row : chessArray) {
            for (int val : row) {
                System.out.printf("%d\t", val);
            }
            System.out.println();
        }

        //转换成稀疏矩阵
        int sparseArray[][] = new int[valsum(chessArray) + 1][3];

        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = valsum(chessArray);
        //找到二维数组中有数据的位置，并保存到稀疏矩阵中
        int count = 0;
        for (int i = 0; i < 11; i++) {

            for (int j = 0; j < 11; j++) {

                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];

                }
            }
        }

        System.out.println("输出稀疏矩阵：");
        for (int[] row : sparseArray) {

            for (int val : row) {
                System.out.printf("%d\t", val);
            }
            System.out.println();
        }

        System.out.println("稀疏矩阵转换成二位数组：");
        int toChessArray[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i <= sparseArray[0][2]; i++) {

            toChessArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        for (int[] row : toChessArray) {

            for (int val : row) {

                System.out.printf("%d\t", val);
            }
            System.out.println();
        }


    }

    public static int valsum(int array[][]) {
        int sum = 0;
        for (int i = 0; i < 11; i++) {

            for (int j = 0; j < 11; j++) {

                if (array[i][j] != 0) {

                    sum++;
                }
            }
        }
        return sum;
    }
}
