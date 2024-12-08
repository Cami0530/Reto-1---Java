import java.util.Random;
import java.util.Scanner;

public class App {
    // Variables globales
    static Scanner scanner = new Scanner(System.in);

    static String[] planetas = {"Mercurio", "Venus", "Marte", "Neptuno"};
    static double[] distancias = {0.39, 0.72, 1.52, 4.50}; // En millones de Km   

    static String[] naves = {"Atlantis", "Enterprise", "Serenity", "Halcón Milenario"};
    static double[] velocidades = {20000, 10000, 40000, 60000}; // En Km/h
    static int[] consumoCombustible = {200, 100, 400, 600}; // Litros por millón de km
    static int[] consumoOxigeno = {100, 50, 200, 300}; // Litros por millón de km

    static int naveSeleccionada = -1; // Inicializado en -1 para indicar que no se ha seleccionado ninguna nave
    static int planetaSeleccionado = -1; // Inicializado en -1 para indicar que no se ha seleccionado ningún planeta

    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    selecionarPlaneta();
                    break;
                case 2:
                    selecionarNave();
                    break;
                case 3:
                    calcularRecursos();
                    break;
                case 4:
                    iniciarSimulacion();
                    break;
                case 5:
                    System.out.println(" ");
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("¡Opción no válida! Por favor, selecciona una opción dentro del menú.");
            }
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println(" ");
        System.out.println("------------------------------");
        System.out.println("        Menu Principal");
        System.out.println("------------------------------");
        System.out.println("1. Selecciona un planeta de destino");
        System.out.println("2. Selecciona una nave espacial");
        System.out.println("3. Calcular recursos de viaje");
        System.out.println("4. Iniciar simulacion de viaje");
        System.out.println("5. Salir del programa");
        System.out.println(" ");
        System.out.println("Por favor elige una opcion: ");
    }

    public static void selecionarPlaneta() {
        System.out.println(" ");
        System.out.println("----Seleccion de un planeta----");
        for (int i = 0; i < planetas.length; i++) {
            System.out.println((i + 1) + ". " + planetas[i] + " - Distancia: " + distancias[i] + " millones de Km");
        }
        System.out.println(" ");
        System.out.println("Por favor elige un planeta: ");
        int seleccion = scanner.nextInt();
        if (seleccion > 0 && seleccion <= planetas.length) {
            System.out.println("Planeta seleccionado: " + planetas[seleccion - 1]);
            planetaSeleccionado = seleccion - 1;
        } else {
            System.out.println(" ");
            System.out.println("¡Opción no válida! Intenta de nuevo.");
        }
    }

    public static void selecionarNave() {
        System.out.println(" ");
        System.out.println("---Seleccion de una nave espacial---");
        for (int i = 0; i < naves.length; i++) {
            System.out.println("Nave: " + (i + 1) + ". " + naves[i] + " - Velocidad: " + velocidades[i] + " Km/h");
        }
        System.out.println(" ");
        System.out.println("Por favor elige una nave: ");
        int seleccion = scanner.nextInt();
        if (seleccion > 0 && seleccion <= naves.length) {
            System.out.println("Nave seleccionada: " + naves[seleccion - 1]);
            naveSeleccionada = seleccion - 1;
        } else {
            System.out.println(" ");
            System.out.println("¡Opción no válida! Intenta de nuevo.");
            System.out.println("");
        }
    }

    public static void calcularRecursos() {
        // Validar que se haya seleccionado un planeta y una nave
        if (planetaSeleccionado == -1 || naveSeleccionada == -1) {
            System.out.println(" ");
            System.out.println("Debes seleccionar un planeta y una nave antes de calcular los recursos.");
            System.out.println(" ");
            return; // Salir del método si no hay selección
        }
    
        // Calcular recursos
        double distancia = distancias[planetaSeleccionado];
        double combustible = distancia * consumoCombustible[naveSeleccionada];
        double oxigeno = distancia * consumoOxigeno[naveSeleccionada];

        // Calcular el tiempo de viaje
        double velocidad = velocidades[naveSeleccionada];
        double tiempoHoras = (distancia * 1000000) / velocidad;
        int dias = (int) (tiempoHoras / 24);
        int horas = (int) (tiempoHoras % 24);

        // Mostrar resultados
        System.out.println("Recursos necesarios para el viaje a " + planetas[planetaSeleccionado]);
        System.out.printf("- Combustible requerido: %.2f millones de litros%n", combustible);
        System.out.printf("- Oxígeno requerido: %.2f millones de litros%n", oxigeno);
        System.out.println("Tiempo estimado de viaje a " + planetas[planetaSeleccionado] + ": " + dias + " días y " + horas + " horas.");
    }

    public static void iniciarSimulacion() {
        // Validar que se haya seleccionado un planeta y una nave
        if (planetaSeleccionado == -1 || naveSeleccionada == -1) {
            System.out.println(" ");
            System.out.println("¡Debes seleccionar un planeta y una nave antes de iniciar la simulación!");
            System.out.println(" ");
            return; // Salir del método si no hay selección
        }

        Random random = new Random();
        double distancia = distancias[planetaSeleccionado];
        double combustible = distancia * consumoCombustible[naveSeleccionada];
        double oxigeno = distancia * consumoOxigeno[naveSeleccionada];

        double velocidad = velocidades[naveSeleccionada];
        double tiempoHoras = (distancia * 1000000) / velocidad;
        int tiempoRestanteDias = (int) (tiempoHoras / 24);
        int tiempoRestanteHoras = (int) (tiempoHoras % 24);

        System.out.println(" ");
        System.out.println("...Iniciando simulacion...");
        for (int progreso = 0; progreso <= 100; progreso += 10) {
            double porcentajeAvance = progreso / 100.0;
            double combustibleRestante = combustible * (1 - porcentajeAvance);
            double oxigenoRestante = oxigeno * (1 - porcentajeAvance);
            int tiempoRestanteDiasActualizado = (int) (tiempoRestanteDias * (1 - porcentajeAvance));
            int tiempoRestanteHorasActualizado = (int) (tiempoRestanteHoras * (1 - porcentajeAvance));

            // Mostrar progreso
            System.out.println(progreso + "% del viaje completado.");
            System.out.printf("Recursos restantes: %.2f millones de litros de combustible, %.2f millones de litros de oxígeno%n", combustibleRestante, oxigenoRestante);
            System.out.printf("Tiempo restante: %d días y %d horas%n", tiempoRestanteDiasActualizado, tiempoRestanteHorasActualizado);

            // Generar evento aleatorio con una probabilidad del 30%
            if (random.nextInt(100) < 30){
                generarEvento(random);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Error en la simulación");
            }
        }
        System.out.println(" ");
        System.out.println("¡Simulación completada! Has llegado a " + planetas[planetaSeleccionado] + ".");
    }

    public static void generarEvento(Random random) {
        int evento = random.nextInt(3);  // Generar un evento aleatorio (falla, asteroide, desvío)

        switch (evento) {
            case 0:
                System.out.println(" ");
                System.out.println("¡Falla en el sistema de propulsión! Se requiere reiniciar el sistema.");
                resolverFalla();
                break;
            case 1:
                System.out.println(" ");
                System.out.println("¡Asteroide dirigiendo hacia la nave! Necesitas cambiar la dirección.");
                evitarAsteroide();
                break;
            case 2:
                System.out.println(" ");
                System.out.println("¡Desvío inesperado! Debes corregir el curso!");
                corregirDesvio();
                break;
        }
    }

    public static void resolverFalla() {
        System.out.println(" ");
        System.out.println("El sistema de propulsión está fallando. ¿Quieres intentar reiniciarlo? (S/N)");
        char respuesta = scanner.next().charAt(0);
        if (respuesta == 'S' || respuesta == 's') {
            System.out.println(" ");
            System.out.println("Reiniciando el sistema... ¡Reinicio exitoso!");
            System.out.println(" ");
        } else {
            System.out.println(" ");
            System.out.println("No se realizó el reinicio. El sistema de propulsión podría averiarse.");
            System.out.println(" ");
        }
    }

    public static void evitarAsteroide() {
        System.out.println(" ");
        System.out.println("Un asteroide se esta dirigiendo hacia la nave. ¿Deseas maniobrar para esquivarlo? (S/N)");
        char respuesta = scanner.next().charAt(0);
        if (respuesta == 'S' || respuesta == 's') {
            System.out.println(" ");
            System.out.println("Evitando el asteroide... ¡Maniobra exitosa!");
            System.out.println(" ");
        } else {
            System.out.println(" ");
            System.out.println("Impacto con el asteroide.¡La nave ha sido destruida! La tripulación ha muerto.");
            System.out.println(" ");
            System.exit(0);
        }
    }

    public static void corregirDesvio() {
        System.out.println(" ");
        System.out.println("La nave ha sufrido un desvío. ¿Quieres corregir el curso? (S/N)");
        char respuesta = scanner.next().charAt(0);
        if (respuesta == 'S' || respuesta == 's') {
            System.out.println(" ");
            System.out.println("Corrigiendo el curso... ¡Curso restaurado!");
            System.out.println(" ");
        } else {
            System.out.println(" ");
            System.out.println("No se corrigió el curso. El viaje podría ser más largo.");
            System.out.println(" ");
        }
    }
}