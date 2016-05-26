import java.util.Scanner;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {


   public static enum Room {

      TYPE0 {},
      TYPE1 {},
      TYPE2 {
         @Override
         int getNewY(int y, String position) {
            return y;
         }

         @Override
         int getNewX(int x, String position) {
            return x + (position.equals(Constants.LEFT) ? 1 : -1);
         }
      },
      TYPE3 {},
      TYPE4 {
         @Override
         int getNewX(int x, String position) {
            return x + (position.equals(Constants.RIGHT)?0:-1);
         }

         @Override
         int getNewY(int y, String position) {
            return y+ (position.equals(Constants.RIGHT)?1:0);
         }
      },
      TYPE5 {
         @Override
         int getNewX(int x, String position) {
            return x + (position.equals(Constants.TOP)?1:0);
         }

         @Override
         int getNewY(int y, String position) {
            return y+ (position.equals(Constants.TOP)?0:1);
         }
      },
      TYPE6 {
         @Override
         int getNewX(int x, String position) {
            return x + (position.equals(Constants.LEFT)?1:-1);
         }

         @Override
         int getNewY(int y, String position) {
            return y;
         }
      },
      TYPE7 {},
      TYPE8 {},
      TYPE9 {},
      TYPE10 {
         @Override
         int getNewY(int y, String position) {
            return y;
         }

         @Override
         int getNewX(int x, String position) {
            return x - 1;
         }
      },
      TYPE11 {
         @Override
         int getNewY(int y, String position) {
            return y;
         }

         @Override
         int getNewX(int x, String position) {
            return x + 1;
         }
      },
      TYPE12 {},
      TYPE13 {};

      int getNewX(int x, String position) {
         return x;
      }

      int getNewY(int y, String position) {
         return y + 1;
      }

      private static class Constants {
         private static final String LEFT = "LEFT";
         public static final String TOP = "TOP";
         public static final String RIGHT = "RIGHT";
      }
   }

   static Room[][] roomMap;

   public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
      int W = in.nextInt(); // number of columns.
      int H = in.nextInt(); // number of rows.
      roomMap = new Room[H][W];
      Room[] rooms = Player.Room.TYPE0.getDeclaringClass().getEnumConstants();

      System.err.println("Width:" + W);
      System.err.println("Height:" + H);
      in.nextLine();
      for (int i = 0; i < H; i++) {
         String LINE = in.nextLine(); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
         System.err.println(LINE);
         String[] LINE2 = LINE.split(" ");
         for (int index = 0; index < W; index++) {
            int roomType = Integer.parseInt(LINE2[index]);
            roomMap[i][index] = rooms[roomType];
         }
      }

      int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).
      System.err.println("Exit:" + EX);

      // game loop
      while (true) {
         int XI = in.nextInt();
         int YI = in.nextInt();
         String POS = in.next();

         System.err.println("XI:" + XI + " : YI:" + YI + " : POS:" + POS);
         // Write an action using System.out.println()
         // To debug: System.err.println("Debug messages...");
         Room room = roomMap[YI][XI];
         int updatedX = room.getNewX(XI, POS);
         int updatedY = room.getNewY(YI, POS);
         System.out.println(updatedX + " " + updatedY);
         // One line containing the X Y coordinates of the room in which you believe Indy will be on the next turn.
      }
   }

}