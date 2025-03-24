package blackjack.domain.card_hand.state;

import blackjack.domain.WinningStatus;
import blackjack.domain.card.Card;
import blackjack.domain.deck.CardDrawer;

import java.util.List;

public interface BlackjackCardHandState {

    boolean isBlackjack();
    boolean isBust();
    boolean isFinished();
    int getBlackjackSum();
    BlackjackCardHandState initializeCards();
    BlackjackCardHandState addCard(Card card);
    BlackjackCardHandState stand();
    WinningStatus determineWinningStatus(BlackjackCardHandState otherState);
    List<Card> getCards();
}
