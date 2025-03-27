#  API devForneria

API desenvolvida em **Java com Spring Boot** para gerenciar reservas de restaurante.

##  Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Banco de dados PostgreSQL

---

##  Como Rodar o Projeto

1. **Clone o repositório:**
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. **Configure o projeto no seu IDE (IntelliJ, Eclipse, VS Code).**

3. **Execute a aplicação:**  
   - No terminal, use:
     ```sh
     gradlew build
     gradlew bootRun
     ```

4. **Acesse a API em:**  
   - [`http://localhost:8080`](http://localhost:8080)  

---

#  Endpoints da API

##  **Usuários**

### **Listar usuários**
`GET /users`  
Retorna uma lista de todas os usuários cadastradas.

####  Exemplo de resposta:
```json
[
    {
        "id": 1,
        "name": "João Silva",
        "email": "joao@email.com",
        "password": "hash_da_senha",
        "role": "cliente"
    },
    {
        "id": 2,
        "name": "Lucas Roveder",
        "email": "lucas@email.com",
        "password": "123",
        "role": "cliente"
    }
]
```

---

###  **Buscar uma usuário pelo ID**
`GET /users/{id}`  
Retorna um usuário específica pelo seu ID.

####  Exemplo de resposta:
```json
{
    "id": 2,
    "name": "Lucas Roveder",
    "email": "lucas@email.com",
    "password": "123",
    "role": "cliente"
}
```

---

###  **Criar um novo usuário**
`POST /users`  
Adiciona um novo usuário.

####  Exemplo de requisição:
```json

{
    "name": "user123",
    "email": "user123@email.com",
    "password": "hash_da_senha",
    "role": "cliente"
}
```

####  Exemplo de resposta (201 Created):
```json
{
    "id": 3,
    "name": "user123",
    "email": "user123@email.com",
    "password": "hash_da_senha",
    "role": "cliente"
}
```

---

### **Atualizar um usuário pelo ID**
`PUT /streams/{id}`  
Atualiza um usuário existente.

####  Exemplo de requisição:
```json
{
    "id": 3,
    "name": "Amanda",
    "email": "amanda@email.com",
    "password": "amandinha123",
    "role": "cliente"
}
```

####  Resposta (204 No Content):
Nada é retornado, pois a atualização foi bem-sucedida.

---

###  **Excluir uma usuário pelo ID**
`DELETE /streams/{id}`  
Remove uma usuário da lista.

####  Resposta (204 No Content):
Nada é retornado, pois a exclusão foi bem-sucedida.

---

##  Como Contribuir

1. **Fork** este repositório.
2. **Crie uma branch:**  
   ```sh
   git checkout -b minha-feature
   ```
3. **Faça suas alterações e commit:**  
   ```sh
   git commit -m "Adicionando nova funcionalidade"
   ```
4. **Envie para o repositório remoto:**  
   ```sh
   git push origin minha-feature
   ```
5. **Crie um Pull Request.**

---
