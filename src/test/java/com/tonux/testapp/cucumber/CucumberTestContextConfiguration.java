package com.tonux.testapp.cucumber;

import com.tonux.testapp.TestApp;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = TestApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
