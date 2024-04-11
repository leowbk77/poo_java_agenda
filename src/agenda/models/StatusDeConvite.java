package agenda.models;

import java.time.LocalDate;

public class StatusDeConvite {
    public boolean confirmado;
    public String horaSugerida;
    public LocalDate dataSugerida;

    public StatusDeConvite(){
        this.confirmado = false;
    }
    
    public boolean isConfirmado(){
        return confirmado;
    }

    public String getHoraSugerida(){
        return horaSugerida;
    }

    public LocalDate getDataSugerida(){
        return dataSugerida;
    }

    public void setConfirmado(boolean confirmado){
        this.confirmado = confirmado;
    }

    public void setHoraSugerida(String horaSugerida){
        this.horaSugerida = horaSugerida;
    }

    public void setDataSugerida(LocalDate dataSugerida){
        this.dataSugerida = dataSugerida;
    }

}