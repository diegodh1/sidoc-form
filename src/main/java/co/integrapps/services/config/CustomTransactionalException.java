package co.integrapps.services.config;

public class CustomTransactionalException extends Exception{
    public CustomTransactionalException(String message, Throwable cause)
     {
        super(message, cause);
    }
}