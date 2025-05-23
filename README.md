# Actividad 3 – Unidad 9: Consulta filtrada de dietas con JDBC

En esta tercera actividad he creado un nuevo proyecto llamado `ConsultarDietas`.  
El objetivo era realizar una consulta a la base de datos `Empresa` y mostrar por consola todas las dietas del departamento de Informática cuyo importe sea mayor a 30 euros.

He reutilizado la clase `ConexionBD` para conectarme a la base de datos.  
Luego he creado una nueva clase llamada `ConsultarDietas` donde preparo una sentencia SQL con parámetros usando `PreparedStatement`.

En la consulta filtro por dos condiciones:
- que el departamento sea “Informática”
- y que la cantidad sea superior a 30

He recorrido los resultados utilizando `ResultSet` y he mostrado por consola el contenido de cada fila de forma clara y ordenada.  
He comprobado que la consulta funciona correctamente y solo devuelve los registros que cumplen las condiciones indicadas.
