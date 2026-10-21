# Repository Guidelines & Agentic Knowledge (`AGENTS.md`)

This repository contains academic software engineering coursework and laboratory projects.

> [!NOTE]
> This repository is created for school (software engineering laboratory coursework).

---

## 🌐 Per-Project Environments & Setups

Technical requirements, environments, dependencies, build tools, and IDE configurations are **strictly managed per project**:

- **No Global Runtime or Tooling Assumptions:** Each project directory is self-contained and may use different technologies, environments, and workflows.
- **Consult Project-Specific Knowledge:** Always refer to the `AGENTS.md` / `GEMINI.md` and `README.md` inside the target project directory for project-specific setup, commands, IDE configurations, and guidelines.

---

## 🔒 General Repository Guidelines

- **Never hardcode user-specific paths:** Always use relative paths or environment variables.
- **Keep `.gitignore` updated:** User workspace state, local caches, and build outputs must never be committed.
- **Do not commit without explicit user instruction:** Never create commits unless specifically requested by the user.
- **Synchronize Agent Knowledge Files:** `AGENTS.md` and `GEMINI.md` must have the exact same content after every edit (raw copy via `cp AGENTS.md GEMINI.md` or Windows `robocopy` equivalent).
