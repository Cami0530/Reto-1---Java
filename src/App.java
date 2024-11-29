import java.util.Random;
import java.util.Scanner;

public class App {
    // Variables globales
    static Scanner scanner = new Scanner(System.in);

    static String[] planetas = {"Mercurio", "Venus", "Marte", "Neptuno"};
    static double[] distancias = {0.39, 0.72, 1.52, 4.50}; // En millones de Km

    static String[] naves = {"Atlantis", "Enterprise", "Serenity", "Halcón Milenario"};
    static double[] velocidades = {20000, 10000, 40000, 60000};// En Km/h
    static double[] consumoCombustible = {200, 100, 400, 600}; // Litros por millon de km
    static double[] consumoOxigeno = {100, 50, 200, 300}; // Litros por millon de km

    static int naveSeleccionada; // Apunta a la posicion de la nave seleccionada, mas no al nombre.
    static int planetaSeleccionado;// Indica la posicion del planeta seleccionado

    public static void main(String[] args) throws Exception {
        int opcion;
        do{
            mostrarMenu();
            opcion = scanner.nextInt();
            switch(opcion){
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
            }

        }while(opcion != 5);
    }

    public static void mostrarMenu(){

        System.out.println("------------------------------");
        System.out.println("        Menu Principal");
        System.out.println("------------------------------");
        System.out.println("1. Selecciona un planeta de destino");
        System.out.println("2. Selecciona una nave espacial");
        System.out.println("3. Calcular recursos de viaje");
        System.out.println("4. Iniciar simulacion de viaje");
        System.out.println("5. Salir del programa");
        System.out.println("Por favor elige una opcion: ");

        
    }

    public static void selecionarPlaneta(){

    }

    public static void selecionarNave(){
        System.out.println("---Seleccion de una nave espacial---");
        for(int i = 0; i < naves.length; i++){
            System.out.println("Nave: " + (i + 1) + ". " + naves[i] + " - Velocidad: " + velocidades[i] + " Km/h");
        }
        System.out.println("Por favor elige una nave: ");
        int seleccion = scanner.nextInt();
        if(seleccion >0 && seleccion <= naves.length){
            System.out.println("Nave seleccionada: " + naves[seleccion - 1]);
            naveSeleccionada = seleccion - 1;
        }
        else{
            System.out.println("¡Opcion no valida! Intenta de nuevo.");
        }
    }

    public static void calcularRecursos(){
        double combustible = consumoCombustible[naveSeleccionada];
        double oxigeno = distancias[planetaSeleccionado]*100; // Por cada millon de km, se necesitan 100 litros de oxigeno.
        System.out.println("El combustible requerido es de: " + combustible + " millones de litros");
        System.out.println("El oxigeno requerido es de: " + oxigeno + " millones de litros");
    }

    public static void iniciarSimulacion(){
        System.out.println("...Iniciando simulacion...");
        Random random = new Random();
        for (int progreso = 0; progreso <= 100; progreso+=10){
            System.out.println(progreso + "% del viaje completado");
            if (progreso == 50){
                System.out.println("50% del viaje completado");
            }
            if(random.nextInt(10) <3){
                System.out.println("¡Evento inesperado! Realizando ajustes...");
            }
            try {
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println("Error en la simulacion");
            }
        }
    }
}
