# Arrangement-app

Et REST API med tilhørende enkel frontend for å opprette arrangementer og melde seg på dem, med kapasitetsgrenser og automatisk venteliste når et arrangement er fullt.

<img width="496" height="859" alt="arrangement" src="https://github.com/user-attachments/assets/ac7d2e04-7c9a-4e53-a028-442bc8ad08a4" />

## Funksjonalitet

- Brukerregistrering og innlogging med JWT-autentisering
- Opprette og hente arrangementer
- Melde seg på arrangementer, med automatisk venteliste når kapasiteten er nådd
- Enkelt web-grensesnitt for å teste alt uten Postman

## Teknologier

- **Backend:** Java 17, Spring Boot, Spring Security, Spring Data JPA
- **Database:** PostgreSQL
- **Frontend:** HTML, CSS, JavaScript (uten rammeverk)
- **Autentisering:** JWT (JSON Web Tokens)
- **Container:** Docker og Docker Compose
- **Testing:** JUnit og Mockito

## Kjøre prosjektet

Krever kun Docker Desktop installert.

\`\`\`bash
docker compose up --build
\`\`\`

Appen er da tilgjengelig på `http://localhost:8080/index.html`.

## API-endepunkter

| Metode | Endepunkt | Beskrivelse | Krever innlogging |
|---|---|---|---|
| POST | `/users/register` | Registrer ny bruker | Nei |
| POST | `/auth/login` | Logg inn, returnerer JWT-token | Nei |
| GET | `/events` | Hent alle arrangementer | Ja |
| POST | `/events` | Opprett nytt arrangement | Ja |
| GET | `/events/{id}/registrations` | Hent påmeldte til et arrangement | Ja |
| POST | `/events/{id}/registrations` | Meld på et arrangement | Ja |

## Hva jeg lærte

Dette var mitt første prosjekt med Spring Boot, PostgreSQL, JPA-relasjoner og JWT-autentisering. Jeg brukte AI som støtte for å forstå nye konsepter, feilsøke underveis og forsto koden selv.
