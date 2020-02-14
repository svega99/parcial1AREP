# Taller de verificación de conocimientos técnicos

Implementación de un servidor que retorna un JSON con una lista ordenada y su sumatoria, con un respectivo cliente JAVA que lo prueba.

## Empezando

Para ver los programas en la web solo es necesario abrir heroku, si se desea ver el codigo fuente o correrlo desde el local sere necesario tener git y heroku en su computador.

### Prerrequisitos

#### Git
Para descargar el programa se necesita git, para comprobar si esta instalado desde la linea de comandos:

```
> git --version

git version 2.21.0.windows.1
```

#### Heroku
La pagina web esta alojada en heroku, para comprobar si esta instalado desde la linea de comandos:

```
> heroku -v

heroku/7.37.0 win32-x64 node-v12.13.0

```

### Instalación

Si desea instalar el repositorio se instala en la ruta deseada desde git de esta forma

```
> git clone https://github.com/svega99/parcial1AREP.git

```

Para compilar desde maven:

```
> mvn package
```
 
## Ejecutando el programa

Link a heroku con un formulario de prueba: 
[![Heroku](https://camo.githubusercontent.com/be46aee4f8d55e322c3e7db60ea23a4deb5427c9/68747470733a2f2f6865726f6b752d62616467652e6865726f6b756170702e636f6d2f3f6170703d6865726f6b752d6261646765)](https://agile-sea-56391.herokuapp.com/)

Link a heroku con una respuesta de prueba:
[![Heroku](https://camo.githubusercontent.com/be46aee4f8d55e322c3e7db60ea23a4deb5427c9/68747470733a2f2f6865726f6b752d62616467652e6865726f6b756170702e636f6d2f3f6170703d6865726f6b752d6261646765)](https://agile-sea-56391.herokuapp.com/results?numbers=9,8,2,18,7,25,15,89,10)

Si quiere ejecutar cualquier programa desde local se puede poner en la linea de comandos desde la ruta del proyecto:

```
> mvn clean install
...
> heroku local web

```


# Diseño 

El programa esta dividido en tres paquetes principales: Server, Cliente y Services. El paquete Services se encarga de hacer las operaciones necesarias de ordenamiento y suma. En el paquete Cliente se encuentra un cliente Java que prueba el servidor imprimiendo una respuesta de ejemplo.

## Authors

* **Santiago Vega Romero**  - [svega99](https://github.com/svega99)

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details
