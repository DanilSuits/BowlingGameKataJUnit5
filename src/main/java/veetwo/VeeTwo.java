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
    final VeeOne veeOne = new VeeOne();

    public interface Game {
        int score(int... readings);
    }

    public Game game() {
        class SimpleGame implements Game {
            VeeOne.Game veeOneGame = veeOne.game();

            @Override
            public int score(int... readings) {
                int[] pinsKnockedDown = pinsKnockedDown(readings);

                return veeOneGame.score(pinsKnockedDown);
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
