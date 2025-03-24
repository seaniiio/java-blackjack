package blackjack.domain.card_hand.state.finished;

import blackjack.domain.WinningStatus;
import blackjack.domain.card_hand.BlackjackCardHand;
import blackjack.domain.card_hand.state.BlackjackCardHandState;

public class Bust extends Finished {
    
    public Bust(final BlackjackCardHand cardHand) {
        super(cardHand);
    }
    
    @Override
    public boolean isBust() {
        return true;
    }
    
    @Override
    public WinningStatus determineWinningStatus(final BlackjackCardHandState otherState) {
        return WinningStatus.LOSE;
    }
}
