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

- GET `http://localhost:8080/varianteA/api/categories/{{id}}`

- POST `http://localhost:8080/varianteA/api/categories`

```json
{
  "code": "ELEC",
  "name": "Électronique"
}
```

- PUT `http://localhost:8080/varianteA/api/categories/{{id}}`

```json
{
  "code": "ELEC",
  "name": "Électronique et gadgets"
}
```

- DELETE `http://localhost:8080/varianteA/api/categories/{{id}}`

- GET `http://localhost:8080/varianteA/api/categories/{{id}}/items`
  - Retourne tous les items associés à la catégorie.

### Items (Produits)

- GET `http://localhost:8080/varianteA/api/items?page=0&size=10`

- GET `http://localhost:8080/varianteA/api/items/{{id}}`

- GET `http://localhost:8080/varianteA/api/items?categoryId={{categoryId}}`

  - Tous les items d’une catégorie donnée.

- POST `http://localhost:8080/varianteA/api/items`

```json
{
  "name": "iPhone 15",
  "price": 1299.99,
  "stock": 25,
  "category": { "id": 1 }
}
```

- PUT `http://localhost:8080/varianteA/api/items/{{id}}`

```json
{
  "name": "iPhone 15 Pro",
  "price": 1399.99,
  "stock": 20,
  "category": { "id": 1 }
}
```

- DELETE `http://localhost:8080/varianteA/api/items/{{id}}`


