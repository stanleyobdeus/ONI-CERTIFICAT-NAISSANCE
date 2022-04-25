package oni.gouv.ht.Services;


import oni.gouv.ht.Bean.*;
import oni.gouv.ht.Exception.*;
import oni.gouv.ht.Interface.IUserService;
import oni.gouv.ht.Models.*;
import oni.gouv.ht.Repository.*;
import oni.gouv.ht.Utils.Constant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper;
    @Autowired
    RoleRepository roleRepository;
//
//    @Autowired
//    UserRoleRepository userRoleRepository;

    @Autowired
    ImageRepository imageRepository;


    @Autowired
    PasswordEncoder encoder;

    Set<Role> listroles;

    {
        modelMapper = new ModelMapper();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public UserBean SaveUser(UserBean userBean, MultipartFile file) throws AlreadyExistdException, IOException {

        //save User
        if (userRepository.getUserByUsername(userBean.getUsername()) != null) {
            throw new AlreadyExistdException(Constant.USER_ALREADY_EXIST);
        }
        User user = modelMapper.map(userBean, User.class);
        user.setEnabled(true);
        user.setCreateDate(LocalDateTime.now());
        Role role = new Role();
        listroles = new HashSet<>();
        listroles.add(role);
        user.setRoles(listroles);
        user.setCreateBy(Long.valueOf("1"));
        user.setPassword(encoder.encode(userBean.getPassword()));
        User entityUser = userRepository.save(user);

        //save image
        Images images2 = new Images(file.getOriginalFilename(), file.getBytes(), file.getContentType(), String.valueOf(file.getSize()), file.getName());
        imageRepository.save(images2);

        return modelMapper.map(entityUser,UserBean.class);
    }

    @Override
    public List<UserBean> FindAllUser() {
        return null;
    }

    @Override
    public String DeleteUser(String id) throws NotFoundException {
        return null;
    }

    @Override
    public String UpdateUser(UserBean userBean) throws NotFoundException, AlreadyExistdException {
        return null;
    }

    @Override
    public String AddRoleToUser(String id_user, String id_role) throws NotFoundException, AlreadyExistdException {
        return null;
    }

    @Override
    public String RemoveRoleToUser(String id_user, String id_role) throws NotFoundException, AlreadyExistdException {
        return null;
    }

    @Override
    public UserBean getUserByUsername(String user_name) throws NotFoundException {

        User entity = userRepository.getUserByUsername(user_name);
        UserBean userBean = modelMapper.map(entity, UserBean.class);
        return userBean;
    }

    @Override
    public RoleBean CreateRole(RoleBean roleMBean) throws AlreadyExistdException {
        return null;
    }

    @Override
    public UserBean getUserById(String id_user) throws NotFoundException {
        return null;
    }

    @Override
    public ImagesBean getImageUser(String username, Long id_organisation) throws NotFoundException {
        return null;
    }

    @Override
    public Response changePassword(String username, Long id_organisation, String old_password, String new_password) throws NotFoundException {
        return null;
    }

    @Override
    public Response lockOrUnlockUser(Long id_user, Long updateBy, boolean enable) throws NotFoundException {
      /*  if (!userRepository.existsById(Long.valueOf(id_user)))
            return new Response(Constant.USER_NOT_FOUND, "404");
        userRepository.lockOrUnlockUser(id_user, LocalDateTime.now(), updateBy, enable);
        return new Response(enable ? Constant.USER_UNLOCK : Constant.USER_LOCK, "200");*/

        return null;
    }

}
