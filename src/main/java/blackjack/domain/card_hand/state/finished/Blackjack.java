package blackjack.domain.card_hand.state.finished;

import blackjack.domain.WinningStatus;
import blackjack.domain.card_hand.state.BlackjackCardHandState;

public class Blackjack extends Finished {
    
    public Blackjack(final blackjack.domain.card_hand.BlackjackCardHand blackjackCardHand) {
        super(blackjackCardHand);
    }
    
    @Override
    public boolean isBlackjack() {
        return true;
    }
    
    @Override
    public WinningStatus determineWinningStatus(final BlackjackCardHandState otherState) {
        if (otherState.isBlackjack()) {
            return WinningStatus.DRAW;
        }
        return WinningStatus.WIN;
    }
}
