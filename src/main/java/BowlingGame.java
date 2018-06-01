import veetwo.Legacy;

/**
 * The Bowling Game Kata from UncleBob
 * http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata
 *
 * @author Tim Riemer
 * @version 1.0
 */
public class BowlingGame {
    static final Legacy factory = new Legacy();

    final Legacy.Game game = factory.game();

    public void roll(int pins) {
        game.roll(pins);
    }

    public int score() {
        return game.score();
    }
}