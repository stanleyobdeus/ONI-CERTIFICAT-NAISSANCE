package oni.gouv.ht.Controller;

import oni.gouv.ht.Bean.UserBean;
import oni.gouv.ht.Exception.NotFoundException;
import oni.gouv.ht.Interface.IUserService;
import oni.gouv.ht.Models.AppResponse;
import oni.gouv.ht.Models.LoginRequest;

import oni.gouv.ht.Security.jwt.JwtUtils;
import oni.gouv.ht.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;

@CrossOrigin(origins = "http://197.168.1.28:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/authentification")
public class AuthentificationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    IUserService userService;

    @Autowired
    PasswordEncoder encoder;
    String jwt = null;



    @PostMapping(value = "/signin", produces = "application/json")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws NotFoundException {


        UserBean userBean = userService.getUserByUsername(loginRequest.getUsername());

        if (userBean==null || !encoder.matches(loginRequest.getPassword(), userBean.getPassword())) {
            //throw new NotFoundException(Constant.USER_NOT_FOUND);
            return ResponseEntity.ok(new AppResponse<UserBean>(null, null,true,"Username Or PassWord Incorrect"));
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        jwt = jwtUtils.generateJwtToken(authentication);
        userBean.setToken(jwt);
        return ResponseEntity.ok(new AppResponse<UserBean>(userBean, null,false, ""));
    }

}
