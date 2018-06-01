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

                    int scoreInFrame
                            = pinsKnockedDown[firstBall] +
                            pinsKnockedDown[secondBall];

                    if (scoreInFrame >= 10) {
                        scoreInFrame +=
                                pinsKnockedDown[thirdBall];
                    }

                    gameScore += scoreInFrame;
                }
                return gameScore;
            }

            private int[] framePositions(int[] pinsKnockedDown) {
                int[] framePositions = new int[10];
                int nextFrame = 0;

                for (int pos = 0; pos < framePositions.length; ++pos) {
                    framePositions[pos] = nextFrame;
                    if (10 == pinsKnockedDown[nextFrame]) {
                        nextFrame += 1;
                    } else {
                        nextFrame += 2;
                    }
                }
                return framePositions;
            }

            private int[] pinsKnockedDown(int[] readings) {
                int[] perfectGame = new int[readings.length];
                int laneReset = 0;
                for (int pos = 0; pos < perfectGame.length; ++pos) {
                    // TODO
                    if (pos == laneReset) {
                        perfectGame[pos] = 10 - readings[pos];
                        if (0 == readings[pos]) {
                            laneReset = pos + 1;
                        }
                    } else {
                        perfectGame[pos] = readings[pos -1 ] - readings[pos];
                        laneReset = pos + 1;
                    }
                }
                return perfectGame;
            }
        }

        Game game = new SimpleGame();

        return game;
    }
}
