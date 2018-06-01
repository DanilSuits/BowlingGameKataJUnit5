/**
 * Copyright Vast 2018. All Rights Reserved.
 * <p/>
 * http://www.vast.com
 */
package veetwo;

/**
 * @author Danil Suits (danil@vast.com)
 */
public class VeeTwo {

    public interface Game {
        int score(int... readings);
    }

    public Game game() {
        class SimpleGame implements Game {

            @Override
            public int score(int... readings) {
                int[] pinsKnockedDown = pinsKnockedDown(readings);
                return veeOneScore(pinsKnockedDown);
            }

            private int veeOneScore(int[] pinsKnockedDown) {
                int[] framePositions = framePositions(pinsKnockedDown);

                int gameScore = 0;
                for (int firstBall : framePositions) {
                    int secondBall = firstBall + 1;
                    int thirdBall = secondBall + 1;

                    // TODO
                    int scoreInFrame
                            = pinsKnockedDown[firstBall] +
                            pinsKnockedDown[secondBall] +
                            pinsKnockedDown[thirdBall];

                    gameScore += scoreInFrame;
                }
                return gameScore;
            }

            private int[] framePositions(int[] pinsKnockedDown) {
                int[] framePositions = new int[10];
                int nextFrame = 0;

                for (int pos = 0; pos  < framePositions.length; ++pos) {
                    framePositions[pos] = nextFrame;
                    // TODO
                    nextFrame += 1;
                }
                return framePositions;
            }

            private int[] pinsKnockedDown(int[] readings) {
                int[] perfectGame = new int[readings.length];
                for (int pos = 0; pos < perfectGame.length; ++pos) {
                    // TODO
                    perfectGame[pos] = 10 - readings[pos];
                }
                return perfectGame;
            }
        }

        Game game = new SimpleGame();

        return game;
    }
}
