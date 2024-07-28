<h1 align="center">Java: Insumos EliDev</h1>
<p align="center">¡Bienvenidos a <strong>Insumos EliDev</strong>!</p>
<hr />

## Integrantes
<table align="center">
  <tr>
    <td align="center"><img src="https://avatars.githubusercontent.com/Javithor360" alt="MF232724" width="100"></td>
    <td align="center"><img src="https://avatars.githubusercontent.com/MatMT" alt="EL232710" width="100"></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/Javithor360">Javier Mejía</a></td>
    <td align="center"><a href="https://github.com/MatMT">Mateo Elías</a></td>
  </tr>
</table>

## Tecnologías Utilizadas

<table align="center">
    <tr>
        <td align="center"><img src="https://www.oracle.com/a/ocom/img/cb71-java-logo.png" alt="Java" width="64" height="64"></td>
        <td align="center"><img src="https://projects.eclipse.org/sites/default/files/36201228_1.png" alt="Jakarta EE" width="64" height="64"></td>
        <td align="center"><img src="https://www.payara.fish/payara-site/themes/payara/nav/logo-social.png" alt="Payara" width="64" height="64"></td>
        <td align="center"><img src="https://img.stackshare.io/service/1757/E6ajYzZW_400x400.png" alt="Jersey" width="64" height="64"></td>
        <td align="center"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Jakarta_Server_Faces_logo.tiff/lossless-page1-800px-Jakarta_Server_Faces_logo.tiff.png" alt="Jakarta Server Faces" width="64" height="64"></td>
        <td align="center"><img src="https://getbootstrap.com/docs/5.0/assets/brand/bootstrap-logo.svg" alt="Bootstrap" width="64" height="64"></td>
        <td align="center"><img src="https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA_icon.svg" alt="IntelliJ IDEA" width="64" height="64"></td>
    </tr>
    <tr>
        <td align="center"><strong><a href="https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html">Java v14.0.2</a></strong></td>
        <td align="center"><strong><a href="https://jakarta.ee/">Jakarta EE 10</a></strong></td>
        <td align="center"><strong><a href="https://www.payara.org/payara-platform-community-edition-520202-is-out">Payara v5.2022.2</a></strong></td>
        <td align="center"><strong><a href="https://mvnrepository.com/artifact/org.glassfish.jersey.core/jersey-client/3.0.8">Jersey v3.0.8</a></strong></td>
        <td align="center"><strong><a href="https://mvnrepository.com/artifact/org.glassfish/jakarta.faces/3.0.0">Jakarta Server Faces v3.0.0</a></strong></td>
        <td align="center"><strong><a href="https://getbootstrap.com/docs/4.6/getting-started/introduction/">Bootstrap 4</a></strong></td>
        <td align="center"><strong><a href="https://www.jetbrains.com/idea/download/?section=windows">IntelliJ IDEA Ultimate 2024.1</a></strong></td>
</table>

## Proceso de Instalación

Para instalar y ejecutar este proyecto en tu entorno local, sigue estos pasos:

1. **Clonar el Repositorio**
    ```bash
    git clone https://github.com/Javithor360/java-supplies
    cd java-supplies
    ```

2. **Configurar el Servidor**
    - Asegúrate de tener Payara 5.2022 instalado y configurado.
    - Despliega la aplicación en el servidor Payara.

3. **Configurar la Base de Datos**
    - Configura tu base de datos en el archivo `AppConnection.java` con las credenciales correctas.

4. **Ejecutar la Aplicación**
    - Inicia el servidor Payara.
    - Accede a la aplicación desde `http://localhost:8080/insumos-1.0-SNAPSHOT/faces/index.xhtml`.

## Observaciones

- **Idioma:** El proyecto está programado y presentado en inglés para motivos de futura difusión y estándares generales.
- **Validaciones:** La aplicación incluye validaciones de formularios para asegurar la integridad de los datos.
- **Estilos:** Todos los formularios y tablas están estilizados utilizando Bootstrap a través de su CDN.
- **Integración:** La aplicación se integra con la base de datos MySQL para almacenar y recuperar los datos.
- **Web Service:** La aplicación consume un REST Web Service interno para obtener la información.

## Imágenes de Exposición

<p align="center">
  <img src="https://i.imgur.com/dTcOkfc.png" alt="Página de Inicio" width="600">
  <br>
  <em>Página de Inicio de la Aplicación</em>
</p>

<p align="center">
  <img src="https://i.imgur.com/keikzxG.png" alt="API Docs" width="600">
  <br>
  <em>API documentada</em>
</p>

<p align="center">
  <img src="https://i.imgur.com/Z7yNfuS.png" alt="Tabla de Datos" width="600">
  <br>
  <em>Tabla de datos y acciones</em>
</p>

<p align="center">
  <img src="https://i.imgur.com/XwfYFKc.png" alt="Web Service" width="600">
  <br>
  <em>Consumo del Web Service REST desde clientes externos</em>
</p>

---

Proyecto realizado con fines de académicos de aprendizaje