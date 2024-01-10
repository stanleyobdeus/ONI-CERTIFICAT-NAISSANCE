package oni.gouv.ht.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/actDenaissance")
public class ActDeNaissanceController {

    @GetMapping(value = "/getAll", produces = "application/json")
    public ResponseEntity<?> getAll() {
        return null;
    }

    @GetMapping(value = "/getByFirstName/{firstName}", produces = "application/json")
    public ResponseEntity<?> getByFirstName(@PathVariable("firstName") String firstName) {
        return null;
    }


    @GetMapping(value = "/getByLastName/{lastName}", produces = "application/json")
    public ResponseEntity<?> getByLastName(@PathVariable("lastName") String lastName) {
        return null;
    }

    @GetMapping(value = "/getByFullName", produces = "application/json")
    public ResponseEntity<?> getByFullName(@PathVariable("fullName") String fullName) {
        return null;
    }
}
