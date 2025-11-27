package it.li.exception;

public class CreateUserException extends RuntimeException{
    public CreateUserException(String message) {
        super(message); // 调用父类构造方法
    }
}
