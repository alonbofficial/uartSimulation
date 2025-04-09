# UART Simulation Project

A real-time full-stack simulation of UART sensor data using **Spring Boot (Java 21)** and **Angular**. This project simulates temperature and humidity sensor data, streams it in real-time via WebSocket (STOMP), and visualizes the data using Angular and ng2-charts. It is designed for seamless operation in both **GitHub Codespaces** and local development environments.

---

## Table of Contents

- [Tech Stack](#tech-stack)
- [Features](#features)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Running in GitHub Codespaces](#running-in-github-codespaces)
  - [Running Locally](#running-locally)
- [WebSocket Configuration](#websocket-configuration)
- [Java Version Troubleshooting](#java-version-troubleshooting)
- [Troubleshooting](#troubleshooting)
- [H2 Database](#H2-database)
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)

---

## Tech Stack

- **Java 21** + Spring Boot 3.4.4
- **Angular** (with `ng2-charts` for real-time visualization)
- **STOMP over WebSocket** for data streaming
- **Maven** for backend builds
- **Node.js + npm** for frontend
- **H2** for database interaction

---

## Features

- **Sensor Simulation:** Generates simulated temperature and humidity readings.
- **Real-Time Streaming:** Uses WebSocket (STOMP) to stream data in real time.
- **Live Visualization:** Displays live charts using Angular and ng2-charts.
- **Responsive Updates:** Implements Angular’s ChangeDetectorRef for fast UI updates.
- **Dual Environment Support:** Ready for both GitHub Codespaces and local development.

---

## Project Structure

uartSimulation/
├── uartsimulation/       # Spring Boot backend
│   └── src/main/java/... # REST + WebSocket logic
├── uart-frontend/        # Angular frontend
│   └── src/app/...       # Chart + WebSocket UI

---

## Getting Started

### Prerequisites

- **Java 21** (verify with `java -version`)
- **Node.js** and **npm**
- **Maven**
- **Angular CLI** (for local development)

Install Angular CLI globally if needed:

```bash
npm install -g @angular/cli
```

### Running in GitHub Codespaces

1. Launch the Codespace from this GitHub repository.

2. Open a terminal and start the backend:

cd uartsimulation
mvn spring-boot:run

3. Open another terminal and start the frontend:

cd uart-frontend
npm install
npm start

4. Open the forwarded ports (8080 for backend, 4200 for frontend) using the Ports tab in Codespaces.

### Running in GitHub Codespaces

1. **Launch the Codespace** from this GitHub repository.
2. **Start the Backend:**
   - Open a terminal and run:
     ```bash
     cd uartsimulation
     mvn spring-boot:run
     ```
3. **Start the Frontend:**
   - Open another terminal and run:
     ```bash
     cd uart-frontend
     npm install
     npm start
     ```
4. **Access the Application:**
   - Use the Codespaces **Ports** tab to forward:
     - **Port 8080** for the backend
     - **Port 4200** for the frontend

---

### Running Locally

1. **Ensure Your Environment Is Set Up:**
   - Java 21 is installed and active (verify with `java -version`)
   - Node.js and npm are installed
   - Angular CLI is installed (verify with `ng version`)
2. **Start the Backend:**
   ```bash
   cd uartsimulation
   mvn spring-boot:run
3. **Start the Frontend:**
   ```bash
    cd uart-frontend
    npm install
    npm start
    ```
4. **Access the Application:**
   Open your browser and navigate to http://localhost:4200


---

## WebSocket Configuration

This project uses WebSocket via SockJS to stream real-time data.

## In GitHub Codespaces

Update the WebSocket connection in the Angular app to use the full Codespaces backend URL:
```bash
new SockJS('https://<your-backend-8080-url>.github.dev/ws');
```
Use a relative path for the WebSocket connection:
```bash
new SockJS('/ws');
```

### Java Version Troubleshooting

If you encounter issues running the backend, make sure Java 21 is selected:

java -version

To switch Java versions in Codespaces:

sudo update-alternatives --config java

Or export it manually in your shell config:

export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH




## Features

- Simulates temperature and humidity readings
- Streams real-time sensor data using WebSocket (STOMP)
- Displays live charts with Angular + ng2-charts
- Responsive and fast updates using ChangeDetectorRef

## Troubleshooting

404 on /ws or WebSocket not connecting?

- Make sure backend is running and accessible.

- Double-check that the correct WebSocket URL is used based on environment (local vs Codespaces).

- Ensure the WebSocket endpoint /ws is properly configured and publicly exposed in Codespaces.


Frontend not displaying data?

- Open browser dev tools → Network tab → check for errors
- Confirm WebSocket is connected
- Verify backend is sending messages to /topic/data


## H2 Database

### Steps to Access H2 Console in GitHub Codespaces

1. Start your Spring Boot application.
   - Make sure it's running without errors.

2. Expose the port in Codespaces.
   - GitHub Codespaces doesn't expose all ports by default.
   - The H2 console will be available on the port your Spring Boot app is running on (usually 8080).
   - In the Codespaces IDE (e.g., VS Code), click on the Ports tab.
      - If it’s not visible, go to View → Ports.
   - Look for port 8080 (or whatever port you're using), and make sure it’s Public.
      - Right-click → Make Public, if not already.

3. Open the H2 Console in your browser.
   - Use the forwarded URL for port 8080 in Codespaces.
   - The URL will look like:
   ```bash
   https://<your-username>-uartsimulation-8080.<random-string>.github.dev/h2-console
   ```
   - My link for H2 DB is the folllowing:
   ```bash
      https://ubiquitous-space-xylophone-95q55gjprgq39p5g-8080.app.github.dev/h2-console
   ```
4. Login to the H2 Console:
   - JDBC URL: 
   ```bash 
   jdbc:h2:mem:hardware
   ```
   - User Name: sa
   - Password: (leave it blank)
### Notes
- Since you're using mem: (in-memory) database, it will be lost when the app restarts.
- If you want persistence, you can change to a file-based DB:
```bash
spring.datasource.url=jdbc:h2:file:~/data/hardware
```
This stores the DB in a file under the Codespaces home directory.

Do not forget to change the field "JDBC URL" to:
```bash
jdbc:h2:file:~/data/hardware
```

## Author
Alon 











