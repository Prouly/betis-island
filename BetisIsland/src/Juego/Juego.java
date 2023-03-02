package Juego;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import Herramientas.Espada;
import Herramientas.Pala;
import Personajes.Insultos;
import Personajes.Jugador;
import Personajes.NPC;

public class Juego {
public static Scanner teclado = new Scanner(System.in);
    
    public static void main(){
        //Crea lo necesario
        Jugador j1 = new Jugador(pedirNombre());
        Tesoro t = new Tesoro();
        Pala pala = new Pala();
        Espada espada = new Espada();
        String[][] mapa = crearMapa();
        mostrarIntro(j1);
        miniMapa(mapa, j1, t, pala, espada);
        //mostrarMapa(mapa, j1, t, pala, espada);
        int opc = Integer.MAX_VALUE;
  
        //Bucle principal del juego
        while(opc != 0 && j1.getVida() > 0) {
            try {
                opc = mostrarMenu();
                tratarMenu(j1, opc, t, pala, espada, mapa);
                //mostrarMapa(mapa, j1, t, pala, espada);
                miniMapa(mapa, j1, t, pala, espada);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (JuegoException e) {
                System.out.println(e.getMessage());
            } catch (GanarException e) {
                System.out.println(e.getMessage());
//                System.out.println(t.verTesoro());
                opc = 0;
            }
        }//while
    }
    
    
    
    /**
     * Pide el nombre para el jugador
     * @return String nombre
     */
    public static String pedirNombre() {
        String nombre;
        
        do {
            System.out.println();
            System.out.print("Introduce nombre para tu jugador: ");
            nombre = teclado.nextLine();
        } while (nombre.isEmpty()  || nombre.isBlank());
        
        return nombre;
    }//pedirNombre()

    
    
    /**
     * Crea un array de TAMAÑO X TAMAÑO vacío (Con formato)
     * @return String con dibujo del mapa
     */
    public static String[][] crearMapa() {
        String[][] mapa = new String[APrincipal.TAMANHO_MAPA][APrincipal.TAMANHO_MAPA];
        
        for (int i = 0; i < APrincipal.TAMANHO_MAPA; i++) {
            for (int j = 0; j < APrincipal.TAMANHO_MAPA; j++) {
                mapa[i][j] = "     ";
            }
        }
        return mapa;
    }//crearMapa()
    
    /**
     * Introduccion del juego donde se muestra el nombre del jugador y la mision a cumplir
     * @param j
     */
    public static void mostrarIntro(Jugador j) {
        System.out.println();
        System.out.println(
                  "            .....                                                                                                                                                    \r\n"
                  + "  ^!J5G#&@@@@@@@&BY~.                                            YB#@J                                                                                             \r\n"
                  + ".@@@@@@@@@@@@@@@@@@@&5^                           .&&@B         7@@@@#                                                                                             \r\n"
                  + ".@@@@@@@@@@@@@@@@@@@@@@&7                         7@@@@. ..     .::::          ...                                                                                 \r\n"
                  + ".@@@@@@@@@@@@@@@@@@@@@@@@&:       .^!?JYYJ7:   :&#&@@@@&@@@PB&&&&&@@@:   .~5#&@@@@@P.                                                                              \r\n"
                  + ".@@@@@@@5:^:::^~?G@@@@@@@@@:   :G&@@@@@@@@@@&: ?@@@@@@@@@@@7@@@@@@@@@: :B@@@@@@@&@@@&                                                                              \r\n"
                  + ".@@@@@@@7         .&@@@@@@@&  ?@@@@&?:..^#@@@& ^GG@@@@@5J?! 7Y?!B@@@@.^@@@@@@P.   :?G                                                                              \r\n"
                  + ":@@@@@@@?          #@@@@@@@@. @@@@&^.:^^^!&@@@:   @@@@&         J@@@@.:@@@@@@BY!:.                                                                                 \r\n"
                  + ":@@@@@@@?         Y@@@@@@@@@..@@@@@@@@@@@@@@@@.  .@@@@&         J@@@@.  ~5#&@@@@@@&GJ^                                                                             \r\n"
                  + ":@@@@@@@#Y5PPPPPG&@@@@@@@@@J  @@@@&PPPP5YYJ??!   :@@@@&         ?@@@@.      .^7YG&@@@@@Y                                                                           \r\n"
                  + ":@@@@@@@@@@@@@@@@@@@@@@@@@!   B@@@@:      :!~    :@@@@&         ?@@@@.~&&5.       ^&@@@@:                                                                          \r\n"
                  + ":@@@@@@@@@@@@@@@@@@@@@@@@@#~  ^@@@@@#B#&&@@@@&   .@@@@#         7@@@@ Y@@@@GYJJYG&@@@@@P                                                                           \r\n"
                  + ":@@@@@@@@@@@@@&&&@@@@@@@@@@@B. ~&@@@@@@@@@@@@5    &@@@&         7@@@&  P@@@@@@@@@@@@@&7                                                                            \r\n"
                  + ":@@@@@@@J         .7#@@@@@@@@&.  :7JJJJ??!~:      :GGG?         .Y!:    .^~7YPG####G!                                                                              \r\n"
                  + "^@@@@@@@7            5@@@@@@@@P                                                                                                                                    \r\n"
                  + "^@@@@@@@?            .@@@@@@@@# ?JJY5P7                    !77:                                                      ...                                           \r\n"
                  + "^@@@@@@@?            .@@@@@@@@P.@@@@@@@.                  .@@@#                                                     J@@@@@~                                        \r\n"
                  + "^@@@@@@@?            G@@@@@@@@..@@@@@@@.                  .@@@#                                                     :@@@@@~                                        \r\n"
                  + "^@@@@@@@5..........^B@@@@@@@@! .@@@@@@@.      .:~7?7~.    .@@@&           ......       .~?  .:~^:             .:::.  &@@@@^                                        \r\n"
                  + "^@@@@@@@@@@@@@@@@@@@@@@@@@@&^  .@@@@@@@.   ~P&@@@@@@@@J   .@@@&    5&@@@@@@@@@@@&J    ?@@@PG@@@@@@B7       !#@@@@@@&G&@@@@:                                        \r\n"
                  + "^@@@@@@@@@@@@@@@@@@@@@@@@#7    .@@@@@@@. 7@@@@@@&G5P#@@:  .@@@@   ?@@@@55PG#&@@@@@Y   P@@@@@@@@@@@@@#     B@@@&&@@@@@@@@@@:                                        \r\n"
                  + "~@@@@@@@@@@@@@@@@@@@@&G?.      .@@@@@@@ .@@@@@@5      ~   .@@@@.  ?@&&B      .P@@@&   B@@@@@@@@@@@@@@    5@@@B   ..^!@@@@@.                                        \r\n"
                  + " ^^^^~~~~!!!!7777!^:.          .@@@@@@@  J&@@@@@&#P7^.    .@@@@.    .~?Y5PPGBB&@@@@   &@@@?      ?@@@:   @@@@Y       &@@@@.                                        \r\n"
                  + "                               .@@@@@@@.   .75B&@@@@@@&G! .@@@@:  .G@@@@@@@@@@@@@@@   @@@@^      ^@@@~  .@@@@P      .@@@@@                                         \r\n"
                  + "                               .@@@@@@@. .:      .~?G@@@@@!@@@@^  &@@@@&7^::: ?@@@@  .@@@@.      :@@@?   @@@@G      .@@@@@                                         \r\n"
                  + "                               .@@@@@@@ !@@@J.     .~&@@@@?@@@@~  @@@@@B     :B@@@@  :@@@@       .@@@P   P@@@&     .J@@@@&                                         \r\n"
                  + "                               .@@@@@@@ :@@@@@&&#&@@@@@@@?.@@@@7  G@@@@@@&&@@@@@@@@  !@@@&        @@@#    #@@@@&&&@@@@@@@&                                         \r\n"
                  + "                               .@@@@@@@. :B&@@@@@@@@@@@B:  5&@@?   P@@@@@@@@@&B@@@@  ?@@@G        B@&B     ?&@@@@@@@#&@@@&                                         \r\n"
                  + "                               .@@@@@@@.     ..^~7???~.      .^.     :^!77!^.  ^^^:   ...                    .:^^^..  :~~:                                         \r\n"
                  + "                               .@@@@@@@.                                                                                                                           \r\n"
                  + "                               .@@@@@@@.                                                                                                                           \r\n"
                  + "                               .@@@@@@@.                                                                                                                           \r\n"
                  + "                               .@@@@@@@.                                                                                                                           \r\n"
                  + "                               .@@@@@@@.                                                                                                                           \r\n"
                  + "                               .@@@@@@@.                                                                                                                           \r\n"
                  + "                               .@@@@@@@.                                                                                                                           \r\n"
                  + "                                ~!7?JJ~                                                                                                                            \r\n"
                  + " - UN JUEGO DE: Álvaro Muñoz, Fran Villa, Antonio Hermosín                                                                                                         \r\n");
        System.out.println(" --- Deep in Alcala de Guadaira... ---");
        System.out.println("Eres "+j.getNombre()+ " y quieres ser un pirata informatico. \nTras salir del Scummvm Bar, los jefes piratas te han encomendado la misión de desenterrar un tesoro.\nTras comprar un mapa a un vendedor local te dispones a buscar el tesoro, pero...Cuidado con los piratas informaticos, no te lo pondran facil para conseguirlo.\nRecuerda, la X marca el lugar del tesoro.");
    }
    
    /**
     * Muestra el menu del juego
     * @return int con la opcion elegida
     */
    public static int mostrarMenu() throws JuegoException{
        int opc = 0;
        System.out.println();
        System.out.println("==== MENU ====");
        System.out.println("1. Mover");
        System.out.println("2. Estado");
        System.out.println("0. Salir");
        
        System.out.println();
        System.out.print("Elige una opcion: ");
        
        try {
            opc = Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            throw new JuegoException("Entrada invalida");
        }
        System.out.println();
        
        return opc;
    }//mostrarMenu()
    
    
    
    /**
     * Trata el menu del juego
     * @param j1
     * @param opc
     * @throws JuegoException
     */
    public static void tratarMenu(Jugador j1, int opc, Tesoro t, Pala pala, Espada espada, String[][] mapa) throws JuegoException,IOException, GanarException{
        switch (opc) {
            case 1 : {
                System.out.println();
                System.out.println("--- MOVER ---");
                System.out.println("W. Arriba");
                System.out.println("A. Izquierda");
                System.out.println("S. Abajo");
                System.out.println("D. Derecha");
                System.out.print("Eleccion: ");
                moverJugador(j1, teclado.nextLine().toUpperCase().charAt(0), t, pala, espada);
                break;
            }
            case 2 : {
                System.out.println();
                System.out.println("--- ESTADO ---");
                System.out.println(j1.toString());
                break;
            }
            
            case 3 : { //Opcion secreta que muestra mapa completo, puede descomentarse syso que muestra las posiciones de espada, pala y tesoro
                mostrarMapa(mapa, j1, t, pala, espada);
//                System.out.println(espada);
//                System.out.println(pala);
//                System.out.println(t);
            }
            
            case 0 :{
                break;
            }
            default:{
                throw new JuegoException("Opcion invalida");
            }
                
        }
        
    }//tratarMenu()
    
    
    
    /**
     * Controla el movimiento de jugador
     * @param Jugador j1
     * @param direccion
     * @throws JuegoException
     */
    public static void moverJugador(Jugador j1, char direccion,Tesoro t, Pala pala, Espada espada) throws JuegoException, IOException, GanarException{
 
       switch (direccion) {
           case 'D': { //Derecha
               j1.setPosicionY((j1.getPosicionY() + 1)); //Derecha
               break;
           }
           case 'A': { //Izquierda
               j1.setPosicionY((j1.getPosicionY() - 1)); //Izquierda
               break;
           }
           case 'W': { //Arriba
               j1.setPosicionX((j1.getPosicionX() + 1)); //Arriba
               break;
           }
           case 'S': { //Abajo
               j1.setPosicionX((j1.getPosicionX() - 1)); //Abajo
               break;
           }
           default:
               throw new JuegoException("Movimiento inválido");
       }
         
       
        if(!j1.isTienePala()) {
            cogerPala(j1, pala); //Coger Pala si esta cerca
        }

        if(!j1.isTieneEspada()) {
            cogerEspada(j1, espada); //Coger Espada si esta cerca
        }
        
        if (j1.getPosicionX() == t.getPosicionY() && j1.getPosicionY() == t.getPosicionX()) {
            if (j1.isTienePala()) {
                System.out.println(t.verTesoro());
                throw new GanarException("Has Ganado");
            }else {
                
                System.out.println("Has encontrado el tesoro, pero no tienes pala");
            }
            
        }
        
        //Comprueba si hay combate aleatorio
        hayCombate(j1);
        
    }//moverJugador()


    /**
     * Metodo con el que recoger la pala si esta se encuentra en la misma posicion que el jugador
     * @param j1
     * @param pala
     */
    public static void cogerPala(Jugador j1, Pala pala) {
        if (pala.getPosicionX() == j1.getPosicionY() && pala.getPosicionY() == j1.getPosicionX()) {
            j1.conseguirPala();
            System.out.println("¡Has encontrado una pala!");
            System.out.println(pala.verPala());
        }
    }//cogerPala()
    
    /**
     * Metodo con el que recoger la pala si esta se encuentra en la misma posicion que el jugador
     * @param j1
     * @param pala
     */
    public static void cogerEspada(Jugador j1, Espada espada) {
        if (espada.getPosicionX() == j1.getPosicionY() &&espada.getPosicionY() == j1.getPosicionX()) {
            j1.conseguirEspada();
            System.out.println("¡Has encontrado una espada!");
            System.out.println(espada.verEspada());
        }
    }//cogerEspada()
    

    
    /**
     * Muestra el mapa completo. Opción secreta
     * @param mapa
     * @param j1
     */
    public static void mostrarMapa(String [][] mapa, Jugador j1, Tesoro t, Pala pala, Espada espada) {
        //Formato
        System.out.println();
        System.out.println("--- MAPA ---");
        System.out.println("-------------------------------------");
        //Representar el mapa
        for (int y = APrincipal.TAMANHO_MAPA -1; y >= 0; y--) {
            System.out.print("|");
            for (int x = 0; x < APrincipal.TAMANHO_MAPA; x++) {
                
                mapa[x][y] = "     ";
                //mapa[x][y] = x + " " + y;
                
                //Pinta el tesoro
                if (x == t.getPosicionX() && y == t.getPosicionY()) {
                    mapa[x][y] = "  X  ";
                }
                
                //Pinta las herramientas
                if(x == pala.getPosicionX() && y == pala.getPosicionY() || x == espada.getPosicionX() && y == espada.getPosicionY()) {
                    mapa[x][y] = "  ?  ";
                }

                //Pintar posicion del jugador
                if (x == j1.getPosicionY() && y == j1.getPosicionX()) {
                    mapa[x][y] = "  J  ";
                }
                
                System.out.print(mapa[x][y]);
                System.out.print("|");
            }
            System.out.println("\n-------------------------------------");
        }
    }//mapaJugador()
    
    
    
    /**
     * Mapa que ve el jugador, aparecen el y su alrededor
     * @param mapa
     * @param j1
     * @param t
     */
    public static void miniMapa(String[][] mapa, Jugador j1, Tesoro t, Pala pala, Espada espada) {
        //Formato
        System.out.println();
        System.out.println("--- MAPA ---");
        System.out.println("-------------------");
        //Representar el mapa
        for (int y = j1.getPosicionX() + APrincipal.CAMPO_DE_VISION; y >= j1.getPosicionX() - APrincipal.CAMPO_DE_VISION; y--) {
            System.out.print("|");
            for (int x = j1.getPosicionY() - APrincipal.CAMPO_DE_VISION; x <= j1.getPosicionY() + APrincipal.CAMPO_DE_VISION; x++) {
                
                //Control de limites
                if ((x >= 0 && y >= 0) && (x < APrincipal.TAMANHO_MAPA && y < APrincipal.TAMANHO_MAPA)) {
                    
                    mapa[x][y] = "     ";
                    
                    
                    //Pinta el tesoro
                    if (x == t.getPosicionX() && y == t.getPosicionY()) {
                        mapa[x][y] = "  X  ";
                    }
                    
                    if (!j1.isTienePala()) {
                        if(x == pala.getPosicionX() && y == pala.getPosicionY()) {
                            mapa[x][y] = "  ?  ";
                        }
                    }
                    //Pinta las herramientas
                    if (!j1.isTieneEspada()) {
                        if(x == espada.getPosicionX() && y == espada.getPosicionY()) {
                            mapa[x][y] = "  ?  ";
                        }
                    }
                    
                    //Pintar posicion del jugador. Al fondo para que se muestre por encima de todo
                    if (x == j1.getPosicionY() && y == j1.getPosicionX()) {
                        mapa[x][y] = "  J  ";
                    }
                    
                    System.out.print(mapa[x][y]);
                    System.out.print("|");
                }else {
                    System.out.print(":::::|");
                }
            }
            System.out.println("\n-------------------");
        }
    }//mostrarMapa()

    
    
    /**
     * Comprueba si hay un combate aleatorio
     */
    public static void hayCombate(Jugador j1) throws FileNotFoundException, IOException, JuegoException, GanarException{
        if(new Random().nextBoolean()){
            combatir(j1);
        }
    }//haycombate()

    
    
    /**
     * Método que controla el combate
     * @param j1
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void combatir(Jugador j1) throws FileNotFoundException, IOException, JuegoException, GanarException{
        NPC enemigo = new NPC();
        Random rnd = new Random();
        int numeroInsulto = 0;
        
        //Los puntos sirven para calcular quien hace daño, en cada ronda se hacen 5 de daño, si hay empate no hay daño
        int puntosJugador = 0;
        int puntosEnemigo = 0;
        boolean pirataPresentado = false;
        
        //Bucle principal
        while(j1.getVida() > 0 && enemigo.getVida() > 0){
            
            //Formato
            System.out.println();
            System.out.println("------------- COMBATE -------------");
            
            if (pirataPresentado == false) {
                // Con quien tienes el combate y su vida
                System.out.println("Te enfrentas a: " + enemigo.getNombre());
                pirataPresentado = true;
            }
            
            //Mostrar vidas
            System.out.println("Tu vida: " + j1.getVida() + "       Vida del enemigo: " + enemigo.getVida()+"\n");
            
            //Cargar insultos aleatorios para esta ronda
            String[] insultos = Insultos.elegirAleatorios();
            
            //Mostrar y elegir insultos
            for(int i = 0; i < insultos.length; i++){
                System.out.println((i+1) + ". " + insultos[i]);
            }
            
            //Si el input no es un numero, tira una excepcion y huye del combate
            
            //Procesar eleccion del jugador
                //Bucle que controla que el input sea valido
            do {
                try { // Este try va dentro del bucle porque si no, no se actualiza numeroInsulto, bucle infinito
                    System.out.print("Elige tu insulto: ");
                    System.out.println();
                    numeroInsulto = Integer.parseInt(teclado.nextLine());
                } catch (NumberFormatException e) {
                    throw new JuegoException("Has huido");
                }
                System.out.println();
                
                switch (numeroInsulto) {
                    case 1: {
                        System.out.println(j1.getNombre() + ": ¡" + insultos[0] + "!");
                        puntosJugador = rnd.nextInt(6);
                        break;
                    }
                    case 2: {
                        System.out.println(j1.getNombre() + ": ¡" + insultos[1] + "!");
                        puntosJugador = rnd.nextInt(6);
                        break;
                    }
                    case 3: {
                        System.out.println(j1.getNombre() + ": ¡" + insultos[2] + "!");
                        puntosJugador = rnd.nextInt(6);
                        break;
                    }
                    default:
                        System.out.println("Insulto inválido");
                }//switch
            } while (numeroInsulto < 1 || numeroInsulto > 3);
            
            System.out.print(enemigo.getNombre() + ": ");
            
            //Procesar eleccion del enemigo
            System.out.println(insultos[rnd.nextInt(insultos.length)]);
            puntosEnemigo = rnd.nextInt(6); //El minimo de puntos es 0, el máximo es 5
            
            System.out.println();
            
            //Procesar ganador y daño
            if (puntosJugador > puntosEnemigo) {
                
                //Si tiene la espada, hace el doble de daño
                if (j1.isTieneEspada()) {
                    enemigo.setVida(enemigo.getVida() - 10);
                    System.out.println(j1.getNombre() + " ¡Usas la espada en el ataque! Inflinges 10 de daño");
                }else {
                    enemigo.setVida(enemigo.getVida() - 5);
                    System.out.println(j1.getNombre() + " ataca, inflinge 5 de daño");
                }
            }else if(puntosEnemigo > puntosJugador) {
                System.out.println(enemigo.getNombre() + " ataca, inflinge 5 de daño");
                j1.setVida(j1.getVida() - 5);
            }else {
                System.out.println("Hay empate, nadie ataca.");
            }
            
            //Mensajes de victoria o derrota
            if (j1.getVida() == 0) {
                throw new GanarException(
                          " _     _ _______ _______       _____  _______  ______ ______  _____ ______   _____    \r\n"
                        + " |_____| |_____| |______      |_____] |______ |_____/ |     \\   |   |     \\ |     | \r\n"
                        + " |     | |     | ______|      |       |______ |    \\_ |_____/ __|__ |_____/ |_____|      ");
            }else if(enemigo.getVida() == 0) {
                System.out.println("Has ganado");
            }
        }//while
    }//combatir()

}
