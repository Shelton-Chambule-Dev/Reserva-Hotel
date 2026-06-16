package com.mz.reserva.hotel.entity;
import com.mz.reserva.hotel.exception.DominioExceptions;
import java.time.LocalDate;
import java.util.Objects;
public class Reserva {

    private Integer id;
    private String nome;
    private LocalDate diaEntrada;
    private LocalDate diaSaida;

    public Reserva(){}

    public Reserva(Integer id,String nome ,LocalDate diaEntrada, LocalDate diaSaida ) throws DominioExceptions {
        LocalDate now =  LocalDate.now();
        if(getDiaEntrada().isBefore(now) || getDiaSaida().isBefore(now)){
            throw new DominioExceptions("As datas deve estar no futuro nao no passado!");
        }
        if(!getDiaSaida().isAfter(getDiaEntrada())) {
            throw  new DominioExceptions("Erro: a data de saida deve ser depois da data de entrada!");
        }
        this.id = id;
        this.nome = nome;
        this.diaEntrada = diaEntrada;
        this.diaSaida = diaSaida;
    }
    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public LocalDate getDiaEntrada() {
        return diaEntrada;
    }
    public LocalDate getDiaSaida() {
        return diaSaida;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDiaEntrada(LocalDate diaEntrada) {
        this.diaEntrada = diaEntrada;
    }
    public void setDiaSaida(LocalDate diaSaida) {
        this.diaSaida = diaSaida;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
