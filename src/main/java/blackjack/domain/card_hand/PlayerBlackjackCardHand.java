package blackjack.domain.card_hand;

import blackjack.domain.WinningStatus;
import blackjack.domain.card_hand.state.BlackjackCardHandState;
import blackjack.domain.card_hand.state.running.Start;
import blackjack.domain.deck.CardDrawer;
import java.util.List;

import blackjack.domain.card.Card;
import blackjack.domain.deck.BlackjackCardHandInitializer;
import blackjack.domain.player.Player;

public final class PlayerBlackjackCardHand {
    
    private BlackjackCardHandState cardHandState;
    private final Player player;
    
    public PlayerBlackjackCardHand(final Player player, final BlackjackCardHandInitializer initializer) {
        validateNotNull(player, initializer);
        this.player = player;
        cardHandState = new Start(initializer).initializeCards();
    }
    
    private void validateNotNull(final Player player, final BlackjackCardHandInitializer initializer) {
        if (player == null) {
            throw new IllegalArgumentException("플레이어는 null이 될 수 없습니다.");
        }
        if (initializer == null) {
            throw new IllegalArgumentException("초기 카드 지급 방식은 null이 될 수 없습니다.");
        }
    }
    
    public List<Card> getInitialCards() {
        return List.of(cardHandState.getCards().getFirst(), cardHandState.getCards().get(1));
    }
    
    public void addCard(final Card card) {
        cardHandState = cardHandState.addCard(card);
    }
    
    public String getPlayerName() {
        return player.getName();
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public List<Card> getCards() {
        return cardHandState.getCards();
    }

    public BlackjackCardHandState getCardHandState() {
        return cardHandState;
    }

    public WinningStatus determineWinningStatus(BlackjackCardHandState otherState) {
        return cardHandState.determineWinningStatus(otherState);
    }

    public int getBlackjackSum() {
        return cardHandState.getBlackjackSum();
    }

    public void stand() {
        cardHandState = cardHandState.stand();
    }

    public boolean canHit() {
        return !cardHandState.isFinished();
    }
}
