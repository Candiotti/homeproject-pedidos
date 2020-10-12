# homeproject-pedidos
Repositório Projeto Teste - Pedidos

API REST para geração de pedidos e entregas de pedidos desenvolvida com Spring Boot, utilizando o banco de dados em memória H2 e com integração com o Spring Boot Data JPA, também foi utilizado RabbitMQ para enviar para uma fila os pedidos inseridos no banco de dados e receber dessa fila esses registros para inserir no banco os cadastros das entregas desses pedidos.

Para rodar a aplicação, primeramente importe as dependência necessárias do Maven e execute br.com.homeproject.pedidos.PedidosApplication.java

Para testar a geração de pedido e posteriormente a entrega, utilize a seguinte cURL:

curl --location --request POST 'http://localhost:8080/pedido' \
--header 'Content-Type: application/json' \
--data-raw '{
    "clienteId" : 1,
    "produtosId" : [3, 3, 2, 2, 4, 5]
}'


