# Curso de Padrões em microsserviços - Aula 2

* Material da segnuda aula aula do curso de padrões em microsserviços.

## Histórias de usuários
### Cadastro de Usuário
Como Cliente ou vendedor, eu quero manter um cadastro para que meus pedidos sejam processados corretamente com meus dados.​
**Critérios de Aceite​**

* Os campos Nome, CPF, e-mail, senha, e pelo menos​ um endereço são obrigatórios​
* O campo CPF deve ser validado com a regra vigente​ de validação de números e dígitos, assim como a​ formatação correta​
* A qualquer momento quaisquer dados meus podem​ ser alterados por mim através da interface correta,​ desde que, devidamente logado e autorizado.​


### Credenciamento de Usuário
Como Cliente ou vendedor,  eu quero ser credenciado para ter​ acesso ao sistema e suas funcionalidades de acordo com meu perfil​

**Critérios de Aceite​**
* Os campos para credenciamento são: login e senha​
* Em caso de inatividade, minha sessão deve ser invalidada em 15 minutos​

### Realizar Pedido
Como Cliente, eu quero realizar uma compra para ter acesso a produtos de meu interesse​

**Critérios de Aceite**

* O cliente deve estar habilitado e validado​
* Cada compra pode possuir um ou mais produtos de um mesmo vendedor​
* Os produtos devem estar disponíveis e em quantidades adequadas ao pedido do usuário​
* O pedido só pode ser finalizado uma vez que o pagamento seja AUTORIZADO​

### Efetuar Pagamento
Como Cliente,  eu quero realizar o pagamento de um pedido para dar continuidade ao processamento do mesmo​

**Critérios de Aceite**

* A Forma de pagamento deve ser aceita pelo vendedor
* O pedido pode ser cancelado enquanto não for finalizado através da entrega

### Status Pedido
Como cliente, eu quero poder ver meus pedidos e seus respectivos status

**Critérios de Aceite**

*Cliente deve estar logado no sistema
*Só poderá aparecer pedidos do cliente logado

### Alterar Produto
Como vendedor, eu quero poder alterar o preço dos meus produtos

**Critérios de Aceite**

*Vendedor deve estar logado no sistema
*Só poderá alterar o preço dos produtos do vendedor em questão

### Cancelar Compra
Como cliente, quero poder cancelar minha compra

**Critérios de Aceite**

*Cliente precisar estar logado
*Cliente só pode cancelar as compras feitas por ele
*Compras com status FINALIZADO não podem ser canceladas

### Produtos Vendedor
Como vendedor, eu quero poder ver todos os meus produtos listados

**Critérios de Aceite**

*Apenas produtos do vendedor aparecem na listagem


## Operações do Sistema

| Ator | História de Usuário | Comando | Descrição
|----------------|------------------------|--------------------|--------|
|Cliente|Manter Cliente|criaUsuario()|Cria um novo usuário
|Cliente|Manter Cliente|alteraUsuario()|Altera os dados do usuário logado
|Cliente|Credenciamento|login()|Credencia e autoriza o usuário para o acesso a suas funcionalidade
|Cliente|Ver Pedidos|pedidosDoUsuario()|Lista os pedidos do usuário logado no sistema
|Cliente|Cancelar Pedido|cancelarPedido()|Cliente cancela um pedido
|Vendedor|Gestão de Produtos|alterarPrecoProduto()|Vendedor altera o preço do produto
|Vendedor|Gestão de Produtos|listaProdutos()|Lista os produtos do vendedor logado no sistema
|Vendedor|Gestão de Produtos|criaProduto()|Vendedor cria um produto novo
|Vendedor|Gestão de Produtos|zeraProduto()|Zerando o estoque do produto e não pode mais ser vendido


## Definindo as APIs
|  Serviço  |  Operação | Colaboradores
|-----------|---------------|----------
|User Service| createUser();<br/>  updateUser();<br/> login();<br/> logout();<br/> validateUser(); | -
|Order Service|createOrder()|ProductService.getProduct();<br/>ProductService.processProduct();<br/>UserService.validateUser();<br/>PaymentService.ReceivePayment();
|Order Service| changeStatus();| ProductService.processProduct();


## Links

* https://en.wikiquote.org/wiki/Software_architecture​
* https://www.youtube.com/watch?v=BrT3AO8bVQY​
* https://en.wikipedia.org/wiki/Loose_coupling​
* http://microservices.io/patterns/decomposition/decompose-by-business-capability.html​
* http://wiki.c2.com/?GodClass​
* https://plantuml.com//
