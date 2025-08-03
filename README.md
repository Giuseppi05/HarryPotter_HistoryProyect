GUÍA PARA EJECUTAR EL PROYECTO

REQUISITO PREVIO:
Asegúrese de tener instalado un JDK de Java compatible con Scala 2.12.20.

1. INSTALAR COURSER:
Descargue e instale Coursier desde el sitio oficial de Scala:
https://www.scala-lang.org/download/2.12.20.html

2. VERIFICAR LA INSTALACIÓN DE HERRAMIENTAS:
Abra una terminal o PowerShell (preferentemente como administrador) y ejecute:

    cs list

Verifique que 'sbt' y 'scala-cli' estén listados.
Si no aparecen, repita la instalación con permisos de administrador o verifique la instalación global.

3. COMPILAR EL PROYECTO:
Ubíquese en la carpeta raíz del proyecto y ejecute:

    sbt compile

Espere a que el proceso termine correctamente.

4. EJECUTAR EL PROGRAMA:
Ejecute el siguiente comando para iniciar el programa:

    sbt run

5. TODO LISTO:
¡El proyecto se estará ejecutando!

NOTA:
En caso de corrupción de archivos u otros problemas, puede clonar nuevamente el repositorio.
