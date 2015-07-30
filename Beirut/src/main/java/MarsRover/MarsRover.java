package MarsRover;

import com.google.common.collect.ImmutableMap;

/**
 * Coding Dojo Session
 * https://code.google.com/p/marsrovertechchallenge/
 * Date: 29/07/2015
 **/
public class MarsRover {

   private static final String WEST = "W";
   private static final String EAST = "E";
   private static final String NORTH = "N";
   private static final String SOUTH = "S";

   private static final ImmutableMap<String, Integer> X_DIRECTION = ImmutableMap.of(WEST, -1, EAST, 1, NORTH, 0, SOUTH, 0);
   private static final ImmutableMap<String, Integer> Y_DIRECTION = ImmutableMap.of(WEST, 0, EAST, 0, NORTH, 1, SOUTH, -1);

   private static final ImmutableMap<String, String> RIGHT_MOVEMENTS = ImmutableMap.of(NORTH, EAST, EAST, SOUTH, SOUTH, WEST, WEST, NORTH);
   private static final ImmutableMap<String, String> LEFT_MOVEMENTS = ImmutableMap.of(NORTH, WEST, WEST, SOUTH, SOUTH, EAST, EAST, NORTH);

   public static String moveRobot(int height, int width, String startLocation, String instructions) {
      final String[] params = startLocation.split(" ");
      return location(params[0], params[1], params[2], instructions);
   }

   private static String location(String x, String y, String direction, String instructions) {
      if(instructions.isEmpty()) {
         return x + " " + y + " "+ direction;
      }
      final String nextInstruction = instructions.substring(0, 1);
      final String instructionsTail = instructions.substring(1, instructions.length());
      if(nextInstruction.equals("R")) {
         return location(x, y, RIGHT_MOVEMENTS.get(direction), instructionsTail);
      }
      if(nextInstruction.equals("L")) {
         return location(x, y, LEFT_MOVEMENTS.get(direction), instructionsTail);
      }
      return location(delta(x, direction, X_DIRECTION), delta(y, direction, Y_DIRECTION), direction, instructionsTail);
   }

   private static String delta(String x, String direction, ImmutableMap<String, Integer> directionMap) {
      return String.valueOf(Integer.parseInt(x) + directionMap.get(direction));
   }
}