CREATE TABLE funcionarios (
  idFuncionarios INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR NOT NULL,
  email VARCHAR NOT NULL,
  telefone VARCHAR NOT NULL,
  cpf VARCHAR NOT NULL,
  dataNascimento DATE NOT NULL,
  salario DOUBLE NOT NULL,
  comissao DOUBLE NOT NULL,
  fichamento DATE NOT NULL,
  endereco VARCHAR NOT NULL,
  bairro VARCHAR NOT NULL,
  cidade INTEGER UNSIGNED NOT NULL,
  cep VARCHAR NOT NULL,
  Estado CHAR NOT NULL,
  PRIMARY KEY(idFuncionarios)
)
TYPE=InnoDB;

CREATE TABLE clientes (
  idClientes INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR NOT NULL,
  email VARCHAR NOT NULL,
  telefone VARCHAR NOT NULL,
  cpf VARCHAR NOT NULL,
  dataNascimento DATE NOT NULL,
  endereco VARCHAR NOT NULL,
  cep VARCHAR NOT NULL,
  PRIMARY KEY(idClientes)
)
TYPE=InnoDB;

CREATE TABLE produtos (
  idProdutos INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  funcionarios_idFuncionarios INTEGER UNSIGNED NOT NULL,
  nome VARCHAR NOT NULL,
  descricao VARCHAR NOT NULL,
  precoUnitario DOUBLE NOT NULL,
  cor VARCHAR NOT NULL,
  tamanho VARCHAR NOT NULL,
  marca VARCHAR NOT NULL,
  PRIMARY KEY(idProdutos, funcionarios_idFuncionarios),
  INDEX produtos_FKIndex1(funcionarios_idFuncionarios),
  FOREIGN KEY(funcionarios_idFuncionarios)
    REFERENCES funcionarios(idFuncionarios)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;

CREATE TABLE login (
  idLogin INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  funcionarios_idFuncionarios INTEGER UNSIGNED NOT NULL,
  usuario VARCHAR NULL,
  senha VARCHAR NULL,
  validar BOOL NULL,
  PRIMARY KEY(idLogin, funcionarios_idFuncionarios),
  INDEX login_FKIndex1(funcionarios_idFuncionarios),
  FOREIGN KEY(funcionarios_idFuncionarios)
    REFERENCES funcionarios(idFuncionarios)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;

CREATE TABLE pedidos (
  idPedidos INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  clientes_idClientes INTEGER UNSIGNED NOT NULL,
  funcionarios_idFuncionarios INTEGER UNSIGNED NOT NULL,
  dataPedido DATE NOT NULL,
  horas INT NOT NULL,
  valorPedido DOUBLE NOT NULL,
  PRIMARY KEY(idPedidos, clientes_idClientes, funcionarios_idFuncionarios),
  INDEX pedidos_FKIndex2(clientes_idClientes),
  INDEX pedidos_FKIndex2(funcionarios_idFuncionarios),
  FOREIGN KEY(clientes_idClientes)
    REFERENCES clientes(idClientes)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(funcionarios_idFuncionarios)
    REFERENCES funcionarios(idFuncionarios)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;

CREATE TABLE vendas (
  pedidos_idPedidos INTEGER UNSIGNED NOT NULL,
  produtos_idProdutos INTEGER UNSIGNED NOT NULL,
  produtos_funcionarios_idFuncionarios INTEGER UNSIGNED NOT NULL,
  pedidos_clientes_idClientes INTEGER UNSIGNED NOT NULL,
  pedidos_funcionarios_idFuncionarios INTEGER UNSIGNED NOT NULL,
  valorDoProduto DOUBLE NOT NULL,
  quantidade INTEGER UNSIGNED NULL,
  precoTotal DOUBLE NULL,
  PRIMARY KEY(pedidos_idPedidos, produtos_idProdutos, produtos_funcionarios_idFuncionarios, pedidos_clientes_idClientes, pedidos_funcionarios_idFuncionarios),
  INDEX pedidos_has_produtos_FKIndex1(pedidos_idPedidos, pedidos_clientes_idClientes, pedidos_funcionarios_idFuncionarios),
  INDEX pedidos_has_produtos_FKIndex2(produtos_idProdutos, produtos_funcionarios_idFuncionarios),
  FOREIGN KEY(pedidos_idPedidos, pedidos_clientes_idClientes, pedidos_funcionarios_idFuncionarios)
    REFERENCES pedidos(idPedidos, clientes_idClientes, funcionarios_idFuncionarios)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(produtos_idProdutos, produtos_funcionarios_idFuncionarios)
    REFERENCES produtos(idProdutos, funcionarios_idFuncionarios)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;


