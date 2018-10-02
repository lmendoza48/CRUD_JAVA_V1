package com.spring.version.services.implement;

import com.spring.version.DAO.UserDataDAOint;
import com.spring.version.model.UserData;
import com.spring.version.services.UserDataServicesInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.plugin.util.UserProfile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service("userDataServicesImpl")
@Transactional
public class UserDataServicesImpl implements UserDataServicesInt, UserDetailsService {

    @Autowired
    private UserDataDAOint userDataDAOint;

    @Transactional
    public void saveUser(UserData userData) {
        userDataDAOint.saveUser(userData);
    }

    public UserData getUserDataByIdUser(String IdUser) {
        return userDataDAOint.getUserDataByIdUser(IdUser);
    }

    @Override
    public UserData getUserByEmail(String email) {
        return userDataDAOint.getUserDataByUsername(email);
    }


    /**
     * Method for get User by Spring Security
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if( username.isEmpty() ) {
            throw new UsernameNotFoundException("Please ingrese el username el campo no puede estar vacio");
        }

        UserData userdataLogin = userDataDAOint.getUserDataByUsername(username);

        if( userdataLogin == null ) {
            throw new UsernameNotFoundException("Usuario no existe");
        }
        List<GrantedAuthority> authorities = buildUserAuthority(userdataLogin.getRolUser());

        return new org.springframework.security.core.userdetails.User(String.valueOf(userdataLogin.getIdUser()), userdataLogin.getPassword(),
                true, true, true, true, authorities);

    }

    /**
     * metodo para conseguir los roles que estan permitido en el sistema
     * @param userRoles
     * @return
     */
    private List<GrantedAuthority> buildUserAuthority(String userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        setAuths.add(new SimpleGrantedAuthority(userRoles));

        /* // When much ROles
        for (UserData userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRolUser()));
        }*/

        return new ArrayList<GrantedAuthority>(setAuths);
    }

}
