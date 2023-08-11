package com.codewithmandar.console;

import com.codewithmandar.AppConfig;
import com.codewithmandar.MessageGenerator;
import com.codewithmandar.MessageGeneratorImpl;
import com.codewithmandar.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //Create context (initializing container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //Get bean from context
        NumberGenerator numberGenerator = context.getBean( NumberGenerator.class);

        int number = numberGenerator.next();

        log.info("number {}",number);

//        Game game = context.getBean(Game.class);
        MessageGenerator messageGenerator = context.getBean(MessageGeneratorImpl.class);

        log.info("getMainMessage {} ",messageGenerator.getMainMessage());
        log.info("getResultMessage {} ",messageGenerator.getResultMessage());

        context.close();
    }
}
