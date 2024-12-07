    package kg.alatoo.database.entity;
    import jakarta.persistence.CascadeType;
    import jakarta.persistence.Column;
    import jakarta.persistence.EnumType;
    import jakarta.persistence.Enumerated;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.OneToOne;
    import kg.alatoo.database.enums.Role;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;
    import jakarta.persistence.Entity;
    import jakarta.persistence.Table;
    import lombok.Data;

    import java.util.Collection;
    import java.util.Collections;

    @Entity
    @Data
    @Table(name = "users")
    public class User implements UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String email;
        private String password;
        private String phoneNumber;
        private String fullName;

        @Enumerated(EnumType.STRING)
        private Role role;

        @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
        private Doctor doctor;

        @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
        private Patient patient;


        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));

        }

        public boolean isAccountNonExpired() {
            return true;
        }

        public boolean isAccountNonLocked() {
            return true;
        }

        public boolean isCredentialsNonExpired() {
            return true;
        }

        public boolean isEnabled() {
            return true;
        }
        @Override
        public String getUsername() {
            return email;
        }
        @Override
        public String getPassword() {
            return password;
        }


    }
