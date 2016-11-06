package project.caixaeletronico.TO;

/**
 * Created by Maael on 12/09/2016.
 */
public class ExtratoTO {

    private String tipoMovimentacao;
    private int tipo;
    private double valorMovimentacao;
    private double saldoAtual;
    private String dataMovimentacao;

    public ExtratoTO(String tipoMovimentacao, int tipo, double valorMovimentacao, double saldoAtual, String dataMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.tipo = tipo;
        this.valorMovimentacao = valorMovimentacao;
        this.saldoAtual = saldoAtual;
        this.dataMovimentacao = dataMovimentacao;
    }

    public ExtratoTO() {
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getValorMovimentacao() {
        return valorMovimentacao;
    }

    public void setValorMovimentacao(double valorMovimentacao) {
        this.valorMovimentacao = valorMovimentacao;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public String getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(String dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }
}
