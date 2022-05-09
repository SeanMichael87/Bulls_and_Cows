
class ArrayOperations {
    static final int SIZE = 3;
    
    public static int[][][] createCube() {
        
        int[][][] array = new int[SIZE][SIZE][SIZE];

        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    array[i][j][k] = count;
                    count++;
                }
            }
        }
        return array;
    }
}
