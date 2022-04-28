package oni.gouv.ht.Controller;


import oni.gouv.ht.Interface.IInstitutionService;
import oni.gouv.ht.Repository.RequestRepository;
import oni.gouv.ht.Services.CitizenService;
import oni.gouv.ht.Services.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/get")
public class CitizenController extends BaseController {

    @Autowired
    CitizenService citizenService;


    @Autowired
    IInstitutionService ins;

    @Autowired
    IApplicationService appService;

    @Autowired
    RequestRepository requestRepository;


    @GetMapping(value = "/v1/citoyen/{pid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getCitoyenByPidV2(@PathVariable("pid") String pid, @RequestHeader("appkey") String app, HttpServletRequest request) {
        ApiMessage am = checkAppBefore(app, request);

        if (!am.isError()) {
            return ResponseEntity.ok().body(citizenService.getCitizenByPid(pid));
        }
        return ResponseEntity.ok().body(am);
    }


    @GetMapping(value = "/imageCitizenByPid/{pid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getImageCitizenByPid(@PathVariable("pid") String pid, @RequestHeader("appkey") String app, HttpServletRequest request) {
        ApiMessage am = checkAppBefore(app, request);

        if (!am.isError()) {
            return ResponseEntity.ok().body(citizenService.getImageCitizenByPid(pid));
        }
        return ResponseEntity.ok().body(am);
    }

    @GetMapping(value = "/CitizenByCriteria", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getCitizenByCriteria(@RequestParam(required = true) String GivenName,
                                                  @RequestParam(required = false) String Gender,
                                                  @RequestParam(required = true) String Surname,
                                                  @RequestParam(required = false) String DateOfBirth, @RequestHeader("appkey") String app, HttpServletRequest request) {

        ApiMessage am = checkAppBefore(app, request);
        if (!am.isError()) {
            return ResponseEntity.ok().body(citizenService.getCitizenByCriteria(GivenName, Gender, Surname, DateOfBirth));
        }
        return ResponseEntity.ok().body(am);
    }

}
