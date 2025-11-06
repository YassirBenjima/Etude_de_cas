# Variante C (Spring Data REST + HATEOAS)

Application REST HAL auto-exposée avec Spring Data REST, Spring Data JPA et PostgreSQL. Les ressources sont sous le préfixe `/api`.

## Prérequis
   
   - **Java 21**
   - **Maven 3.8+**
   - **PostgreSQL** installé et en cours d'exécution

## Configuration de la base de données

   1. Créez la base de données PostgreSQL :
      ```sql
      CREATE DATABASE variante_c_db;
      ```
   2. Vérifiez/modifiez les propriétés dans `src/main/resources/application.properties` :
      - `spring.datasource.url=jdbc:postgresql://localhost:5432/variante_c_db`
      - `spring.datasource.username=postgres`
      - `spring.datasource.password=postgres`
      - `spring.jpa.hibernate.ddl-auto=update`
      - `spring.data.rest.base-path=/api`

## Lancement de l'application

   ```bash
   mvn clean spring-boot:run
   ```
   
   Racine HAL : `http://localhost:8080/api` (expose les liens `_links`).

## Endpoints REST exposés automatiquement

   Pagination supportée via `page` (0-based) et `size`. Les réponses sont HATEOAS (HAL+JSON).

### Catégories (`/api/categories`)

   - GET `/api/categories?page=0&size=10`
   
   <img width="1542" height="987" alt="image" src="https://github.com/user-attachments/assets/e73427d1-110f-400a-8634-813d95541188" />

   - GET `/api/categories/{id}`

   <img width="1540" height="984" alt="image" src="https://github.com/user-attachments/assets/1b674833-896f-4ad6-a3b3-548ae7246919" />

   - POST `/api/categories`
     ```json
     { "code": "ELEC", "name": "Électronique" }
     ```
   
   <img width="1541" height="984" alt="image" src="https://github.com/user-attachments/assets/75c42174-65d5-4e27-acb0-275c741377a6" />

   - PUT `/api/categories/{id}`
     ```json
     { "code": "ELEC", "name": "Électronique et gadgets" }
     ```
   
   <img width="1539" height="984" alt="image" src="https://github.com/user-attachments/assets/b8da3905-3a08-4f31-85c2-f5f4e126f58d" />

   - DELETE `/api/categories/{id}`

   <img width="1538" height="990" alt="image" src="https://github.com/user-attachments/assets/6d5ea6e8-cf31-4173-bd63-38688cd26fee" />

   - Relation inverse (items d'une catégorie) : GET `/api/categories/{id}/items`
   
   ### Items (`/api/items`)
   
   - GET `/api/items?page=0&size=10`

   <img width="1541" height="985" alt="image" src="https://github.com/user-attachments/assets/e8ac0da7-202b-482e-801f-a86ca4a75e54" />

   - GET `/api/items/{id}`

   <img width="1542" height="983" alt="image" src="https://github.com/user-attachments/assets/b04a0a44-ff58-4d56-8428-63e94b3416f2" />

   - Recherche par catégorie (paginée) :
   - GET `/api/items/search/byCategory?categoryId={id}&page=0&size=10`

   <img width="1539" height="985" alt="image" src="https://github.com/user-attachments/assets/4b22fbd0-ba10-4b8b-86a5-317c0f1790ae" />

   - POST `/api/items`
     ```json
     {
       "name": "iPhone 15",
       "price": 1299.99,
       "stock": 25,
       "category": "http://localhost:8080/api/categories/1"
     }
     ```

     <img width="1544" height="987" alt="image" src="https://github.com/user-attachments/assets/8569afcb-9380-4716-8eaa-2248ab16754f" />

   - PUT `/api/items/{id}`
     ```json
     {
       "name": "iPhone 15 Pro",
       "price": 1399.99,
       "stock": 20,
       "category": "http://localhost:8080/api/categories/1"
     }
     ```
   
   <img width="1540" height="986" alt="image" src="https://github.com/user-attachments/assets/dfe30546-646a-4271-acd0-5c79d0bb7460" />

   - DELETE `/api/items/{id}`

   <img width="1542" height="987" alt="image" src="https://github.com/user-attachments/assets/0fbf87b2-0812-477d-bcb1-896d76a71e65" />

