package system.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.business.Project;
import system.business.Skill;
import system.business.User;
import system.business.UserProject;
import system.business.enums.SkillProfficiency;
import system.dao.GenericDao;
import system.dao.UserDao;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService extends AbstractRepositoryService<User> {

    private final UserDao dao;

    @Autowired
    private ProjectService projectService;

    @Autowired
    public UserService(UserDao dao) {
        this.dao = dao;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected GenericDao<User> getPrimaryDao() {
        return dao;
    }

    @Override
    void prePersist(User instance) {
        persistSkills(instance);
    }

    @Transactional
    public void create(User instance) {
        try {
            if (exists(instance.getUserName())) {
                System.out.println("User already exists");
            } else {
                if (instance.getPassword() != null) {
                    instance.encodePassword(passwordEncoder);
                }
                super.persist(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
//    @PreAuthorize("(#instance.userName==principal.username)or(principal.authorities.contains('ADMIN_ROLE'))")//TODO - check if works - user can only edit own profile or if is admin
    public void update(User instance) {
        try {
            if (!exists(instance.getUserName())) {
                System.out.println("User doesn't exists");
            } else {
                if (instance.getPassword() != null) {
                    instance.encodePassword(passwordEncoder);
                }
                super.update(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User findUserByUsername(String username) {
        return dao.findByUsername(username);
    }

    public List<User> findUsersBySkill(Skill skill) {
        List<User> found = new LinkedList<>();
        for (User user : dao.findAll()) {
            for (Skill s : user.getSkills()) {
                if (s.getName() == skill.getName()) {
                    found.add(user);
                }
            }
        }
        return found;
    }

    public List<User> findUsersBySkillProfficiency(Skill skill) {
        List<User> found = new LinkedList<>();
        SkillProfficiency prof = skill.getProfficiency();
        List<SkillProfficiency> allowed = new LinkedList<>();
        // BEGINNER, INTERMEDIATE, PROFFICIENT, ADVANCED, MASTER
        allowed.add(SkillProfficiency.MASTER);
        if (prof != SkillProfficiency.MASTER) {
            allowed.add(SkillProfficiency.ADVANCED);
            if (prof != SkillProfficiency.ADVANCED) {
                allowed.add(SkillProfficiency.PROFFICIENT);
                if (prof != SkillProfficiency.PROFFICIENT) {
                    allowed.add(SkillProfficiency.INTERMEDIATE);
                    if (prof != SkillProfficiency.INTERMEDIATE) {
                        allowed.add(SkillProfficiency.BEGINNER);
                        if (prof != SkillProfficiency.BEGINNER) {
                            System.out.println("This is not okay bro - how come this person searched a weird undefined profficiency? EXPLAIN!");
                        }
                    }
                }
            }
        }

        for (User user : dao.findAll()) {
            for (Skill s : user.getSkills()) {
                if (s.getName() == skill.getName() && allowed.contains(s.getProfficiency())) {
                    found.add(user);
                }
            }
        }
        return found;
    }

    public List<User> findUsersByProject(Project project) {
        List<User> found = findAll();

        for (User user : dao.findAll()) {
            for (UserProject up : user.getUserProjects()) {
                if (up.getProject() == project) {
                    found.add(user);
                }
            }
        }
        return found;
    }

    //TODO: do this the stupid way
    public List<User> findUsersByProjectByDuration(Project project, long duration) {
        List<User> users = findAll();
        return null;
    }

    public boolean exists(String username) {
//        Objects.requireNonNull(username);
        return dao.exists(username);
    }

    private void persistSkills(User instance) {
        Optional.ofNullable(instance.getSkills())
                .ifPresent(
                        skills -> skills.stream()
                                .filter(t -> t.getUser() == null)
                                .forEach(
                                        t -> {
                                            t.setUser(instance);
                                        }
                                )
                );
    }
}
