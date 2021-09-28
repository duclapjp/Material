import java.time.LocalDate;

public class Meat extends Material{
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return cost*weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        return getAmount()*0.9;
    }

    @Override
    public String toString() {
        return "Meat{" +
                "cost=" + cost +
                ", weight=" + weight +
                '}'+super.toString();
    }
}
