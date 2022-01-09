package com.jasokolowska.registrationapp.service;

import com.jasokolowska.registrationapp.model.User;
import com.jasokolowska.registrationapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DbServiceTestSuite {

    @Autowired
    private DbService dbService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddUser() {
        //Given
        User user1 = new User("asia", "Joanna", "Sokołowska", "joanna_s@op.pl");
        User user2 = new User("bartek", "Bartosz", "Drabicki", "drabollo666@gmail.com");
        User user3 = new User("kowal", "Jan", "Kowalski", "jan@kowalski.com");
        dbService.addUser(user1);
        dbService.addUser(user2);
        dbService.addUser(user3);

        //When
        int result = dbService.getUsers().size();

        //Then
        assertEquals(3, result);

        //CleanUp
        userRepository.deleteById(user1.getId());
        userRepository.deleteById(user2.getId());
        userRepository.deleteById(user3.getId());
    }

}