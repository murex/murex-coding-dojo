public final class SpiralDiagonal {
   public static int sumOfEdge(int size) {
      if (size == 1) {
         return 1;
      }

      int edgeDistance = size - 1;

      int topRightCorner = size * size;
      int topLeftCorner = topRightCorner - edgeDistance;
      int bottomLeftCorner = topLeftCorner - edgeDistance;
      int bottomRightCorner = bottomLeftCorner - edgeDistance;

      return topRightCorner + topLeftCorner + bottomLeftCorner + bottomRightCorner;
   }

   public static int spiralSum(int size) {
     if(size == 1) {
        return sumOfEdge(1);
     }
      return sumOfEdge(size)+spiralSum(size-2);
   }
}
