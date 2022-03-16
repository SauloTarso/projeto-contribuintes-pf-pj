package entities;

public class PessoaFisica extends Contribuinte {

    private Double gastoSaude;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
        super(nome, rendaAnual);
        this.gastoSaude = gastoSaude;
    }

    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }

    @Override
    public double imposto() {
        double impostoPagar;
        if (getRendaAnual() < 20000.00) {
            impostoPagar = getRendaAnual() * 0.15;

        } else {
            impostoPagar = getRendaAnual() * 0.25;
        }
        impostoPagar -= (getGastoSaude() * 0.5);
        if (impostoPagar < 0.0){
            impostoPagar = 0.0;
        }
        return impostoPagar;
    }
}
