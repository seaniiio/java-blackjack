package blackjack.domain.card_hand.state.running;

import blackjack.domain.card.Card;
import blackjack.domain.card_hand.BlackjackCardHand;
import blackjack.domain.card_hand.state.BlackjackCardHandState;
import blackjack.domain.card_hand.state.finished.Bust;
import blackjack.domain.card_hand.state.finished.Stand;

public class Hit extends Running {
    
    public Hit(final BlackjackCardHand blackjackCardHand) {
        super(blackjackCardHand);
    }

    @Override
    public BlackjackCardHandState initializeCards() {
        throw new IllegalStateException("이미 카드가 초기화 되었습니다.");
    }
    
    @Override
    public BlackjackCardHandState addCard(final Card card) {
        cardHand.addCard(card);
        if (cardHand.getBlackjackSum() > 21) {
            return new Bust(cardHand);
        }
        return this;
    }
    
    @Override
    public BlackjackCardHandState stand() {
        return new Stand(cardHand);
    }
}
