CREATE TABLE login (
  idLogin INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  usuario VARCHAR NULL,
  senha VARCHAR NULL,
  validar BOOL NULL,
  PRIMARY KEY(idLogin)
)
TYPE=InnoDB;

CREATE TABLE funcionarios (
  idFuncionarios INTEGER NOT NULL AUTO_INCREMENT,
  login_idLogin INTEGER UNSIGNED NOT NULL,
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
  PRIMARY KEY(idFuncionarios),
  INDEX funcionarios_FKIndex1(login_idLogin),
  FOREIGN KEY(login_idLogin)
    REFERENCES login(idLogin)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
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
  PRIMARY KEY(idProdutos),
  INDEX produtos_FKIndex1(funcionarios_idFuncionarios),
  FOREIGN KEY(funcionarios_idFuncionarios)
    REFERENCES funcionarios(idFuncionarios)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;

CREATE TABLE clientes (
  idClientes INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  funcionarios_idFuncionarios INTEGER UNSIGNED NOT NULL,
  nome VARCHAR NOT NULL,
  email VARCHAR NOT NULL,
  telefone VARCHAR NOT NULL,
  cpf VARCHAR NOT NULL,
  dataNascimento DATE NOT NULL,
  endereco VARCHAR NOT NULL,
  cep VARCHAR NOT NULL,
  PRIMARY KEY(idClientes),
  INDEX clientes_FKIndex1(funcionarios_idFuncionarios),
  FOREIGN KEY(funcionarios_idFuncionarios)
    REFERENCES funcionarios(idFuncionarios)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;

CREATE TABLE pedidos (
  idPedidos INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  funcionarios_idFuncionarios INTEGER UNSIGNED NOT NULL,
  clientes_idClientes INTEGER UNSIGNED NOT NULL,
  dataPedido DATE NOT NULL,
  horas INT NOT NULL,
  valorPedido DOUBLE NOT NULL,
  PRIMARY KEY(idPedidos),
  INDEX pedidos_FKIndex1(clientes_idClientes),
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

CREATE TABLE pedidos_has_produtos (
  pedidos_idPedidos INTEGER UNSIGNED NOT NULL,
  produtos_idProdutos INTEGER UNSIGNED NOT NULL,
  valorDoProduto DOUBLE NOT NULL,
  quantidade INTEGER UNSIGNED NULL,
  PRIMARY KEY(pedidos_idPedidos, produtos_idProdutos),
  INDEX pedidos_has_produtos_FKIndex1(pedidos_idPedidos),
  INDEX pedidos_has_produtos_FKIndex2(produtos_idProdutos),
  FOREIGN KEY(pedidos_idPedidos)
    REFERENCES pedidos(idPedidos)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(produtos_idProdutos)
    REFERENCES produtos(idProdutos)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;


