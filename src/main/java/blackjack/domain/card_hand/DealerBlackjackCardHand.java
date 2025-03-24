package blackjack.domain.card_hand;

import blackjack.domain.WinningStatus;
import blackjack.domain.card_hand.state.BlackjackCardHandState;
import blackjack.domain.card_hand.state.running.Start;
import java.util.List;

import blackjack.domain.card.Card;
import blackjack.domain.deck.CardDrawer;
import blackjack.domain.deck.BlackjackCardHandInitializer;

public final class DealerBlackjackCardHand {
    
    private static final int DEALER_DRAW_THRESHOLD = 16;
    
    private BlackjackCardHandState cardHandState;
    
    public DealerBlackjackCardHand(final BlackjackCardHandInitializer initializer) {
        validateNotNull(initializer);
        cardHandState = new Start(initializer).initializeCards();
    }
    
    private void validateNotNull(final BlackjackCardHandInitializer initializer) {
        if (initializer == null) {
            throw new IllegalArgumentException("초기 카드 지급 방식은 null이 될 수 없습니다.");
        }
    }
    
    public List<Card> getInitialCards() {
        return List.of(cardHandState.getCards().getFirst());
    }
    
    public void startAdding(final CardDrawer cardDrawer) {
        while (cardHandState.getBlackjackSum() <= DEALER_DRAW_THRESHOLD) {
            cardHandState = cardHandState.addCard(cardDrawer.draw());
        }
    }

    public BlackjackCardHandState getCardHandState() {
        return cardHandState;
    }

    public List<Card> getCards() {
        return cardHandState.getCards();
    }

    public WinningStatus determineWinningStatus(BlackjackCardHandState otherState) {
        return cardHandState.determineWinningStatus(otherState);
    }

    public int getBlackjackSum() {
        return cardHandState.getBlackjackSum();
    }
}
