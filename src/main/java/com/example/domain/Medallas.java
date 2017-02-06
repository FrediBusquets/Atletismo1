package com.example.domain;

import javax.persistence.*;

@Entity
public class Medallas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idmedalla;
    private String especialidad;
    private String competicion;
    @Enumerated(EnumType.STRING)
    private TipoMedalla tipoMedalla;
    @ManyToOne
    private Atleta atleta;
    public Medallas(){
    }

    public Medallas(String especialidad, String competicion, TipoMedalla tipoMedallaa) {
        this.especialidad = especialidad;
        this.competicion = competicion;
        this.tipoMedalla = tipoMedalla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medallas medallas = (Medallas) o;

        if (idmedalla != medallas.idmedalla) return false;
        if (!especialidad.equals(medallas.especialidad)) return false;
        if (!competicion.equals(medallas.competicion)) return false;
        if (tipoMedalla != medallas.tipoMedalla) return false;
        return atleta.equals(medallas.atleta);

    }

    @Override
    public int hashCode() {
        int result = (int) (idmedalla ^ (idmedalla >>> 32));
        result = 31 * result + especialidad.hashCode();
        result = 31 * result + competicion.hashCode();
        result = 31 * result + tipoMedalla.hashCode();
        result = 31 * result + atleta.hashCode();
        return result;
    }

    public long getIdmedalla() {
        return idmedalla;
    }

    public void setIdmedalla(long idmedalla) {
        this.idmedalla = idmedalla;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public TipoMedalla getTipoMedalla() {
        return tipoMedalla;
    }

    public void setTipoMedalla(TipoMedalla tipoMedalla) {
        this.tipoMedalla = tipoMedalla;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    @Override
    public String toString() {
        return "Medallas{" +
                "idmedalla=" + idmedalla +
                ", especialidad='" + especialidad + '\'' +
                ", competicion='" + competicion + '\'' +
                ", tipoMedalla=" + tipoMedalla +
                ", atleta=" + atleta +
                '}';
    }
}
