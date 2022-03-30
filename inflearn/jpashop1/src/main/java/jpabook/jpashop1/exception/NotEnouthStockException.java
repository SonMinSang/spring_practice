package jpabook.jpashop1.exception;

public class NotEnouthStockException extends RuntimeException {
    public NotEnouthStockException() {
        super();
    }

    public NotEnouthStockException(String message) {
        super(message);
    }

    public NotEnouthStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnouthStockException(Throwable cause) {
        super(cause);
    }
}
