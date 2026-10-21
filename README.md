# Software Engineering Laboratory Coursework

> [!NOTE]
> This repository is created for school (software engineering laboratory coursework).

---

## 📖 Overview

This repository hosts software engineering coursework and laboratory assignments.

Because each laboratory assignment may have different technical requirements, runtime dependencies, tools, or frameworks, **all configurations, environment prerequisites, and IDE setups are defined per project** within their respective project directories.

---

## 📁 Repository Structure

```
.
├── README.md                  # Repository overview and structure (this file)
├── AGENTS.md / GEMINI.md      # Global repository guidelines
├── template_web_project/      # Master template for web application projects
│   ├── README.md              # Project-specific requirements, setup, and commands
│   ├── AGENTS.md / GEMINI.md  # Project-specific agentic guidelines
│   └── ...                    # Build, IDE, and source configurations
└── lab*_...                   # Individual laboratory projects
```

### Projects & Templates

- **[`template_web_project/`](template_web_project/):** Master template for web applications. Contains project-specific setup, build scripts, IDE configurations, boilerplate code, and documentation.
- **`lab*_...`:** Individual laboratory projects. Each project is self-contained with its own project-specific `README.md`, environment requirements, and build settings.

---

## 🚀 Creating a New Laboratory Project

When starting a new laboratory assignment based on the web template:

1. **Copy the template directory:**
   ```bash
   cp -r template_web_project <new_lab_name>
   ```
2. **Consult the project documentation:**
   - Refer to the `README.md` inside `<new_lab_name>/` for project-specific prerequisites, environment setup, and execution instructions.
