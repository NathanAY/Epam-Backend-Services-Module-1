package com.epam.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.demo.entity.Identity;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class IdentityRepositoryWithDataJpaTest {


    @Autowired
    private IdentityRepository identityRepository;


    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers() {
        Identity identity = new Identity();
        identity.setName("Bob");
        identity.setEmail("bob@domain.com");
        identityRepository.save(identity);

        List<Identity> identities = (List<Identity>) identityRepository.findAll();

        assertThat(identities.size()).isEqualTo(1);
    }
}
