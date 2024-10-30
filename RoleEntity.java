// package com.example.RBD.Entity;

// import java.util.*;
// import jakarta.persistence.*;

// @Entity
// @Table(name = "roles")
// public class RoleEntity {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long r_id;
//     @Column(nullable = false)

//     private String r_name;
//     // @Column(name = "r_name")
//     @Column(nullable = false)

//     @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
//     private Set<UserEntity> users = new HashSet<>();

//     public Long getR_id() {
//         return r_id;
//     }

//     public void setR_id(Long r_id) {
//         this.r_id = r_id;
//     }

//     public String getR_name() {
//         return r_name;
//     }

//     public void setR_name(String r_name) {
//         this.r_name = r_name;
//     }

//     public Set<UserEntity> getUsers() {
//         return users;
//     }

//     public void setUsers(Set<UserEntity> users) {
//         this.users = users;
//     }

//     public void addUsers(UserEntity user) {
//         this.users.add(user);
//         user.getRoles().add(this);
//     }
// }

package com.example.RBD.Entity;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long r_id;

    @Column(nullable = false)
    private String rname;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<UserEntity> users = new HashSet<>();

    public Long getR_id() {
        return r_id;
    }

    public void setR_id(Long r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return rname;
    }

    public void setR_name(String rname) {
        this.rname = rname;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public void addUsers(UserEntity user) {
        this.users.add(user);
        user.getRoles().add(this);
    }
}
