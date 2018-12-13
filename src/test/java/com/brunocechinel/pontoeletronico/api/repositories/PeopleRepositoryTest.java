package com.brunocechinel.pontoeletronico.api.repositories;

import com.brunocechinel.pontoeletronico.entities.People;
import com.brunocechinel.pontoeletronico.repositories.PeopleRepository;
import org.assertj.core.internal.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PeopleRepositoryTest {
    
    @Autowired
    private PeopleRepository peopleRepository;
    
    @Value("${test.people.save.name}")
    private String peopleToSaveName;
    @Value("${test.people.save.email}")
    private String peopleToSaveEmail;
    
    @Test
    public void testSuccessSave() {
        People peopleSaved = peopleRepository.save(
            People.builder()
                .name(peopleToSaveName)
                .email(peopleToSaveEmail)
                .build()
        );
        
        assertEquals(peopleToSaveName, peopleSaved.getName());
        assertEquals(peopleToSaveEmail, peopleSaved.getEmail());
        assertNotNull(peopleSaved.getId());
        
    }
}
