package oni.gouv.ht.Controller;


import oni.gouv.ht.Bean.RequestBean;
import oni.gouv.ht.Models.Request;
import oni.gouv.ht.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://197.168.1.28:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/get")
public class RequesrController {

    @Autowired
    RequestRepository requestRepository;

    @GetMapping(value = "/getAllRequest", produces = "application/json")
    public ResponseEntity<?> getAllRequest() {
        return ResponseEntity.ok(requestRepository.findAll());

    }


    @GetMapping(value = "/getAllRequestPagination", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?>uestPagination(Pageable pageable)  {
        Page<Request> pageResquest = requestRepository.findAll(pageable);
        return ResponseEntity.ok(pageResquest);
    }


}
