package oni.gouv.ht.Controller;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/users")
@Api(description = "API pour les opérations CRUD sur les Users.")
public class UserController {

    @GetMapping(value = "/getAll", produces = "application/json")
    public String getAllUser() {
        System.out.println("ddddddddddddd");
        return "oK";
    }
}
