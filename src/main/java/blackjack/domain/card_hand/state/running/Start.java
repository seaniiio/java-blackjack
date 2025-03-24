package blackjack.domain.card_hand.state.running;

import blackjack.domain.card.Card;
import blackjack.domain.card_hand.state.BlackjackCardHandState;
import blackjack.domain.card_hand.state.finished.Blackjack;
import blackjack.domain.deck.BlackjackCardHandInitializer;

public class Start extends Running {
    
    public Start(final BlackjackCardHandInitializer initializer) {
        super(new blackjack.domain.card_hand.BlackjackCardHand(initializer));
    }
    
    @Override
    public BlackjackCardHandState initializeCards() {
        if (cardHand.getBlackjackSum() == 21) {
            return new Blackjack(cardHand);
        }
        return new Hit(cardHand);
    }
    
    @Override
    public BlackjackCardHandState addCard(final Card card) {
        throw new IllegalStateException("아직 손패가 초기화되지 않았습니다.");
    }
    
    @Override
    public BlackjackCardHandState stand() {
        throw new IllegalStateException("아직 손패가 초기화되지 않았습니다.");
    }
}
