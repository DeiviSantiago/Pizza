import java.util.Scanner;

public class SistemaPizzas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ======= BIENVENIDO A PIZZANTI'S ======= ");
        System.out.println("Elija el tamaño de la pizza: Mediana, Grande, Extragrande");
        String tamaño = scanner.nextLine().trim();

        PizzaBase miPizzaBase = new PizzaBase(tamaño);
        miPizzaBase.registerObserver(new Observer() {
            @Override
            public void update(Pizza pizza) {
                System.out.println("----- NOTIFICACIÓN: Pizza actualizada: -----");
                System.out.println("Descripción: " + pizza.getDescription());
                System.out.println("Costo: $" + pizza.getCost());
            }
        });

        Pizza miPizza = miPizzaBase;
        System.out.println("Pizza base creada: " + miPizza.getDescription());

        while (true) {
            System.out.println("¿Qué ingrediente desea añadir? (Queso, Pepperoni, Aceitunas, Tocineta)");
            System.out.println("O escriba FIN para terminar y mostrar la pizza.");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("FIN")) {
                break;
            }

            switch (entrada.toLowerCase()) {
                case "queso": miPizza = new Queso(miPizza); break;
                case "pepperoni": miPizza = new Pepperoni(miPizza); break;
                case "aceitunas": miPizza = new Aceitunas(miPizza); break;
                case "tocineta": miPizza = new Tocineta(miPizza); break;
                default:
                    System.out.println("Ingrediente no válido. Intente de nuevo."); continue;
            }
        }

        System.out.println("Tu pizza: " + miPizza.getDescription());
        System.out.println("Costo total: $" + miPizza.getCost());
        scanner.close();
    }
}
