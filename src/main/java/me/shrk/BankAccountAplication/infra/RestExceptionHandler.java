package me.shrk.BankAccountAplication.infra;


import me.shrk.BankAccountAplication.exceptions.SameAccountNumber;
import me.shrk.BankAccountAplication.exceptions.SameCardNumber;
import me.shrk.BankAccountAplication.exceptions.UserAlreadyDeleted;
import me.shrk.BankAccountAplication.exceptions.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFound.class)
    private ResponseEntity<String> userNotFoundHandler(UserNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
    }

    @ExceptionHandler(SameAccountNumber.class)
    private ResponseEntity<String> sameAccountNumberHandler(SameAccountNumber exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Account number is already exists!");
    }

    @ExceptionHandler(SameCardNumber.class)
    private ResponseEntity<String> sameCardNumberHandler(SameCardNumber exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Card number is already exists!");
    }

    @ExceptionHandler(UserAlreadyDeleted.class)
    private ResponseEntity<String> userDeletedHandler(UserAlreadyDeleted exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User is Already Deleted or Not Created!");
    }
}
