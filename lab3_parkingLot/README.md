# Parking Lot Web Application (`lab3_parkingLot`)

> [!NOTE]
> This repository is made for school (Software Engineering laboratory / academic coursework).

A Jakarta EE 11 web application running on Eclipse GlassFish 8, demonstrating modular JSP development with reusable tag templates and page navigation.

---

## ✨ Features

- **JSP UI Templating:** Base layout defined in `src/WEB-INF/tags/pageTemplate.tag` with dynamic `${pageTitle}` and body insertion via `<jsp:doBody/>`.
- **Multi-Page Layout:**
  - **Home / Welcome:** `src/index.jsp` (`Welcome to the Parking Lot`).
  - **About:** `src/about.jsp` (`About Parking Lot`).
- **Container & Tooling:** Runs on Eclipse GlassFish 8 and OpenJDK 21, managed via a Gradle wrapper with automated deployment and hot-reloading tasks.

---

## 🛠️ Environment & Prerequisites

Configured for **WSL2 (Windows Subsystem for Linux 2)** with **IntelliJ IDEA on the host OS (Windows)**:

- **Operating Environment:** WSL2 Linux (Debian/Ubuntu)
- **Java:** OpenJDK 21
- **Application Server:** Eclipse GlassFish 8 (default at `/opt/glassfish8`)
- **Build Tool:** Gradle (wrapper `./gradlew` included)
- **Host IDE Support:** IntelliJ IDEA running on host OS accessing the WSL2 filesystem (`\\wsl.localhost\...`).

---

## ⚙️ Environment Configuration (`.env` & `.env.template`)

System and developer-specific configurations are handled through `.env` (derived from `.env.template`):

| Variable | Default Value | Description |
| :--- | :--- | :--- |
| `APP_NAME` | `webapp` | WAR archive name and default context path. |
| `APP_CONTEXT_PATH` | `/webapp` | Base web context path. |
| `HTTP_HOST` | `localhost` | Host where server is reachable. |
| `HTTP_PORT` | `8080` | GlassFish HTTP listener port. |
| `ADMIN_PORT` | `4848` | GlassFish admin console port. |
| `GLASSFISH_HOME` | `/opt/glassfish8` | Eclipse GlassFish installation root. |
| `GLASSFISH_DOMAIN` | `domain1` | Target GlassFish domain name. |
| `GLASSFISH_DOMAINS_DIR` | `/opt/glassfish8/glassfish/domains` | Custom domains directory. |
| `GLASSFISH_AUTODEPLOY_DIR` | `/opt/glassfish8/glassfish/domains/domain1/autodeploy` | Custom autodeploy directory. |
| `GLASSFISH_ASADMIN` | `/opt/glassfish8/glassfish/bin/asadmin` | Path to `asadmin` binary CLI. |
| `GLASSFISH_ADMIN_USER` | `admin` | GlassFish admin username. |
| `GLASSFISH_ADMIN_PASSWORD` | *(blank)* | GlassFish admin password. |
| `JAVA_HOME` | `/usr/lib/jvm/java-21-openjdk-amd64` | OpenJDK 21 installation path. |

---

## 💻 Working with IntelliJ IDEA on the Host

1. **Open Project:** In IntelliJ IDEA on Windows, open `\\wsl.localhost\<distro>\path\to\lab3_parkingLot`.
2. **Gradle & JDK Sync:** Ensure Gradle JVM is set to OpenJDK 21 from WSL.
3. **Run Configurations:** Shared run configurations in `.idea/runConfigurations/`:
   - **`Run Server`**: Cleans up existing instances, builds the WAR, deploys to GlassFish, and starts in foreground.
   - **`Hot Reload`**: Recompiles and updates the deployed WAR on the running server without restarting.

---

## 🚀 Running and Managing the Application

Run commands from the project root using the Gradle wrapper:

### 1. Build the WAR
```bash
./gradle/wrapper/gradlew war
```
Outputs the archive to `out/libs/<APP_NAME>.war`.

### 2. Start the GlassFish Server
```bash
./gradle/wrapper/gradlew runServer
```
Builds, deploys to GlassFish `autodeploy`, and runs the server in foreground mode.

### 3. Hot Reload
```bash
./gradle/wrapper/gradlew hotReload
```
Rebuilds and redeploys changes without restarting the server.

---

## 🌐 Endpoints

Once the server is running (default port `8080` and context `/webapp`):

| Description | URL |
| :--- | :--- |
| **Welcome Page** | [http://localhost:8080/webapp/index.jsp](http://localhost:8080/webapp/index.jsp) |
| **About Page** | [http://localhost:8080/webapp/about.jsp](http://localhost:8080/webapp/about.jsp) |
| **Base URL** | [http://localhost:8080/webapp/](http://localhost:8080/webapp/) |
| **GlassFish Admin Console** | [http://localhost:4848/](http://localhost:4848/) |

---

## 📁 Project Structure

```
lab3_parkingLot/
├── .env.template                             # Tracked environment variable defaults
├── .env                                      # Dev/user-specific settings (gitignored)
├── .idea/                                    # IntelliJ project and run configurations
├── gradle/wrapper/                           # Gradle wrapper files
├── src/
│   ├── WEB-INF/
│   │   └── tags/
│   │       └── pageTemplate.tag              # Base HTML layout tag template
│   ├── about.jsp                             # About page
│   └── index.jsp                             # Welcome page
├── build.gradle                              # Gradle build script with lifecycle tasks
├── settings.gradle                           # Gradle project settings
├── .gitignore                                # Git ignore configuration
└── README.md                                 # Project documentation
```
