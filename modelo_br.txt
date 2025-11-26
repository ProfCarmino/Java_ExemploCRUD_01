CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY,
    nome        VARCHAR(100) NOT NULL,
    email       VARCHAR(100) NOT NULL
);

CREATE TABLE Pedido (
    id_pedido    INT PRIMARY KEY,
    data_pedido  DATE NOT NULL,
    valor_total  DECIMAL(10,2) NOT NULL,
    id_cliente   INT NOT NULL,
    FOREIGN KEY (id_cliente)
        REFERENCES Cliente(id_cliente)
);
