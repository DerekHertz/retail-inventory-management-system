# Derek's Garden Kits Inventory Application

This is a Spring Boot web application for managing inventory and sales of garden kits and parts, including both handcrafted and supplier-sourced items. The application provides a user-friendly interface for tracking products, managing inventory, and handling sales transactions.

## Features

- **Inventory Management**: Add, update, and delete garden parts (handcrafted and supplier).
- **Product Management**: Create, update, and delete garden kits (products) composed of multiple parts.
- **Inventory Validation**: Ensures inventory levels are within allowed min/max bounds.
- **Product Validation**: Validates that product price is greater than the sum of its parts and that there are enough parts in stock.
- **Sales**: Buy garden kits, decrementing inventory accordingly.
- **Search & Filter**: Filter parts and products by keyword.
- **Bootstrap Data**: Loads sample data on first run for demonstration.
- **Thymeleaf UI**: Responsive web interface using Thymeleaf templates and Bootstrap.
- **H2 Database**: Uses an embedded H2 database for development and testing.

## Project Structure

- `src/main/java/com/example/demo/`
  - **domain/**: Entity classes (`Product`, `Part`, `HandCrafted`, `Supplier`)
  - **repositories/**: Spring Data JPA repositories
  - **service/**: Service interfaces and implementations for business logic
  - **controllers/**: Spring MVC controllers for handling web requests
  - **validators/**: Custom validation annotations and logic
  - **bootstrap/**: Loads initial data on startup

- `src/main/resources/`
  - **templates/**: Thymeleaf HTML templates for UI
  - **static/**: Static resources (CSS, images)
  - **application.properties**: Spring Boot configuration

- `src/test/java/com/example/demo/`: Unit and integration tests

## Main Screens

- **Main Screen**: View, earch, and manage all parts and products.
- **Add/Update Part**: Forms for adding or editing handcrafted or supplier parts.
- **Add/Update Product**: Forms for creating or editing garden kits, associating parts.
- **Buy Kit**: Purchase a kit, decrementing inventory.
- **About**: Information about Derek's Garden Kits.

## Validation

- Inventory cannot exceed max or fall below min.
- Product price must be greater than the sum of its parts.
- Cannot delete a part if it is used in a product.
- Cannot reduce part inventory below minimum when updating products.

## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring MVC
- Thymeleaf
- H2 Database
- JUnit & Mockito (for testing)
- Bootstrap (for UI)

## Customization

- Update initial inventory and products in [`BootStrapData`](src/main/java/com/example/demo/bootstrap/BootStrapData.java)
- Change database settings in [`application.properties`](src/main/resources/application.properties)
- Modify UI in [`templates/`](src/main/resources/templates/)

## License

This project is for educational/demo purposes.


