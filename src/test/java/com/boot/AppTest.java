package com.boot;

import com.boot.controller.HomeController;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AppTest {

    @Test
    public void testApp() {
        HomeController controller = new HomeController();
        String result = controller.home();
        assertThat(result, equalTo("Das Boot, reporting for duty!"));
    }
}
