create table videos(

    id bigint not null auto_increment,
    titulo varchar(120) not null,
    descricao varchar(500) not null,
    url varchar(200) not null,
    competicao varchar(100) not null,
    data date not null,

    primary key(id)

)