package com.rodrigo.dummymigrationliquibase.api.controller;

import com.rodrigo.dummymigrationliquibase.domain.model.Requisicao;
import com.rodrigo.dummymigrationliquibase.util.DatabaseCleaner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requisicoes")
public class RequisicaoController {

    private JdbcTemplate jdbcCoop;

    public RequisicaoController(JdbcTemplate jdbcCoop, @Qualifier("util") JdbcTemplate jdbcUtil) {
        this.jdbcCoop = jdbcCoop;
    }

    @GetMapping("/{id}")
    public Requisicao buscarPorId(@PathVariable("id") Long id) {

        if(id == 2) throw new RuntimeException("Teste");

        Object[] params = new Object[]{id};

        return jdbcCoop.queryForObject(" select * from requisicao where id = ? ",
                params, Requisicao.class);
    }


}
