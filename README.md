
5.

6. Para correr el proyecto es necesario crear un contenedor de mysql con el comando 
   "docker run --name mysql-parcial2 -p 8090:3306 -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_USER=yms_user -e MYSQL_PASSWORD=yms_clave -e MYSQL_DATABASE=yms -d mysql"
   y asegurarse de que el contenedor esté encendido. Ya con esto al ejecutar el proyecto de manera local funciona.