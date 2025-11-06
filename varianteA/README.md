# Variante A (Jersey + Hibernate)

Application REST API utilisant Jersey et Hibernate avec PostgreSQL.

## Prérequis

   - **Java 11** ou supérieur
   - **Maven 3.6+**
   - **PostgreSQL** installé et en cours d'exécution
   - Base de données `variante_a_db` créée (ou modifiez la configuration dans `persistence.xml`)

## Configuration de la base de données

   1. Assurez-vous que PostgreSQL est installé et en cours d'exécution
   2. Créez la base de données :
      ```sql
      CREATE DATABASE variante_a_db;
      ```
   3. Vérifiez/modifiez les paramètres de connexion dans `src/main/resources/META-INF/persistence.xml` :
      - URL : `jdbc:postgresql://localhost:5432/variante_a_db`
      - User : `postgres`
      - Password : `postgres` (modifiez selon votre configuration)

## Lancement de l'application

   Cette méthode lance l'application directement avec un serveur Jetty embarqué :
   
   ```bash
   mvn clean jetty:run
   ```
   
   L'application sera accessible à : `http://localhost:8080/varianteA/api`
   
   Pour arrêter l'application, appuyez sur `Ctrl+C` dans le terminal.

## Tests Postman

   Ce guide explique comment tester les endpoints REST avec Postman.

### Catégories

   - GET `http://localhost:8080/varianteA/api/categories?page=0&size=10`
   
   <img width="1543" height="989" alt="image" src="https://github.com/user-attachments/assets/d19d2b3a-87e6-4824-8783-15d063211444" />
   
   - GET `http://localhost:8080/varianteA/api/categories/{{id}}`
   
   <img width="1540" height="986" alt="image" src="https://github.com/user-attachments/assets/b0125d4e-8f3a-4b4f-a6a1-fd4ad854faaa" />
   
   - POST `http://localhost:8080/varianteA/api/categories`
   
   ```json
   {
     "code": "ELEC",
     "name": "Électronique"
   }
   ```
   
   <img width="1534" height="982" alt="image" src="https://github.com/user-attachments/assets/6ed7690b-de84-4b19-855f-3d2f4e5aa234" />
   
   - PUT `http://localhost:8080/varianteA/api/categories/{{id}}`
   
   ```json
   {
     "code": "ELEC",
     "name": "Électronique et gadgets"
   }
   ```
   
   <img width="1546" height="986" alt="image" src="https://github.com/user-attachments/assets/93ff5417-2d83-4d9b-8658-242b350413e7" />
   
   - DELETE `http://localhost:8080/varianteA/api/categories/{{id}}`
   
   <img width="1548" height="1041" alt="image" src="https://github.com/user-attachments/assets/cac4ab2e-e959-4c16-9c0c-d487ace2dafa" />
   
   - GET `http://localhost:8080/varianteA/api/categories/{{id}}/items`
     - Retourne tous les items associés à la catégorie.
   
   <img width="1542" height="989" alt="image" src="https://github.com/user-attachments/assets/7b803e6c-2c55-4d8a-9466-4d6939463bb6" />
   
   ### Items (Produits)
   
   - GET `http://localhost:8080/varianteA/api/items?page=0&size=10`
   
   <img width="1538" height="988" alt="image" src="https://github.com/user-attachments/assets/978d5238-6686-4a61-9120-7d6ee052b0a4" />
   
   - GET `http://localhost:8080/varianteA/api/items/{{id}}`
   
   <img width="1538" height="979" alt="image" src="https://github.com/user-attachments/assets/58b7339f-2fd1-40e3-a0cb-51739ad4102c" />
   
   - GET `http://localhost:8080/varianteA/api/items?categoryId={{categoryId}}`
   
     - Tous les items d’une catégorie donnée.
   
   <img width="1541" height="986" alt="image" src="https://github.com/user-attachments/assets/e8f346a4-d478-430a-be7b-bee32093542f" />
   
   - POST `http://localhost:8080/varianteA/api/items`
   
   ```json
   {
     "name": "iPhone 15",
     "price": 1299.99,
     "stock": 25,
     "category": { "id": 1 }
   }
   ```
   
   <img width="1539" height="950" alt="image" src="https://github.com/user-attachments/assets/8763a7d9-a400-4d5a-acf6-ea655e098779" />
   
   - PUT `http://localhost:8080/varianteA/api/items/{{id}}`
   
   ```json
   {
     "name": "iPhone 15 Pro",
     "price": 1399.99,
     "stock": 20,
     "category": { "id": 1 }
   }
   ```
   
   <img width="1534" height="986" alt="image" src="https://github.com/user-attachments/assets/4453d548-b2e5-4d83-868c-7e32db5372c3" />
   
   - DELETE `http://localhost:8080/varianteA/api/items/{{id}}`
   
   <img width="1537" height="986" alt="image" src="https://github.com/user-attachments/assets/f29466d7-3acd-4f1a-ac8c-77819b2fc18b" />

