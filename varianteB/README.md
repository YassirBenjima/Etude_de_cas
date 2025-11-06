# Variante B (Spring Boot + @RestController)

   Application REST API utilisant Spring Boot (Web + Data JPA) avec PostgreSQL.

## Prérequis

   - **Java 21** 
   - **Maven 3.8+**
   - **PostgreSQL** installé et en cours d'exécution

## Configuration de la base de données

   1. Créez la base de données PostgreSQL :
      ```sql
      CREATE DATABASE variante_b_db;
      ```
   2. Vérifiez/modifiez les propriétés dans `src/main/resources/application.properties` :
      - `spring.datasource.url=jdbc:postgresql://localhost:5432/variante_b_db`
      - `spring.datasource.username=postgres`
      - `spring.datasource.password=postgres`
      - `spring.jpa.hibernate.ddl-auto=update`

## Lancement de l'application

   ```bash
   mvn clean spring-boot:run
   ```
   
   L'application sera accessible à : `http://localhost:8080`

## Endpoints REST

   Paramètres de pagination supportés : `page` (0-based) et `size`.

### Catégories

   - GET `http://localhost:8080/categories?page=0&size=10`
   
   <img width="1542" height="993" alt="image" src="https://github.com/user-attachments/assets/632e871d-5b10-4e4d-ae04-9404ca8299aa" />
   
   - GET `http://localhost:8080/categories/{id}`
   
   <img width="1537" height="994" alt="image" src="https://github.com/user-attachments/assets/65f5533d-abd5-4be0-b6af-83732ff910fa" />
   
   - POST `http://localhost:8080/categories`
   
   ```json
   {
     "code": "ELEC",
     "name": "Électronique"
   }
   ```
   
   <img width="1534" height="986" alt="image" src="https://github.com/user-attachments/assets/9cedc1eb-6565-4ec6-b664-369d1edf7b6b" />
   
   - PUT `http://localhost:8080/categories/{id}`
   
   ```json
   {
     "code": "ELEC",
     "name": "Électronique et gadgets"
   }
   ```
   
   <img width="1538" height="984" alt="image" src="https://github.com/user-attachments/assets/9f2f44ea-2ab0-427d-9f5b-801c6b508034" />
   
   - DELETE `http://localhost:8080/categories/{id}`
   
   <img width="1533" height="986" alt="image" src="https://github.com/user-attachments/assets/af96ba7f-aab7-4e5b-a132-7bf58982d424" />
   
   - GET `http://localhost:8080/categories/{id}/items`
   
   <img width="1539" height="987" alt="image" src="https://github.com/user-attachments/assets/671cca5c-1687-4d73-ace8-bb73c7b22244" />
   
   ### Items (Produits)
   
   - GET `http://localhost:8080/items?page=0&size=10`
   
   <img width="1539" height="995" alt="image" src="https://github.com/user-attachments/assets/4c1929df-bbc0-4b7a-a6fb-b03d51394421" />
   
   - GET `http://localhost:8080/items/{id}`
   
   <img width="1545" height="988" alt="image" src="https://github.com/user-attachments/assets/65f2043a-ae36-4b33-8a97-8a89b93a4c5c" />
   
   - GET `http://localhost:8080/items?categoryId={categoryId}`
   
   <img width="1533" height="987" alt="image" src="https://github.com/user-attachments/assets/a7052f51-a8f2-4c0a-a745-ecab249e7fb5" />
   
   - POST `http://localhost:8080/items`
   
   ```json
   {
     "name": "iPhone 15",
     "price": 1299.99,
     "stock": 25,
     "category": { "id": 1 }
   }
   ```
   
   <img width="1542" height="980" alt="image" src="https://github.com/user-attachments/assets/285aa56d-8033-46b8-907e-f8e5ff05dc83" />

   - PUT `http://localhost:8080/items/{id}`
   
   ```json
   {
     "name": "iPhone 15 Pro",
     "price": 1399.99,
     "stock": 20,
     "category": { "id": 1 }
   }
   ```
   
   <img width="1542" height="986" alt="image" src="https://github.com/user-attachments/assets/c4c455eb-6157-4079-8ff4-dd1af004cf1b" />

   - DELETE `http://localhost:8080/items/{id}`

   <img width="1540" height="991" alt="image" src="https://github.com/user-attachments/assets/3e8f3d91-b44a-4b98-84dd-3da920e5afed" />
