
# Docker
Exemplos utilizados em aula sobre o básico de docker

	docker run hello-world
Baixa a imagem (caso seja necessário) e roda um container com as configurações passadas

## Wordpress
	docker run --name some-wordpress -p 8080:80 -d wordpress
Acessar: http://localhost:8080

## PostgreSQL
Iniciando o container

	docker run --name some-postgres -e POSTGRES_PASSWORD=123456 -d postgres
	
Executando o banco dentro do container

	docker exec -it some-postgres2 psql -h localhost -p 5432 -U postgres -W
	
	show databases;
	
	\c aula_docker;
	
Criando Tabela

	CREATE TABLE accounts (
	user_id serial PRIMARY KEY,
	username VARCHAR ( 50 ) UNIQUE NOT NULL,
	password VARCHAR ( 50 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	created_on TIMESTAMP NOT NULL,
        last_login TIMESTAMP );
Inserindo dados
	
	insert into accounts values(1, 'Bernardo', '123456', 'bernardolobato@gmail.com', current_timestamp, null);
	
## Volumes
Cria um volume

	docker run -dit --name my-running-app -p 8080:80 httpd:2.4
Roda um Container com o volume criado

	docker run -dit --name my-apache-app -p 8081:80 -v "$PWD"/apache-htdocs:/usr/local/apache2/htdocs/ httpd:2.4
	docker volume create data_volume #se o nome não é especificado, é gerado um nome aleatório
	docker volume ls
	docker volume inspect ca808e6fd82590dd0858f8f2486d3fa5bdf7523ac61d525319742e892ef56f59
	docker volume rm data_volume
	docker volume prune #Remove todos os volumes não utilizados

## Portainer
Aplicação utilizada para gerenciamento dos containeres, imagens e volume, de maneira visual, na web

	docker volume create portainer_data
	
	docker run -d -p 8000:8000 -p 9443:9443 --name portainer \
    --restart=always \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v portainer_data:/data \
    portainer/portainer-ce:2.11.1
Acessar
https://localhost:9443


# Criando uma imagem
Cria-se o Dockerfile

	FROM node:alpine

	WORKDIR /usr/app

	RUN npm init -y
	RUN npm install cowsay

	CMD npx cowsay Exemplo muito útil de docker!

Para rodar a imagem
	
	docker build -t nome_da_imagem .

