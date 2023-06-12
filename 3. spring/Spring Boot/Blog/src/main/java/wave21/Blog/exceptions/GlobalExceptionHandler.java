package wave21.Blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import wave21.Blog.dto.response.ErrorDTO;

import java.rmi.AlreadyBoundException;

@ControllerAdvice (annotations = RestController.class)
public class GlobalExceptionHandler {

    //Metodo visto en clase de Playground
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> alreadyExistsException (Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    //Metodo visto en clase en Vivo con Martin
    @ExceptionHandler(NotExistsException.class)
    public ResponseEntity<?> notExistsException (NotExistsException e){
        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(), 404);
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    /*@ExceptionHandler(NotExistsException.class)
    public ResponseEntity<?> notExistsException (Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }*/

    //HTTPMessageNotReadeableException
    //MethodArgumentNotValidException
}
