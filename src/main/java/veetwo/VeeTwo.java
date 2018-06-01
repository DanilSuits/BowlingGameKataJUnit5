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
        Game game = readings -> 0;

        return game;
    }
}
