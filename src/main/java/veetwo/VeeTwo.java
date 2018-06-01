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
        int score(int ... readings);
    }

    public Game game() {
        class SimpleGame implements Game {

            @Override
            public int score(int... readings) {
                int [] pinsKnockedDown = pinsKnockedDown(readings);
                return veeOneScore(pinsKnockedDown);
            }

            private int veeOneScore(int[] pinsKnockedDown) {
                // TODO:
                return 300;
            }

            private int[] pinsKnockedDown(int[] readings) {
                // TODO
                int [] perfectGame = {10,10,10,10,10,10,10,10,10,10};
                return perfectGame;
            }
        }
        
        Game game = new SimpleGame();

        return game;
    }
}
