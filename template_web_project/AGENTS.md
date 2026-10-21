# Agent Guidelines & Knowledge Base (`AGENTS.md`)

This repository contains `template_web_project`, a boilerplate Jakarta EE 11 web application running on Eclipse GlassFish 8 with Gradle.

> [!NOTE]
> This repository is created for school (academic software engineering laboratory coursework).
> The environment is configured for a **WSL2** Linux machine with pre-installed dependencies and supports **IntelliJ IDEA on the host OS**.

---

## 🖥️ System & Environment Context

- **Operating System:** WSL2 Linux (Debian / Ubuntu).
- **Host OS Interaction:** IntelliJ IDEA runs on the host OS (Windows), opening the project via WSL path (`\\wsl.localhost\<distro>\<path>` or `\\wsl$\...`).
- **Java SDK:** OpenJDK 21 (located at standard system JDK paths such as `/usr/lib/jvm/java-21-openjdk-amd64`).
- **Application Server:** Eclipse GlassFish 8 installed at `/opt/glassfish8` (configurable via `.env`).
  - GlassFish domain directory: `/opt/glassfish8/glassfish/domains/domain1`.
  - Autodeploy directory: `/opt/glassfish8/glassfish/domains/domain1/autodeploy`.
  - Admin CLI: `/opt/glassfish8/glassfish/bin/asadmin`.
  - Default HTTP port: `8080`.
  - Default Admin port: `4848`.
- **Build System:** Gradle using the local wrapper (`./gradlew`).
- **Environment Management:** Driven by `.env` and `.env.template`.

---

## ⚙️ Environment Configuration (`.env` & `.env.template`)

System and user-specific configurations are mapped via `.env` (derived from `.env.template`):

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
| `GLASSFISH_ADMIN_PASSWORD` | *(blank)* | GlassFish admin password (blank by default). |
| `JAVA_HOME` | `/usr/lib/jvm/java-21-openjdk-amd64` | Path to OpenJDK 21. |

**Precedence Order:**
1. Gradle project property (`-PKEY=val` / `-Dkey=val`)
2. `.env` file (developer-specific overrides)
3. System environment variable (`System.getenv()`)
4. `.env.template` file (template defaults)
5. Built-in hardcoded fallbacks

---

## 🚀 Key Tasks & Build Commands

All commands should be executed from the project root (`template_web_project/`):

| Task | Command | Description |
| :--- | :--- | :--- |
| **Build WAR** | `./gradle/wrapper/gradlew war` | Compiles source files and packages `out/libs/<APP_NAME>.war`. |
| **Clean & Build** | `./gradle/wrapper/gradlew clean war` | Cleans previous build artifacts and recompiles. |
| **Run Server** | `./gradle/wrapper/gradlew runServer` | Automatically shuts down existing instances at start/rerun, autodeploys WAR, runs in foreground, and gracefully shuts down GlassFish on stop/exit. |
| **Hot Reload** | `./gradle/wrapper/gradlew hotReload` | Recompiles and copies updated WAR to `autodeploy` without restarting GlassFish. |
| **Test Endpoint** | `curl -i http://localhost:8080/webapp/index.jsp` | Verifies JSP response from GlassFish. |

---

## 🏗️ Architecture & Conventions

1. **Jakarta EE 11 API:**
   - Provided via `compileOnly 'jakarta.platform:jakarta.jakartaee-api:11.0.0'` in `build.gradle` (GlassFish provides the runtime implementation).
2. **Web Resources:**
   - JSP and web files reside directly under `src/` (e.g. `src/index.jsp`) and are packaged at the root of the WAR archive.
3. **Java Sources (Optional):**
   - Java classes can be placed in `src/` (configured in `sourceSets.main.java.srcDirs = ['src']`).
4. **Context Path:**
   - Defined by the war archive name: `<APP_NAME>.war` -> `/<APP_NAME>`.
   - Base endpoint URL: `http://<HTTP_HOST>:<HTTP_PORT>/<APP_CONTEXT>/index.jsp`.

---

## 🔒 Reproducibility & Git Guidelines

- **Never hardcode user-specific paths:** Always use `.env` and `.env.template` for user/dev specific configurations.
- **Maintain IDE Portability:** Keep shared IntelliJ run configurations (`.idea/runConfigurations/*.xml`) checked into version control using `$PROJECT_DIR$`.
- **Keep `.gitignore` updated:** Ensure `.env`, personal workspace state (`workspace.xml`, `.gradle/`, `build/`, `out/`) are never committed, while `.env.template` is tracked.
- **Do not commit without explicit user instruction:** Never create commits unless specifically requested by the user.
- **Synchronize Agent Knowledge Files:** `AGENTS.md` and `GEMINI.md` must have the exact same content after every edit (raw copy via `cp AGENTS.md GEMINI.md` or Windows `robocopy` equivalent).
