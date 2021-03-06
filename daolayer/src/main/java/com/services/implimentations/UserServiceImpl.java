package com.services.implimentations;

        import com.dao.RoleDao;
        import com.dao.StudGroupDao;
        import com.dao.UserDao;
        import com.entities.StudGroup;
        import com.entities.Students;
        import com.entities.UserRole;
        import com.services.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.jpa.repository.Modifying;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.Arrays;
        import java.util.HashSet;
        import java.util.List;
        import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private StudGroupDao groupDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Students user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> roles = new HashSet<>();
        roles.add(roleDao.getOne(1361L));
        user.setUserRole(roles);
        user.setGroup(groupDao.findByName(user.getGroupName()));
        userDao.save(user);
    }

    public Students findByUsername(String username){
        return userDao.findByUsername(username);
    }

    public List<Students> findAll(){
        return userDao.findAll();
    }

    public void updateUser(Students user){
        Set<UserRole> roles = new HashSet<>();
        roles.add(roleDao.getOne(1361L));
        user.setUserRole(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setGroup(groupDao.findByName(user.getGroupName()));
        userDao.save(user);
    }

    public void save(List<Students> students){
        userDao.save(students);
    }

    @Transactional
    public Students findById(Long id){
        Students stud = userDao.getOne(id);
        return stud;
    }

    @Transactional
    public void deleteByUsername(String username){
        userDao.deleteByUsername(username);
    }

    //For student registration only
    public StudGroup findGroupByStudent(Students user){
        return groupDao.findByName(user.getGroupName());
    }

    public StudGroup getGroupById(Long id){
        return groupDao.findById(id);
    }

    public List<Students> findAllByGroup(StudGroup group){
        return userDao.findAllByGroup(group);
    }


}
