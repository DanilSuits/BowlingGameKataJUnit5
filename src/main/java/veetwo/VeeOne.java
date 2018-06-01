/**
 * Copyright Vast 2018. All Rights Reserved.
 * <p/>
 * http://www.vast.com
 */
package veetwo;

/**
 * @author Danil Suits (danil@vast.com)
 */
public class VeeOne {
    interface Game {
        int score(int... pinsKnocedDown);
    }

    final Legacy legacy = new Legacy();

    public Legacy.Game legacy() {
        return legacy.game();
    }
    
    public Game game() {
        class VeeOneGame implements Game {
            @Override
            public int score(int... pinsKnockedDown) {
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

        }

        return new VeeOneGame();
    }
}
