package com.leonel.myControl2.models;

public class DepartamentosDTO {
    private Long edificio;

    private String numero;

    

  
    public Long getEdificio() {
        return edificio;
    }

  
    public void setEdificio(Long edificio) {
        this.edificio = edificio;
    }

    /**
     * @return String return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }


	

    public DepartamentosDTO() {
       
    }

}
