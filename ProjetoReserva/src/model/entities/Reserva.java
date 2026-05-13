package model.entities;
import model.exceptions.DominioExceptions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class Reserva {

    private Integer nomeSala;
    private Date diaEntrada;
    private Date diaSaida;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer nomeSala, Date diaEntrada, Date diaSaida) throws DominioExceptions {
        if(!diaSaida.after(diaEntrada)) {
            throw  new DominioExceptions("Erro: a data de saida deve ser depois da data de entrada!");
        }
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
    public  long Duracao(){
        long diferenca = diaEntrada.getTime() - diaSaida.getTime();  // retorna millisegundos de cada data e faz a subtracao
        return  TimeUnit.DAYS.convert(diferenca,TimeUnit.MILLISECONDS);  // faz a conversao de millisegundos para dias
    }
    public  void  atualizarDatas( Date diaEntrada, Date diaSaida) throws DominioExceptions{
        Date now = new Date();
        if(diaEntrada.before(now) || diaSaida.before(now)){
            throw new DominioExceptions("As datas deve estar no futuro nao no passado!");
        }
        if(!diaSaida.after(diaEntrada)) {
            throw  new DominioExceptions("Erro: a data de saida deve ser depois da data de entrada!");
        }
           this.diaEntrada = diaEntrada;
           this.diaSaida = diaSaida;
    }
    @Override
    public String toString(){
        return "Sala: "+nomeSala+", DiaEntrada : "+sdf.format(diaEntrada)+", DiaSaida:  "+sdf.format(diaSaida)+ " Duracao: " +Duracao()+ " Noites";
    }
}
