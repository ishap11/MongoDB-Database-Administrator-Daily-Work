package com.example.MongoDBAuth.service;

import com.example.MongoDBAuth.model.User;
import com.example.MongoDBAuth.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticateUser(String name, String password) {
        // Find user by name
        Optional<User> userOptional = userRepository.findByName(name);
        
        // If user is not found, return false
        if (userOptional.isEmpty()) {
            return false;
        }

        User user = userOptional.get();
        
        // Check if the password matches (simplified, but you can hash passwords for better security)
        return user.getPassword().equals(password);
    }

    public void askUserForCredentials() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        // Authenticate the user
        if (authenticateUser(name, password)) {
            System.out.println("Authentication successful! You can now perform actions.");
            // Perform your work here (for example, allow the user to perform operations)
        } else {
            System.out.println("Authentication failed! Invalid credentials.");
        }
        
        scanner.close();
    }
}
