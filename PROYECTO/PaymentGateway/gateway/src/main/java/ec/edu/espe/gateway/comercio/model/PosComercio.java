package ec.edu.espe.gateway.comercio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "GTW_POS_COMERCIO")
public class PosComercio implements Serializable {

    @EmbeddedId
    private PosComercioPK pk;
    @NotNull
    @Column(name = "DIRECCION_MAC", length = 32, nullable = false)
    private String direccionMac;
    @NotNull
    @Column(name = "ESTADO", length = 3, nullable = false)
    private String estado;
    @NotNull
    @Column(name = "FECHA_ACTIVACION", nullable = false)
    private LocalDate fechaActivacion;
    @NotNull
    @Column(name = "ULTIMO_USO", nullable = false)
    private LocalDate ultimoUso;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "COD_COMERCIO", nullable = false)
    private Comercio comercio;

    // Constructor, Getters and Setters
    public PosComercio() {
    }

    public PosComercio(PosComercioPK pk) {
        this.pk = pk;
    }

    public PosComercioPK getPk() {
        return pk;
    }

    public void setPk(PosComercioPK pk) {
        this.pk = pk;
    }

    public String getDireccionMac() {
        return direccionMac;
    }

    public void setDireccionMac(String direccionMac) {
        this.direccionMac = direccionMac;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (!"ACT".equals(estado) && !"INA".equals(estado)) {
            throw new IllegalArgumentException("El estado debe ser 'ACT' o 'INA'.");
        }
        this.estado = estado;
    }

    public LocalDate getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(LocalDate fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public LocalDate getUltimoUso() {
        return ultimoUso;
    }

    public void setUltimoUso(LocalDate ultimoUso) {
        this.ultimoUso = ultimoUso;
    }

    public Comercio getGtwComercio() {
        return comercio;
    }

    public void setGtwComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    // HashCode and Equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PosComercio other = (PosComercio) obj;
        if (pk == null) {
            if (other.pk != null)
                return false;
        } else if (!pk.equals(other.pk))
            return false;
        return true;
    }

    // ToString
    @Override
    public String toString() {
        return "GtwPosComercio [pk=" + pk + ", direccionMac=" + direccionMac + ", estado=" + estado
                + ", fechaActivacion=" + fechaActivacion + ", ultimoUso=" + ultimoUso + ", gtwComercio=" + comercio
                + "]";
    }
}