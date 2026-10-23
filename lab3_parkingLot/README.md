# Template Web Project (`template_web_project`)

> [!NOTE]
> This repository is made for school (Software Engineering laboratory / academic coursework).

A Jakarta EE 11 web application boilerplate running on Eclipse GlassFish 8, built and managed using Gradle.

---

## 🛠️ Environment & Prerequisites

This setup is specifically tailored for a **WSL2 (Windows Subsystem for Linux 2)** machine with pre-installed dependencies and supports **IntelliJ IDEA on the host OS (Windows)**:

- **Operating Environment:** WSL2 Linux (e.g. Debian/Ubuntu)
- **Java:** OpenJDK 21
- **Application Server:** Eclipse GlassFish 8 (default at `/opt/glassfish8`)
- **Build Tool:** Gradle (wrapper `./gradlew` included)
- **Host IDE Support:** IntelliJ IDEA running on the host OS accessing the project files stored inside the WSL2 file system.

---

## ⚙️ Environment Configuration (`.env` & `.env.template`)

System and user-specific configurations are decoupled from the build logic using an environment file:

- **`.env.template`**: Tracked in version control. Contains all configurable settings with explicit default values.
- **`.env`**: Dev/machine-specific configuration file. Ignored by Git. If not present, Gradle automatically creates it by copying `.env.template` on first run.

### Configuration Variables

| Variable | Default Value | Description |
| :--- | :--- | :--- |
| `APP_NAME` | `webapp` | Name used for WAR archive (`<APP_NAME>.war`) and default context path. |
| `APP_CONTEXT_PATH` | `/webapp` | Base web context path (defaults to `/${APP_NAME}`). |
| `HTTP_HOST` | `localhost` | Hostname / IP address where the server is reachable. |
| `HTTP_PORT` | `8080` | GlassFish HTTP listener port. |
| `ADMIN_PORT` | `4848` | GlassFish administrative console port. |
| `GLASSFISH_HOME` | `/opt/glassfish8` | Root directory of Eclipse GlassFish 8. |
| `GLASSFISH_DOMAIN` | `domain1` | Target GlassFish domain name. |
| `GLASSFISH_DOMAINS_DIR` | `/opt/glassfish8/glassfish/domains` | GlassFish domains directory. |
| `GLASSFISH_AUTODEPLOY_DIR` | `/opt/glassfish8/glassfish/domains/domain1/autodeploy` | Autodeploy directory for WAR archives. |
| `GLASSFISH_ASADMIN` | `/opt/glassfish8/glassfish/bin/asadmin` | Path to `asadmin` binary CLI. |
| `GLASSFISH_ADMIN_USER` | `admin` | GlassFish administrator username. |
| `GLASSFISH_ADMIN_PASSWORD` | *(blank)* | GlassFish administrator password (blank by default). |
| `JAVA_HOME` | `/usr/lib/jvm/java-21-openjdk-amd64` | OpenJDK 21 installation path. |

### Configuration Precedence

Configurations are resolved using the following priority order:
1. **Gradle project property** (e.g. `-PHTTP_PORT=9090` or `-Dkey=val`)
2. **`.env` file** (local developer override)
3. **System environment variables** (OS / shell / CI environment)
4. **`.env.template` file** (fallback defaults)
5. **Built-in defaults**

---

## 💻 Working with IntelliJ IDEA on the Host

You can develop, build, and debug using IntelliJ IDEA installed on your Windows host:

1. **Open Project:**
   - In IntelliJ IDEA on Windows, select **Open**.
   - Navigate to the project directory via the WSL network share:
     `\\wsl.localhost\<distro>\path\to\template_web_project` (or `\\wsl$\<distro>\...`).
2. **Gradle & JDK Sync:**
   - IntelliJ detects the Gradle project automatically.
   - Configure Gradle JVM to use Java 21 from WSL (e.g., `21 (WSL)`).
3. **Pre-configured Run Configurations:**
   - Ready-to-use shared run configurations are included in `.idea/runConfigurations/`:
     - **`Run Server`**: Shuts down any existing instances at start/rerun, builds the WAR, deploys to GlassFish, runs in foreground, and gracefully shuts down on stop.
     - **`Hot Reload`**: Recompiles code, rebuilds the WAR, and redeploys changes to the running server without restarting.

---

## 🚀 Running and Managing the Application

All operations can be run from the project root using the Gradle wrapper (`gradle/wrapper/gradlew`):

### 1. Build the WAR
```bash
./gradle/wrapper/gradlew war
```
Outputs the deployable archive to `out/libs/<APP_NAME>.war`.

### 2. Start the GlassFish Server
```bash
./gradle/wrapper/gradlew runServer
```
- Automatically stops any existing GlassFish instances at the start of `runServer` (preventing port conflicts on rerun).
- Builds and deploys `<APP_NAME>.war` to the GlassFish `autodeploy` directory.
- Starts the GlassFish server in foreground (`--verbose`) mode for the specified `GLASSFISH_DOMAIN`.
- Gracefully shuts down GlassFish when stopped in IntelliJ UI (or interrupted).

### 3. Hot Reload (Deploy Changes Without Restarting)
```bash
./gradle/wrapper/gradlew hotReload
```
- Rebuilds `<APP_NAME>.war` and copies the updated archive into the GlassFish `autodeploy` directory.
- GlassFish automatically detects the updated archive and hot-reloads the application within seconds.

---

## 🌐 Endpoints

Once the server is running (assuming default port `8080` and context `/webapp`):

| Description | URL |
| :--- | :--- |
| **JSP Hello World Page** | [http://localhost:8080/webapp/index.jsp](http://localhost:8080/webapp/index.jsp) |
| **Base WebApp URL** | [http://localhost:8080/webapp/](http://localhost:8080/webapp/) |
| **GlassFish Admin Console** | [http://localhost:4848/](http://localhost:4848/) |

---

## 📁 Project Structure

```
template_web_project/
├── .env.template                             # Tracked environment variable defaults
├── .env                                      # Dev/user-specific settings (gitignored)
├── .idea/
│   ├── runConfigurations/
│   │   ├── Run_Server.xml                    # IntelliJ shared configuration for runServer
│   │   └── Hot_Reload.xml                    # IntelliJ shared configuration for hotReload
│   └── ...                                   # IDE configuration files
├── gradle/
│   └── wrapper/
│       ├── gradlew                           # Linux/macOS wrapper script
│       ├── gradlew.bat                       # Windows wrapper script
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── src/
│   └── index.jsp                             # Minimal Hello World JSP page
├── build.gradle                              # Gradle build script with .env loader & tasks
├── settings.gradle                           # Gradle project settings
├── .gitignore                                # Git ignore configuration
└── README.md                                 # Project documentation
```
