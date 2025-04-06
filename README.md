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
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)
- [Screenshots](#screenshots)

---

## Tech Stack

- **Java 21** + Spring Boot 3.4.4
- **Angular** (with `ng2-charts` for real-time visualization)
- **STOMP over WebSocket** for data streaming
- **Maven** for backend builds
- **Node.js + npm** for frontend

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

```bash
cd uartsimulation
mvn spring-boot:run
```

3. Open another terminal and start the frontend:

```bash
cd uart-frontend
npm install
npm start
```

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


## Author
Alon 

## Screenshots

![image](https://github.com/user-attachments/assets/b73de080-b8a4-487c-aacd-0c291d317fba)

![image](https://github.com/user-attachments/assets/3858febe-1964-49a4-bd3f-60c85f9b0f50)






