# desafioAtran
Instruções:

Fazer o checkout do projeto 

Back-end na raiz acessar a pasta CarrinhoDeComprasApi e executar o comando abaixo:

mvn clean install
Com o build realizado com sucesso


Front-end

Na pasta carrinho-de-compras executar os comandos abaixo

- npm install
- npm start



A partir de agora você poderá acessar os serviços pelos endpoints.
Segue exemplos de alguns endpoints

consultar usuarios -> http://localhost:8181/usuario

consutlar itens -> http://localhost:8181/item


Link de acesso para a aplicação: http://localhost:4200


Foi utilizado o primeNg no angular 8 para dar uma face amigável
à aplicação. O sistema foi dividido em 4 classes de modelo.

Usuário que possui carrinho.  
Carrinho que possui uma lista de produtos (produtos - representa cada linha do carrinho)
Produto que possui quantidade e item
e por fim Item que possui a descrição e valor dos itens do carrinho.
