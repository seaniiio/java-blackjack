package blackjack.domain.card_hand.state.finished;

import blackjack.domain.WinningStatus;
import blackjack.domain.card_hand.BlackjackCardHand;
import blackjack.domain.card_hand.state.BlackjackCardHandState;

public class Stand extends Finished{
    
    public Stand(final BlackjackCardHand cardHand) {
        super(cardHand);
    }
    
    @Override
    public WinningStatus determineWinningStatus(final BlackjackCardHandState otherState) {
        if (otherState.isBlackjack()) {
            return WinningStatus.LOSE;
        }
        if (otherState.isBust() || getBlackjackSum() > otherState.getBlackjackSum()) {
            return WinningStatus.WIN;
        }
        if (getBlackjackSum() < otherState.getBlackjackSum()) {
            return WinningStatus.LOSE;
        }
        return WinningStatus.DRAW;
    }
}
