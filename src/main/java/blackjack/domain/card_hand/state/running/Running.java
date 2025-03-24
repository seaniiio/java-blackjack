package blackjack.domain.card_hand.state.running;

import blackjack.domain.WinningStatus;
import blackjack.domain.card.Card;
import blackjack.domain.card_hand.BlackjackCardHand;
import blackjack.domain.card_hand.state.BlackjackCardHandState;

import java.util.List;

public abstract class Running implements BlackjackCardHandState {
    
    protected final BlackjackCardHand cardHand;
    
    public Running(final BlackjackCardHand cardHand) {
        this.cardHand = cardHand;
    }
    
    @Override
    public int getBlackjackSum() {
        return cardHand.getBlackjackSum();
    }
    
    @Override
    public boolean isBlackjack() {
        return false;
    }
    
    @Override
    public boolean isBust() {
        return false;
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }
    
    @Override
    public List<Card> getCards() {
        return cardHand.getCards();
    }
    
    @Override
    public WinningStatus determineWinningStatus(BlackjackCardHandState state) {
        throw new IllegalStateException("카드 뽑기가 진행중입니다.");
    }
}
