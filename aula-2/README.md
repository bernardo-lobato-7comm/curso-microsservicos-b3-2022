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
Critérios de Aceite

* A Forma de pagamento deve ser aceita pelo vendedor
* O pedido pode ser cancelado enquanto não for finalizado através da entrega





## Links

* https://en.wikiquote.org/wiki/Software_architecture​
* https://www.youtube.com/watch?v=BrT3AO8bVQY​
* https://en.wikipedia.org/wiki/Loose_coupling​
* http://microservices.io/patterns/decomposition/decompose-by-business-capability.html​
* http://wiki.c2.com/?GodClass​
* https://plantuml.com//
