# Refactoring U11 Post 1

## Analisis inicial
- CC de procesarPedido: X
- Code Smells reportados: X
- TDR inicial: X

## Tecnicas aplicadas
- Extract Method
- Extract Class
- Value Objects (DatosCliente, Direccion, LineaPedido, CodigoDescuento)

## Resumen de cambios
- PedidoService reducido a metodos pequenos de orquestacion.
- NotificacionService extraido para separar responsabilidades.
- Data clumps reemplazados por value objects inmutables.

## Analisis final
- CC de procesarPedido: X
- Code Smells reportados: X
- TDR final: X

## Capturas
![Dashboard inicial](img/sonar-inicial.png)
![Dashboard final](img/sonar-final.png)

## Notas
- Las capturas se guardan en la carpeta img/.
