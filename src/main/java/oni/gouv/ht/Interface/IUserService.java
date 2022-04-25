package oni.gouv.ht.Interface;


import oni.gouv.ht.Bean.ImagesBean;
import oni.gouv.ht.Bean.RoleBean;
import oni.gouv.ht.Bean.UserBean;
import oni.gouv.ht.Exception.AlreadyExistdException;
import oni.gouv.ht.Exception.NotFoundException;
import oni.gouv.ht.Models.Response;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IUserService {
    UserBean SaveUser(UserBean userBean, MultipartFile file) throws AlreadyExistdException, IOException;

    List<UserBean> FindAllUser();

    String DeleteUser(String id) throws NotFoundException;

    String UpdateUser(UserBean userBean) throws NotFoundException, AlreadyExistdException;

    public String AddRoleToUser(String id_user, String id_role) throws NotFoundException, AlreadyExistdException;

    public String RemoveRoleToUser(String id_user, String id_role)throws NotFoundException, AlreadyExistdException;

    public UserBean getUserByUsername(String user_name)throws NotFoundException;

    public RoleBean CreateRole(RoleBean roleMBean) throws AlreadyExistdException;

    public UserBean getUserById(String id_user)throws NotFoundException;

    public ImagesBean getImageUser(String username,Long id_organisation)throws NotFoundException;

    public Response changePassword(String username, Long id_organisation, String old_password, String new_password) throws NotFoundException;

    Response lockOrUnlockUser(Long id_user, Long updateBy, boolean enable)throws NotFoundException;
}
