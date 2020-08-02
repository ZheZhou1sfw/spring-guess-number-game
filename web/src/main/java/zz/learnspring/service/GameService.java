package zz.learnspring.service;

public interface GameService {

    boolean isGameOver();

    String getMainMessage();

    String getResultMesage();

    void checkGuess(int guess);

    void reset();
}
