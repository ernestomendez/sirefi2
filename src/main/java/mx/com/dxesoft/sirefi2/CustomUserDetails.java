package mx.com.dxesoft.sirefi2;

import mx.com.dxesoft.sirefi2.entities.Rol;
import mx.com.dxesoft.sirefi2.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * sirefi2, mx.com.dxesoft.sirefi2 . CustomUserDetails
 * Created by ernesto on 31/08/17.
 */
public class CustomUserDetails implements UserDetails {

    private String userName;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;


    public CustomUserDetails(User user) {
        userName = user.getEmail();
        password = user.getPassword();

        List<GrantedAuthority> userAuthorities = new ArrayList<>(user.getRoles().size());

        user.getRoles().forEach(rol -> userAuthorities.add(new SimpleGrantedAuthority(rol.getRole_name())));

        this.authorities = userAuthorities;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
