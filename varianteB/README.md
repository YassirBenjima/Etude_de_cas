# Variante B (Spring Boot + @RestController)

Application REST API utilisant Spring Boot (Web + Data JPA) avec PostgreSQL.

## Prérequis

- **Java 21** (selon `pom.xml`)
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
- GET `http://localhost:8080/categories/{id}`
- POST `http://localhost:8080/categories`

```json
{
  "code": "ELEC",
  "name": "Électronique"
}
```

- PUT `http://localhost:8080/categories/{id}`

```json
{
  "code": "ELEC",
  "name": "Électronique et gadgets"
}
```

- DELETE `http://localhost:8080/categories/{id}`
- GET `http://localhost:8080/categories/{id}/items`

### Items (Produits)

- GET `http://localhost:8080/items?page=0&size=10`
- GET `http://localhost:8080/items/{id}`
- GET `http://localhost:8080/items?categoryId={categoryId}`
- POST `http://localhost:8080/items`

```json
{
  "name": "iPhone 15",
  "price": 1299.99,
  "stock": 25,
  "category": { "id": 1 }
}
```

- PUT `http://localhost:8080/items/{id}`

```json
{
  "name": "iPhone 15 Pro",
  "price": 1399.99,
  "stock": 20,
  "category": { "id": 1 }
}
```

- DELETE `http://localhost:8080/items/{id}`

## Notes

- Les entités `Category` et `Item` sont liées via `@OneToMany` et `@ManyToOne`.
- L'API renvoie les items d'une catégorie via `GET /categories/{id}/items` ou le filtre `GET /items?categoryId=...`.
- La sérialisation JSON ignore `Category.items` pour éviter la récursion infinie.
