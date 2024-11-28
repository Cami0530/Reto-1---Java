import java.util.Scanner;

public class App {
    // Variables globales
    static Scanner scanner = new Scanner(System.in);

    static String[] planetas = {"Mercurio", "Venus", "Marte", "Neptuno"};
    static double[] distancias = {0.39, 0.72, 1.52, 4.50}; // En millones de Km

    static String[] naves = {"Atlantis", "Enterprise", "Serenity", "Halcón Milenario"};
    static double[] velocidades = {20000, 10000, 40000, 60000};// En Km/h

    static String naveSeleccionada;
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
            naveSeleccionada = naves[seleccion - 1];
        }
        else{
            System.out.println("¡Opcion no valida! Intenta de nuevo.");
        }
    }

    public static void calcularRecursos(){
        double combustible = 0;
    }

    public static void iniciarSimulacion(){

    }
}
