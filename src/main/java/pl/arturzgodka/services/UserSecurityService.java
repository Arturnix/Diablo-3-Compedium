package pl.arturzgodka.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.arturzgodka.databaseutils.UserDao;
import pl.arturzgodka.datamodel.UserDataModel;

@Service
public class UserSecurityService implements UserDetailsService {

    private final UserDao dao = new UserDao();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDataModel userDataModel = dao.findUserByEmail(username);

        return User.withUsername(userDataModel.getEmail())
                .password(userDataModel.getPassword())
                .authorities("USER")
                .build();
    }
}
