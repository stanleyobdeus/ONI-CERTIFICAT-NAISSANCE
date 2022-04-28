package oni.gouv.ht.Controller;


import lombok.Data;
import oni.gouv.ht.Models.Application;
import oni.gouv.ht.Models.Request;
import oni.gouv.ht.Repository.RequestRepository;
import oni.gouv.ht.Services.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Optional;

public class BaseController {

    @Autowired
    IApplicationService app;

    @Autowired
    RequestRepository requestRepository;


    public boolean isAuthentificate(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            if(((UserDetails)principal).getUsername()!=null)
                return true;
        }
        return false;
    }

    public ApiMessage checkAppBefore(String params, HttpServletRequest request) {
        ApiMessage<Application> am = new ApiMessage<Application>();

         if(isAuthentificate()){
             am.setError(false);
             am.setMsg("User ONI Is Connect..!");
             return am;
         }


        String ipAddress = request.getHeader("X-Forward-For");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        am.setIp(ipAddress);
        am.setError(true);
        String[] keys;
        try {
            keys = params.split("\\.");
            System.out.println("-----------------| " + params + " : " + keys.length + "|---------------");
        } catch (Exception e) {
            am.setMsg(e.getMessage() + ">>>");
            return am;
        }

        if (keys.length == 2) {
            String secretKey = keys[0];
            String publicKey = keys[1];
            Optional<Application> app = this.app.getAppByKey(secretKey);
            if (app.isPresent()) {
                Application obj = app.get();

                if (obj.getLock() == 1) {
                    am.setMsg(obj.getLock_message());
                    return am;
                }

                if (obj.getPublic_key().equals(publicKey)) {

                    if (obj.getOrigin().equals(ipAddress) || obj.getStrict() != 1) {
                        Request requestlog = new Request();
                        requestlog.setCreateDate(LocalDateTime.now());
                        requestlog.setUrl(request.getRequestURI());
                        requestlog.setType_request(request.getMethod());
                        requestlog.setAmount(obj.getRequest_price());
                        requestlog.setIp(ipAddress);
                        requestlog.setInstitution(obj.getIns().getName());
                        requestlog.setApp(obj.getName());
                        requestRepository.save(requestlog);
                        am.setData(obj);
                        am.setError(false);
                    } else {
                        am.setMsg("IP NOT VALID");
                    }
                } else {
                    am.setMsg("Public key not valid");
                }
            } else {
                am.setMsg("Application not exist");
            }
        } else {
            am.setMsg("Wrong appkey format ");
        }

        return am;
    }

    @Data
    @Table(name = "apiMessage")
    class ApiMessage<T> {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        String msg;
        boolean error;
        String ip;
        @Transient
        T data;

        public ApiMessage() {
        }
    }

}
