package oni.gouv.ht.Utils;

import oni.gouv.ht.Models.Images;
import oni.gouv.ht.Models.Role;
import oni.gouv.ht.Models.User;
import oni.gouv.ht.Repository.ImageRepository;
import oni.gouv.ht.Repository.RoleRepository;
import oni.gouv.ht.Repository.UserRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


@Component
public class InsertCommandLineRunner implements CommandLineRunner {



    @Autowired
    ImageRepository imageRepository;

    @Autowired
    UserRepository userRepository;


    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    RoleRepository roleRepository;


    File file;

    FileInputStream input;

    MultipartFile multipartFile;

    Resource resource;

    User user, entityUser;

    Images images2, images, image_organisation, image_operator;
    Role role, entityRole;
    Set<Role> listroles;


    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {

            resource = resourceLoader.getResource("classpath:image/stanley.jpg");
            file = resource.getFile();
            input = new FileInputStream(file);
            multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));


            //save image User
            images = new Images(multipartFile.getOriginalFilename(), multipartFile.getBytes(), multipartFile.getContentType(), String.valueOf(multipartFile.getSize()), multipartFile.getName());
            image_organisation = imageRepository.save(images);



           //save Role User
            role = new Role();
            role.setCreateDate(LocalDateTime.now());
            role.setName("User");
            role.setDescription("Role Pour Les Operator");
            roleRepository.save(role);

            //save Role Admin
            role = new Role();
            role.setCreateDate(LocalDateTime.now());
            role.setName("Admin");
            role.setDescription("Role Pour Les Admin");
            roleRepository.save(role);

            //save Role SuperAdmin
            role = new Role();
            role.setCreateDate(LocalDateTime.now());
            role.setName("SuperAdmin");
            role.setDescription("Role Pour Les Super Admin");
            entityRole = roleRepository.save(role);
            listroles = new HashSet<>();
            listroles.add(entityRole);

            //save User
            user = new User();
            user.setEnabled(true);
            user.setFirstname("Stanley");
            user.setLastname("Obdeus");
            user.setRoles(listroles);
            user.setCreateDate(LocalDateTime.now());
            user.setUsername("blackos");
            user.setCreateBy(Long.valueOf("0"));
            user.setPassword(encoder.encode("blackosmimi"));
            entityUser = userRepository.save(user);

        }
    }
}
