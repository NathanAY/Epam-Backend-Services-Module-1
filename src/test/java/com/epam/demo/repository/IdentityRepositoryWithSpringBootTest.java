package com.epam.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.demo.Application;
import com.epam.demo.entity.Identity;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class IdentityRepositoryWithSpringBootTest {


    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private IdentityRepository identityRepository;

    @Test
    public void whenGettingBeenWithTestProfile_thenGettingBeen() {
        Object bean = applicationContext.getBean("getDataSourceForTest");

        assertThat(bean).isNotNull();
    }

    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers() {
        Identity identity = new Identity();
        identity.setName("Bob");
        identity.setEmail("bob@domain.com");
        identityRepository.save(identity);

        List<Identity> identities = (List<Identity>) identityRepository.findAll();

        assertThat(identities.size()).isEqualTo(2);
    }
}
