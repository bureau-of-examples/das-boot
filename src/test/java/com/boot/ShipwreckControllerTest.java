package com.boot;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTest {

    @InjectMocks
    private ShipwreckController controller;

    @Mock
    private ShipwreckRepository shipwreckRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet() {
        //arrange
        Shipwreck shipwreck = new Shipwreck();
        shipwreck.setId(1L);
        when(shipwreckRepository.findOne(1L)).thenReturn(shipwreck);

        //action
        shipwreck = controller.get(1L);

        //assert
        assertThat(shipwreck.getId(), equalTo(1L));
        verify(shipwreckRepository).findOne(1L);
    }
}
