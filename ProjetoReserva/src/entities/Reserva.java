package entities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class Reserva {

    private Integer nomeSala;
    private Date diaEntrada;
    private Date diaSaida;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer nomeSala, Date diaEntrada, Date diaSaida) {
        this.nomeSala = nomeSala;
        this.diaEntrada = diaEntrada;
        this.diaSaida = diaSaida;
    }
    public Integer getNomeSala() {
        return nomeSala;
    }
    public void setNomeSala(Integer nomeSala) {
        this.nomeSala = nomeSala;
    }
    public Date getDiaEntrada() {
        return diaEntrada;
    }
    public Date getDiaSaida() {
        return diaSaida;
    }
   // Removi so metodos set de diaEntrada e diaSaida
    public  long Duracao(){
        // para calcular a difeenca de dias entre diaEntrda e diaSaida usei os Milisegundos
        // diferenca entra as duas datas diaEntrada e diaSaida em
        long diferenca = diaEntrada.getTime() - diaSaida.getTime();
        return  TimeUnit.DAYS.convert(diferenca,TimeUnit.MILLISECONDS);
    }
    public  void atualizarDatas( Date diaEntrada, Date diaSaida){
           this.diaEntrada = diaEntrada;
           this.diaSaida = diaSaida;
    }
    @Override
    public String toString(){
        return "Sala: "+nomeSala+", DiaEntrada : "+sdf.format(diaEntrada)+", DiaSaida:  "+sdf.format(diaSaida)+ " Duracao: " +Duracao()+ " Noites";
    }
}
