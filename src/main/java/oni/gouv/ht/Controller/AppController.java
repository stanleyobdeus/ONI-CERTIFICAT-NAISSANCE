package oni.gouv.ht.Controller;

import io.swagger.annotations.Api;
import oni.gouv.ht.Exception.AlreadyExistdException;
import oni.gouv.ht.Exception.NotFoundException;
import oni.gouv.ht.Interface.IUserService;
import oni.gouv.ht.Repository.ImageRepository;
import oni.gouv.ht.Services.IAppService;
import oni.gouv.ht.Interface.IInstitutionService;
import oni.gouv.ht.Utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "http://197.168.1.28:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/app")
@Api(description = "API pour les opérations CRUD sur les Users.")
public class AppController {
    @Autowired
    IUserService userService;

    @Autowired
    ImageRepository imageRepository;


    @Autowired
    IAppService iappService;

    @Autowired
    IInstitutionService iInstitutionService;

    @PostMapping(value = "/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> createApp() throws AlreadyExistdException, IOException {
        return ResponseEntity.ok(null);
    }


    @GetMapping(value = "/getApplicationBynameAndRequestPrice/{name}", produces = "application/json")
    public ResponseEntity<?> getApplicationBynameAndRequestPrice(@PathVariable String name) throws NotFoundException {
        return ResponseEntity.ok(iappService.getApplicationBynameAndRequestPrice(name));
    }


    @GetMapping(value = "/getAllApplicationsByRequestPrice", produces = "application/json")
    public ResponseEntity<?> getAllApplicationsByRequestPrice() throws NotFoundException {
        return ResponseEntity.ok(iappService.getAllApplicationsByRequestPrice());
    }


    //not
    @GetMapping(value = "/getAllInstByRequestPrice", produces = "application/json")
    public ResponseEntity<?> getAllInstByRequestPrice() throws NotFoundException {
        return ResponseEntity.ok(iappService.getAllInstByRequestPrice());
    }


    @GetMapping(value = "/getHomeStat", produces = "application/json")
    public ResponseEntity<?> getHomeStat() throws NotFoundException {
        return ResponseEntity.ok(iappService.getHomeStat());
    }


    @GetMapping(value = "/getAllApplicationsByRequestPriceDate/{debut}/{fin}", produces = "application/json")
    public ResponseEntity<?> getAllApplicationsByRequestPriceDate(@PathVariable("debut") String debut,@PathVariable("fin") String fin ) throws NotFoundException {
        return ResponseEntity.ok(iappService.getAllApplicationsByRequestPriceDate(DateUtils.getLDT(debut),DateUtils.getLDT(fin)));
    }

    @GetMapping(value = "/getAllInstByRequestPriceAndDate/{debut}/{fin}", produces = "application/json")
    public ResponseEntity<?> getAllInstByRequestPriceAndDate(@PathVariable("debut") String debut,@PathVariable("fin") String fin ) throws NotFoundException {
        return ResponseEntity.ok(iappService.getAllInstByRequestPriceAndDate(DateUtils.getLDT(debut),DateUtils.getLDT(fin)));
    }


/*
    @GetMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<?> deleteUser(@PathVariable String id) throws NotFoundException {
        return ResponseEntity.ok(new ApiResponse<String>(userService.DeleteUser(id)));
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(new ApiResponse<List<UserBean>>(userService.FindAllUser()));

    }

    @PostMapping(value = "/update", produces = "application/json")
    public ResponseEntity<?> updatelUser(@Valid @RequestBody UserBean userBean) throws NotFoundException, AlreadyExistdException {
        return ResponseEntity.ok(new ApiResponse<String>(userService.UpdateUser(userBean)));
    }

    @GetMapping(value = "/AddRoleToUser/{id_user}/{id_role}", produces = "application/json")
    public ResponseEntity<?> AddRoleToUser(@PathVariable String id_user, @PathVariable String id_role) throws NotFoundException, AlreadyExistdException {
        return ResponseEntity.ok(new ApiResponse<String>(userService.AddRoleToUser(id_user, id_role)));
    }

    @GetMapping(value = "/RemoveRoleToUser/{id_user}/{id_role}", produces = "application/json")
    public ResponseEntity<?> RemoveRoleToUser(@PathVariable String id_user, @PathVariable String id_role) throws NotFoundException, AlreadyExistdException {
        return ResponseEntity.ok(new ApiResponse<String>(userService.RemoveRoleToUser(id_user, id_role)));
    }


    @PostMapping(value = "/create/role", produces = "application/json")
    public ResponseEntity<?> createRole(@Valid @RequestBody RoleBean roleBean) throws AlreadyExistdException {
        return ResponseEntity.ok(new ApiResponse<RoleBean>(userService.CreateRole(roleBean), Constante.ROLE_CREATE));
    }


    @GetMapping(value = "/getUserByUsername/{username}", produces = "application/json")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) throws NotFoundException {
        return ResponseEntity.ok(new ApiResponse<UserBean>(userService.getUserByUsername(username)));
    }

    @GetMapping(value = "/getUserById/{id_user}", produces = "application/json")
    public ResponseEntity<?> getUserById(@PathVariable String id_user) throws NotFoundException {
        return ResponseEntity.ok(new ApiResponse<UserBean>(userService.getUserById(id_user)));
    }

    @GetMapping(value = "/getImageUser/{username}/{id_organisation}", produces = "application/json")
    public ResponseEntity<?> getImageUser(@PathVariable String username, @PathVariable String id_organisation) throws NotFoundException {
        return ResponseEntity.ok(new ApiResponse<ImagesBean>(userService.getImageUser(username, Long.valueOf(id_organisation))));
    }

    @GetMapping(value = "/getUserByUserNameAndIdOrganisation/{username}/{id_organisation}", produces = "application/json")
    public ResponseEntity<?> getUserByUserNameAndIdOrganisation(@PathVariable String username, @PathVariable String id_organisation) throws NotFoundException {
        return ResponseEntity.ok(new ApiResponse<UserBean>(userService.getUserByUserNameAndIdOrganisation(username, Long.valueOf(id_organisation))));
    }

    @PostMapping(value = "/changePassword", produces = "application/json")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordBean changePassword) throws NotFoundException {
        System.out.println("new password " + changePassword.getNew_password());
        return ResponseEntity.ok(userService.changePassword(changePassword.getUsername(),
                Long.valueOf(changePassword.getId_organisation()),
                changePassword.getOld_password(),
                changePassword.getNew_password()));


    }

    @GetMapping(value = "/lockOrUnlockUser/{id_user_lock}/{id_user}/{enable}", produces = "application/json")
    public ResponseEntity<?> lockOrUnlockUser(@PathVariable String id_user_lock, @PathVariable String id_user, @PathVariable boolean enable) throws NotFoundException {
        return ResponseEntity.ok(userService.lockOrUnlockUser(Long.valueOf(id_user_lock), Long.valueOf(id_user), enable));

    }*/
}