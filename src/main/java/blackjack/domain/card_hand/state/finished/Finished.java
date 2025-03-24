package blackjack.domain.card_hand.state.finished;

import blackjack.domain.card.Card;
import blackjack.domain.card_hand.BlackjackCardHand;
import blackjack.domain.card_hand.state.BlackjackCardHandState;

import java.util.List;

public abstract class Finished implements BlackjackCardHandState {
    
    protected final BlackjackCardHand cardHand;
    
    public Finished(final BlackjackCardHand cardHand) {
        this.cardHand = cardHand;
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
        return true;
    }
    
    @Override
    public int getBlackjackSum() {
        return cardHand.getBlackjackSum();
    }
    
    @Override
    public List<Card> getCards() {
        return cardHand.getCards();
    }
    
    @Override
    public BlackjackCardHandState initializeCards() {
        throw new IllegalStateException("카드 뽑기가 이미 종료되었습니다.");
    }
    
    @Override
    public BlackjackCardHandState addCard(final Card card) {
        throw new IllegalStateException("카드 뽑기가 이미 종료되었습니다.");
    }
    
    @Override
    public BlackjackCardHandState stand() {
        throw new IllegalStateException("이미 stand 상태입니다.");
    }
}
