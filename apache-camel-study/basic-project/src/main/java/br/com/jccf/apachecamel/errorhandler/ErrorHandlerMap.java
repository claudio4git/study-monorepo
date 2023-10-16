package br.com.jccf.apachecamel.errorhandler;

import java.util.logging.Logger;

public class ErrorHandlerMap {

    Logger logger = Logger.getLogger(ErrorHandlerMap.class.getName());

    public String map(String input) {
        try {

            return input.replaceAll("a", "b");
        } catch (RuntimeException e) {
            logger.severe("RuntimeException: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.severe("Exception: " + e.getMessage());
            throw e;
        }
    }
}
