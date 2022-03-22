package com.rodrigo.dummymigrationliquibase.api.controller;

import com.rodrigo.dummymigrationliquibase.util.DatabaseCleaner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource("/application.properties")
public class RequisicaoControllerTest {

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    public static DataSource dataSource;

    @BeforeEach
    public void limparBanco() {

        //databaseCleaner.clearTables();
    }

    @Test
    public void teste() {
        Assertions.assertTrue(true);
    }

}
