package com.leonel.myControl2.models;

public class PersonasDTO {
    private Long resideEn;

    private String nombre;

    private String apellido;

    private String rut;

    private String fechaNacimiento;

    public PersonasDTO() {
    }

    public Long getResideEn() {
        return resideEn;
    }

    public void setResideEn(Long resideEn) {
        this.resideEn = resideEn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
