package com.boot;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class IntegrationTest {

    @Autowired
    private ShipwreckRepository shipwreckRepository;

    @Test
    public void testFindAll() {
        List<Shipwreck> shipwreckList = shipwreckRepository.findAll();
        assertThat(shipwreckList.size(), greaterThan(0));
    }

}
