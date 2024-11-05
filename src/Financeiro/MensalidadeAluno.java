package Financeiro;

import java.util.Date;

public class MensalidadeAluno {
    private int alunoId;
    private double valorPago;
    private Date dataPagamento;

    public MensalidadeAluno(int alunoId, double valorPago, Date dataPagamento) {
        this.alunoId = alunoId;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public double getValorPago() {
        return valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}