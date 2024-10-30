// package com.example.RBD.Service;

// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// //import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;
// import com.example.RBD.Repository.UserRepo;
// import com.example.RBD.Repository.AddRepo;
// import com.example.RBD.Repository.RoleRepo;
// import com.example.RBD.DTO.LoginRequest;
// import com.example.RBD.DTO.LoginResponse;
// import com.example.RBD.DTO.RegisterUser;
// import com.example.RBD.Entity.*;

// @SpringBootApplication(scanBasePackages = { "com.example.RBD" })
// @Service
// public class UserService {

//     @Autowired
//     private UserRepo userRepository;

//     @Autowired
//     private AddRepo addRepository;

//     @Autowired
//     private RoleRepo rr;

//     public UserEntity addUserWithAddresses(UserEntity user, List<AddEntity> addresses) {
//         for (AddEntity address : addresses) {
//             address.setUser(user);
//         }
//         user.setAddresses(addresses);
//         return userRepository.save(user);
//     }

//     public UserEntity addUserWithRole(UserEntity user, Set<RoleEntity> roles) {
//         for (RoleEntity role : roles) {
//             role.addUsers(user);
//         }
//         user.setRoles(roles);
//         return userRepository.save(user);

//     }

//     public UserEntity registerUserWithRoles(RegisterUser request) {
//         UserEntity user = new UserEntity();
//         user.setUsername(request.getUsername());
//         user.setUseremail(request.getUseremail());
//         user.setUserpass(encryptPassword(request.getUserpass()));

//         Set<RoleEntity> roles = new HashSet<>();
//         for (String r_Name : request.getRoles()) {
//             RoleEntity role = rr.findByRoleName(r_Name)
//                     .orElseThrow(() -> new RuntimeException("Role not found: " + r_Name));
//             roles.add(role); // Add the RoleEntity to the roles set

//         }
//         user.setRoles(roles); // Set the roles in the user entity

//         return userRepository.save(user);
//     }

//     public UserEntity registerUser(UserEntity user) {
//         if (userRepository.findByUseremail(user.getUseremail()).isPresent()) {
//             throw new RuntimeException("Email already exists!");
//         }
//         if (userRepository.findByUsername(user.getUsername()).isPresent()) {
//             throw new RuntimeException("Username already exists!");
//         }

//         user.setUserpass(encryptPassword(user.getUserpass()));
//         return userRepository.save(user);
//     }

//     public LoginResponse loginUser(LoginRequest loginRequest) {
//         System.out.println("Received username: " + loginRequest.getUsername());
//         System.out.println("Received password: " + loginRequest.getUserpass());

//         Optional<UserEntity> userOpt = userRepository.findByUsername(loginRequest.getUsername());

//         if (userOpt.isPresent()) {
//             UserEntity user = userOpt.get();
//             if (checkPassword(loginRequest.getUserpass(), user.getUserpass())) {
//                 return new LoginResponse("Login successful", true);
//             } else {
//                 return new LoginResponse("Invalid password", false);
//             }
//         }
//         return new LoginResponse("User not found", false);
//     }

//     // Encryption method (You can add password encryption logic here)
//     private String encryptPassword(String password) {
//         return password; // In real case, use something like BCrypt to encrypt the password
//     }

//     // Simplified password check method
//     private boolean checkPassword(String rawPassword, String encryptedPassword) {
//         // Null check for the raw password
//         if (rawPassword == null) {
//             throw new IllegalArgumentException("Password cannot be null");
//         }

//         // In case you want to do actual encrypted password comparison, use an encoder
//         // For now, it's just a plain text comparison
//         return rawPassword.equals(encryptedPassword);
//     }
// }

package com.example.RBD.Service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import com.example.RBD.Repository.UserRepo;
import com.example.RBD.Repository.RoleRepo;
import com.example.RBD.DTO.LoginRequest;
import com.example.RBD.DTO.LoginResponse;
import com.example.RBD.DTO.RegisterUser;
import com.example.RBD.Entity.*;

@SpringBootApplication(scanBasePackages = { "com.example.RBD" })
@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private RoleRepo rr;

    public UserEntity addUserWithAddresses(UserEntity user, List<AddEntity> addresses) {

        if (user == null) {
            throw new IllegalArgumentException("User entity cannot be null");
        }

        for (AddEntity address : addresses) {
            address.setUser(user);
        }
        user.setAddresses(addresses);
        return userRepository.save(user);
    }

    // public UserEntity addUserWithRole(UserEntity user, Set<RoleEntity> roles) {
    // if (user == null) {
    // throw new IllegalArgumentException("User entity cannot be null");
    // }

    // for (RoleEntity role : roles) {
    // role.addUsers(user);
    // }
    // user.setRoles(roles);
    // return userRepository.save(user);
    // }

    // public UserEntity registerUserWithRoles(RegisterUser request) {
    // if (userRepository.findByUseremail(request.getUseremail()).isPresent()) {
    // throw new RuntimeException("Email already exists!");
    // }
    // if (userRepository.findByUsername(request.getUsername()).isPresent()) {
    // throw new RuntimeException("Username already exists!");
    // }

    // UserEntity user = new UserEntity();
    // user.setUsername(request.getUsername());
    // user.setUseremail(request.getUseremail());
    // user.setUserpass(encryptPassword(request.getUserpass()));

    // Set<RoleEntity> roles = new HashSet<>();
    // for (String rname : request.getRoles()) {
    // RoleEntity role = rr.findByrname(rname)
    // .orElseThrow(() -> new RuntimeException("Role not found: " + rname));
    // roles.add(role);
    // }
    // user.setRoles(roles);

    // return userRepository.save(user);
    // }

    // public UserEntity registerUser(UserEntity user) {
    // if (userRepository.findByUseremail(user.getUseremail()).isPresent()) {
    // throw new RuntimeException("Email already exists!");
    // }
    // if (userRepository.findByUsername(user.getUsername()).isPresent()) {
    // throw new RuntimeException("Username already exists!");
    // }

    // user.setUserpass(encryptPassword(user.getUserpass()));
    // return userRepository.save(user);
    // }

    public LoginResponse loginUser(LoginRequest loginRequest) {
        Optional<UserEntity> userOpt = userRepository.findByUsername(loginRequest.getUsername());

        if (userOpt.isPresent()) {
            UserEntity user = userOpt.get();
            if (checkPassword(loginRequest.getUserpass(), user.getUserpass())) {
                return new LoginResponse("Login successful", true);
            } else {
                return new LoginResponse("Invalid password", false);
            }
        }
        return new LoginResponse("User not found", false);
    }

    private String encryptPassword(String password) {
        return password; // Placeholder for actual encryption logic
    }

    private boolean checkPassword(String rawPassword, String encryptedPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        return rawPassword.equals(encryptedPassword);
    }

    public UserEntity saveUser(UserEntity user) {
        // Check if user fields (like email or username) already exist to prevent
        // duplicates, if necessary
        if (userRepository.findByUseremail(user.getUseremail()).isPresent()) {
            throw new RuntimeException("Email already exists!");
        }
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists!");
        }

        // Encrypt the password before saving (replace with your actual encryption logic
        // if available)
        user.setUserpass(encryptPassword(user.getUserpass()));

        // Save the user entity to the database
        return userRepository.save(user);
    }
}