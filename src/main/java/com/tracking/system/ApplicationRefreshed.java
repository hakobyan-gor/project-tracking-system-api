package com.tracking.system;

import com.tracking.system.enums.ProjectStatusEnum;
import com.tracking.system.exceptions.EntityNotFoundException;
import com.tracking.system.models.entities.coontact.Contact;
import com.tracking.system.models.entities.project.Project;
import com.tracking.system.repositories.contact.ContactRepository;
import com.tracking.system.repositories.project.ProjectRepository;
import com.tracking.system.repositories.user.AdminRepository;
import com.tracking.system.repositories.user.role.RoleRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ApplicationRefreshed implements ApplicationListener<ContextRefreshedEvent> {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final ProjectRepository projectRepository;
    private final ContactRepository contactRepository;

    public ApplicationRefreshed(
            AdminRepository adminRepository,
            PasswordEncoder passwordEncoder,
            RoleRepository roleRepository,
            ProjectRepository projectRepository, ContactRepository contactRepository) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.projectRepository = projectRepository;
        this.contactRepository = contactRepository;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            seedData();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void seedData() throws EntityNotFoundException {

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            List<Contact> contactList = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                Contact contact = Contact
                        .builder()
                        .fullName("Test")
                        .email("test@gmail.com")
                        .phoneNumber("+37411223344")
                        .build();
                contactList.add(contact);
            }
            Project project = Project
                    .builder()
                    .title("Test")
                    .projectStatus(ProjectStatusEnum.fromOrdinal(random.ints(1, 5)
                            .findFirst().getAsInt()))
                    .build();
            projectRepository.save(project);
            contactList.forEach(contact -> contact.setProject(project));
            contactRepository.saveAll(contactList);
        }
        /*Role adminRole = new Role();
        adminRole.setRoleName(RoleConstants.ADMIN_NAME);
        adminRole.setRoleDescription("Admin - Has permission to perform admin tasks");
        adminRole.setDeleted(false);
        roleRepository.save(adminRole);

        Admin abmAdmin = new Admin();
        abmAdmin.setFirstname("Gor");
        abmAdmin.setFirstname("Hakobyan");
        abmAdmin.setPassword(passwordEncoder.encode("asdasd"));
        abmAdmin.setPhoneNumber("+37493095777");
        abmAdmin.setEmail("gorhakobiann@gmail.com");
        abmAdmin.setDeleted(false);
        abmAdmin.setUsername("gorhakobiann@gmail.com" + new Date().getTime());
        abmAdmin.setRole(roleRepository.findById(RoleConstants.ADMIN_ID).orElseThrow(() -> new EntityNotFoundException("Role Admin not found")));
        adminRepository.save(abmAdmin);*/

    }

}
