import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class APUPlayer {

   public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
      int width = in.nextInt(); // the number of cells on the X axis
      int height = in.nextInt(); // the number of cells on the Y axis
      in.nextLine();
      List<List<Boolean>> matrix = new ArrayList();
      for (int i = 0; i < height; i++) {
         String line = in.nextLine(); // width characters, each either 0 or .
         List<Boolean> row = new ArrayList<Boolean>();
         for (int i1 = 0; i1 < line.length(); i1++) {
            row.add(line.charAt(i1) == '0');
            // True is for a power node
         }
         matrix.add(row);
      }
      for (int rowIndex = 0; rowIndex < matrix.size(); rowIndex++) {
         for (int columnIndex = 0; columnIndex < matrix.get(rowIndex).size(); columnIndex++) {
            if (matrix.get(rowIndex).get(columnIndex)) {
               String neighbours = columnIndex + " " + rowIndex;
               neighbours += (horizontalNeighbours(matrix.get(rowIndex), columnIndex, rowIndex));
               neighbours += (verticalNeighbours(matrix, rowIndex, columnIndex));
               System.out.println(neighbours);
            }
         }
      }
   }

   static String verticalNeighbours(List<List<Boolean>> matrix, int row, int columnIndex) {
      for (int i = row + 1; i < matrix.size(); ++i) {
         if (matrix.get(i).get(columnIndex)) {
            return " " + columnIndex + " " + i;
         }
      }
      return " -1 -1";
   }

   static String horizontalNeighbours(List<Boolean> row, int columnIndex, int rowIndex) {
      for (int i = columnIndex + 1; i < row.size(); ++i) {
         if (row.get(i)) {
            return " " + i + " " + rowIndex;
         }
      }
      return " -1 -1";
   }

}

