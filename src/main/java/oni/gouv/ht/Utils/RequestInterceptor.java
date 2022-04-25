package oni.gouv.ht.Utils;

import oni.gouv.ht.Bean.UserBean;
import oni.gouv.ht.Models.Request;
import oni.gouv.ht.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;


@Component
public class RequestInterceptor implements HandlerInterceptor{

    @Autowired
    RequestRepository requestRepository;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        if (principal instanceof UserDetails) {
//            String username = ((UserDetails)principal).getUsername();
//            System.out.println("Username is "+username);
//        }
//
//
//        String   ipAddress = request.getHeader("X-Forward-For");
//        if(ipAddress== null){
//            ipAddress = request.getRemoteAddr();
//        }
//        Request requestlog=new Request();
//        requestlog.setCreateDate(LocalDateTime.now());
//        requestlog.setUrl(request.getRequestURI());
//        requestlog.setType_request(request.getMethod());
//        requestlog.setAmount("5 GDS");
//        requestlog.setIp(ipAddress);
       // requestRepository.save(requestlog);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
