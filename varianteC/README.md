# Variante C (Spring Data REST + HATEOAS)

Application REST HAL auto-exposée avec Spring Data REST, Spring Data JPA et PostgreSQL. Les ressources sont sous le préfixe `/api`.

## Prérequis

- **Java 21** (selon `pom.xml`)
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
- GET `/api/categories/{id}`
- POST `/api/categories`
  - Corps exemple:
  ```json
  { "code": "ELEC", "name": "Électronique" }
  ```
- PUT `/api/categories/{id}`
  ```json
  { "code": "ELEC", "name": "Électronique et gadgets" }
  ```
- DELETE `/api/categories/{id}`
- Relation inverse (items d'une catégorie) : GET `/api/categories/{id}/items`

### Items (`/api/items`)

- GET `/api/items?page=0&size=10`
- GET `/api/items/{id}`
- Recherche par catégorie (paginée) :
  - GET `/api/items/search/byCategory?categoryId={id}&page=0&size=10`
- POST `/api/items`
  - Corps exemple:
  ```json
  {
    "name": "iPhone 15",
    "price": 1299.99,
    "stock": 25,
    "category": "http://localhost:8080/api/categories/1"
  }
  ```
- PUT `/api/items/{id}`
  ```json
  {
    "name": "iPhone 15 Pro",
    "price": 1399.99,
    "stock": 20,
    "category": "http://localhost:8080/api/categories/1"
  }
  ```
- DELETE `/api/items/{id}`

## HATEOAS

- Spring Data REST retourne par défaut du HAL (`_links`, `_embedded`).
- Chaque ressource inclut un lien `self`, et des liens vers les relations (ex: `category` pour un item, `items` pour une catégorie).

## Notes

- Les entités `Category` et `Item` sont liées via `@OneToMany` / `@ManyToOne`.
- L'association inverse est accessible via `/api/categories/{id}/items`.
- La sérialisation standard ignore le champ `Category.items` pour éviter la récursion; les liens HAL restent exposés.
