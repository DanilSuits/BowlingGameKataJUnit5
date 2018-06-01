/**
 * Copyright Vast 2018. All Rights Reserved.
 * <p/>
 * http://www.vast.com
 */

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
}
