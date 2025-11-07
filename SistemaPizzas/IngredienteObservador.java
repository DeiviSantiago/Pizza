import java.util.List;
import java.util.ArrayList;

abstract class IngredienteObservador implements Pizza, Subject {
    protected Pizza pizza;
    protected List<Observer> observers = new ArrayList<>();

    public IngredienteObservador(Pizza pizza) {
        this.pizza = pizza;
        if (pizza instanceof Subject) {
            for (Observer obs : ((Subject)pizza).getObservers()) {
                registerObserver(obs);
            }
        }
        notifyObservers();
    }

    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public int getCost() {
        return pizza.getCost();
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
}


class Queso extends IngredienteObservador {
    public Queso(Pizza pizza) { super(pizza); }
    @Override
    public String getDescription() { return pizza.getDescription() + ", Queso"; }
    @Override
    public int getCost() { return pizza.getCost() + 5000; }
}
class Pepperoni extends IngredienteObservador {
    public Pepperoni(Pizza pizza) { super(pizza); }
    @Override
    public String getDescription() { return pizza.getDescription() + ", Pepperoni"; }
    @Override
    public int getCost() { return pizza.getCost() + 7000; }
}
class Aceitunas extends IngredienteObservador {
    public Aceitunas(Pizza pizza) { super(pizza); }
    @Override
    public String getDescription() { return pizza.getDescription() + ", Aceitunas"; }
    @Override
    public int getCost() { return pizza.getCost() + 4000; }
}
class Tocineta extends IngredienteObservador {
    public Tocineta(Pizza pizza) { super(pizza); }
    @Override
    public String getDescription() { return pizza.getDescription() + ", Tocineta"; }
    @Override
    public int getCost() { return pizza.getCost() + 6000; }
}
