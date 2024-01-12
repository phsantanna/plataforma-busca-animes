# Plataforma de busca por animes #

Aqui, desenvolvi uma aplicação web simples que consome uma API externa chamada [Kitsu API](https://kitsu.docs.apiary.io/). Nela, é possível receber dados específicos de um anime, como nome, sinopse, ranking de popularidade, faixa etária e diversas outras informações.

* Utilizei Java e Spring para tratar do Back e Thymeleaf para tratar do Front. Quis criar algo mais amigável no momento em que fosse utilizar a aplicação.
* Futuramente, adicionarei um sistema de cadastro e login (também utilizarei Spring Security). Portanto, mantive as configurações no `application-dev.yml`.

# Utilizando a aplicação #

O acesso à aplicação se dá a partir da URL http://localhost:8080/api/anime/index.html, onde haverá um input para realizar a busca do anime desejado a partir do nome digitado. Feito isso, clique em buscar. Você receberá as informações do anime, como poster, nome, popularidade e sinopse.
