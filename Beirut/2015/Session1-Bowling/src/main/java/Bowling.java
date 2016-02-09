import static java.lang.Integer.parseInt;

/**
 * Coding Dojo Session
 * Write a program to score a game of Ten-Pin Bowling.
 * http://cyber-dojo.org/setup/show/
 * Date: 15/07/2015
 **/
public class Bowling {

   private static final int MAX_SCORE = 10;
   private static final String STRIKE = "X";
   private static final String SPARE = "/";

   public static int play(String gameFrame) {
      int score = 0;
      String[] splitGameFrame = gameFrame.replace("-", "0").split("\\|");

      for (int i = 0; i < splitGameFrame.length; i++) {
         final String frame = splitGameFrame[i];

         if (i < splitGameFrame.length - 1) {

            final String nextFrame = splitGameFrame[i + 1];

            score += computeFrameScore(frame, nextFrame);
         } else {
            score += computeFrameScore(frame, "--");
         }
      }

      return score;

   }

   private static int computeFrameScore(String frame, String nextFrame) {
      if (frameCharAt(frame, 0).equals(STRIKE)) {
         return MAX_SCORE + frameScore(nextFrame);
      } else if (frameCharAt(frame, 1).equals(SPARE)) {
         return MAX_SCORE + ballScore(nextFrame, 0);
      }
      return frameScore(frame);
   }

   private static int frameScore(String frame) {
      return ballScore(frame, 0) + ballScore(frame, 1);
   }

   private static int ballScore(String frame, int position) {
      final String ballScoreStr = frameCharAt(frame, position);
      if(ballScoreStr.equals(SPARE))return MAX_SCORE-ballScore(frame,0);
      return parseInt(ballScoreStr);
   }

   private static String frameCharAt(String Frame, int position) {
      return Frame.substring(position, position + 1);
   }
}

