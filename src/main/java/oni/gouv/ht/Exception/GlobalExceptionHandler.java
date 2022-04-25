/*
package oni.gouv.ht.Exception;

import cep.gouv.ht.Services.UploadResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

import static org.reflections.Reflections.log;

@ControllerAdvice
public class GlobalExceptionHandler {

   */
/* @ExceptionHandler(AlreadyExistdException.class)
    public ResponseEntity<?> handlerNotFoundException(AlreadyExistdException exception, WebRequest request) {
        return new ResponseEntity<>(new Response(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerNotValidException(MethodArgumentNotValidException exception, WebRequest request) {
        return new ResponseEntity<>(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }*//*


*/
/*    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerException(Exception exception, WebRequest request) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*//*

*/
/*@ExceptionHandler(MaxUploadSizeExceededException.class)
public ResponseEntity<ResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File too large!"));
}*//*

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlerExceptionNotFound(NotFoundException exception, WebRequest request) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handlerExceptionBadRequest(BadRequestException exception, WebRequest request) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

   */
/* @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<?> fileException(FileUploadException exception, WebRequest request) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
*//*

   @ExceptionHandler(MultipartException.class)
   public ResponseEntity handleFileUploadingError(MultipartException exception) {
       log.warn("Failed to upload attachment", exception);
       return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

   }


    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<UploadResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new UploadResponseMessage("Unable to upload. File is too large!"));
    }

}
*/
