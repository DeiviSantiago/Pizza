import java.util.List;
import java.util.ArrayList;

public interface Pizza {
    String getDescription();
    int getCost();
}

interface Observer {
    void update(Pizza pizza);
}

interface Subject {
    void registerObserver(Observer obs);
    void removeObserver(Observer obs);
    void notifyObservers();
    List<Observer> getObservers();
}


class PizzaBase implements Pizza, Subject {
    private String tamaño;
    private int costo;
    private List<Observer> observers = new ArrayList<>();

    public PizzaBase(String tamaño) {
        this.tamaño = tamaño.toLowerCase();
        switch (this.tamaño) {
            case "mediana": this.costo = 19900; break;
            case "grande": this.costo = 29900; break;
            case "extragrande": this.costo = 39900; break;
            default: this.tamaño = "mediana"; this.costo = 19900; break;
        }
    }

    @Override
    public String getDescription() {
        return "Pizza Base " + tamaño;
    }

    @Override
    public int getCost() {
        return costo;
    }

    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(this);
        }
    }

    @Override
    public List<Observer> getObservers() {
        return observers;
    }
}
