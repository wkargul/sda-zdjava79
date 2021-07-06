package pl.sdacademy.java.spring.helloweb.workshop2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.Random;

@Controller
public class ResponsesController {
    private final Random random = new Random();
    @ResponseStatus(HttpStatus.GONE)
    @GetMapping("/gone1")
    public void statusGone1() {
    }
    @GetMapping("/gone2")
    public ResponseEntity<Void> entityGone2() {
        return ResponseEntity.status(HttpStatus.GONE).build();
    }
    @GetMapping("/gone3")
    public void exceptionGone2() {
        throw new ResponseStatusException(HttpStatus.GONE);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/no-content1")
    public void responseAnnotationNoContent() {
        if(!random.nextBoolean()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/no-content2")
    public ResponseEntity<Void> responseEntityNoContent() {
        if(!random.nextBoolean()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
