# CineSpring - API de Catálogo de Filmes (Estudo)

Este repositório é um projeto de estudo que implementa uma API REST básica para gerenciar um catálogo de filmes. O objetivo inicial foi cumprir os requisitos do desafio técnico e, posteriormente, evoluir a aplicação gradualmente (melhorias, tratamento de erros, testes, documentação, etc.).

## Checklist

- [x] Criar API básica para cadastro/listagem/busca por id de filmes
- [x] Usar Spring Boot + H2 + JPA
- [x] Validar campos essenciais com Bean Validation (@NotBlank)
- [x] Melhorar tratamento de erros para retornar 404 quando um filme não existir
- [ ] Adicionar testes de integração e unitários mais completos
- [ ] Documentação (OpenAPI/Swagger)

## Visão geral

- Linguagem: Java (versão do projeto: definida em `pom.xml` como 21)
- Framework: Spring Boot (starter-parent no `pom.xml`)
- Gerenciador: Maven (scripts via `mvnw.cmd` no Windows)
- Banco: H2 (in-memory)

## Estrutura principal do projeto

- `src/main/java/com/CineSpring/desafio/DesafioApplication.java` - classe principal do Spring Boot
- `src/main/java/com/CineSpring/desafio/controller/FilmeController.java` - endpoints REST
- `src/main/java/com/CineSpring/desafio/service/FilmeService.java` - regras de negócio
- `src/main/java/com/CineSpring/desafio/repository/FilmeRepository.java` - interface JPA
- `src/main/java/com/CineSpring/desafio/model/Filme.java` - entidade JPA com validações
- `src/main/resources/application.yaml` - configuração (H2, JPA)

## Dependências relevantes (ver `pom.xml`)

- `spring-boot-starter-data-jpa` - JPA/Hibernate
- `spring-boot-starter-validation` - Bean Validation (JSR 380)
- `spring-boot-starter-webmvc` - Web MVC
- `h2` - banco em memória e console H2
- `lombok` - geração de getters/setters/constructors (opcional)

## Endpoints 

- `POST /api/filme`
  - Cria um novo filme
  - Corpo: JSON representando um `Filme`
  - Resposta: 201 Created com o objeto salvo

- `GET /api/filme`
  - Lista todos os filmes
  - Resposta: 200 OK com array de filmes

- `GET /api/filme/{id}`
  - Busca um filme por id
  - Resposta: 200 OK com o filme quando encontrado
  - Observação: atualmente, se o id não existir, o serviço lança `RuntimeException` (mensagem "Filme não encontrado"). Isso resulta no comportamento padrão de erro do Spring (500). Uma melhoria recomendada é adicionar um `@ControllerAdvice` para transformar essa exceção em 404 Not Found.

## Exemplo de JSON para POST (criar filme)

```json
{
  "titulo": "Matrix",
  "diretor": "Lana Wachowski",
  "anoLancamento": 1999,
  "genero": "Ficção Científica"
}
```

## Exemplos de requisições

Usando PowerShell (Invoke-RestMethod):

```powershell
# Criar filme
Invoke-RestMethod -Method Post -Uri http://localhost:8080/api/filme -ContentType 'application/json' -Body (@'
{
  "titulo": "Matrix",
  "diretor": "Lana Wachowski",
  "anoLancamento": 1999,
  "genero": "Ficção Científica"
}
'@)

# Listar todos
Invoke-RestMethod -Method Get -Uri http://localhost:8080/api/filme

# Buscar por id (ex: id = 1)
Invoke-RestMethod -Method Get -Uri http://localhost:8080/api/filme/1
```

Usando curl (Linux/macOS / Git Bash no Windows):

```bash
# Criar filme
curl -X POST http://localhost:8080/api/filme \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Matrix","diretor":"Lana Wachowski","anoLancamento":1999,"genero":"Ficção Científica"}'

# Listar todos
curl http://localhost:8080/api/filme

# Buscar por id
curl http://localhost:8080/api/filme/1
```

## H2 Console

- URL do console H2: http://localhost:8080/h2-console
- JDBC URL (definido em `application.yaml`): `jdbc:h2:mem:cinespringdb`
- Usuário: `sa` / senha: em branco

## Como executar (Windows PowerShell)

1) Usando o wrapper Maven (recomendado):

```powershell
# Executar direto (modo desenvolvimento)
.\mvnw.cmd spring-boot:run

# Ou gerar JAR e executar:
.\mvnw.cmd clean package
java -jar .\target\desafio-0.0.1-SNAPSHOT.jar
```

2) Com Maven instalado diretamente:

```powershell
mvn spring-boot:run
```

## Testes

O projeto inclui dependências de teste no `pom.xml`. Para rodar os testes:

```powershell
.\mvnw.cmd test
```

## Observações sobre validação e tratamento de erros

- A entidade `Filme` possui anotações de validação (`@NotBlank`, `@Min`, `@Max`) e o `FilmeController` utiliza `@Valid` no endpoint de criação. Isto impede que filmes com título/diretor/gênero em branco sejam persistidos — o Spring retornará 400 Bad Request em caso de violação de validação.
- A busca por ID atualmente lança `RuntimeException` quando não encontra o filme. Recomendo criar uma exceção específica (ex: `ResourceNotFoundException`) e um `@ControllerAdvice` para mapear para 404 Not Found e payloads de erro amigáveis.

## Status do repositório

Este repositório é um repositório de estudo. A ideia foi criar uma API básica funcionando e, a partir daqui, evoluir gradualmente a aplicação adicionando melhorias de arquitetura, testes e documentação. Sinta-se à vontade para abrir sugestões, issues ou pull requests com propostas de melhorias — este é um espaço de aprendizado.
