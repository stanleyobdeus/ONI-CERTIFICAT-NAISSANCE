package oni.gouv.ht.Controller;


import oni.gouv.ht.Interface.IInstitutionService;
import oni.gouv.ht.Models.Application;
import oni.gouv.ht.Models.Institution;
import oni.gouv.ht.Models.Request;
import oni.gouv.ht.Repository.RequestRepository;
import oni.gouv.ht.Services.CitizenService;
import oni.gouv.ht.Services.IAppService;
import org.apache.commons.collections4.MultiValuedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/get")
public class CitizenController  extends  BaseController {

    @Autowired
    CitizenService citizenService;


    @Autowired
    IInstitutionService ins;

    @Autowired
    IAppService appService;

    @Autowired
    RequestRepository requestRepository;

    @GetMapping(value ="/citoyen/{pid}" , produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getCitoyenByPid(@PathVariable("pid") String pid){
        return ResponseEntity.ok().body(citizenService.getCitizenByPid(pid));
    }

    @GetMapping(value ="/v1/citoyen/{pid}" , produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getCitoyenByPidV2(@PathVariable("pid") String pid,@RequestHeader("appkey") String app, HttpServletRequest request){
        // requestRepository.deleteAll();
       ApiMessage am = checkAppBefore(app, request);

       if(!am.isError()) {
           return ResponseEntity.ok().body(citizenService.getCitizenByPid(pid));
       }
       return ResponseEntity.ok().body(am);
    }

    @GetMapping(value ="/v1/test" , produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> test(){
        Institution i = ins.createInsTest();
        Application a = appService.createAppTest(i);
        return ResponseEntity.ok().body(a);
    }



    @GetMapping(value ="/imageCitizenByPid/{pid}" , produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getImageCitizenByPid(@PathVariable("pid") String pid){
        return ResponseEntity.ok().body(citizenService.getImageCitizenByPid(pid));
    }

    @GetMapping(value ="/CitizenByCriteria" , produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getCitizenByCriteria(@RequestParam(required = true) String GivenName,
                                                  @RequestParam(required = false) String Gender,
                                                  @RequestParam(required = true) String Surname,
                                                  @RequestParam(required = false) String DateOfBirth){
        return ResponseEntity.ok().body(citizenService.getCitizenByCriteria(GivenName,Gender,Surname,DateOfBirth));
    }




}
