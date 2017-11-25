# GS1-Snaked
Repositorio Master del Snake

## Managers:
  Encargadas del control del flujo de datos principal del programa.
  
  **InputManager:** Controla la entrada por teclado y activa lás acciones pertinentes.
  
  **DisplayManager:** Frame y canvas donde se va a dibujar.
  
  **StateManager:** Para cambiar entre los  estados en ejecución.

## Estados:
  Clases con logica entre a las entidades y relativa al juego.
  
  **Menu:** Estado inicial de aplicaccíon permite al usuario cambiar entre estados.
  
  **OriginalGame:** El Snake clásico de toda lavida.
  
## Entidades:
  
  Objetos dibujables y actualizables. 

  **Button:** Rectángulo que permite lanzár una accíon
  
  **Snake:** Objeto serpiente que controlla los jugadores.
  
  **Food:** Cuadrados simples que colisionan con snake.
