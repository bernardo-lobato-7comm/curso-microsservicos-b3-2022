# Saga Coreografada

<img src=https://i.gyazo.com/6907b577bc7f43f2836fd6db4a228a7e.png alt=“comunicacao”>

# Sagas como Máquina de Estados

<img src=https://i.gyazo.com/e6fecdcebdbbfd59fe10f6c8a63a84d4.png alt=“comunicacao”>

# Saga orquestrada

<img src=https://i.gyazo.com/b67b4344d299698668376449e2146b67.png alt=“comunicacao”>

# Tipos de Sagas

| Passo | Serviço                                            | Transação                                                             | Compensação
|----------------|----------------------------------------------------|-----------------------------------------------------------------------|--------|
|1| OrderService     | Criar pedido vinculado ao usuário</span>    |-
|2| UserService    | Validar dados do usuário</span>             |CancelarPedido
|3| ProductService    | Verificar disponibilidade do produto |CancelarPedido
|4| PaymentService    | Processar pagamento                  |CancelarPedido; LiberarProdutos;
|5| ProductService    | Processar estoque                    |-
|6| NotificationService | Enviar e-mail de pedido criado         |-
|7| OrderService       | Atualiza status para APROVADO         |-


# Um Novo Serviço: Order Service Saga

<img src=https://i.gyazo.com/b26b4343716d65a4bc952e7ac0fa04cf.png>

<img src=https://i.gyazo.com/fc0acef4af5b39b0bc9bf950aefc0ff1.png>

<img src=https://i.gyazo.com/eb1187f43aa2c163ef121d000685567c.png>