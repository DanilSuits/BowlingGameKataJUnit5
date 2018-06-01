import veetwo.Legacy;
import veetwo.VeeOne;

/**
 * The Bowling Game Kata from UncleBob
 * http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata
 *
 * @author Tim Riemer
 * @version 1.0
 */
public class BowlingGame {
    static final VeeOne factory = new VeeOne();

    final Legacy.Game game = factory.adapter();

    public void roll(int pins) {
        game.roll(pins);
    }

    public int score() {
        return game.score();
    }
}