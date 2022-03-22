package com.rodrigo.dummymigrationliquibase.api.controller;

import com.rodrigo.dummymigrationliquibase.domain.model.Acesso;
import com.rodrigo.dummymigrationliquibase.domain.model.Endereco;
import com.rodrigo.dummymigrationliquibase.util.DatabaseCleaner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private JdbcTemplate jdbcCoop;

    private JdbcTemplate jdbcUtil;

    private DatabaseCleaner databaseCleaner;

    public EnderecoController(JdbcTemplate jdbcCoop, @Qualifier("util") JdbcTemplate jdbcUtil, DatabaseCleaner databaseCleaner) {
        this.jdbcCoop = jdbcCoop;
        this.jdbcUtil = jdbcUtil;
        this.databaseCleaner = databaseCleaner;
    }

    @GetMapping("/coop")
    public List<Endereco> buscarEnderecosCoop() {
        List<Endereco> enderecos = jdbcCoop.query(" select * from endereco ",
                new BeanPropertyRowMapper<>(Endereco.class));

        this.databaseCleaner.clearTables();

        return enderecos;
    }

    @GetMapping("/util")
    public List<Acesso> buscarAcessosUtil() {
        return jdbcUtil.query(" select * from acesso ", new BeanPropertyRowMapper<>(Acesso.class));
    }

}
