# Security Policy

This document includes information about the vulnerability reporting, patch,
release, and disclosure processes, as well as general security posture for **CanScan**.

* [Supported Versions](#supported-versions)
* [Reporting a Vulnerability](#reporting-a-vulnerability)
* [When Should I Report a Vulnerability?](#when-should-i-report-a-vulnerability)
* [When Should I NOT Report a Vulnerability?](#when-should-i-not-report-a-vulnerability)
* [Vulnerability Response](#vulnerability-response)
* [Security Release & Disclosure Process](#security-release--disclosure-process)
* [Security Posture](#security-posture)
* [Security Team](#security-team)
* [Security Policy Updates](#security-policy-updates)

## Supported Versions

The following versions are currently supported and receive security updates.

| Version   | Supported          |
|-----------| ------------------ |
| >=1.1.0.0 | :white_check_mark: |
| <1.1.0.0  | :x:                |

## Reporting a Vulnerability

Vulnerabilities are reported privately via GitHub's [Security Advisories](https://docs.github.com/en/code-security/security-advisories) feature.

[Report a vulnerability for CanScan](https://github.com/Lob2018/CanScan/security/advisories/new)

### When Should I Report a Vulnerability?

* You discovered a potential security vulnerability in **CanScan**.
* You are unsure how a vulnerability affects the application.
* You found a vulnerability in a dependency (e.g., **ZXing**, **FlatLaf**, **LGoodDatePicker**) as used by CanScan.

### When Should I NOT Report a Vulnerability?

* You need help with the Java installation or running the JAR.
* Your issue is a general bug (e.g., UI glitch) not affecting data integrity or security.

### Vulnerability Response

Each report is acknowledged within **14 days**. Any information shared stays within the **CanScan** project security team.

## Security Release & Disclosure Process

### Private Disclosure

Fixes are developed in [temporary private forks](https://docs.github.com/en/code-security/security-advisories/repository-security-advisories/collaborating-in-a-temporary-private-fork-to-resolve-a-repository-security-vulnerability).

### Public Disclosure

Vulnerabilities are disclosed publicly as [GitHub Security Advisories](https://github.com/Lob2018/CanScan/security/advisories).

## Security Posture

We use the following tools and practices to ensure **CanScan** security:

* **Static Analysis**: [SpotBugs](https://spotbugs.github.io/) and [SonarCloud](https://sonarcloud.io/) integration.
* **Code Quality**: [Checkstyle](https://checkstyle.sourceforge.io/) and [Spotless](https://github.com/diffplug/spotless) formatting.
* **Dependency Tracking**: Regular updates of Maven dependencies.
* **Testing**: JUnit 5 and Mockito with [JaCoCo](https://www.jacoco.org/jacoco/) coverage.

## Security Team

* **Lob2018** (@Lob2018)

## Security Policy Updates

Changes are reviewed and approved by the Security Team.
