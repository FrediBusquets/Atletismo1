package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Atleta {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
    @OneToMany(mappedBy = "atleta", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Medallas> medallas = new HashSet<>();

    public Atleta() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atleta atleta = (Atleta) o;

        if (id != atleta.id) return false;
        if (!nombre.equals(atleta.nombre)) return false;
        if (!apellidos.equals(atleta.apellidos)) return false;
        if (!nacionalidad.equals(atleta.nacionalidad)) return false;
        if (!fechaNacimiento.equals(atleta.fechaNacimiento)) return false;
        return medallas.equals(atleta.medallas);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + nombre.hashCode();
        result = 31 * result + apellidos.hashCode();
        result = 31 * result + nacionalidad.hashCode();
        result = 31 * result + fechaNacimiento.hashCode();
        result = 31 * result + medallas.hashCode();
        return result;
    }

    public Set<Medallas> getMedallas() {
        return medallas;
    }

    public void setMedallas(Set<Medallas> medallas) {
        this.medallas = medallas;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    public Atleta( String nombre, String apellidos, String nacionalidad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
