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

    private final int[] rolls = new int[21];
    private int currentRoll;

    public void roll(int pins) {
        game.roll(pins);
        rolls[currentRoll++] = pins;
    }

    public int score() {
        if (true) return game.score();
        
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