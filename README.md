# Betis Island
![PortadaBetisIsland 1](https://github.com/Prouly/betis-island/assets/80397239/8f5e9036-95c4-471b-bd9c-5cd3280961cb)
<h2>Prólogo</h2>
Hay una leyenda que recorre el mundo entero de los piratas, esta cuenta que un fantástico tesoro se esconde en la lejana isla de Betis.</br>
En este juego de plataformas deberás luchar con tu espada y tu ingenio contra todo tipo de piratas informáticos, que intentarán quitarte las ganas de seguir en tu
búsqueda del tesoro.</br>
Este manual te guiará a través del juego, explicando las diferentes opciones disponibles, cómo moverse en el mapa, cómo defenderte de los piratas, algún secreto que esconde nuestro juego y mucho más. Así que, ¡prepárate para una aventura emocionante y empieza a leer!</br>
Betis Island es un juego donde podrás experimentar la emoción de moverte por un mapa en busca de un tesoro escondido, mientras te defiendes de los ataques de los
piratas informáticos con batallas memorables.</br>
Agradecimientos a Ron Gilbert por servir de inspiración para la creación de esta adaptación del mítico Monkey Island.

<h2>Tecnologías y propósito</h2>
Este juego ha sido desarrollado con caracter formativo utilizando Java como lenguaje de programación en toda su lógica.
Como interfaz de usuario se utiliza la terminal del propio IDE.

<h2>1. Guía Básica.</h2>
<h3>1.1. Instalación.</h3>
Descargar el proyecto e importarlo en IDE con Java (Eclipse, Netbeans, Visual Studio Code…). Una vez importado el proyecto, ejecutar aplicación desde la Clase APrincipal.

<h3>1.2. Primeros pasos.</h3>
Una vez ejecutado el juego, comenzará a sonar la música que te acompañará en la aventura y se mostrará en pantalla la información del juego a través de la interfaz de
consola Java el título de la aventura y el equipo de desarrolladores.
A continuación se mostrará en pantalla el texto que nos introduce a la aventura para encontrar el legendario tesoro escondido. Para empezar, pedirá introducir su nombre.

<h3>1.3. Mapa.</h3>

Una vez introducido su nombre, se generará un mapa de 6x6.
En pantalla se mostrará un mapa de 3x3 que representa el rango de visión del jugador y que será actualizado con cada movimiento realizado por el jugador. En el mapa se posicionarán de manera aleatoria varios elementos que serán representados por diferentes caracteres:
<b>1. Jugador -> </b>Será representado en el mapa por el carácter “ J ”.
<b>2. Tesoro -> </b>Será representado en el mapa por el carácter “ X ”.
<b>3. Pala -> </b>Será representado en el mapa por el carácter “ ? ”.
<b>4. Espada -> </b>Será representado en el mapa por el carácter “ ? ”.

![MapaPeq](https://github.com/Prouly/betis-island/assets/80397239/05f24cdd-8a6f-4ea5-8791-80380d513c5e)

<h3>1.4. Interfaz.</h3>
<h4>1.4.1. Opciones disponibles.</h4>

Hay cuatro opciones en el menú que se muestra al iniciar el juego, estas opciones serán introducidas mediante teclado utilizando los carácteres numéricos 0-3. Las
disponibles en el juego son las siguientes:

![MenuSeleccion](https://github.com/Prouly/betis-island/assets/80397239/e755946f-b075-4f9e-be21-caa9dd405b02)

<ol>
<b>1. Mover -> </b>Permite moverse a través del mapa desde la casilla en la que se encuentra el jugador a otra de las contiguas que se encuentren en las siguientes direcciones pulsando uno de los siguientes carácteres desde el teclado:</br>

<ol>
  a. Arriba (“W”).</br>
  b. Abajo (“S”).</br>
  c. Derecha (“D”).</br>
  d. Izquierda (“A”).</br>
</ol>

Si el jugador trata de moverse a una posición que salga del borde del mapa (representado en el mapa con caracteres ::::::), se mostrará un mensaje en pantalla indicando que no puede pasar por allí.

Después de cada movimiento se mostrará la nueva posición en el mapa y volverá a mostrar al jugador el menú de opciones.

<b>2. Estado -></b> Muestra la cantidad de vida restante del jugador, las coordenadas de la posición en la que se encuentra el jugador y si tiene la espada y/o la pala.

![EstadoJug](https://github.com/Prouly/betis-island/assets/80397239/44fd5277-b493-4f76-b373-34d1818a5b02)

<b>0. Salir -></b> Permite salir del juego.</br>

<b>3. Mostrar mapa completo (oculta) -></b> Muestra el mapa completo de 6x6. La interfaz no nos informará de dicha opción, ya que es una opción secreta, solo el equipo de desarrollo o quien haya leído el manual lo conocerá.

![MapaCompleto](https://github.com/Prouly/betis-island/assets/80397239/ed287e78-ad31-4f53-b7ff-eef594e73739)
</ol>
<h3>1.5. Objetos y cómo ganar la partida.</h3>
En el mapa se encuentran tres objetos: una pala, un tesoro y un jugador. El objetivo para ganar la partida es desenterrar el tesoro, para ello deberá encontrar la pala, ya que si intenta desenterrar el tesoro sin ella, saldrá un mensaje que informará al jugador de que es necesario una pala para poder desenterrar el tesoro.
Utilidad de la espada: Si el jugador tiene la espada, puede vencer a los piratas de un solo ataque. De lo contrario, se requieren dos ataques certeros para poder ganar la batalla.

<h3>1.6. Ataques de piratas.</h3>
Cada vez que se mueve el jugador, hay una posibilidad aleatoria de ser atacado por distintos piratas informáticos que iniciarán una guerra de insultos. Se mostrará los
puntos de salud del jugador, los del pirata y una lista de insultos en la consola, el jugador debe elegir una respuesta entre las tres que se muestran para vencer al
pirata. Una vez seleccionada, el pirata dará una respuesta al insulto del jugador, se mostrará el resultado del ataque indicando quien lo ha ganado, los puntos de vida
restantes y si ninguno llega a 0 puntos de vida, el combate continuará de la misma manera hasta que uno de los dos personajes no tenga vida.

<h3>1.7. Vida.</h3>
El jugador comienza con 100 puntos de vida y pierde 5 puntos cada vez que es atacado por los piratas.
Los piratas tienen 10 puntos de vida, este pierde 5 puntos cada vez que es atacado por el jugador si este no tiene la espada, si el jugador está en posesión de la espada, el daño infligido en cada ataque es de 10 puntos.

<h3>1.8. Consejos.</h3>
Mantente alerta de los ataques de los piratas y trata de mantener tu vida lo más alta posible. No te olvides de usar la opción 2 (Estado) para revisar tu vida y si tienes la espada o no. Y recuerda, encontrar la pala es la clave para desenterrar el tesoro. Cuando localices en el mapa un carácter “ ? ” en el mapa ve a por ello.
Si no encuentras el camino, recuerda que dispones de la opción secreta del menú para desvelar el mapa completo.

<h3>1.9. Conclusión.</h3>
¡Diviértete explorando el mapa y encontrando el tesoro! ¡Buena suerte en tu aventura y cuidado con los piratas informáticos!

<h2>2. FAQS.</h2>

<b>¿Cómo descargo e instalo el juego?</b>

Descárgalo desde nuestra desde https://github.com/Prouly/betis-island/, clona el repositorio con git, desde tu IDE Java favorito carga el proyecto y dale al play para disfrutar de la aventura desde la clase APrincipal.

<b>¿Qué son los elementos en el mapa (Jugador, Tesoro, Pala, Espada)?</b>

El <b>jugador</b> (“ J ”) te representa a ti y tu posición en el mapa.
El <b>tesoro</b> es representado por el carácter “ X ”, recuerda que la X siempre marca el
tesoro en un mapa pirata.
La <b>Pala</b> y la <b>Espada</b> están representados por el carácter <i>(“ ? ”)</i>, corre de tu cuenta
averiguar cual es cada uno, así que, ve a por ellos.

<b>¿Cómo me muevo en el mapa?</b>

Podrás moverte por el mapa con las teclas W, A, S y D, de una casilla en una y siempre teniendo en cuenta los bordes del mapa que te impedirán seguir avanzando.

<b>¿Cómo defiendo a mi personaje de los piratas informáticos?</b>

Elige el insulto que creas correcto o más te guste de la lista, el correcto es aleatorio.

<b>¿Puedo omitir los combates con los piratas informáticos?</b>

Sí, para huir de la batalla (cual cobarde), puedes pulsar cualquier caracter del teclado que no sea un número y tu personaje escapará del combate.

<b>¿Puedo ganar puntos de vida?</b>

No, los puntos de vida no pueden restaurarse. Deberás afrontar la aventura con 100 puntos de vida iniciales y perderás 5 puntos si un pirata te ataca.

<b>¿Cómo gano el juego?</b>

Tendrás que desenterrar el tesoro que se muestra en el mapa con el carácter “ X ”.

<b>¿Hay algún consejo para jugar?</b>

Nuestro mejor consejo es que subas el volumen, explora la isla para encontrar la pala para desenterrar el tesoro, localiza la espada para derrotar a los piratas de un ataque, ríe con los insultos de los piratas y desentierra el tesoro para obtener tu recompensa y ver los magníficos ASCII que mostrarán cada uno de los objetos una vez los localices.

<b>¿Hay tiempo límite para acabar la aventura?</b>

No, toma el tiempo que necesites para completar la aventura.

<b>¿Qué ocurre si la vida del personaje llega a 0?</b>

Si la vida del personaje llega a 0, tendrás que volver a comenzar la aventura desde el principio.

<h2>3. Glosario</h2>
<b>Betis Island:</b> Juego de plataformas en el que el jugador debe encontrar un tesoro escondido mientras se defiende de los ataques de piratas informáticos.

<b>Tesoro:</b> Objeto que el jugador debe encontrar en el juego. Representado en el mapa por el carácter "X".

<b>Piratas informáticos:</b> Enemigos que intentarán detener al jugador en su búsqueda del tesoro.

<b>Espada:</b> Objeto utilizado para defenderse de los ataques de los piratas informáticos. Representado en el mapa por el carácter "?".

<b>Pala:</b> Objeto utilizado para cavar en la búsqueda del tesoro. Representado en el mapa por el carácter "?".

<b>Jugador:</b> Personaje controlado por el usuario en el juego. Representado en el mapa por el carácter "J".

<b>Mapa:</b> Representación gráfica de las casillas y elementos del juego. Se muestra en pantalla en forma de una matriz de 3x3 que se actualiza con cada movimiento del jugador. Si se accede a la opción secreta este es mostrado en su formato completo 6x6.

<b>Interfaz:</b> Área en la que se muestra la información del juego y las opciones disponibles para el usuario.

<b>Mover:</b> Opción en el menú que permite al jugador moverse a través del mapa.

![LogoBetisIsland](https://github.com/Prouly/betis-island/assets/80397239/59bcd412-3e26-478c-aede-930182e26b0c)
