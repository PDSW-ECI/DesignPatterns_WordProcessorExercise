###Escuela Colombiana de Ingeniería###Arquitecturas de Software – ARSW###Laboratorio – Patrones GoF – Fábrica abstractaSoftware de microcontrolador para la fabricación automática de pizza.Entregables:
* Parte I, antes de finalizar la clase, en moodle.* Parte II-1 y II-2, impreso en la próxima clase.* Parte II-3,4 y 5, antes del próximo laboratorio, vía moodle.####Parte I. 
El siguiente, es un modelo de clases de una aplicación que se comunica con un microcontrolador encargado de la fabricación automática de pizzas. Dichas clases encapsulan la lógica para amasar, hornear y moldear pizzas de las pizzas delgadas.![alt text](img/Model.png "Logo Title Text 1")

El programa principal del micro-controlador utiliza la siguiente función, la cual depende de las clases antes mostradas:
```Javapublic void prepararPizza(Ingredientes[] ingredientes, Tamano tam) throws ExcepcionParametrosInvalidos{	AmasadorPizzaDelgada am=new AmasadorPizzaDelgada();	HorneadorPizzaDelgada hpd=new HorneadorPizzaDelgada();	MoldeadorPizzaDelgada mp=new MoldeadorPizzaDelgada();	am.amasar();	if (tam == Tamano.PEQUENA){		mp.moldearPizzaPequena();}else if(tam==Tamano.MEDIANA){	mp.molderarPizzaMediana();}else{	throw new ExcepcionParametrosInvalidos (“Tamano de piza invalido:”+tam);}	aplicarIngredientes(ingredientes);	hpd.hornear();}```Se quiere actualizar el software, ya que el fabricante de las máquina va a sacar al mercado unas variantes de la máquina original, y quiere simplificar el proceso de adaptación del código de los microcontroladores. Por ahora se espera sacar dos variantes:
*	Máquina para preparar pizzas de masa gruesa (masa de pan).*	Máquina para preparar pizzas de masa integral.Es importante tener en cuenta que para dichas variantes, aunque la secuencia de pasos del proceso principal es el mismo, los procesos de amasado, moldeado y horneado son diferentes para cada variante.Dado que es posible que en el futuro salgan variantes adicionales de esta máquina, y que se sabe que la secuencia de pasos en general NO cambiará, se le ha pedido que el software quede escrito de manera que la lógica básica no requiera cambios, independientemente de cómo se amase, como se hornee y cómo se moldee en dichas variantes.1.	Teniendo esto en cuenta, y considerando el patrón de fábrica abstracta, plantee el modelo de clases que permitiría desacoplar la lógica de la fabricación de pizzas, de las diferentes manera como se pueden realizar las actividades de bajo nivel relacionadas (cocción, corte, etc.).2.	Descargue el proyecto mediante el comando git (git clone) :```git clone https://github.com/PDSW-2015-2/GoF-Patterns-Creational-PizzaFactory.git
```	e impórtelo en el IDE NetBeans.3.	Revise el funcionamiento actual de la aplicación. Como este es un proyecto Maven, ejecútelo a través de la línea de comando (desde el directorio del proyecto):```mvn exec:java -Dexec.mainClass="edu.eci.pdsw.pizzafactory.consoleview.PreparadorPizza"```
4.	Implemente el modelo propuesto. Para compilar después de haber hecho cambios, hágalo a través de Maven con: ```mvn compile```


####Parte II. 

En el presente [repositorio](https://github.com/PDSW-ECI/DesignPatterns_WordProcessorExercise.git) se tiene una versión muy básica de un procesador de texto orientado principalmente a la calidad del texto escrito. 

Para revisar su funcionamiemto, clone el proyecto y desde la consola ejecute con maven:

```
mvn exec:java -Dexec.mainClass="edu.eci.pdsw.wordprocessor.view.GuordMainFrame"
```
Verifique qué pasa al escribir en alguna parte el texto un error tipográfico/ortográfico como 'hoal' o 'vuenas'. Como se observa, el procesador de texto realiza automáticamente correcciones sobre este tipo de errores. 

Ahora, ensaye escribir en el texto palabras como 'parcero' o 'supersona', y escoja la opción 'Style/Autocorrect'. Como puede observar, esta opción hace correcciones de 'estilo', sustituyendo modernismos o costumbrismos por sus equivalentes más formales.

Realice lo siguiente:

1. Clone el repositorio disponible en: https://github.com/PDSW-ECI/DesignPatterns_WordProcessorExercise.git
2. Impórtelo en NetBeans IDE.
3. Revise el código y haga el diagrama de clases UML.
4. Como se observa, los fuente incluyen las clases requeridas para que la aplicación pueda trabajar con inglés en lugar de español. Analice: qué habría que hacer para que la aplicación funcione en inglés en lugar de español?. De acuerdo con esto, se puede considerar que la misma está cerrada para modificación y abierta para extensión?. Justifique su respuesta.
5. Proponga una versión alterna del diseño, en la que se aprovechen las propiedades de polimorfismo y se aplique el patrón Fábrica Abstracta, de manera que la aplicación quede 'cerrada para modificación' y 'abierta para extensión'.
6. Implemente su diseño, y agregue a la aplicación una opción de menú que permita seleccionar en qué idioma se va a trabajar.
7. Enumere: si se quisiera agregar soporte -por ejemplo- a la corrección de errores y de estilo del francés, qué se tendría que hacer para lograrlo?