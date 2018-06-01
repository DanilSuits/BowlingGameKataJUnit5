/**
 * Copyright Vast 2018. All Rights Reserved.
 * <p/>
 * http://www.vast.com
 */
package veetwo;

/**
 * @author Danil Suits (danil@vast.com)
 */
public class Legacy {
    public interface Game {
        void roll(int pinsKnockedDown);
        int score();
    }

    public Game game() {
        /**
         * The Bowling Game Kata from UncleBob
         * http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata
         *
         * @author Tim Riemer
         * @version 1.0
         */
        class BowlingGame implements Game {
            private final int[] rolls = new int[21];
            private int currentRoll;

            public void roll(int pins) {
                rolls[currentRoll++] = pins;
            }

            public int score() {
                int score = 0;
                int frameIndex = 0;
                for (int frame = 0; frame < 10; frame++) {
                    if (isStrike(frameIndex)) {
                        score += 10 + strikeBonus(frameIndex);
                        frameIndex++;
                    } else if (isSpare(frameIndex)) {
                        score += 10 + spareBonus(frameIndex);
                        frameIndex += 2;
                    } else {
                        score += sumOfBallsInFrame(frameIndex);
                        frameIndex += 2;
                    }
                }
                return score;
            }

            private int sumOfBallsInFrame(int frameIndex) {
                return rolls[frameIndex] + rolls[frameIndex + 1];
            }

            private int spareBonus(int frameIndex) {
                return rolls[frameIndex + 2];
            }

            private int strikeBonus(int frameIndex) {
                return rolls[frameIndex + 1] + rolls[frameIndex + 2];
            }

            private boolean isStrike(int frameIndex) {
                return rolls[frameIndex] == 10;
            }

            private boolean isSpare(int i) {
                return rolls[i] + rolls[i + 1] == 10;
            }
        }

        return new BowlingGame();
    }
}
