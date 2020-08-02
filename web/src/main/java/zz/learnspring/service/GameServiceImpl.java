package zz.learnspring.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zz.learnspring.Game;
import zz.learnspring.MessageGenerator;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService{

    // == fields ==
    private final Game game;
    private final MessageGenerator messageGenerator;

    @PostConstruct
    public void init() {
        log.info(getMainMessage(), "The target is {}", game.getNumber());
    }

    // == methods ==
    @Override
    public boolean isGameOver() {
        return game.isGameLost() || game.isGameWon();
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMesage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
