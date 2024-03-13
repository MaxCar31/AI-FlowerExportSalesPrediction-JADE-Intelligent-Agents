package EnviarMensaje;

import java.io.Serializable;

public class AgenteInfo implements Serializable {
    private String ecuacion;
    private int valorY;
    private int valorX;

    public AgenteInfo(String ecuacion, int numIteracion, int valor) {
        this.ecuacion = ecuacion;
        this.valorY = numIteracion;
        this.valorX = valor;
    }

    public String obtenerEc() {
        return ecuacion;
    }

    public void setEcuacion(String ecuacion) {
        this.ecuacion = ecuacion;
    }

    public int getValorY() {
        return valorY;
    }

    public void setValorY(int valorY) {
        this.valorY = valorY;
    }

    public int getValorX() {
        return valorX;
    }

    public void setValorX(int valorX) {
        this.valorX = valorX;
    }

    @Override
    public String toString() {
        return "AgenteInfo{" +
                "ecuacion='" + ecuacion + '\'' +
                ", valorX=" + valorX +
                '}';
    }
}
