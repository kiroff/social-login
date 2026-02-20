# Social Login

This is a demonstration Spring Boot application for implementing **Social Login** using **OAuth2** and **OpenID Connect (OIDC)**. The project demonstrates integration with external Identity Providers (such as Google) for user authentication.

## Tech Stack

*   **Java 25**
*   **Spring Boot 4.0.3**
*   **Spring Security (OAuth2 Client)**
*   **Thymeleaf** (with Spring Security 6 extension)
*   **Maven**

## Features

*   **Social Login:** Capability to log in via a Google profile.
*   **Custom Home Page:** After successful authentication, the user is redirected to `/home`, where their name from the OAuth2 profile is displayed.
*   **Security:** Use of `SecurityFilterChain` to define public and protected resources.
*   **Logout:** Support for logging out and returning to the index page.

## Prerequisites

1.  **Java 25** or newer.
2.  **Maven 3.9.0** or newer.
3.  **Google Cloud Project:** Configured OAuth2 credentials (Client ID and Client Secret) in the Google Cloud Console.

## Configuration

Main OAuth2 client settings are located in `src/main/resources/application.yaml`.

```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: <YOUR_CLIENT_ID>
            client-secret: <YOUR_CLIENT_SECRET>
```

The project is currently configured with test keys for Google.

## Running the Application

You can start the application using the Maven wrapper:

```bash
./mvnw spring-boot:run
```

The application will start on port `8080` (by default). Go to `http://localhost:8080` to see the index page.

## Project Structure

*   `src/main/java/org/kiroff/clients/social_login/controllers` - Controllers for the home and index pages.
*   `src/main/java/org/kiroff/clients/social_login/security` - Spring Security configuration.
*   `src/main/resources/templates` - HTML templates (Thymeleaf).
*   `src/main/resources/application.yaml` - Main configuration.

## Author
**Boyan G. Kiroff**
*   Email: boyan@kiroff.org
*   Website: [https://www.kiroff.org](https://www.kiroff.org)
