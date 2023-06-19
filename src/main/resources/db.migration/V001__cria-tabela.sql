create table StatusCasa (
                         id bigint not null auto_increment,
                         temperatura bigint not null,
                         umidade bigint not null,
                         hasGas bit not null,
                         hasChama bit not null,
                         hasIncendio bit not null,

                         primary key (id)
);