:uk:
## Project description
Project under development in which the administrator has the power to execute the CRUD (from the original in English: Create, Read, Update and Delete), which is used to refer to the basic functions in databases or the persistence layer in software. Therefore, the administrator can add, edit, and delete products from the store, in this case, sneakers, from the web reflecting it in the database. This marketplace, Galactica, is focused on the administrator's profile and its main functions.

<h4 align="center">
:construction: Project under construction :construction:
</h4>

## :hammer:Prerequisites

- Java 8 o superior instalado en tu sistema.
- Gradle 6.0 o superior.
 
## :white_check_mark:Dependencies
- Spring Boot 2.5.0
- JPA Buddy 2.5.0
- Lombok 1.18.20
- Gradle 6.0

## :gear:Project structure.
The project is structured into three main layers:
- `apiService`: It contains the errors, category, and sneaker controllers.
- `domain`: It contains the DTOs, models, and services.
- `infrastructure`: It contains the different repositories for admin, category, and sneaker.

The controllers execute previously declared functions in the services. This way, we make the controllers section cleaner and easier to read and modify.

## 🛠️ Open and run the project

Once the prerequisites are installed, you can clone the repository from the terminal:
```
git clone https://github.com/CarlosJavierVilla/Api-FullStack-Application.git
```
Finally, you need to run the following command to compile and run the project:
```
gradle bootRun
```
We recommend running it together with the Front-End. Here is the [link to the repository](https://github.com/ItzAle/sneakers-app) with the different instructions on how to run it.


## :bust_in_silhouette:Contributors
[@marcygon](https://github.com/marcygon)<br>
[@saidGM](https://github.com/SaidGM)<br>
[@ItzAle](https://github.com/ItzAle)<br>
[@CarlosJavierVilla](https://github.com/CarlosJavierVilla)<br>
[@vanessa-cp](https://github.com/vanessa-cp)<br>


<br><br>


:es:
## Descripción del proyecto
Proyecto en desarrollo en el cual el administrador tiene el poder de ejecutar el CRUD (del original en inglés: Create, Read, Update and Delete), que se usa para referirse a las funciones básicas en bases de datos o la capa de persistencia en un software. Por ende, el administrador puede de añadir, editar y borrar los productos de la tienda, en este caso zapatillas, desde la web reflejándolo en la base de datos. Este marketplace, Galactica, está centrado en el perfil de administrador y sus principales funciones.

<h4 align="center">
:construction: Proyecto en construcción :construction:
</h4>

## :hammer:Requisitos previos

- Java 8 o superior instalado en tu sistema.
- Gradle 6.0 o superior.
 
## :white_check_mark:Dependencias
- Spring Boot 2.5.0
- JPA Buddy 2.5.0
- Lombok 1.18.20
- Gradle 6.0

## :gear:Estructura del proyecto
El proyecto esta estructurado en tres capas principales:
- `apiService`: Contiene los controladores de errores, categorías y sneakers.
- `domain`: Contiene los DTOs, modelos y servicios.
- `infrastructure`: Contiene los distintos repositorios para admin, category y sneaker.

Los controladores ejecutan funciones previamente declaradas en los servicios, de esta manera hacemos que el apartado de controladores quede más limpio y sea más facil de leer y modificar.

## 🛠️ Abre y ejecuta el proyecto

Una vez que estén los requisitos instalados, ya se puede clonar desde la terminal:
```
git clone https://github.com/CarlosJavierVilla/Api-FullStack-Application.git
```
Por último hay que ejecutar el siguiente comando para compilar y ejecutar el proyecto:
```
gradle bootRun
```
Recomendamos hacerlo en compañía del Front-End, este es el [link al repositorio](https://github.com/ItzAle/sneakers-app) con las distintas instruciones de como ejecutarlo.


## :bust_in_silhouette:Personas contribuyentes
[@marcygon](https://github.com/marcygon)<br>
[@saidGM](https://github.com/SaidGM)<br>
[@ItzAle](https://github.com/ItzAle)<br>
[@CarlosJavierVilla](https://github.com/CarlosJavierVilla)<br>
[@vanessa-cp](https://github.com/vanessa-cp)<br>
