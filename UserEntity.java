package com.example.RBD.Entity;

//import org.hibernate.mapping.List;
import java.util.*;

//import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.LongArraySerializer;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // @JoinColumn(name = "add_id")

    @ElementCollection
    private List<AddEntity> addresses = new ArrayList<>();
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String useremail;
    @Column(nullable = false)
    private String userpass;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "roles", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "r_id"))

    private Set<RoleEntity> roles = new HashSet<>();

    @Column(nullable = false)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)

    public Long getId() {
        return id;
    }

    public Set<RoleEntity> getRole() {
        return roles;
    }

    public void setRole(Set<RoleEntity> role) {
        this.roles = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public List<AddEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddEntity> addresses) {
        this.addresses = addresses;
    }

    public Set<RoleEntity> getRoles() {

        if (roles == null) {
            roles = new HashSet<>();
        }
        return roles;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getRoles'");
    }

    public void setRoles(Set<RoleEntity> roles) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRoles'");
    }

    public void addRole(RoleEntity role) {
        this.roles.add(role);
        role.getUsers().add(this); // Maintain bidirectional relationship
    }

}
