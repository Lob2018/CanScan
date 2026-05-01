# Contributing to CanScan

Thank you for your interest in contributing to **CanScan**!
We welcome all kinds of contributions — from bug reports and feature requests to documentation improvements and code enhancements.

<a href="https://github.com/Lob2018/CanScan/releases/latest">
 <img src="https://raw.githubusercontent.com/Lob2018/CanScan/master/.myresources/images/CanScan_in_action.png" alt="CanScan in action"  width="400"/>
</a>

## 📚 Table of Contents

1. [Project Overview](#1-project-overview)
2. [How to Contribute](#2-how-to-contribute)
3. [Filing an Issue](#3-filing-an-issue)
4. [Development Setup](#4-development-setup)
5. [Coding Standards and Formatting](#5-coding-standards-and-formatting)
6. [Git Hooks and Code Quality with pre-commit](#6-git-hooks-and-code-quality-with-pre-commit)
7. [Testing Guidelines](#7-testing-guidelines)
    - [Test Policy for New Functionality](#test-policy-for-new-functionality)
8. [Commit Message Guidelines](#8-commit-message-guidelines)
9. [Contribution Workflow](#9-contribution-workflow)
10. [Pull Requests](#10-pull-requests)
11. [Types of Contributions Welcome](#11-types-of-contributions-welcome)
12. [Community and Communication](#12-community-and-communication)
13. [Code of Conduct](#13-code-of-conduct)
14. [Security Policy](#14-security-policy)
15. [Useful Links](#15-useful-links)

---

## 1. Project Overview

**CanScan** is a Java Swing desktop application for Windows x64 and Linux AppImage that generates QR codes.
Our goal is to provide a clean, extensible, and performant local-only QR Code generator experience for desktop users.

---

## 2. How to Contribute

1. **Fork the repository** to your GitHub account.
2. **Clone your fork** locally:

   ```bash
   git clone https://github.com/your-username/CanScan.git
   cd CanScan
   ```

3. **Create a new branch** for your changes:

   ```bash
   git checkout -b feature/your-feature-name
   ```

4. Make your changes, commit them, and push to your fork.

---

## 3. Filing an Issue

If you encounter a bug, have a feature request, or need help with CanScan, please [file an issue](https://github.com/Lob2018/CanScan/issues) on our GitHub repository.

### 🐛 Bug Reports

To ensure your report is actionable, we require a **Clean Bug Report**. Please follow this structured format to help maintainers reproduce and fix the issue quickly.

#### **Recommended Bug Report Template**

* **Scenario**: A brief description of what you were doing.
    * *Example*: "The application fails to generate the QR Code with a 5,000-character text in the **Saisie libre** field."


* **Platform**: OS version (e.g., Windows 11), Java version, and Display resolution/Scaling.
    * *Example*: "Windows 11 Pro, OpenJDK 25, 1920x1080 (125% scaling)."


* **Steps to Reproduce**: Detailed sequence of actions to trigger the bug.
    * *Example*:
        1. Open **CanScan** and select **Saisie libre** radio button.
        2. Write the 5,000-character text in **Texte** field.


* **Expected Behaviour**: What should have happened.
    * *Example*: "A corresponding QR Code should be visible."


* **Actual Behaviour**: What actually happened.
    * *Example*: "An error pop-up opens, and when I close it I cannot save."


* **Technical Note**: Relevant stacktraces, or error codes.
    * *Example*: `Erreur --- Réduire la quantité de données : Data too big`.

> [!TIP]
> **Why this matters:** High-quality reports save time. Including logs and specific steps allows us to jump straight into the code rather than guessing the context.

### ✨ Feature Requests

For feature requests, please describe:

- The feature you'd like to see
- Why it would be useful
- Any implementation ideas you might have

---

## 4. Development Setup

### 🛠 Prerequisites

- Java 25+
- Git
- No need to install Maven manually — we use the **Maven Wrapper** (`./mvnw`)
- Recommended IDE: **IntelliJ IDEA**

---

### ▶️ Build and Run

We provide preconfigured **Run Configurations** in the `.idea/runConfigurations/` directory.

> ✅ **Please use these configurations instead of running Maven manually.**

They are designed to:

- Automatically run `mvn clean` followed by the appropriate goal (`exec:java`, etc.)
- Ensure the project is rebuilt from a clean state
- Trigger the **Spotless plugin** during the `validate` and `compile` phases
- Enforce consistent code formatting automatically

### 🧭 Available Run Configurations

| Name                                         | Description                                                                     |
|----------------------------------------------|---------------------------------------------------------------------------------|
| CanScan [run]                                | Launches the application using clean compile exec:java.                         |
| canscan [run details]                        | Same as [run], but with verbose Maven output (-X) for debugging.                |
| CanScan [test]                               | Runs the full test suite using clean test via Maven.                            |
| CanScanUTest                                 | Directly runs the CanScanUTest JUnit class.                                     |
| CanScan [Windows native package]             | Builds the Windows native executable using the windows-native Maven profile.    |
| canscan [Linux native package]               | Builds the Linux native package using the linux-native Maven profile.           |
| CanScan [manual simulation (Runtime)]        | Runs the app with the GraalVM agent to generate native-image config files.      |
| CanScan [auto simulation (Config trace)]     | Executes the NativeImageConfigSimulator to automate metadata collection.        |
| CanScan [run with VisualVM Monitoring]       | Launches the app with the visualvm-monitoring profile for performance analysis. |
| SpotBugs [GUI]                               | Runs static code analysis and opens the SpotBugs GUI to review findings.        |
| CanScan Doxygen                              | Generates Doxygen documentation and automatically stages changes in Git.        |

To use them:

1. Open the project in IntelliJ IDEA.
2. Go to the **Run** menu → **Edit Configurations**.
3. Select one of the predefined entries listed above.
4. Click **Run** ▶️ to launch or build the project.

> 🧼 These configurations help enforce formatting rules and prevent build issues due to unformatted code.

---

## 5. Coding Standards and Formatting

- We use **Google Java Format v1.27.0** with **AOSP style**.
- Formatting is enforced via the **Spotless Maven Plugin**.
- Code must be formatted before submission.

> ✅ **Spotless is automatically triggered** when using the provided IntelliJ IDEA Run Configurations
> (see [▶️ Build and Run](#️-build-and-run)). These configurations always start with `mvn clean`,
> which ensures Spotless runs during the `validate` and `compile` phases.

### Formatting commands (optional if using Run Configurations):

```bash
./mvnw spotless:apply     # Apply formatting
./mvnw spotless:check     # Check formatting compliance
```

> ❗ Unformatted code will fail the build or be rejected during review.

## 6. Git Hooks and Code Quality with pre-commit

We use [pre-commit](https://pre-commit.com/) to enforce code quality and prevent common issues before commits are made. This also helps keep our dependencies secure and monitored.

### ✅ Enabled Hooks

- `mvn-checkstyle`: Runs Checkstyle on Java files.
- `gitleaks`: Scans for hardcoded secrets and credentials.
- `shellcheck`: Lints shell scripts (excluding `mvnw`).
- `end-of-file-fixer`: Ensures a newline at the end of files.
- `trailing-whitespace`: Removes trailing whitespace.

### ⚙️ Setup and Maintenance Instructions

To ensure you are using the latest, most secure versions of our tools, follow these steps:

```bash
# 1. Install Python (via Microsoft Store on Windows)
# 2. Install/Update pre-commit
# Use --upgrade to ensure you have the latest runner and security patches
py -m pip install --upgrade pre-commit

# 3. Install Git hooks for this repository
py -m pre_commit install

# 4. (Optional) Run hooks on all files to verify everything is clean
py -m pre_commit run --all-files --verbose

# 5. (Optional) Update hooks to their latest versions
# This updates the 'rev' tags in your .pre-commit-config.yaml
py -m pre_commit autoupdate

# 6. Install ShellCheck via winget (required for shellcheck hook)
winget install --id=koalaman.shellcheck

# 7. IMPORTANT: Update requirements.txt for Snyk/Security scanning
# If you updated pre-commit, you must synchronize the requirements file
# so that security scanners (like Snyk) can verify transitive dependencies.
py -m pip freeze > requirements.txt
```

## 7. Testing Guidelines

- ✅ **All new features and bug fixes must include appropriate unit or integration tests.**
- Use **JUnit 5** for unit tests.
- Run tests locally before submitting:

```bash
./mvnw test
```
### Test Policy for New Functionality

As a general policy, any major new functionality must be accompanied by automated tests.
This ensures that new features are reliable, maintainable, and do not introduce regressions.
Pull Requests that introduce significant changes without tests may be rejected or delayed.

Tests should cover:

- Core logic and edge cases
- Input validation and error handling
- UI behavior (if applicable)

If you're unsure how to test a specific feature, feel free to open a draft PR or ask for guidance in your Pull Request description.

---

## 8. Commit Message Guidelines

We use a standardized commit message template to keep our Git history clean, readable, and consistent.

### 📄 Commit Template

A commit message template is provided in the root of the repository:

```
.gitmessage
```

To activate it locally, run:

```bash
git config --local commit.template .gitmessage
```

To verify it's correctly set:

```bash
git config --get commit.template
```

### ✅ Commit Types

Uncomment the appropriate line in the template and write your message after the prefix.
Here are the supported commit types:

| Emoji | Type      | Description                                                                 |
|--------|-----------|-----------------------------------------------------------------------------|
| ✨     | `feat:`   | A new feature                                                              |
| 🐛     | `fix:`    | A bug fix                                                                  |
| 🔧     | `chore:`  | Routine tasks like dependency updates or config changes                    |
| ♻️     | `refactor:` | Code changes that neither fix a bug nor add a feature                    |
| 📚     | `docs:`   | Documentation updates                                                      |
| 📝     | `style:`  | Code style changes (formatting, whitespace, etc.)                          |
| ✅     | `test:`   | Adding or updating tests                                                   |
| ⚡     | `perf:`   | Performance improvements                                                   |
| 👷     | `ci:`     | Continuous integration-related changes                                     |
| 🛠️     | `build:`  | Changes to the build system or dependencies                               |
| ⏪     | `revert:` | Reverting a previous commit                                                |

### 🧠 Example

```bash
# Uncomment and edit:
#🔧 chore harden-runner, qodana-action: Bump the actions-dependencies
```

> Use the imperative mood in your messages (e.g., "Add", not "Added" or "Adds").

---

## 9. Contribution Workflow

1. Sync your local `main` branch with upstream:

   ```bash
   git checkout main
   git pull upstream main
   git checkout -b feature/your-feature-name
   ```

2. Make atomic commits with clear messages.
3. Format and test your code.
4. Push your branch and open a Pull Request.

---

## 10. Pull Requests

- Open a PR against the `main` branch.
- Use the PR template and include:
    - A concise description of the change.
    - Motivation and context.
    - Related issue references (if any).
- Be responsive to feedback.
- Ensure all CI checks pass.

---

## 11. Types of Contributions Welcome

We welcome:

- 🐛 Bug reports and fixes
- ✨ New features and enhancements
- 🧪 Tests and test coverage improvements
- 📚 Documentation updates
- ♻️ Code cleanup and refactoring
- 🌐 Internationalization and accessibility improvements

---

## 12. Community and Communication

- Use GitHub Issues for bugs and feature requests.
- Use Pull Requests for code contributions.
- For private or sensitive matters, contact us via email: **soft64.fr@gmail.com**

---

## 13. Code of Conduct

Please read and follow our [Code of Conduct](./CODE_OF_CONDUCT.md).
We are committed to fostering a welcoming and respectful community.

---

## 14. Security Policy

If you discover a security vulnerability, please report it responsibly.
See our [Security Policy](./SECURITY.md) for details.

---

## 15. Useful Links

- [Spotless Maven Plugin](https://github.com/diffplug/spotless)
- [Google Java Format](https://github.com/google/google-java-format)
- [GitHub Forking Guide](https://docs.github.com/en/get-started/quickstart/fork-a-repo)
- [Maven Build Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)
- [Contributor Covenant](https://www.contributor-covenant.org/)

---

Thank you for helping improve **CanScan**!
Your contributions make this project better for everyone.
