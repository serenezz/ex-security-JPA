# Exercise: JPA Hibernate with H2 Database using Spring Boot and Spring Security

This exercise demonstrates authentication and authorization with roles using JPA Hibernate, backed by an H2 in-memory database.

## Endpoints

### GET `/api/allusers`

- **Description**: Endpoint accessible to all users.
- **Security**: Open to all users.
- **Response**: Returns a message indicating it's open to all users.

### GET `/api/manager`

- **Description**: Endpoint accessible to users with roles MANAGER or ADMIN.
- **Security**: Requires ROLE_MANAGER or ROLE_ADMIN role.
- **Response**: Returns a message with the username accessing the manager API.

### GET `/api/admin`

- **Description**: Endpoint accessible to users with role ADMIN.
- **Security**: Requires ROLE_ADMIN role.
- **Response**: Returns a message with the username accessing the admin API.

## Implementation Details

### Security Configuration

- **UserDetailsManager**: Manages user details using JPA repository.
- **LoadByUsername**: Loads user details by username.
- **Role-based Access Control**: Configured using `@PreAuthorize` annotations for endpoint access based on user roles.