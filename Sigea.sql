create database sigea;
use sigea;

create table Pessoa(
cpf char(11) not null,
nome varchar(50) not null,
email varchar(50) not null,
endereco varchar(50) not null, 
primary key (cpf)); 

create table Fone(
cpfPessoa char(11) not null,
numero char(15) not null,
primary key (cpfPessoa,numero),
foreign key (cpfPessoa) references Pessoa(cpf));

create table Departamento(
codigo smallint not null,
nome varchar(20) not null,
localizacao varchar(40) not null,
primary key (codigo));

create table Funcionario(
matricula smallint not null,
cpfPessoa char(11) not null,
codDepartamento smallint not null,
senha varchar(15) not null,
primary key (matricula),
foreign key (cpfPessoa) references Pessoa(cpf),
foreign key (codDepartamento) references Departamento(codigo));

create table Candidato(
numero smallint not null auto_increment,
cpfPessoa char(11) not null,
senha varchar(15) not null,
primary key (numero),
foreign key (cpfPessoa) references Pessoa(cpf));

create table Evento(
numero smallint not null,
matFuncSolicita smallint not null,
matFuncAutoriza smallint not null,
nome varchar(60) not null,
qtdePessoas smallint not null,
dataInicio date not null,
dataFim date not null,
horaInicio time not null,
horaFim time not null,
horaInscricaoInicio time not null,
horaInscricaoFim time not null,
dataInscricaoInicio date not null,
dataInscricaoFim date not null,
primary key (numero),
foreign key (matFuncSolicita) references Funcionario(matricula),
foreign key (matFuncAutoriza) references Funcionario (matricula));

create table Inscricao(
numero smallint not null,
matFuncAprova smallint not null,
numEventoReferente smallint not null,
numCandidatoFaz smallint not null,
dataInscricao date not null,
hora time not null,
dataFim date not null,
situacao varchar(20) not null,
primary key (numero),
foreign key(matFuncAprova) references Funcionario(matricula),
foreign key (numEventoReferente) references Evento(numero),
foreign key (numCandidatoFaz) references Candidato(numero)); 


create table Responsavel(
matFuncionario smallint not null,
numEvento smallint not null,
papel varchar(20) not null,
foreign key (matFuncionario) references Funcionario(matricula),
foreign key (numEvento) references Evento(numero),
primary key(matFuncionario,numEvento));

insert into pessoa values('034','Junior','gabrielpmoda','Rua 01');
insert into departamento values('1','DAIC','Duque de Caxias');
insert into funcionario values('2017','034','1','123456');

desc evento;

insert into evento values (1,1,1,'Gabriel',15,'2016-12-05','2016-12-5','05:05:05','05:05:05','05:05:05','05:05:05','2016-12-5','2016-12-5');
truncate evento;

select *from evento;



