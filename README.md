# Reserva-Hotel
------------------------------------------------------------------------------------------------------------------
Um sistema CRUD em Java para gestão de reservas de hotel, com persistência de dados em banco de dados relacional PostgreSQL via JDBC.

------------------------------------------------------------------------------------------------------------------
 📖 Sobre o Projecto

Este projecto foi desenvolvido com foco em consolidar conhecimentos de conexão com banco de dados relacional, validação de regras de domínio e boas práticas de arquitectura em Java. 
A aplicação permite gerir reservas de hotel, garantindo a integridade das datas de entrada e saída antes de persistir qualquer dado.

A aplicação permite realizar as operações fundamentais de um CRUD:

- ✅ Criar uma nova reserva
- ✅ Listar todas as reservas
- ✅ Buscar reserva por ID
- ✅ Actualizar dados de uma reserva
- ✅ Remover uma reserva

- Validação de domínio: A entidade `Reserva` impede a criação de reservas com datas no passado ou com a data de saída anterior/igual à data de entrada, lançando `DominioExceptions` quando as regras não são respeitadas.
-- -------------------------------------------------------------------------------------------------------------
⚙️ Pré-requisitos

- Java 21+
- PostgreSQL instalado e em execução
- Maven (para gestão de dependências)
- IDE recomendada: IntelliJ IDEA

- ----------------------------------------------------------------------------------------------------------------
🚀 Como Executar

 1. Clone o repositório

```bash
git clone https://github.com/SEU_USUARIO/Reserva-Hotel.git
cd Reserva-Hotel
```
-----------------------------------------------------------------------------------------------------------------
📌 Padrões e Conceitos Utilizados

- Singleton Pattern — `DataBaseConnection.java` garante uma única instância de conexão
- Repository Pattern — `ReservaRepositoryInterface` desacopla contrato da implementação
- JDBC — comunicação directa com o banco usando `PreparedStatement`
- Optional — tratamento seguro de resultados nulos no `findById`
- Excepções de domínio — `DominioExceptions` valida regras de negócio na própria entidade
- try-with-resources — gestão automática do fecho de `Connection`/`PreparedStatement
------------------------------------------------------------------------------------------------------------------
🛠️ Tecnologias

![Java](https://img.shields.io/badge/Java-21-orange?style=flat&logo=java)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue?style=flat&logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-build-red?style=flat&logo=apachemaven)

------------------------------------------------------------------------------------------------------------------
📄 Licença

Este projecto está licenciado sob a licença **MIT**. Consulte o ficheiro [LICENSE](LICENSE) para mais detalhes.

------------------------------------------------------------------------------------------------------------------
👨‍💻 Autor

 Shelton Chambule
- GitHub: [@Shelton-Chambule-Dev](https://github.com/Shelton-Chambule-Dev)


