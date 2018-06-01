/**
 * Copyright Vast 2018. All Rights Reserved.
 * <p/>
 * http://www.vast.com
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import veetwo.VeeTwo;

/**
 * @author Danil Suits (danil@vast.com)
 */
public class VeeTwoTest {
    @Test
    public void testPerfectGame() {
        VeeTwo veeTwo = new VeeTwo();
        VeeTwo.Game game = veeTwo.game();
        int [] perfectGame = {0,0,0,0,0,0,0,0,0,0,0,0};

        int score = game.score(perfectGame);
        Assertions.assertEquals(300, score);
    }

    @Test
    public void testBustInTheFinalFrame() {
        VeeTwo veeTwo = new VeeTwo();
        VeeTwo.Game game = veeTwo.game();
        int [] readings = {0,0,0,0,0,0,0,0,0,10,10};

        int score = game.score(readings);
        Assertions.assertEquals(240, score);
    }

    @Test
    public void testRedeemedInTheFinalFrame() {
        VeeTwo veeTwo = new VeeTwo();
        VeeTwo.Game game = veeTwo.game();
        int [] readings = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,0,0,0};

        int score = game.score(readings);
        Assertions.assertEquals(30, score);
    }

    @Test
    public void testBustInTheFinalPin() {
        VeeTwo veeTwo = new VeeTwo();
        VeeTwo.Game game = veeTwo.game();
        int [] readings = {0,0,0,0,0,0,0,0,0,1,1};

        int score = game.score(readings);
        Assertions.assertEquals(267, score);
    }

    @Test
    public void testSpareInFirstFrame() {
        VeeTwo veeTwo = new VeeTwo();
        VeeTwo.Game game = veeTwo.game();
        int [] perfectGame = {1,0,0,0,0,0,0,0,0,0,0,0,0};

        int score = game.score(perfectGame);
        Assertions.assertEquals(290, score);
    }
}
