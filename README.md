# Plataforma de busca por animes #

#### Aqui eu desenvolvi uma aplicação web simples que consome uma api externa chamada Kitsu API, nela é possível receber dados específicos de um anime como: nome, sinopse, ranking de popularidade, faixa etária e diversas outras informações.


###### * Utilizei Java e Spring para tratar do Back e Thymeleaf para tratar do Front, quis criar algo mais amigável no momento em que fossse utilizar a aplicação *
###### * Futuramente adicionarei um sistema de cadastro e login (também utilizarei spring security), portanto, mantive as configurações no applicaiton-dev.yml *

# Utilizando a aplicação #

O acesso a aplicação se dá apartir da url http://localhost:8080/api/anime/index.html onde terá um input para realizar a busca do anime desejado a partir do nome digitado, feito isso, clique em buscar.
Você receberá as informações do anime, como: poster, nome, popularidade e sinopse.
