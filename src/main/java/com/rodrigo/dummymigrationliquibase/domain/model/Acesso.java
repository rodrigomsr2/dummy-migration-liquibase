package com.rodrigo.dummymigrationliquibase.domain.model;

public class Acesso {

    private Long id;

    private Long idPerfil;

    private Long idRotas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Long getIdRotas() {
        return idRotas;
    }

    public void setIdRotas(Long idRotas) {
        this.idRotas = idRotas;
    }
}
