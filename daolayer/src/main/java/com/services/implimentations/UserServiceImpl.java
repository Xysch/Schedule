package com.services.implimentations;

        import com.dao.RoleDao;
        import com.dao.UserDao;
        import com.entities.Students;
        import com.entities.UserRole;
        import com.services.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.stereotype.Service;

        import java.util.HashSet;
        import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Students user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> roles = new HashSet<>();
        roles.add(roleDao.getOne(1361L));
        user.setUserRole(roles);
        userDao.save(user);
    }


    public Students findByUsername(String username){
        return userDao.findByUsername(username);
    }

}
