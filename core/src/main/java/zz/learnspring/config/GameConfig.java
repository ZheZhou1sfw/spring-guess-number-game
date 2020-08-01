package zz.learnspring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import zz.learnspring.GuessCount;
import zz.learnspring.MaxNumber;
import zz.learnspring.MinNumber;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "zz.learnspring")
public class GameConfig {

    // == fields ==
    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.minNumber:0}")
    private int minNumber;


    @Value("${game.guessCount:5}")
    private int guessCount;


    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }
}
