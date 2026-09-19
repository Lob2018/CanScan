# Changelog


## Unreleased - 


📚 docs Doxygen

([3e6bbd27e54f696](https://github.com/Lob2018/CanScan/commit/3e6bbd27e54f6963691669df01749f2d106ae818))

🔧 chore CanScan_Doxygen.xml: Enable verbose git add and independent interpreter path
- Add &#x60;-v&#x60; parameter to the git add command in SCRIPT_TEXT.
- Set INDEPENDENT_INTERPRETER_PATH to true and clear INTERPRETER_PATH.
- Add Maven BeforeRunTask for clean package goal.
- Tests pass.

([2b49645c8da16cd](https://github.com/Lob2018/CanScan/commit/2b49645c8da16cdca4221795827b7009cd81e357))

## v1.2.2.2 - 2026-09-07


📚 docs Doxygen

([3779d836ae8c397](https://github.com/Lob2018/CanScan/commit/3779d836ae8c3974523f34beda0453b28cbf7494))

🐛 fix CanScan, MyTextField, NativeImageConfigSimulator: Prevent UI thread freeze on text field triple-click
- CanScan:
	- Replace standard text fields with MyTextField instances.
- MyTextField:
	- Implement custom text field class extending JTextField.
	- Override processMouseEvent to consume click counts greater than two.
	- Add complete class and method Javadoc.
- NativeImageConfigSimulator:
	- Add triple-click mouse simulation actions.
- Tests pass.

([5b6fae7e76ef398](https://github.com/Lob2018/CanScan/commit/5b6fae7e76ef3982a7af8561520a825e95b9d6bb))

🐛 fix NativeImageConfigSimulator: Update assertion and remove unnecessary typing in clipboard test
- Remove simulated text re-typing and update expected assertion value to empty string in clipboard and length validation test.
- Tests pass.

([fc18e926025e3a9](https://github.com/Lob2018/CanScan/commit/fc18e926025e3a9b2a6ee0751e7c4344fcdb6118))

✨ feat natif.yml: Add SonarQube analysis step with quality gate check during Maven compilation

([e5d2f1c913b7e51](https://github.com/Lob2018/CanScan/commit/e5d2f1c913b7e5135bd9e071f4890823132954e4))

🐛 fix NativeImageConfigSimulator: Fix clipboard keyboard shortcut simulations and update method name
- Update method name from textFieldClipboardAndValidationSimulation to simulateClipboardAndLengthValidation.
- Fix key release order for control key during copy, cut, paste and select all shortcut simulations.
- Adjust delays and sequence for robot input validation tests.
- Tests pass.

([bb0e9225c09138a](https://github.com/Lob2018/CanScan/commit/bb0e9225c09138a6ec603afceaba1d1c5d4b55d4))

✨ feat CanScan, EncodedImage, NativeImageConfigSimulator: Enforce ISO 18004 capacity validation with automatic field reset and error handling
-CanScan :
	-Add ISO 18004 length validation in getQrInput
	-Implement clearFieldsForCurrentMode method
	-Update Javadocs
-EncodedImage :
	-Add length validation throwing WriterException
	-Update Javadocs
-NativeImageConfigSimulator :
	-Format method signature
-Tests pass.

([b76328491beb1b7](https://github.com/Lob2018/CanScan/commit/b76328491beb1b736053d46377acd64e965596f6))

🐛 fix reachability-metadata.json: Fix missing native-image configuration for Linux runtime
- reachability-metadata.json : Add runtime usage simulation data generated under Lubuntu to resolve missing metadata errors
- Tests pass.

([9d9f462cc766ef9](https://github.com/Lob2018/CanScan/commit/9d9f462cc766ef935299e7bbff161ab1ee15a513))

🐛 fix:✨ fix NativeImageConfigSimulator: Increase simulation delays and adjust text length for validation tests
- Increase robot delay from 500ms to 1000ms after text simulation in free data and name typing tests to prevent dialog interception failures.
- Reduce text length from 3058 to 1500 characters for name field validation test.
- Tests pass.

([64f53f748015356](https://github.com/Lob2018/CanScan/commit/64f53f7480153567059557c8dd7e61708374a51e))

🐛 fix NativeImageConfigSimulator: Fix application freeze during large string copy-paste in text field
- Add textFieldClipboardAndValidationSimulation to handle large string inputs and prevent UI thread blocking.
- Update NativeImageConfigSimulator to integrate the new validation test sequence.
- Adjust subsequent test index numbers to maintain sequence continuity.
- Tests pass.

([3921a2c77bba0cf](https://github.com/Lob2018/CanScan/commit/3921a2c77bba0cf39e0017b2e437bae5aa3a9f12))

♻️ refactor Canscan__Linux_native_package_.xml, reflect-config.json, natif.sh, .sdkmanrc, mvnw.cmd, pom.xml: Update native build configuration and script environment paths
- Canscan__Linux_native_package_.xml : Add JAVA_HOME environment property to Maven run configuration
- reflect-config.json : Remove serialVersionUID and serialPersistentFields from java.lang.String reflection configuration
- natif.sh : Use explicit JAVA_HOME path for java and native-image execution
- .sdkmanrc : Update Maven version to 3.9.16
- mvnw.cmd : Clean up line endings and update wrapper formatting
- pom.xml : Adjust project version to 1.2.2.2
- Tests pass.

([2fdb744eac3ea16](https://github.com/Lob2018/CanScan/commit/2fdb744eac3ea1643276fa394a27aa6b33e55df3))

🐛 fix reflect-config.json, pom.xml: Fix GraalVM native image clipboard crash on Linux and bump version
- Add serialPersistentFields field reflection metadata for java.lang.String in Linux manual configuration to resolve MissingReflectionRegistrationError during Ctrl+A/C/V/X clipboard interactions.
- Bump project version to 1.2.2.3 in pom.xml.
- Tests pass.

([cabdc6928fe6125](https://github.com/Lob2018/CanScan/commit/cabdc6928fe61256e5f24b711e33e9398c7dfdf1))

🐛 fix reflect-config.json, pom.xml: Fix GraalVM native image clipboard crash on Linux and bump version
- Add serialVersionUID field reflection metadata for java.lang.String in Linux manual configuration to resolve MissingReflectionRegistrationError during Ctrl+A/C/V/X clipboard interactions.
- Bump project version to 1.2.2.2 in pom.xml.
- Tests pass.

([ece31d3ef128ca9](https://github.com/Lob2018/CanScan/commit/ece31d3ef128ca93c93f330b513abc0037b9c79f))

## v1.2.2.1 - 2026-09-04


✨ feat pom.xml: Update project version to 1.2.2.1

([13bbb945983e890](https://github.com/Lob2018/CanScan/commit/13bbb945983e8901e66cb313c91d5c18d2ac1db4))

🐛 fix NativeImageConfigSimulator: Clipboard simulation test stability in native image configuration
☑ Root cause: Missing clipboard shortcut sequences in the test caused undetected serialization and interaction issues under GraalVM.
☑ Fix: Enhance nameTypingSimulation in NativeImageConfigSimulator to simulate comprehensive Ctrl+A/Ctrl+C/Ctrl+X/Ctrl+V key sequences with precise delays.
☑ Update or add tests: Update NativeImageConfigSimulator with keyboard shortcut simulation routines.
- Tests pass.

([8a2673b35eb3955](https://github.com/Lob2018/CanScan/commit/8a2673b35eb395531dfd14bcf7d653c4439ea642))

## v1.2.2.0 - 2026-09-04


🐛 fix EncodedImage: Use Locale.ROOT in filename string lowercase conversion

([c89d1505f3da98e](https://github.com/Lob2018/CanScan/commit/c89d1505f3da98ea16958bf41f6245f72af623c6))

✨ feat CanScan: Enhance logo field tooltip with format details
- Add format-specific behaviors for JPG, JPEG, and PNG images in the logo field tooltip
- Tests pass.

([df15b03a1bc0824](https://github.com/Lob2018/CanScan/commit/df15b03a1bc0824b091e558f7b85e08bf87dbf41))

📚 docs Doxygen

([1f047d41fe422e0](https://github.com/Lob2018/CanScan/commit/1f047d41fe422e0be54665332937bf0c61e7a997))

✨ feat pom.xml: Update project version to 1.2.2.0

([48b1aa3407b1412](https://github.com/Lob2018/CanScan/commit/48b1aa3407b1412d087dcf61b3e5e354c47fedf1))

🔧 chore maven-compiler-plugin, maven-surefire-plugin:Bump the maven-dependencies

([7a478d2a93cd4e0](https://github.com/Lob2018/CanScan/commit/7a478d2a93cd4e07028fa72adad0abf5842e3a0f))

🔧 chore harden-runner :Bump step-security/harden-runner

([a16ce3d684c9bc6](https://github.com/Lob2018/CanScan/commit/a16ce3d684c9bc6f0381a5d4a6deca65bb2c95f4))

🔧 chore requirements.txt: Bump the python-dependencies

([6fbef8f00178a9c](https://github.com/Lob2018/CanScan/commit/6fbef8f00178a9cc58ce2be1316a78430e7c0bd7))

♻️ refactor: README, EncodedImage: Update logo scaling and cropping logic for PNG files
- README.md:
    - Add documentation for PNG and JPG/JPEG logo rendering behavior.
- EncodedImage.java:
    - Update Javadoc for drawLogoIfPresent.
    - Refactor drawLogoIfPresent method to bypass forced square cropping for PNGs.
- Tests pass.

([4a9c56bbbe5e813](https://github.com/Lob2018/CanScan/commit/4a9c56bbbe5e813f99939f747d00ec0bdebd5f6e))

✨ feat ColorOperation, EncodedImage: Add full transparent background support and optimize color conversion and finder patterns
- ColorOperation :
    - Optimize colorToHex using String.format and bitwise masking.
- EncodedImage :
    - Add ALPHA_COMPOSITE_SRC constant.
    - Update generateImage to support transparent backgrounds with TYPE_INT_ARGB.
    - Update Javadocs for native transparency support.
    - Optimize drawRoundedFinderPatternAtPixel and drawSquareFinderPatternAtPixel for background alpha handling.
- Tests pass.

([ac0ba0702e79c6f](https://github.com/Lob2018/CanScan/commit/ac0ba0702e79c6fe541edac14ec28b67a938d47e))

## v1.2.1.0 - 2026-08-31


📚 docs Doxygen

([87e44fad4c7f9a3](https://github.com/Lob2018/CanScan/commit/87e44fad4c7f9a37ad86fb48637126da37541afb))

🔧 chore mvn, spotbugs-annotations, junit-jupiter, spotless-maven-plugin, spotbugs-maven-plugin, spotbugs, checkstyle: Upgrade Maven version and plugin dependencies

([7802f5d3a345f2a](https://github.com/Lob2018/CanScan/commit/7802f5d3a345f2a3c537e2fb0caebb47b2dae322))

🔧 chore harden-runner, setup-java, codeql-action, osv-scanner-reusable, qodana-action:Bump the actions-dependencies

([8807c439ebd4ee3](https://github.com/Lob2018/CanScan/commit/8807c439ebd4ee3ae88bd3eb450a6d08fd795c46))

🔧 chore requirements.txt :Bump the python-dependencies

([1d006bec5eaf50f](https://github.com/Lob2018/CanScan/commit/1d006bec5eaf50f15c525a7f8231b7de9bd39297))

♻️ refactor pom.xml, module-info.java, VersionService.java: Bump version to 1.2.1.0 and replace Jackson with Google Gson for JSON parsing and enhance error handling
- pom.xml :
	- Update project version from 1.2.0.4 to 1.2.1.0.
	- Remove Jackson databind dependency and add Google Gson.
- module-info.java : Replace Jackson requirement with com.google.gson.
- VersionService.java : Replace Jackson ObjectMapper with Gson parser and add robust exception handling with SuppressFBWarnings.
- Tests pass.

([97ade3c9d9094e7](https://github.com/Lob2018/CanScan/commit/97ade3c9d9094e71d9ea94ee8fcf67079b1969b3))

## v1.2.0.4 - 2026-08-01


🐛 fix natif.yml: Update Inno Setup installation and dynamic path resolution
-Remove static INNOSETUP_EXE environment variable and Inno Setup cache step.
-Switch to winget install for Inno Setup deployment to always use the latest version.
-Add dynamic path resolution for ISCC.exe in PowerShell.
-Tests pass.

([d89a3cac7ed01eb](https://github.com/Lob2018/CanScan/commit/d89a3cac7ed01ebde40038bd27329246ae9a37de))

✨ feat pom.xml: Bump version from 1.2.0.3 to 1.2.0.4

([5f25cf10249dd9d](https://github.com/Lob2018/CanScan/commit/5f25cf10249dd9d2a31027334690e2b44d2c05ed))

🔧 chore requirements.txt: Bump the python-dependencies

([079e343828d36cf](https://github.com/Lob2018/CanScan/commit/079e343828d36cfdf15c5d9f23f4c6c54671b876))

📚 docs: Doxygen

([8ff059294d26537](https://github.com/Lob2018/CanScan/commit/8ff059294d26537819d7bb26590e7bd5ef4b8301))

🔧 chore jackson-databind, flatlaf, spotbugs-annotations, junit-jupiter, spotbugs-maven-plugin, spotbugs, checkstyle: Bump the maven-dependencies group

([d014379ef037559](https://github.com/Lob2018/CanScan/commit/d014379ef03755922de5933b71a58d33f6a6450b))

🔧 chore harden-runner, checkout, setup-java, codeql-action, cache, scorecard-action, setup-python: Bump the actions-dependencies group

([4f638acd2f54f56](https://github.com/Lob2018/CanScan/commit/4f638acd2f54f563a10d65c1b59d4364f5f12d19))

🔧 chore requirements.txt: Bump the python-dependencies

([ccd048efc12c476](https://github.com/Lob2018/CanScan/commit/ccd048efc12c476a5012ac0f8536b3310c271ea6))

📚 docs Doxygen

([703d5dd4825f67c](https://github.com/Lob2018/CanScan/commit/703d5dd4825f67c45f4fdda079cf68cf2f49ccfe))

🛠️ build canscan-setup.iss: Refactor the Visual C++ runtime dependency detection logic
-NeedsVC:
  -Replace registry-based checks with direct file-level version validation for VCRUNTIME140_1.dll.
  -Set 14 as the minimum major version threshold for binary compatibility.
  -Ensure robust fallback to installation if file metadata is unreachable.
-Tests pass.

([2ab9babbdc0ebd5](https://github.com/Lob2018/CanScan/commit/2ab9babbdc0ebd505410510ad663ea4b62b339c3))

📚 docs Doxygen

([3272427bed9d092](https://github.com/Lob2018/CanScan/commit/3272427bed9d092641652a4e91b38a895d3de806))

👷 ci Check VC_redist version

# Conflicts:
#	.github/workflows/natif.yml

([dbece1f099fc0ae](https://github.com/Lob2018/CanScan/commit/dbece1f099fc0ae7e00188030cfb705cac09dba5))

## v1.2.0.3 - 2026-06-28


✨ feat moved from v1.2.0.2 to v1.2.0.3

([3dfea1139e2d57a](https://github.com/Lob2018/CanScan/commit/3dfea1139e2d57afb9378b7f3c90aff57bdb42a1))

📚 docs Doxygen and add THIRD_PARTY_NOTICES.txt

([5601952cb2ce2d1](https://github.com/Lob2018/CanScan/commit/5601952cb2ce2d1540e520aa6dee60fdfa4d5bbf))

👷 ci add OSV scanner

([f45cefb7edc1785](https://github.com/Lob2018/CanScan/commit/f45cefb7edc1785c7578360448fe4b1c4aa6529a))

📝 style: Run automatic code formatter

([23e41c377b2422d](https://github.com/Lob2018/CanScan/commit/23e41c377b2422d3b3bdff8881c0a2cc6aa80e87))

♻️ refactor CanScan.java, GenerateAndSaveService.java, AbstractDynamicWorker.java, DynamicPreviewWorker.java, DynamicResizeWorker.java, GenerateAndSaveWorker.java: Implement Static Factory pattern and secure instantiation
-CanScan: Update instantiations to use create factory methods.
-GenerateAndSaveService: Set class to final.
-AbstractDynamicWorker: Remove defensive copy logic from constructor.
-DynamicPreviewWorker: Implement private constructor and create static factory method.
-DynamicResizeWorker: Implement private constructor and create static factory method.
-GenerateAndSaveWorker: Set class to final.
-Tests pass.

([f22ef35fe3d919f](https://github.com/Lob2018/CanScan/commit/f22ef35fe3d919f3bb61b24a912b1a387cd2604b))

🔧 chore jackson-databind, spotbugs-annotations, spotbugs, spotbugs-maven-plugin, checkstyle, jacoco-maven-plugin: bump maven dependencies

([ae19c136406a2d9](https://github.com/Lob2018/CanScan/commit/ae19c136406a2d980369da49cbcae9f5ed64ff39))

🔧 chore checkout, cache, setup-java, harden-runner, codeql-action, qodana-action, setup-python: bump actions dependencies and optimize pre-commit

([8980d6494fc6595](https://github.com/Lob2018/CanScan/commit/8980d6494fc6595522fcfffe6de3ab19854f6ab1))

✨ feat VC_redist.x64.exe: Replace existing binary with the latest version.
-Tests pass.

([bc3bab8af994b04](https://github.com/Lob2018/CanScan/commit/bc3bab8af994b04ecb4d79f278fe8fc49ab23a0c))

✨ feat natif.yml: Update Liberica and OpenJDK to version 25.0.3
-natif.yml : Update LIBERICA_VERSION, OPENJDK_VERSION, LIBERICA_MSI and LIBERICA_TGZ constants to 25.0.3+12.
-Tests pass.

([f313f0ef8384836](https://github.com/Lob2018/CanScan/commit/f313f0ef83848366c518e1c11620599cdbfe3361))

🔧 chore pom.xml: Bump versions

([b7c679e6b3a1ab4](https://github.com/Lob2018/CanScan/commit/b7c679e6b3a1ab4dc42ad3674897ca51d54c0613))

🔧 chore codeql-action: Bump version

([f406eb9eb37d7c2](https://github.com/Lob2018/CanScan/commit/f406eb9eb37d7c204b91610106aa4891bd117cb5))

👷 ci pre_commit_autoupdate.yml: Add bleeding-edge flag to pre-commit autoupdate workflow step
-Update the GitHub Actions workflow to run pre-commit autoupdate with the --bleeding-edge flag, ensuring alignment with the local configuration strategy.
-Tests pass.

([49fb989546167aa](https://github.com/Lob2018/CanScan/commit/49fb989546167aa328e34d0b0eb3737e8a36ef8f))

👷 ci .pre-commit-config.yaml: Upgrade pre-commit hooks and switch to bleeding-edge SHA tracking
-Update maintenance documentation to use --bleeding-edge flag during autoupdate.
-Refresh cryptographic SHAs for gitleaks and pre-commit-hooks.
-Fall back to native tag for shellcheck due to upstream repository constraints.
-Tests pass.

([c0b60e847e32394](https://github.com/Lob2018/CanScan/commit/c0b60e847e323942af57fe4f61f25babb06c5eff))

Merge branch &#x27;develop&#x27; of https://github.com/Lob2018/CanScan into develop

([9708091cd01854c](https://github.com/Lob2018/CanScan/commit/9708091cd01854c9d1b98ef097107f2691642369))

👷 ci .pre-commit-config.yaml: Pin hook revisions to immutable commit SHAs
-Replace mutable tags with cryptographic SHAs for gitleaks, shellcheck, and pre-commit-hooks to secure the CI/CD pipeline against tag tampering.
-Tests pass.

([ff46b8a404ddd5f](https://github.com/Lob2018/CanScan/commit/ff46b8a404ddd5f951e00012d973ccc4d5193f1d))

🔧 chore requirements.txt: Update all .venv packages &amp; hooks

([fe836bf1e915dc2](https://github.com/Lob2018/CanScan/commit/fe836bf1e915dc2853f1c346eb98a9bde85bba71))

🔧 chore requirements.txt: Update pre-commit-hooks group dependencies

([ef2830e3809e924](https://github.com/Lob2018/CanScan/commit/ef2830e3809e92450ceca1f1eae4f53c22b5ef7b))

📚 docs Doxygen

([67a399eeac472de](https://github.com/Lob2018/CanScan/commit/67a399eeac472ded34789f552bf6e9319d673c88))

📚 docs package-info.java: Add package documentation files
-Tests pass.

([22fa81664284f6b](https://github.com/Lob2018/CanScan/commit/22fa81664284f6b66cab4d62b5b0594a7fae74dd))

♻️ refactor README.md, CanScan.java, IntConstants.java, UiComponentsConfiguration.java, NativeImageConfigSimulator.java: Implement predictive length validation and ISO standards
- README.md:
	- Update Meet Nom field label to Organisateur in documentation
- CanScan.java:
	- Replace ABSOLUTE_MAX_CHARS with ISO_18004_HIGH_NUMERIC_MAX_CHAR_PLUS_1 in FieldConfig
- IntConstants.java:
	- Rename ABSOLUTE_MAX_CHARS to ISO_18004_HIGH_NUMERIC_MAX_CHAR_PLUS_1
	- Update value from 5000 to 3058
- UiComponentsConfiguration.java:
	- Implement isLengthSafe with predictive integer arithmetic
	- Optimize insertString and replace to use projectedLength
	- Add Javadoc for the new validation logic and ECI/ISO thresholds
- NativeImageConfigSimulator.java:
	- Update test case to use 3058 characters for boundary validation
- Tests pass.

([27a177eed520400](https://github.com/Lob2018/CanScan/commit/27a177eed520400c192566ee1ad07f5852b02977))

🔧 chore pom.xml: Bump com.puppycrawl.tools checkstyle

([368e429e62861d1](https://github.com/Lob2018/CanScan/commit/368e429e62861d150b0db68b827750964b1a2a25))

🔧 chore harden-runner, codeql-action: Bump the actions-dependencies

([adadeecb14a2c4b](https://github.com/Lob2018/CanScan/commit/adadeecb14a2c4b0a527c5b71723b4abd865674f))

♻️ refactor FieldConfig: Add JavaDoc for the compact constructor

([da09298962047e8](https://github.com/Lob2018/CanScan/commit/da09298962047e8164507a57cd191626fb24e9f7))

Save work before line ending normalization

([93bfe0d4fb635dd](https://github.com/Lob2018/CanScan/commit/93bfe0d4fb635dd457abb2b8f8b6acf56fc81ee2))

♻️ refactor UiComponentsConfiguration UiComponentsConfiguration: Reorganize agenda fields and update labels for better UX
-UiComponentsConfiguration:
	-Reassign meetTitleField to Titre label with updated tooltip and bold formatting.
	-Position Identifiant field (meetUIdField) immediately after Titre.
	-Rename meetNameField to Organisateur and move it to the bottom of the section.
	-Remove the temporary Référence label.
	-Standardize tooltips for Titre and Identifiant to clarify their roles in UID generation.
-Tests pass.

([00cedeae5445122](https://github.com/Lob2018/CanScan/commit/00cedeae54451225b484e1f6c3a2b3e72ec808ce))

♻️ refactor UiComponentsConfiguration: Update agenda field labels and tooltips for better UX
-UiComponentsConfiguration:
	-Reassign Titre label to meetNameField for better semantic mapping.
	-Remove redundant Identifiant field from the top of the grid.
	-Replace Nom field with Référence using meetTitleField as source.
	-Add Identifiant field linked to meetUIdField with explicit UID technical details.
	-Update all tooltips to clarify the distinction between reference, display title, and technical UID.
Tests pass.

([71f045ee10e77c8](https://github.com/Lob2018/CanScan/commit/71f045ee10e77c8b68c5bb22e485357ac8f1ea59))

## v1.2.0.2 - 2026-05-02


📚 docs Doxygen

([5933562c391a3cf](https://github.com/Lob2018/CanScan/commit/5933562c391a3cfc437b2761db71a62f58b42d60))

✨ feat CanScan, IntConstants, UiComponentsConfiguration, FieldConfig, FieldFilterType: implement modular field filtering and validation system
- CanScan: refactor automaticQRCodeRenderingForFieldsAndControls to use loops and FieldConfig
- IntConstants: add ABSOLUTE_MAX_CHARS constant set to 5000
- UiComponentsConfiguration: replace attachLimitedDocumentListener with configureFieldFilters
- UiComponentsConfiguration: add private applyFilter helper implementing STRICT, FREE, and NUMERIC strategies
- FieldConfig: create new record for UI field configuration with null-safe factory method
- FieldFilterType: create new enum defining sanitization strategies for text input
- Tests pass.

([517e6256372cb22](https://github.com/Lob2018/CanScan/commit/517e6256372cb221bee282d8ca04d39066ae034e))

👷 ci dependabot.yml, pre_commit_autoupdate.yml: Secure and automate pre-commit updates
-dependabot.yml:
  -Add pre-commit ecosystem to track hooks in .pre-commit-config.yaml
  -Implement grouping for pre-commit hooks to reduce PR noise
  -Update Python/Pip ecosystem comments
-pre_commit_autoupdate.yml:
  -Add Python setup step with pip caching
  -Replace generic pre-commit action with manual secure installation
  -Pin pip version to 26.1 and pre-commit to 4.6.0
  -Enforce --only-binary&#x3D;:all: for secure dependency resolution
  -Add explicit version check and autoupdate execution flow
-Tests pass.

([b616ade664bf1e5](https://github.com/Lob2018/CanScan/commit/b616ade664bf1e5dd700640193096a4665ddee02))

📚 docs Pre_commit (end of file and trim trailing whitespace)

([58b08289726f402](https://github.com/Lob2018/CanScan/commit/58b08289726f4023676788184ed8e323a5785202))

🐛 fix pre_commit_autoupdate.yml: pre-commit/action SHA to valid reference

([a238f7ef3c817b5](https://github.com/Lob2018/CanScan/commit/a238f7ef3c817b58cb3a5ccd6b58909f458e9756))

📝 style : Run automatic code formatter

([cdaf76d34936390](https://github.com/Lob2018/CanScan/commit/cdaf76d3493639005b2cafeb7d6dc5af641f4e56))

♻️ refactor dependabot.yml, pre_commit_autoupdate.yml, IntConstants, GenerateAndSaveService: Refactor CI maintenance and centralize constants
-dependabot.yml:
  -Add pip ecosystem tracking for requirements.txt.
  -Configure weekly schedule and grouping for Python dependencies.
-pre_commit_autoupdate.yml:
  -Replace manual Python setup and pip installation with official pre-commit/action.
  -Switch to versioned action with hash for enhanced security.
  -Simplify autoupdate logic and config change detection.
-IntConstants:
  -Add RESOLVING_FILE_NAME_CONFLICT_MAX_ATTEMPTS constant.
-GenerateAndSaveService:
  -Remove local MAX_ATTEMPTS constant.
  -Use IntConstants for file name conflict resolution attempts.
-Tests pass.

([a32b447757742f1](https://github.com/Lob2018/CanScan/commit/a32b447757742f133891744c4c5d513579cacb83))

✨ feat openssf_score_card.yml, README.md, pom.xml: Integrate OpenSSF Scorecard and Best Practices badges
-openssf_score_card.yml: Add new GitHub Actions workflow for automated security analysis.
-README.md: Add OpenSSF Best Practices and Scorecard status badges.
pom.xml: Bump project version to 1.2.0.2.
-Tests pass.

([ccf5eec9ae55151](https://github.com/Lob2018/CanScan/commit/ccf5eec9ae551516dfbfd98ad16476ccabfae2b0))

📚 docs README.md: Add Code of Conduct and update contribution icon

([30aac9d50d82d36](https://github.com/Lob2018/CanScan/commit/30aac9d50d82d363bfecaa30fa200ae6dc14aeb9))

📚 docs Doxygen

([1635e95be46030c](https://github.com/Lob2018/CanScan/commit/1635e95be46030cb20ea0466743d6e6e872d0510))

✨ feat pre_commit_autoupdate.yml, .gitignore, .pre-commit-config.yaml, CONTRIBUTING.md, README.md, CODEOWNERS, CODE_OF_CONDUCT.md: Add pre-commit quality hooks and comprehensive contribution guidelines
- pre_commit_autoupdate.yml:
    - Add automated workflow to check for pre-commit hook updates on main and develop branches.
- .gitignore:
    - Ignore additional image formats (qr, jpg, jpeg, svg).
    - Add ignore rules for JetBrains IDE metadata and various diagnostic/log files.
- .mvn/jvm.config:
    - Configure JVM options for UTF-8 encoding and native access permissions.
- .pre-commit-config.yaml:
    - Implement local Maven checkstyle hook.
    - Integrate gitleaks, shellcheck, end-of-file-fixer, and trailing-whitespace hooks.
- CODEOWNERS, CODE_OF_CONDUCT.md:
    - Establish project ownership and community behavioral standards.
- CONTRIBUTING.md:
    - Create detailed documentation for setup, coding standards (Google AOSP), testing policies, and commit message conventions.
- .myresources/scripts/natif.sh:
    - Refactor script to use boolean check structures for better error handling.
    - Modernize AppRun script generation using braced redirection and shellcheck ignores.
- README.md:
    - Add links to security and contribution documentation.
- Tests pass.

([03506083f9ec7da](https://github.com/Lob2018/CanScan/commit/03506083f9ec7da82898f95d55ecaddd317dcbb5))

🐛 fix CI/CD: Add explicit permissions to resolve CodeQL alerts

([663f0c1e7add5cd](https://github.com/Lob2018/CanScan/commit/663f0c1e7add5cd5a840fa5717680cbe1efde9fa))

🔧 chore jackson-databind, checkstyle: Bump the maven-dependencies

([5b22281431c2f54](https://github.com/Lob2018/CanScan/commit/5b22281431c2f5427717f57b7215fdd0fc2e4679))

🔧 chore harden-runner, qodana-action: Bump the actions-dependencies

([67c523fd6e1a2bc](https://github.com/Lob2018/CanScan/commit/67c523fd6e1a2bc49811e74f833b69b724a9d371))

🔧 chore harden-runner, codeql-action, upload-artifact: Bump the actions-dependencies group

([a1fd52734a07ddb](https://github.com/Lob2018/CanScan/commit/a1fd52734a07ddbb258c59a8ff49958815adeb66))

## v1.2.0.1 - 2026-04-10


📚 docs Doxygen

([06fac86483e752f](https://github.com/Lob2018/CanScan/commit/06fac86483e752f4a95706439eae0c6b9b5bf22d))

✨ feat pom.xml: Moved from 1.2.0.0 to 1.2.0.1 (incl. fix for jackson-core vuln. CWE‑770 CVSS 8.7)

([0c765c48f56303b](https://github.com/Lob2018/CanScan/commit/0c765c48f56303b3fe8f996ddc03f4bd1c13ff59))

🔧 chore spotbugs-maven-plugin, checkstyle: Bump the maven-dependencies

([765a412a3226563](https://github.com/Lob2018/CanScan/commit/765a412a32265634cf96f35970d57426c5fd08e6))

🔧 chore harden-runner, codeql-action: Bump the actions-dependencies

([efd0e25f97976b7](https://github.com/Lob2018/CanScan/commit/efd0e25f97976b7978ecf903771b7d5d79ff9624))

🔧 chore jackson-databind: Bump the maven-dependencies

([592252ab1ff2f7f](https://github.com/Lob2018/CanScan/commit/592252ab1ff2f7f31f76e43976b58c5ce5c3baae))

🔧 chore codeql-action: Bump the actions-dependencies

([206257836e769bc](https://github.com/Lob2018/CanScan/commit/206257836e769bc5269db1be4e977a891a5377e3))

🔧 chore spotless-maven-plugin : Bump the maven-dependencies

([96afe93ec159aa6](https://github.com/Lob2018/CanScan/commit/96afe93ec159aa6b61b39db7e3fefa0db755045a))

🔧 chore harden-runner, codeql-action, delete-artifact, qodana-action, release-action: Bump the actions-dependencies

([356fb6b8e489f30](https://github.com/Lob2018/CanScan/commit/356fb6b8e489f3000880f5de319eb5febc46b4ee))

🔧 chore flatlaf, flatlaf-intellij-themes, mockito-core: Bump the maven-dependencies

([c43161044b01aa5](https://github.com/Lob2018/CanScan/commit/c43161044b01aa522f83e9fa73dc3e58b4bec93f))

🔧 chore jacoco-reporter, download-artifact: Bump the actions-dependencies

([cb40c198969e7a0](https://github.com/Lob2018/CanScan/commit/cb40c198969e7a02f47a3320a98f10fd5202b0fe))

🔧 chore checkstyle, spotless-maven-plugin: Bump the maven-dependencies

([87737c926272af6](https://github.com/Lob2018/CanScan/commit/87737c926272af670c3241a0fed744473f14ca24))

🔧 chore harden-runner, codeql-action: Bump the actions-dependencies

([a97dfc794b890ab](https://github.com/Lob2018/CanScan/commit/a97dfc794b890ab2cf1e80a797ee739ad8ae86e1))

✨ feat GenerateAndSaveService, GenerateAndSaveServiceUTest: limit file naming attempts to 1000
- GenerateAndSaveService:
  - Implement maxAttempts constant set to 1000 in resolveFileNameConflict.
  - Add error dialog when unique file name generation fails after 1000 tries.
  - Refactor FileNameExtensionFilter to use direct import.
  - Update Javadoc to document safety limit and new return conditions.
- GenerateAndSaveServiceUTest:
  - Add givenOneThousandExistingFiles_whenResolveConflict_thenReturnNull test case.
  - Use MockedStatic to verify JOptionPane interactions and error messaging.
  - Refactor static mocks to use method-level static imports.
- Tests pass.

([25d654c2c70ce98](https://github.com/Lob2018/CanScan/commit/25d654c2c70ce9887cc14fc2f4f5e89e548a8514))

## v1.2.0.0 - 2026-02-27


🐛 fix CanScanUTest: Wrap parameterized validation test in invokeAndWait

([a86c426542327c9](https://github.com/Lob2018/CanScan/commit/a86c426542327c9195072e5b520ed9f5c9114fe5))

📝 style CanScanUTest: Run automatic code formatter

([466d54eb8e37655](https://github.com/Lob2018/CanScan/commit/466d54eb8e37655d597883605fe7b1ac15e7fe3d))

🐛 fix CanScanUTest: Ensure EDT compliance for UI initializations

([732a8ccf2184b91](https://github.com/Lob2018/CanScan/commit/732a8ccf2184b9167d017d0d5114e11e75808881))

✅ test CanScanUTest: Refine size validation test cases

([2484c69cc0e588c](https://github.com/Lob2018/CanScan/commit/2484c69cc0e588c0745da6c830bf0d054ca1ed5e))

📚 docs Doxygen

([5c6f8df53ed2a59](https://github.com/Lob2018/CanScan/commit/5c6f8df53ed2a59f321cf59fc4ec4a19a6cbbc55))

🔧 chore mockito-core, maven-surefire-plugin: Bump the maven-dependencies

([a4414a05bad28bb](https://github.com/Lob2018/CanScan/commit/a4414a05bad28bb8137b7a565ac16f65fc5bc151))

🔧 chore harden-runner, codeql-action, upload-artifact, download-artifact: Bump the actions-dependencies

([fb3a74c432b2243](https://github.com/Lob2018/CanScan/commit/fb3a74c432b2243810ae6892a54e534d78a79369))

Merge branch &#x27;develop&#x27; of https://github.com/Lob2018/CanScan into develop

([5fe1840d0ff2e96](https://github.com/Lob2018/CanScan/commit/5fe1840d0ff2e963167df8a362633f01f0b96579))

✨ feat pom.xml, EncodedImage: bump version to 1.2.0.0 and implement logo center crop
- EncodedImage:
    - Update drawLogoIfPresent Javadoc to document center cropping and bilinear interpolation.
    - Implement source coordinate calculations (w, h, edge, xOffset, yOffset) for 1:1 square extraction.
    - Prevent logo distortion for non-square source images (e.g., 3000x1000).
    - Use drawImage with source region parameters to optimize memory and rendering performance.
- Tests pass.

([8ef56ff87f2a237](https://github.com/Lob2018/CanScan/commit/8ef56ff87f2a237c026bdde1a0818058b7b6423f))

Fix download badge link in README.md

([6676ad4569a59ca](https://github.com/Lob2018/CanScan/commit/6676ad4569a59ca56528514318fcaf8255175202))

## v1.1.0.0 - 2026-02-26


📚 docs Doxygen

([faabd8010c19929](https://github.com/Lob2018/CanScan/commit/faabd8010c19929b38432b85c0ba559b9f19b5f0))

🐛 fix CanScanUTest: Fix race condition and text accumulation in size validation test
- CanScanUTest:
	- Remove default size field initialization from setUp to ensure test isolation.
	- Wrap size validation logic in invokeAndWait to ensure thread-safe execution on the Event Dispatch Thread (EDT).
	- Move assertion inside the EDT block to guarantee state consistency.
	- Add descriptive error message to size assertion.
- Tests pass.

([ce338d01fca2a9c](https://github.com/Lob2018/CanScan/commit/ce338d01fca2a9c9ef38f56db9b9377677fa56c5))

♻️ refactor CanScan, VersionService, UiComponentsConfiguration, FontManager: Replace magic numbers with named constants
- CanScan:
	- Define DEFAULT_SCROLLBAR_WIDTH constant.
	- Use constant for fallback scrollbar width calculation.
- VersionService:
	- Define HTTP_FORBIDDEN and HTTP_NOT_FOUND constants.
	- Replace literal status codes in GitHub API response handling.
	- UiComponentsConfiguration:
	- Define GENRATE_BUTTON_HEIGHT_SCALING_FACTOR constant.
	- Use constant for generate button dimension calculation.
- FontManager:
	- Define BASELINE_CORRECTION_FACTOR constant.
	- Use constant for vertical offset calculation.
- Tests pass.

([4348deacafdd0e5](https://github.com/Lob2018/CanScan/commit/4348deacafdd0e52e8500e9780bf2340a006475e))

👷 ci .github/workflows/codeql.yml, .github/workflows/develop.yml, .github/workflows/natif.yml: Update GitHub Actions and enable SonarCloud analysis
- codeql.yml:
	- Pin GitHub Actions to specific SHA for security (checkout, setup-java, codeql-action).
	- Update CodeQL actions to v4.32.0.
	- Update setup-java to v5.2.0.
- develop.yml:
	- Enable SonarCloud analysis by uncommenting SONAR_TOKEN and sonar-maven-plugin execution.
- natif.yml:
	- Enable SonarCloud analysis by uncommenting SONAR_TOKEN and sonar-maven-plugin execution.
- Tests pass.

([c914734b333e71f](https://github.com/Lob2018/CanScan/commit/c914734b333e71ff58c45bc73d06b06498483c72))

Merge pull request #10 from soft64fr/develop

✨ feat: Implement OS-independent scaling, CI/CD stabilization and Linux AppImage enhancements

([3136898031c2820](https://github.com/Lob2018/CanScan/commit/3136898031c28205ce101b54d51986cb6b572849))

✨ feat CanScan, FontManager, FontManagerUTest, UiComponentsConfiguration, DynamicResizeWorker, AbstractDynamicWorker, DynamicPreviewWorker, GenerateAndSaveWorker, CanScanUTest, DataBuilderServiceUTest, GenerateAndSaveServiceUTest, ValidationFieldHelperUTest, MyPopupUTest, natif.sh, natif.yml, develop.yml, codeql.yml, coverage_report.yml, pom.xml, StringConstants, NativeImageConfigSimulator: Implement OS-independent scaling, stabilize CI/CD workflows and enhance Linux AppImage integration
- CanScan:
    - Implement FontManager scaling for UI components and QR labels.
    - Set awt.appname system property for correct Linux WM identification.
    - Switch graphics pipeline from OpenGL to XRender for Linux stability.
- FontManager:
    - Add getScaledDimension logic and BASE_LINE_HEIGHT_REFERENCE constant.
    - Add comprehensive Javadoc for all scaling methods.
- FontManagerUTest:
    - Add unit tests for proportional scaling and fallback mechanisms.
- AbstractDynamicWorker, DynamicPreviewWorker, DynamicResizeWorker, GenerateAndSaveWorker:
    - Secure workers against asynchronous disposal and NullPointerException.
    - Add guards for headless CI environments.
- CanScanUTest:
    - Fix race conditions and field concatenation using EDT flushing and resource disposal.
    - Add @DisplayName and Javadoc documentation for the entire suite.
- DataBuilderServiceUTest, GenerateAndSaveServiceUTest, ValidationFieldHelperUTest, MyPopupUTest:
    - Add Javadoc for all classes and methods.
    - Standardize prefixes for test display names.
- natif.sh:
    - Fix WM_CLASS mapping and simplify icon handling using canonical naming.
    - Enhance AppImage metadata with version and identifier fields.
- natif.yml, develop.yml, codeql.yml, coverage_report.yml:
    - Standardize JAVA_TOOL_OPTIONS and enforce French locale for deterministic tests.
    - Stabilize AWT/Xvfb execution on Windows and Ubuntu runners.
- pom.xml:
    - Configure maven-surefire-plugin for detailed console reporting and plain format.
- StringConstants:
    - Add XRender pipeline constants.
- NativeImageConfigSimulator:
    - Update trace generation logic with correct app identity and XRender support.
- Tests pass.

([90db80db44c3f71](https://github.com/Lob2018/CanScan/commit/90db80db44c3f71f4bbaaaea531f5233e2be636d))

👷 ci .github/workflows/natif.yml: Switch to cmd shell for locale extraction on Windows
- Replace bash shell with cmd for the locale properties extraction step.
- Implement for /f loops to correctly capture Maven output in cmd environment.
- Use native Windows backslash path syntax for mvnw.cmd.
- Update GITHUB_ENV injection syntax to use %variable% format.
- Tests pass.

([a2ef892cd7df877](https://github.com/Lob2018/CanScan/commit/a2ef892cd7df8779a0c70eff64f412d8a1f1b33e))

👷 ci .github/workflows/natif.yml: Fix mvnw execution paths and permissions
- Update mvnw.cmd calls to use forward slashes ./ for Bash compatibility on Windows runner.
- Add chmod +x mvnw in package_for_ubuntu job to grant execution permissions.
- Add chmod +x mvnw in publish_release job to ensure Maven wrapper is executable on Linux.
- Tests pass.

([b51dfa731638203](https://github.com/Lob2018/CanScan/commit/b51dfa73163820378c526a7dcfa1c149d6ea62ae))

✨ feat pom.xml, VersionService, module-info.java: Replace manual regex parsing with Jackson for GitHub API
- pom.xml:
	- Add jackson-databind dependency version 2.21.1.
- VersionService:
	- Replace Regex-based parsing with ObjectMapper for robust JSON handling.
	- Implement parseResponse to process InputStream and extract release tags.
	- Add MAX_TAGS_RESPONSE_SIZE and MAX_TAG_NAME_LENGTH constants for memory safety.
	- Refactor doInBackground to use specific exception types (IOException, HttpTimeoutException) instead of generic blocks.
	- Improve HTML tooltip building using new constants OPEN_HTML and TOOLTIP_PREFIX.
	- Remove manual TLS 1.3 configuration in favor of default HttpClient settings.
	- Standardize Javadoc for all methods and the enum itself.
- module-info.java:
	- Add requires com.fasterxml.jackson.databind.
- Tests pass.

([fa97d6cb3ff6ec7](https://github.com/Lob2018/CanScan/commit/fa97d6cb3ff6ec76d993358ab76882ed2a96b05e))

✨ feat ColorOperation, FontManager ColorOperation, FontManager: Implement dynamic font shifting and icon scaling
- ColorOperation:
    - Replace fixed BUTTON_ICON_COLOR_SIZE with FontManager.INSTANCE.getCharWidth().
    - Refactor Graphics2D handling with immediate initialization and streamlined disposal.
    - Switch to Rectangle2D.Float for high-precision border rendering.
    - Add antialiasing rendering hints for smoother icon edges.
- FontManager:
    - Remove hardcoded FONT_SHIFT_DOWN constant.
    - Implement calculateVerticalOffset using LineMetrics for OS-agnostic baseline adjustment.
    - Use a 0.11 divisor ratio on font descent to achieve perfect vertical centering.
    - Simplify method documentation and clean up unused comments.
- Tests pass.

([0f50bbe584aca65](https://github.com/Lob2018/CanScan/commit/0f50bbe584aca650edd51040b5e9de41abcc3b17))

✨ feat CanScan, UiComponentsConfiguration: Optimize window sizing and UI component scaling for Linux parity
- CanScan :
    - Update Javadoc to reflect dynamic metric usage.
    - Move setLoaderSize before pack to stabilize initial layout and prevent component crushing.
    - Use Insets and UIManager ScrollBar width for precise window sizing to suppress Linux ghost scrollbars.
    - Refactor calculateAvailableQrCodeLabelHeight to use JViewport bounds with a ContentPane fallback, removing manual gap offsets.
- UiComponentsConfiguration:
    - Update Javadoc for configureGenerateButton to reflect new sizing logic.
    - Use getPreferredSize instead of getWidth/getHeight to ensure valid dimensions on GTK/Linux.
    - Remove maximumSize constraint on generate button.
- Tests pass.

([7f2ab2a197d6414](https://github.com/Lob2018/CanScan/commit/7f2ab2a197d64149feea82db1c5cc076f065fbed))

🔧 chore junit-jupiter, checkstyle, : Bump the maven-dependencies

([4f071573afd81d3](https://github.com/Lob2018/CanScan/commit/4f071573afd81d3275da408304168243f02e91af))

🛠️ build .idea/misc.xml, .sdkmanrc: Update Java SDK to version 25.0.2
-.idea/misc.xml:
	-Update project-jdk-name to graalvm-25 (2) to match new local environment configuration.
-.sdkmanrc:
	-Update java version from 23.1.9.r21-nik to 25.0.2.fx-nik.
	-Standardize file format with SDKMAN auto-env headers.
-Tests pass.

([f0105c17b37d4ab](https://github.com/Lob2018/CanScan/commit/f0105c17b37d4ab81320cb070099648ae1f92209))

👷 ci: fix executable permission for mvnw

([7e0def8565866d7](https://github.com/Lob2018/CanScan/commit/7e0def8565866d7ec1bf30377f2ac7c7324d9731))

👷 ci codeql.yml, coverage_report.yml, develop.yml, natif.yml, maven-wrapper.properties, natif.cmd, mvnw, mvnw.cmd, pom.xml, SECURITY.md: Add CodeQL and JaCoCo workflows with Maven Wrapper integration

([b725138858c39a1](https://github.com/Lob2018/CanScan/commit/b725138858c39a1bbbbbad5caecefba1ede63a6d))

♻️ refactor .gitignore: Merge build artifacts and add python/AI exclusions

([fc0f70b58ebab5c](https://github.com/Lob2018/CanScan/commit/fc0f70b58ebab5cb82a4449e42a42a5649d8615a))

👷 ci natif.yml, qodana_code_quality.yml: Secure qodana and link native build to production

([0942ef1d3657d71](https://github.com/Lob2018/CanScan/commit/0942ef1d3657d71171d4cbea06c4e687a9912796))

📚 docs SECURITY.md added

([d6a1b7ff9bcd8ea](https://github.com/Lob2018/CanScan/commit/d6a1b7ff9bcd8ea444e50a33e0c49916fe3122b6))

🛠️ build pom.xml: Set provided scope for spotbugs annotations

([11a782c90e24419](https://github.com/Lob2018/CanScan/commit/11a782c90e24419ad049978357243e04e28d3836))

🐛 fix CanScanUTest: Prevent value concatenation in shared generator

([87008721148dae8](https://github.com/Lob2018/CanScan/commit/87008721148dae85e56d623f5f726fba8ab25872))

📚 docs: Doxygen

([50f59c7ab6b6e66](https://github.com/Lob2018/CanScan/commit/50f59c7ab6b6e66de796ce998249776178a78d1c))

♻️ refactor DataBuilderService, GenerateAndSaveService, AbstractDynamicWorker, DynamicPreviewWorker, DynamicResizeWorker, GenerateAndSaveWorker, MyPopup, BrowserHelper, Checker, CanScan: Standardize null-safety validation and documentation

([30a90a4594b5981](https://github.com/Lob2018/CanScan/commit/30a90a4594b5981e4bce95c4c81d67e91e74c7af))

🐛 fix: SpotBugs security and stability findings

([5670bca5c8a910d](https://github.com/Lob2018/CanScan/commit/5670bca5c8a910db6214a2f4ded6789cc68a4b6d))

✨ feat canscan-setup.iss: Implement application lifecycle management

([629df0ff1ab1271](https://github.com/Lob2018/CanScan/commit/629df0ff1ab1271e838b26aa6c5f5c320798b27d))

📚 docs Doxygen

([8bfc6cd966272b5](https://github.com/Lob2018/CanScan/commit/8bfc6cd966272b525f44741ded7648b531dfdf3e))

📚 docs README.md, LICENSE.txt: Update VC++ Redistributable licensing and distribution

([31e5510fd43321d](https://github.com/Lob2018/CanScan/commit/31e5510fd43321dbb0a167f86152398f43b80fa2))

♻️ refactor natif.yml, natif.cmd: Consolidate to a single Windows installer

([677e6329afd37da](https://github.com/Lob2018/CanScan/commit/677e6329afd37da37d5fe5b45012f6a0d0ed7f04))

♻️ refactor CanScan.java, pom.xml, canscan-setup.iss, SpotBugs__GUI_.xml: Modernize graphics pipeline and integrate SpotBugs
- CanScan.java: Refactor &#x60;configureGraphicsPipeline&#x60; using Java 25 &#x60;switch&#x60; pattern matching and &#x60;when&#x60; guards.
- pom.xml: Add &#x60;spotbugs-maven-plugin&#x60; v4.9.8.2 to the build lifecycle for static analysis.
- canscan-setup.iss: Update labels and error messages for Microsoft Visual C++ v14 Redistributable.
- SpotBugs__GUI_.xml: Create IntelliJ run configuration for SpotBugs GUI
- Logic: Standardize OS-based system property configuration.
- Tests pass.

([1661ff0380fcb32](https://github.com/Lob2018/CanScan/commit/1661ff0380fcb320b27bf1bf135785c2f560042f))

🐛 fix StringConstants: Secure OS detection with Locale.ROOT

([3130f8c6dfc3b6d](https://github.com/Lob2018/CanScan/commit/3130f8c6dfc3b6d94668eab95ca1fd1e834336cb))

🐛 fix AbstractDynamicWorker, GenerateAndSaveWorker, EncodedImage, BrowserHelper, ValidationFieldHelper, CoordinateHelper: Use unnamed variables for ignored exceptions

([0b41d9e16d846b5](https://github.com/Lob2018/CanScan/commit/0b41d9e16d846b54d050964a0a0de5d474b2952d))

🐛 fix VersionService: Replace &quot;e&quot; with an unnamed pattern

([3e79997afd9af05](https://github.com/Lob2018/CanScan/commit/3e79997afd9af05aaeb8a83ca0925c3abd9b59e3))

📚 docs Doxygen

([8efec2edca5f390](https://github.com/Lob2018/CanScan/commit/8efec2edca5f39048e06b16427b031df937d2c5e))

♻️ refactor develop.yml, natif.yml, encodings.xml, canscan-setup.iss, canscan-winget.iss, natif.cmd, natif.sh, VC_redist.x64.exe, IntConstants, ApplicationMetadata, LICENSE.txt, pom.xml, README.md : Upgrade to JDK 25 and modernize build ecosystem
- Bump Java version from 21 to 25 in pom.xml and GitHub Workflows.
- Update Liberica NIK to version 25.0.2 with matching OpenJDK 25.0.2+13.
- Replace manual MSVC initialization with ilammy/msvc-dev-cmd@v1 in CI.
- Implement support for **Winget*- distribution with a dedicated Inno Setup script (canscan-winget.iss).
- Rename standard installer script to canscan-setup.iss and update .idea/encodings.xml.
- Modernize native-image build scripts (natif.cmd/natif.sh) with --enable-native-access, -H:IncludeLocales, and HiDPI properties.
- Update LICENSE.txt and README.md to clarify VCRedist bundling strategy.
- Adjust ApplicationMetadata to remove title emoji and refine IntConstants layout width.
- Modernized build pipeline and improved distribution options
- Tests pass.

([2e165d430bc3a00](https://github.com/Lob2018/CanScan/commit/2e165d430bc3a00620a0ed8d5bee2f29843880c1))

✨ feat CanScan, StringConstants, CanScanx256.png: Add window icon and HiDPI graphics pipeline
- Add initializeWindowIcon method to set the application taskbar icon.
- Add configureGraphicsPipeline to enable hardware acceleration (D3D/OpenGL) and HiDPI scaling based on OS.
- Add CanScanx256.png resource file.
- Update StringConstants with new keys for Java2D properties. - Improved UI sharpness and native OS integration
- Tests pass.

([36f5b9f20568042](https://github.com/Lob2018/CanScan/commit/36f5b9f205680426a133322012ee9dbd12ad217e))

📚 docs Doxygen

([b2240772a431057](https://github.com/Lob2018/CanScan/commit/b2240772a431057ea5b9ede02eef1fb64c4eb878))

🛠️ build pom.xml: Bump from 1.0.1.3 to 1.1.0.0

([2173c43a31c6dcb](https://github.com/Lob2018/CanScan/commit/2173c43a31c6dcbd550991bd1fa798c234f48150))

♻️ refactor VersionService, VersionValue, CanScan: Implementation of VersionValue record and switch pattern matching
- Migrated version check logic to use VersionValue record for improved data encapsulation.
- Replaced boolean return with VersionValue in requestAndVerify and checkLatestVersion.
- Implemented switch expression for HTTP status code handling (200, 403, 404).
- Updated SwingWorker and npeCheckLatestVersion to handle the new return type.
- Refined UI tooltips with localized status messages and GitHub URLs.
- Tests pass.

([ecfbdff64260739](https://github.com/Lob2018/CanScan/commit/ecfbdff64260739314bb082dd32c874afcb3a3dc))

🛠️ build misc.xml: Upgrade Java SDK from 21 to 25

([abb4595e65d916f](https://github.com/Lob2018/CanScan/commit/abb4595e65d916f82670b727549f00cf802ce3f2))

📚 docs README.md: Add Winget and manual update procedures

([b0e4de6fa6e86b7](https://github.com/Lob2018/CanScan/commit/b0e4de6fa6e86b72b13d421c3968ac0e3e0d7498))

📚 docs README.md: Add winget installation method

([45dc1256a564be6](https://github.com/Lob2018/CanScan/commit/45dc1256a564be6d3824c06ad4e50df58af64ea6))

🐛 fix CI/CD natif.yml: Enforce HTTPS for external tool downloads

([f4a2ffa2776a6df](https://github.com/Lob2018/CanScan/commit/f4a2ffa2776a6dfc745fa42e161c7278133cd52a))

📚 docs README.md: Remove and update code signing policy with SignPath (Windows)

([5a6b8f7ed5586ed](https://github.com/Lob2018/CanScan/commit/5a6b8f7ed5586edf86f0b6096fc51192f0783c91))

🔧 chore pom.xml spotless-maven-plugin, CI/CD harden-runner: Update

([93bf5372f4e8e72](https://github.com/Lob2018/CanScan/commit/93bf5372f4e8e72e3113a43c78806f88e76560dc))

🔧 chore spotless-maven-plugin: Update

([a96ef88e216ee90](https://github.com/Lob2018/CanScan/commit/a96ef88e216ee905ec6155baffd7b759063f2bc9))

📚 docs README.md: Add total download badge

([5336a82fe35a707](https://github.com/Lob2018/CanScan/commit/5336a82fe35a7079a52fbadc1dd6510c8ce51d05))

## v1.0.1.3 - 2026-01-17


🛠️ build pom.xml: Increment version to 1.0.1.3

([4f938b8e32c9827](https://github.com/Lob2018/CanScan/commit/4f938b8e32c9827534ffb04eb483be24de069ea5))

🐛 fix VersionService: Add User-Agent identification for version check

([66e1b9ec4d7737d](https://github.com/Lob2018/CanScan/commit/66e1b9ec4d7737d7ee62827e1601ba5daa640e51))

🛠️ build pom.xml: Increment version to 1.0.1.2

([8c3d9b9ad8c76fc](https://github.com/Lob2018/CanScan/commit/8c3d9b9ad8c76fc55f171198dbd6f26be6435806))

Merge pull request #3 from Lob2018/dependabot/maven/maven-dependencies-2f19515798

Bump the maven-dependencies group with 12 updates

([91ad2b971f4d37a](https://github.com/Lob2018/CanScan/commit/91ad2b971f4d37aebdfde31e63afe7aecb001d73))

Merge pull request #2 from Lob2018/dependabot/github_actions/actions-dependencies-b489397639

Bump the actions-dependencies group with 7 updates

([84d80aaaf07c580](https://github.com/Lob2018/CanScan/commit/84d80aaaf07c5804f47d85eef15ea340c2aadcc6))

Bump the maven-dependencies group with 12 updates

Bumps the maven-dependencies group with 12 updates:

| Package | From | To |
| --- | --- | --- |
| [com.formdev:flatlaf](https://github.com/JFormDesigner/FlatLaf) | &#x60;3.6.2&#x60; | &#x60;3.7&#x60; |
| [com.formdev:flatlaf-intellij-themes](https://github.com/JFormDesigner/FlatLaf) | &#x60;3.6.2&#x60; | &#x60;3.7&#x60; |
| [com.google.zxing:core](https://github.com/zxing/zxing) | &#x60;3.5.3&#x60; | &#x60;3.5.4&#x60; |
| [com.google.zxing:javase](https://github.com/zxing/zxing) | &#x60;3.5.3&#x60; | &#x60;3.5.4&#x60; |
| org.apache.commons:commons-lang3 | &#x60;3.19.0&#x60; | &#x60;3.20.0&#x60; |
| [org.junit.jupiter:junit-jupiter](https://github.com/junit-team/junit-framework) | &#x60;5.10.0&#x60; | &#x60;6.0.2&#x60; |
| [org.mockito:mockito-core](https://github.com/mockito/mockito) | &#x60;5.6.0&#x60; | &#x60;5.21.0&#x60; |
| [com.puppycrawl.tools:checkstyle](https://github.com/checkstyle/checkstyle) | &#x60;12.0.1&#x60; | &#x60;13.0.0&#x60; |
| [com.diffplug.spotless:spotless-maven-plugin](https://github.com/diffplug/spotless) | &#x60;3.0.0&#x60; | &#x60;3.1.0&#x60; |
| [org.apache.maven.plugins:maven-antrun-plugin](https://github.com/apache/maven-antrun-plugin) | &#x60;3.1.0&#x60; | &#x60;3.2.0&#x60; |
| [org.apache.maven.plugins:maven-assembly-plugin](https://github.com/apache/maven-assembly-plugin) | &#x60;3.7.1&#x60; | &#x60;3.8.0&#x60; |
| [org.codehaus.mojo:exec-maven-plugin](https://github.com/mojohaus/exec-maven-plugin) | &#x60;3.6.2&#x60; | &#x60;3.6.3&#x60; |


Updates &#x60;com.formdev:flatlaf&#x60; from 3.6.2 to 3.7
- [Release notes](https://github.com/JFormDesigner/FlatLaf/releases)
- [Changelog](https://github.com/JFormDesigner/FlatLaf/blob/main/CHANGELOG.md)
- [Commits](https://github.com/JFormDesigner/FlatLaf/compare/3.6.2...3.7)

Updates &#x60;com.formdev:flatlaf-intellij-themes&#x60; from 3.6.2 to 3.7
- [Release notes](https://github.com/JFormDesigner/FlatLaf/releases)
- [Changelog](https://github.com/JFormDesigner/FlatLaf/blob/main/CHANGELOG.md)
- [Commits](https://github.com/JFormDesigner/FlatLaf/compare/3.6.2...3.7)

Updates &#x60;com.google.zxing:core&#x60; from 3.5.3 to 3.5.4
- [Release notes](https://github.com/zxing/zxing/releases)
- [Changelog](https://github.com/zxing/zxing/blob/master/CHANGES)
- [Commits](https://github.com/zxing/zxing/compare/zxing-3.5.3...zxing-3.5.4)

Updates &#x60;com.google.zxing:javase&#x60; from 3.5.3 to 3.5.4
- [Release notes](https://github.com/zxing/zxing/releases)
- [Changelog](https://github.com/zxing/zxing/blob/master/CHANGES)
- [Commits](https://github.com/zxing/zxing/compare/zxing-3.5.3...zxing-3.5.4)

Updates &#x60;org.apache.commons:commons-lang3&#x60; from 3.19.0 to 3.20.0

Updates &#x60;org.junit.jupiter:junit-jupiter&#x60; from 5.10.0 to 6.0.2
- [Release notes](https://github.com/junit-team/junit-framework/releases)
- [Commits](https://github.com/junit-team/junit-framework/compare/r5.10.0...r6.0.2)

Updates &#x60;org.mockito:mockito-core&#x60; from 5.6.0 to 5.21.0
- [Release notes](https://github.com/mockito/mockito/releases)
- [Commits](https://github.com/mockito/mockito/compare/v5.6.0...v5.21.0)

Updates &#x60;com.puppycrawl.tools:checkstyle&#x60; from 12.0.1 to 13.0.0
- [Release notes](https://github.com/checkstyle/checkstyle/releases)
- [Commits](https://github.com/checkstyle/checkstyle/compare/checkstyle-12.0.1...checkstyle-13.0.0)

Updates &#x60;com.diffplug.spotless:spotless-maven-plugin&#x60; from 3.0.0 to 3.1.0
- [Release notes](https://github.com/diffplug/spotless/releases)
- [Changelog](https://github.com/diffplug/spotless/blob/main/CHANGES.md)
- [Commits](https://github.com/diffplug/spotless/compare/lib/3.0.0...lib/3.1.0)

Updates &#x60;org.apache.maven.plugins:maven-antrun-plugin&#x60; from 3.1.0 to 3.2.0
- [Release notes](https://github.com/apache/maven-antrun-plugin/releases)
- [Commits](https://github.com/apache/maven-antrun-plugin/compare/maven-antrun-plugin-3.1.0...maven-antrun-plugin-3.2.0)

Updates &#x60;org.apache.maven.plugins:maven-assembly-plugin&#x60; from 3.7.1 to 3.8.0
- [Release notes](https://github.com/apache/maven-assembly-plugin/releases)
- [Commits](https://github.com/apache/maven-assembly-plugin/compare/maven-assembly-plugin-3.7.1...v3.8.0)

Updates &#x60;org.codehaus.mojo:exec-maven-plugin&#x60; from 3.6.2 to 3.6.3
- [Release notes](https://github.com/mojohaus/exec-maven-plugin/releases)
- [Commits](https://github.com/mojohaus/exec-maven-plugin/compare/3.6.2...3.6.3)

---
updated-dependencies:
- dependency-name: com.formdev:flatlaf
  dependency-version: &#x27;3.7&#x27;
  dependency-type: direct:production
  update-type: version-update:semver-minor
  dependency-group: maven-dependencies
- dependency-name: com.formdev:flatlaf-intellij-themes
  dependency-version: &#x27;3.7&#x27;
  dependency-type: direct:production
  update-type: version-update:semver-minor
  dependency-group: maven-dependencies
- dependency-name: com.google.zxing:core
  dependency-version: 3.5.4
  dependency-type: direct:production
  update-type: version-update:semver-patch
  dependency-group: maven-dependencies
- dependency-name: com.google.zxing:javase
  dependency-version: 3.5.4
  dependency-type: direct:production
  update-type: version-update:semver-patch
  dependency-group: maven-dependencies
- dependency-name: org.apache.commons:commons-lang3
  dependency-version: 3.20.0
  dependency-type: direct:production
  update-type: version-update:semver-minor
  dependency-group: maven-dependencies
- dependency-name: org.junit.jupiter:junit-jupiter
  dependency-version: 6.0.2
  dependency-type: direct:development
  update-type: version-update:semver-major
  dependency-group: maven-dependencies
- dependency-name: org.mockito:mockito-core
  dependency-version: 5.21.0
  dependency-type: direct:development
  update-type: version-update:semver-minor
  dependency-group: maven-dependencies
- dependency-name: com.puppycrawl.tools:checkstyle
  dependency-version: 13.0.0
  dependency-type: direct:production
  update-type: version-update:semver-major
  dependency-group: maven-dependencies
- dependency-name: com.diffplug.spotless:spotless-maven-plugin
  dependency-version: 3.1.0
  dependency-type: direct:production
  update-type: version-update:semver-minor
  dependency-group: maven-dependencies
- dependency-name: org.apache.maven.plugins:maven-antrun-plugin
  dependency-version: 3.2.0
  dependency-type: direct:production
  update-type: version-update:semver-minor
  dependency-group: maven-dependencies
- dependency-name: org.apache.maven.plugins:maven-assembly-plugin
  dependency-version: 3.8.0
  dependency-type: direct:production
  update-type: version-update:semver-minor
  dependency-group: maven-dependencies
- dependency-name: org.codehaus.mojo:exec-maven-plugin
  dependency-version: 3.6.3
  dependency-type: direct:production
  update-type: version-update:semver-patch
  dependency-group: maven-dependencies
...

Signed-off-by: dependabot[bot] &lt;support@github.com&gt;

([0b55380b7cd90fb](https://github.com/Lob2018/CanScan/commit/0b55380b7cd90fb3b2cd1421533dfbd246e93939))

Bump the actions-dependencies group with 7 updates

Bumps the actions-dependencies group with 7 updates:

| Package | From | To |
| --- | --- | --- |
| [step-security/harden-runner](https://github.com/step-security/harden-runner) | &#x60;2.13.1&#x60; | &#x60;2.14.0&#x60; |
| [actions/checkout](https://github.com/actions/checkout) | &#x60;4&#x60; | &#x60;6&#x60; |
| [actions/setup-java](https://github.com/actions/setup-java) | &#x60;4&#x60; | &#x60;5&#x60; |
| [actions/cache](https://github.com/actions/cache) | &#x60;3&#x60; | &#x60;5&#x60; |
| [actions/upload-artifact](https://github.com/actions/upload-artifact) | &#x60;4&#x60; | &#x60;6&#x60; |
| [actions/download-artifact](https://github.com/actions/download-artifact) | &#x60;4&#x60; | &#x60;7&#x60; |
| [JetBrains/qodana-action](https://github.com/jetbrains/qodana-action) | &#x60;2025.2.1&#x60; | &#x60;2025.3.1&#x60; |


Updates &#x60;step-security/harden-runner&#x60; from 2.13.1 to 2.14.0
- [Release notes](https://github.com/step-security/harden-runner/releases)
- [Commits](https://github.com/step-security/harden-runner/compare/f4a75cfd619ee5ce8d5b864b0d183aff3c69b55a...20cf305ff2072d973412fa9b1e3a4f227bda3c76)

Updates &#x60;actions/checkout&#x60; from 4 to 6
- [Release notes](https://github.com/actions/checkout/releases)
- [Changelog](https://github.com/actions/checkout/blob/main/CHANGELOG.md)
- [Commits](https://github.com/actions/checkout/compare/v4...v6)

Updates &#x60;actions/setup-java&#x60; from 4 to 5
- [Release notes](https://github.com/actions/setup-java/releases)
- [Commits](https://github.com/actions/setup-java/compare/v4...v5)

Updates &#x60;actions/cache&#x60; from 3 to 5
- [Release notes](https://github.com/actions/cache/releases)
- [Changelog](https://github.com/actions/cache/blob/main/RELEASES.md)
- [Commits](https://github.com/actions/cache/compare/v3...v5)

Updates &#x60;actions/upload-artifact&#x60; from 4 to 6
- [Release notes](https://github.com/actions/upload-artifact/releases)
- [Commits](https://github.com/actions/upload-artifact/compare/v4...v6)

Updates &#x60;actions/download-artifact&#x60; from 4 to 7
- [Release notes](https://github.com/actions/download-artifact/releases)
- [Commits](https://github.com/actions/download-artifact/compare/v4...v7)

Updates &#x60;JetBrains/qodana-action&#x60; from 2025.2.1 to 2025.3.1
- [Release notes](https://github.com/jetbrains/qodana-action/releases)
- [Commits](https://github.com/jetbrains/qodana-action/compare/27de2a744479d1d731934eeaf79287575ebc5dd3...42dad391966aca8ca344ca2340a7f43a5507e9b2)

---
updated-dependencies:
- dependency-name: step-security/harden-runner
  dependency-version: 2.14.0
  dependency-type: direct:production
  update-type: version-update:semver-minor
  dependency-group: actions-dependencies
- dependency-name: actions/checkout
  dependency-version: &#x27;6&#x27;
  dependency-type: direct:production
  update-type: version-update:semver-major
  dependency-group: actions-dependencies
- dependency-name: actions/setup-java
  dependency-version: &#x27;5&#x27;
  dependency-type: direct:production
  update-type: version-update:semver-major
  dependency-group: actions-dependencies
- dependency-name: actions/cache
  dependency-version: &#x27;5&#x27;
  dependency-type: direct:production
  update-type: version-update:semver-major
  dependency-group: actions-dependencies
- dependency-name: actions/upload-artifact
  dependency-version: &#x27;6&#x27;
  dependency-type: direct:production
  update-type: version-update:semver-major
  dependency-group: actions-dependencies
- dependency-name: actions/download-artifact
  dependency-version: &#x27;7&#x27;
  dependency-type: direct:production
  update-type: version-update:semver-major
  dependency-group: actions-dependencies
- dependency-name: JetBrains/qodana-action
  dependency-version: 2025.3.1
  dependency-type: direct:production
  update-type: version-update:semver-minor
  dependency-group: actions-dependencies
...

Signed-off-by: dependabot[bot] &lt;support@github.com&gt;

([906e570b1d991f7](https://github.com/Lob2018/CanScan/commit/906e570b1d991f7dc5b78a8be7077d10b1196542))

👷 ci dependabot.yml: Add dependabot configuration for maven and github actions

([e4e5f4f9b7dab9d](https://github.com/Lob2018/CanScan/commit/e4e5f4f9b7dab9d2f39f362815f2e0cb5a1c1ef1))

📚 docs LICENSE.txt : Fix typo in license header (English spelling)

([88e118c5c3b3e72](https://github.com/Lob2018/CanScan/commit/88e118c5c3b3e7281cb3864a0e38310dfa525287))

📚 docs README.md: Specify French language interface in README header

([841f1a04859550e](https://github.com/Lob2018/CanScan/commit/841f1a04859550ed92bde4cf18ce80f089024cc9))

📚 docs Doxygen

([12b1d3d0b78f02b](https://github.com/Lob2018/CanScan/commit/12b1d3d0b78f02b2adb28444d089db00a0087602))

📚 docs PRIVACY.txt, README.md: Add privacy policy and update README links
- Create PRIVACY.txt with a focus on local-only data processing
- Update README to link to the new privacy policy
- Fix the license link to point directly to LICENSE.txt

([c39104960b9f85c](https://github.com/Lob2018/CanScan/commit/c39104960b9f85c6bfde4ab24169ffa780f09429))

📚 docs README.md: Update TOC and add code signing policy for SignPath

([3e95c9d94768058](https://github.com/Lob2018/CanScan/commit/3e95c9d94768058190ea2273a1a3b42e0d5a42a9))

Update README.md

([fd244fe0917ed6a](https://github.com/Lob2018/CanScan/commit/fd244fe0917ed6a53ad38b79ebdc2cf4f61b6b59))

## v1.0.1.1 - 2025-12-18


🐛 fix DynamicResizeWorker: Set minimum size for loader to ensure consistent dimensions, moved from v1.0.1.0 to v1.0.1.1

([f02d35b0e8d2b43](https://github.com/Lob2018/CanScan/commit/f02d35b0e8d2b4373886737d01c4ebf1e9ae888d))

🐛 fix natif.sh, pom.xml: Downgrade CPU baseline to compatibility mode and moved from v1.0.0.0 to 1.0.1.0

([da7a80d91b4b9ab](https://github.com/Lob2018/CanScan/commit/da7a80d91b4b9ab46b7e0d00a814a55aedad9f9c))

## v1.0.0.0 - 2025-12-06


📚 docs Doxygen

([56622872fbac47b](https://github.com/Lob2018/CanScan/commit/56622872fbac47bfa3e9500e6b88a814b08e5bf9))

✨ feat pom.xml, canscan.iss: Migrate installation path from Program Files to AppData (v1.0.0.0)

([0519f4ee0a69a65](https://github.com/Lob2018/CanScan/commit/0519f4ee0a69a650ebe9bc057d96e93d28661a6b))

✨ feat pom.xml: Moved form version 0.12.1.0 to 0.12.2.0

([2577d122b3f8fae](https://github.com/Lob2018/CanScan/commit/2577d122b3f8fae0d54fdafbeaeb5dc23fc78b86))

🐛 fix jni-config.json, reflect-config.json, resource-config.json: Correct directory paths for JNI, reflect, and resource configuration

([2a46b5b70dc5ff6](https://github.com/Lob2018/CanScan/commit/2a46b5b70dc5ff63ef1ec5b728874cb994092978))

📚 docs Doxygen

([b22e97e8bae1559](https://github.com/Lob2018/CanScan/commit/b22e97e8bae155985379509cfc9dc48648264b88))

🐛 fix natif.cmd, natif.sh, jni-config.json, resource-config.json: Implement Linux profile for OS-portable configuration and merge manual/auto reflection metadata

([bc58965b50552f2](https://github.com/Lob2018/CanScan/commit/bc58965b50552f24f2df7a7610719d14b3c5abb5))

♻️ refactor Checker: Harmonize methods to non-static

([e7221932576cc67](https://github.com/Lob2018/CanScan/commit/e7221932576cc677fd76fd3bcb25eb262af797e7))

♻️ refactor CanScan, UiComponentsConfiguration: Harmonize methods to non-static

([575c35ac9de8b92](https://github.com/Lob2018/CanScan/commit/575c35ac9de8b926a44daefa6abaab4bfe6ed3a2))

♻️ refactor CanScan: Encapsulate WARNING_ICON visibility

([2493fd13d81d43a](https://github.com/Lob2018/CanScan/commit/2493fd13d81d43afe65ee17372277cfbcb33e923))

♻️ refactor UiComponentsConfiguration: Harmonize methods to non-static

([2fedd3571a604c3](https://github.com/Lob2018/CanScan/commit/2fedd3571a604c340e8405fd41be100aa2337b27))

♻️ refactor FontManager: Harmonize methods to non-static

([1d2784d55c02c01](https://github.com/Lob2018/CanScan/commit/1d2784d55c02c01dbcdced82f9c91d808e1b185f))

♻️ refactor VersionService: Harmonize methods to non-static (Stateful Service)

([729aaac6d1a4e52](https://github.com/Lob2018/CanScan/commit/729aaac6d1a4e524e40edcff340d4466203b1e65))

📚 docs Doxygen

([03acc71d784cab9](https://github.com/Lob2018/CanScan/commit/03acc71d784cab9b6c26fbc4141fe1889f3f0ac8))

📚 docs LICENSE.txt: Specifies
Material Icons Licence Apache 2.0

([c0ca0d0e775d6f7](https://github.com/Lob2018/CanScan/commit/c0ca0d0e775d6f7a6a8fcc7b014bec205ef3f515))

📚 docs: Doxygen

([deeb4d19e3a5e55](https://github.com/Lob2018/CanScan/commit/deeb4d19e3a5e557bab08dbc40c2ef2209dbbc0a))

📚 docs README: Specify AppImage launch methods and parameters and formatting

([ea69bc40447eb6f](https://github.com/Lob2018/CanScan/commit/ea69bc40447eb6fc094997aea8f6feb6e0312683))

🐛 fix MyPopup, EncodedImage, GenerateAndSaveWorker.java, GenerateAndSaveService: Standardize and refine user-facing popup messages for clarity.

([45e374b6ecb0118](https://github.com/Lob2018/CanScan/commit/45e374b6ecb01188357dca4d3ee43d7171ea17fa))

🐛 fix natif.cmd, natif.sh, jni-config.json, resource-config.json: Implement Windows profile for OS-portable configuration and merge manual/auto reflection metadata

([cd03e3cf6c6c072](https://github.com/Lob2018/CanScan/commit/cd03e3cf6c6c07227766ebfb0390b3fe040b36e3))

📝 style: Run automatic code formatter

([abe2fb56d3bfb2d](https://github.com/Lob2018/CanScan/commit/abe2fb56d3bfb2d1c32a00e0fc8d75b9687752fa))

♻️ refactor run configurations: Simulations

([2509bda953c43c5](https://github.com/Lob2018/CanScan/commit/2509bda953c43c5873cc45d4a13e74984cf40679))

♻️ refactor .gitignore: Updated

([ee3aec4b557fabb](https://github.com/Lob2018/CanScan/commit/ee3aec4b557fabb9b84c334b61f28efb8fed793f))

♻️ refactor .gitignore: Updated

([15f0c7d1e96a7b3](https://github.com/Lob2018/CanScan/commit/15f0c7d1e96a7b398a968aa2652410570afbc609))

🐛 fix CanScan, GenerateAndSaveService: Set default home directory
- Tests pass

([3cdb6265b0df563](https://github.com/Lob2018/CanScan/commit/3cdb6265b0df563f2f5d06e9f779087dc1bed840))

♻️ refactor pom.xml, CanScan.java, WholeFields.java, DynamicResizeWorker.java, CanScanUTest.java: Introduce lazy calculation for available rendering height
- [WholeFields.java]
  - Change the availableHeightForQrCode parameter type from int (immediate value) to the functional interface **IntSupplier**.
  - Enables **deferring (lazy evaluation)** the calculation of the available height until the value is actually consumed.
  - Update Javadoc to reflect the role of the IntSupplier.
  - Add required import for java.util.function.IntSupplier.
- [CanScan.java]
  - Update the getQrInput() method to pass the calculateAvailableQrCodeLabelHeight method by **reference** (this::calculateAvailableQrCodeLabelHeight) instead of calling it immediately.
- [DynamicResizeWorker.java]
  - Update calls within createWorker() and updateLoaderSize() to retrieve the value using wholeFields.availableHeightForQrCode().getAsInt().
  - Simplify the updateLoaderSize() logic by removing the conditional fallback code that checked for a zero preferred height (which is now obsolete due to lazy, on-demand calculation).
  - Remove unnecessary import of fr.softsf.canscan.constant.IntConstants.
- [CanScanUTest.java]
  - Update unit tests to construct WholeFields using a Lambda expression (() -&gt; 300) to provide the mock height, ensuring the new type is correctly handled.
- [pom.xml]
  - Update the project version from 0.12.0.0 to **0.12.1.0**.
- Tests pass.

([cad369e5af350e3](https://github.com/Lob2018/CanScan/commit/cad369e5af350e34a11c6301b99272ae8a0b8b64))

📚 docs README.md, CanScan_in_action.png: Update (Multiplatform Installation/Maintenance), and update CanScan_in_action.png

([5f52ed88cd9c0b9](https://github.com/Lob2018/CanScan/commit/5f52ed88cd9c0b9cb39a963dedcd57aa66e734ec))

♻️ refactor natif.yml: Specify Linux release message

([cbb508e50ed46c1](https://github.com/Lob2018/CanScan/commit/cbb508e50ed46c1d5f24cf4602c2500970145a31))

📚 docs Doxygen

([d2ea194adfde6af](https://github.com/Lob2018/CanScan/commit/d2ea194adfde6afe7ca936a5dbd4ba1e5fbf60aa))

✨ feat: Implement Linux native AppImage build pipeline and code cleanup
    🔧 chore: Change project license from MIT to GPLv3.0
    - Moved from v0.11.1.0 to v0.12.0.0
    - Tests pass
    - Doc Doxygen updated
    ✨ feat natif.sh: Implement Linux native AppImage compilation script using Liberica NIK
    ♻️ refactor BrowserHelper: Rename
    ♻️ refactor BrowserHelper: Add a return value to openInBrowser to indicate if the command completed successfully
    ♻️ refactor StringConstants: Add LATEST_RELEASES_REPO_URL
    ♻️ refactor CanScan: Replace local constants by enums constants
    ♻️ refactor pom.xml: Update, and add linux-native profile
    🔧 chore SDKMAN config
    🔧 chore canscan.nsi: Remove useless NSIS script
    Address SpotBugs warnings by implementing input/output defensive copying for internal image state and explicitly documenting shared mutable dependencies.
    - EncodedImage Implemented defensive copying (&#x60;createDefensiveCopy()&#x60;) in &#x60;getQrOriginal()&#x60; and &#x60;updateQrOriginal()&#x60; to ensure immutability of the internal image state against external modification (input/output defense).
    - pom.xml, module-info.java Introduced &#x60;spotbugs-annotations&#x60; dependency (optional) and added the &#x60;requires&#x60; clause to &#x60;module-info.java&#x60;.
    - Models, Workers Added &#x60;@SuppressFBWarnings({&quot;EI_EXPOSE_REP2&quot;, &quot;EI_EXPOSE_REP&quot;})&#x60; to all UI records (&#x60;MecardJFields&#x60;, &#x60;MeetJFields&#x60;, &#x60;NativeImageUiComponents&#x60;) and worker constructors (&#x60;DynamicPreviewWorker&#x60;, &#x60;DynamicResizeWorker&#x60;, &#x60;GenerateAndSaveWorker&#x60;).

([a09cf41942d31f6](https://github.com/Lob2018/CanScan/commit/a09cf41942d31f6d57ce20262bd351595bcf179f))

📚 docs Doxygen

([32f1226dc0238e7](https://github.com/Lob2018/CanScan/commit/32f1226dc0238e780e60a1ef109e131ef1c03903))

🐛 fix FlatLafTimePicker, FlatLafDatePicker, IFlatLafStyledForLGoodDatePicker: Remove useless listener, unify FlatLaf styling
- Moved from 0.11.0.1 to 0.11.1.0
- Dropped redundant property change listener.
- Applied UIManager defaults directly.
- Unified valid/invalid foreground/background for DatePicker and TimePicker.
- Updated Javadoc.
- Tests pass

([8562f8df69c5655](https://github.com/Lob2018/CanScan/commit/8562f8df69c56554d10f1da40e84512f48e8e1e0))

📝 style sonarlint.xml: Run automatic code formatter

([e13db9f23e66209](https://github.com/Lob2018/CanScan/commit/e13db9f23e6620958492e3c974ee178cfbe81761))

📚 docs Doxygen, exclude docs directory from IDE SonarLint

([21b63fce11a4558](https://github.com/Lob2018/CanScan/commit/21b63fce11a4558670e4580f6ae9fce8129050ff))

📚 docs Doxygen

([1565db8c5d8c596](https://github.com/Lob2018/CanScan/commit/1565db8c5d8c596f001a05165c5e88f3508f3f92))

✅ test DataBuilderServiceUTest, ValidationFieldHelperUTest, CoordinateHelperUTest, DateHelperUTest
- Tests pass

([ff6c7b9d04a07a8](https://github.com/Lob2018/CanScan/commit/ff6c7b9d04a07a8c1cfa4411ac23bd551bd7797c))

🐛 fix pom.xml: Moved from version 0.11.0.0 to 0.11.0.1

([addfdcc922852e4](https://github.com/Lob2018/CanScan/commit/addfdcc922852e485fe3877153d41669e8758f58))

♻️ refactor pom.xml, natif.cmd, natif.yml: Pass locale arguments and project version from pom.xml
- Define Maven properties for language (app.lang&#x3D;fr) and country (app.country&#x3D;FR)
- Forward these properties via exec-maven-plugin to native.cmd (%1&#x3D;lang, %2&#x3D;country)
- Extract project.version using mvn help:evaluate for consistent release tagging
- Inject JAVA_TOOL_OPTIONS dynamically in GitHub Actions from pom.xml values
- Document ISO conventions: language lowercase, country uppercase
- Tests pass

([5d983470661caac](https://github.com/Lob2018/CanScan/commit/5d983470661caac531ed1ea9a62ef0e87a20b2d8))

🐛 fix FlatLafDatePicker, FlatLafTimePicker: Removes French locale in Flatlaf

([85d4aef24b35496](https://github.com/Lob2018/CanScan/commit/85d4aef24b354968411cc79d78c80ccca98d83e9))

🐛 fix natif.yml, natif.cmd, FlatLafDatePicker: Enforce French locale for native Windows build
- Add JAVA_TOOL_OPTIONS with French locale to GitHub Actions workflow
- Configure French locale properties in native-image build script (simulation and build)
- Set user.language&#x3D;fr, user.country&#x3D;FR, user.region&#x3D;FR for both
  runtime simulation and native compilation steps
- Tests pass

([605858d6a8ba0c4](https://github.com/Lob2018/CanScan/commit/605858d6a8ba0c412b17d38fdcc00a2a8dd077fa))

🐛 fix CanScan, NativeImageConfigSimulator, FlatLafDatePicker: Restore without the default local set to FRANCE, and force French locale for month and day names in DatePicker in FlatLafDatePicker

([9099e0590946032](https://github.com/Lob2018/CanScan/commit/9099e05909460324cbc4fce02ef05915c9824675))

🐛 fix CanScan, NativeImageConfigSimulator: Set default locale to FRANCE for consistent French formatting

([27763d78a79d175](https://github.com/Lob2018/CanScan/commit/27763d78a79d17561bd8866238ffa917c641bece))

🐛 fix NativeImageConfigSimulator, FlatLafDatePicker, FlatLafTimePicker: Restore old test format (00:00) by enforcing Locale.FRANCE in DatePicker and TimePicker
- All tests now pass

([4b40f9abc59e451](https://github.com/Lob2018/CanScan/commit/4b40f9abc59e451dc87b80bc499b8cb1e2e3451a))

🐛 fix NativeImageConfigSimulator: Update start time validation to support fr-FR and en-US formats

([b9b3931e9c91492](https://github.com/Lob2018/CanScan/commit/b9b3931e9c91492e2be4e49c7abfcfff63da1309))

🐛 fix natif.yml: Restore Windows job environment without LANG and LC_TIME

([de61722bdf8361d](https://github.com/Lob2018/CanScan/commit/de61722bdf8361d3bd9f2a991e56481e4287b3bf))

🐛 fix natif.yml: Set LANG and LC_TIME to fr-FR for Windows job

([8a4f08e5236bbc9](https://github.com/Lob2018/CanScan/commit/8a4f08e5236bbc971573fec580d8c5b4ba5f88eb))

📚 docs Doxygen

([17fa602bc5184e3](https://github.com/Lob2018/CanScan/commit/17fa602bc5184e34218fa3fdfb095f7247748a6e))

✨ feat iCalendar mode

([780bcb696932a10](https://github.com/Lob2018/CanScan/commit/780bcb696932a10db5a632a59f96f057ddbefe98))

📚 docs README.md: Adds Snyk Scan badge

([ac78bd9a46fb0fe](https://github.com/Lob2018/CanScan/commit/ac78bd9a46fb0fe4e2d951e19d5e07152e517b90))

✨ feat .snyk: Add Snyk policy file

([9c8b9491482cbdd](https://github.com/Lob2018/CanScan/commit/9c8b9491482cbdd89c54736397fd26924985d0be))

📚 docs: Doxygen

([7e417f2c93915d8](https://github.com/Lob2018/CanScan/commit/7e417f2c93915d86879c8cddca474c39f5b979a2))

📝 style CanScan: Run automatic code formatter

([769f18647198b87](https://github.com/Lob2018/CanScan/commit/769f18647198b8717f71b34e702d6a615adc000c))

♻️ refactor CanScan, ApplicationMetadata: Use AppMetadata enum for JFrame title and version
- Checkstyle pass
- Tests pass

([89d8deaeac199d8](https://github.com/Lob2018/CanScan/commit/89d8deaeac199d8842fe22e75f4a75d0cb4ee365))

📚 docs Doxygen

([8039fdbce3ce008](https://github.com/Lob2018/CanScan/commit/8039fdbce3ce008b0e82f26f3bad9b0d259e9ef8))

✅ test GenerateAndSaveService, GenerateAndSaveServiceUTest, CanScanUTest, CanScan, MyPopupUTest, UseLucioleFontUTest: Add UTest suffixes and replace reflection with package-private methods

([7888cff21d9f551](https://github.com/Lob2018/CanScan/commit/7888cff21d9f5518e44f5aceccdab6040fbe87bb))

♻️ refactor CanScan: Add NPE checks to UI initialization methods
- addNorthPanelModeSelection: validate northPanel and grid
- addNorthPanelCardPanels: validate northPanel and grid
- addNorthPanelCommonFields: validate northPanel and grid
- addNorthPanelGenerateButton: validate northPanel and grid
- initializeScrollPane: validate mainPanel
- Tests pass

([70eefa31913ff83](https://github.com/Lob2018/CanScan/commit/70eefa31913ff83c67f817fa61a6b36d1074195e))

♻️ Refactor GenerateAndSaveWorker, DynamicResizeWorker, DynamicPreviewWorker, showYesNoConfirmDialog : UI dialogs and workers

- GenerateAndSaveWorker: add NPE check to constructor
- DynamicResizeWorker: add NPE check to updateQrCodeResize
- DynamicPreviewWorker: add NPE check, extract QR config builder into getCommonFields()
- showYesNoConfirmDialog: remove parent parameter, use FrameHelper as parent frame, add message NPE check

([f6c55710be71c44](https://github.com/Lob2018/CanScan/commit/f6c55710be71c44f7e0f08196778f929f8e0860a))

📚 docs Doxygen

([3cb0c2b56b14047](https://github.com/Lob2018/CanScan/commit/3cb0c2b56b14047fc18755aa13cedf958dd508f6))

♻️ refactor CanScan: Change initializeSliders() visibility from protected to private

([b3eae944f62e50b](https://github.com/Lob2018/CanScan/commit/b3eae944f62e50b1efb3455a65ebc853fb2c0275))

✨ feat module-info.java, pom.xml: Migrate project to JPMS module system
- Added module-info.java with explicit module declaration (fr.softsf.canscan)
- Excludes module-info.java from Checkstyle
- Declared required modules: java.desktop, com.formdev.flatlaf, com.formdev.flatlaf.intellijthemes, com.google.zxing, org.apache.commons.lang3, java.net.http
- Removed unnecessary exports since the application is standalone
- Ensured encapsulation and audit-readiness by exposing only dependencies, no internal packages
- Updated project version: 0.9.0.7 → 0.10.0.0
- Tests pass

([bfa5a48609a068a](https://github.com/Lob2018/CanScan/commit/bfa5a48609a068ad8d8954e371d200708e0395a7))

📚 docs Doxygen

([ed55d9f81c5b24b](https://github.com/Lob2018/CanScan/commit/ed55d9f81c5b24beb915899936bd3d4ef3dc0728))

📚 docs Doxygen

([88244e67b3954b0](https://github.com/Lob2018/CanScan/commit/88244e67b3954b016ce6e4cd7b017ce6f9a4d616))

♻️ refactor AbstractDynamicQrCodeWorker, DynamicQrCodePreviewWorker, DynamicQrCodeResizeWorker, QrGenerateAndSaveWorker,... : Rename classes/methods for clarity and reorganize packages
- Tests pass

([011178a9daf96f3](https://github.com/Lob2018/CanScan/commit/011178a9daf96f3dfc4a7f8c10dbac1aa27e5e50))

♻️ refactor CanScan, MecardJFields, UiComponentsConfiguration, DoubleConstants, FloatConstants, IntConstants, StringConstants, ValidationFieldHelper: Centralize UI component setup in UiComponentsConfiguration
- Replace inline GridBagLayout, sliders, panels, and button configurations with reusable methods from UiComponentsConfiguration.
- Replace individual DocumentListener implementations with centralized helpers.
- Delegate MECARD and FREE panel population to dedicated methods.
- Delegate validation of ratio, margin, and size to ValidationFieldHelper.
- Remove unused constants and redundant code for clarity and maintainability.
- Checkstyle violations pass (no warnings)
- Tests pass

([a4f050185aa3a3d](https://github.com/Lob2018/CanScan/commit/a4f050185aa3a3d95edc1eba2e9f5827ebccbb93))

♻️ refactor QrGenerateAndSaveWorker, DynamicQrCodePreview: Optimizes Data too big errors with dedicated messages for preview and save
- Tests pass

([bd77c68f8d61a61](https://github.com/Lob2018/CanScan/commit/bd77c68f8d61a6130cbe01cfeb372b1d9694c582))

🐛 fix CanScan: Declare overlayPanelForQrCodeLabelAndLoader as a local variable in the relevant method

([7ab81a5b8cf9758](https://github.com/Lob2018/CanScan/commit/7ab81a5b8cf97586b78304467e590fa6f67f006f))

📚 docs Doxygen

([75ebe2419bb2ea4](https://github.com/Lob2018/CanScan/commit/75ebe2419bb2ea4522a6d810426053feb78e4337))

♻️ refactor CanScan, AbstractDynamicQrCodeWorker, GenerateAndSaveService, QrGenerateAndSaveWorker, VersionService, DynamicQrCodePreview, DynamicQrCodeResize, QrCodeBufferedImage, NativeImageConfigSimulator: Use JProgressBar to replace Loader and add SwingWorker for non-blocking file saves and loader print
- Replace custom Loader component with standard JProgressBar
- Introduce SwingWorker to ensure non-blocking file saving and responsive loader rendering
- Extract QrGenerationAndSaveWorker for asynchronous QR code generation and save process
- Adjust robot.delay in browseFoldersSimulation
- Tests pass

([287608048bb78ee](https://github.com/Lob2018/CanScan/commit/287608048bb78ee4a7d2798f1a40490dd49d85d6))

♻️ refactor Popup: Rename enum from Popup to MyPopup to avoid ambiguity with javax.swing.Popup

([90b474b35bb2e49](https://github.com/Lob2018/CanScan/commit/90b474b35bb2e49c3bbf49a3a3dd6b3dc9d4ec7c))

♻️ refactor CanScan: Updated Dimension input field tooltip to warn users that large dimensions can impact application performance.

([e187bf0ea4bc6c6](https://github.com/Lob2018/CanScan/commit/e187bf0ea4bc6c68001779f86a5dbd507f91a9ad))

📚 docs: Doxygen

([8acb4153926eb18](https://github.com/Lob2018/CanScan/commit/8acb4153926eb1868b6fcb4fde709df0a0cbdeb4))

📚 docs CanScan_in_action.png: Updated

([d2cc1c36f99b4ee](https://github.com/Lob2018/CanScan/commit/d2cc1c36f99b4ee585fd22bebbd71544165f2fa2))

♻️ refactor Mode, CanScan, CanScanTest: specifies Mode and its associated tooltip.
- Tests pass

([8cebe4fe9f82f7b](https://github.com/Lob2018/CanScan/commit/8cebe4fe9f82f7bf3319f29bddf7de6512e75851))

📚 docs README: Convert functionality list to task items

([408d4988d07f052](https://github.com/Lob2018/CanScan/commit/408d4988d07f052b0dc42591382ade4fbd660cb6))

✅ test CanScan, CanScanTest: Replace reflection with getters/setters in CanScanTest
- Removed reflection-based field access (getField, getFieldValue)
- Used existing getXxxForTests()/setXxxForTests() methods instead
- Kept reflection only for private method switchMode
- Improved test readability and maintainability
- Tests pass

([d399e9a0dd45e56](https://github.com/Lob2018/CanScan/commit/d399e9a0dd45e56e4e68a0e627b28a2c790d5299))

♻️ refactor CanScan, CanScanTest, PopupTest, UseLucioleFontTest: Encapsulate UI components and add test accessors
- Set UI component fields to private final for proper encapsulation
- Introduced getters/setters for test access to fields
- Verified tests pass (updated DisplayName for clarity)

([1b30d4e3416a10b](https://github.com/Lob2018/CanScan/commit/1b30d4e3416a10b14b732d5fc920e8562f6de6ec))

♻️ refactor CanScan: Extract constructor logic into dedicated setup methods

([f5429c25481abb6](https://github.com/Lob2018/CanScan/commit/f5429c25481abb616913a697d0d07ca00ca514f6))

♻️ refactor CanScan: Merge resource cleanup into dispose method
- Tests pass

([e461d19a01dbe96](https://github.com/Lob2018/CanScan/commit/e461d19a01dbe96e7a9932b25b524adf7c50050e))

♻️ refactor CanScan: specify tooltip texts

([19544bafaaf993b](https://github.com/Lob2018/CanScan/commit/19544bafaaf993bc873f889b3b53130f418ff93d))

♻️ refactor Mode, QrCodeColor, CanScan, CanScanTest, README.md: Enhance Mode enum and modernize CanScan UI
- Added descriptive labels to Mode enum values for improved clarity.
- Simplified QrCodeColor tooltips to enhance readability and UX.
- Reworked CanScan layout with clearer structure and consistent design.
- Improved Javadoc and method documentation across the codebase.
- Update README to reflect changes
- Tests pass

([d326933e5348774](https://github.com/Lob2018/CanScan/commit/d326933e5348774e1bb62a32d9f5a1a1b30cff1b))

♻️ refactor CanScan: Moved from  Font.deriveFont to html syntax
- Tests pass

([d824644f31a140a](https://github.com/Lob2018/CanScan/commit/d824644f31a140aa9f6b373283674299ab453ae3))

📚 docs Doxygen

([719ac36260ff751](https://github.com/Lob2018/CanScan/commit/719ac36260ff751f8a8688d22f453e304b4a5dd8))

♻️ refactor AbstractDynamicQrCodeWorker, DataBuilderService, GenerateAndSaveService, DynamicQrCodePreview, DynamicQrCodeResize : Rename QR code classes and services for improved clarity and expressiveness
- Renamed AbstractQrCodeWorker to AbstractDynamicQrCodeWorker for better abstraction and dynamic handling
- Renamed BuildQRDataService to DataBuilderService for more concise and precise naming
- Renamed QrCodeService to GenerateAndSaveService to reduce redundancy and clarify responsibility
- Renamed QrCodePreview to DynamicQrCodePreview to reflect dynamic preview handling
- Renamed QrCodeResize to DynamicQrCodeResize to indicate dynamic resize management
- Tests pass

([cf833a7dbf74047](https://github.com/Lob2018/CanScan/commit/cf833a7dbf74047bf479aaeedcee33a10e83b719))

📚 docs Doxygen

([942b6b9a27119b3](https://github.com/Lob2018/CanScan/commit/942b6b9a27119b31a74f642c5013325fd4406db9))

♻️ refactor AbstractQrCodeWorker, QrCodeResize, QrCodePreview: Extract common done() logic into AbstractQrCodeWorker.handleWorkerDone() to reduce redundancy

([8928fead1e9d4eb](https://github.com/Lob2018/CanScan/commit/8928fead1e9d4ebcf716273dd13a384027ddfcff))

🐛 fix CanScan: Add updateGenerateButtonState to the switchMode, so the generateButton will update when the mode change

([e7b81f0debf7b66](https://github.com/Lob2018/CanScan/commit/e7b81f0debf7b6623a4fe33e3a10af4ec1d8c154))

♻️ refactor CanScan, QrCodeService, StringConstants: Clean CanScan GUI and delegate QR code generation
- Refactored CanScan.generateQrCode to delegate QR generation and saving to QrCodeService
- Removed manual file chooser, conflict resolution, and exception handling from CanScan
- Simplified QrConfig creation and input validation
- Updated StringConstants if needed for QrCodeService
- Tests adjusted/added for CanScan and QrCodeService
- All tests pass

([80f54ca6dc85a65](https://github.com/Lob2018/CanScan/commit/80f54ca6dc85a65f2109a8ee00468d266563516d))

♻️ refactor QrCodeBufferedImage: Remove redundant synchronization on freeQrOriginal
-Tests pass

([921f00b7aa31558](https://github.com/Lob2018/CanScan/commit/921f00b7aa31558dd168245a57a60fad097e4c3c))

📚 docs Doxygen

✅ Tests pass

([d5a4eef612a3fc2](https://github.com/Lob2018/CanScan/commit/d5a4eef612a3fc2c4c4a159642d18762e8b3f459))

♻️ refactor CanScan, AbstractQrCodeWorker, QrCodePreview, QrCodeResize: Unify QR code workflow cleanup and background tasks
- Replaced manual timer and worker management in CanScan with AbstractQrCodeWorker for consistent lifecycle handling.
- QrCodePreview and QrCodeResize now extend AbstractQrCodeWorker to centralize:
  - Debounce timers
  - Worker cancellation
  - Resource cleanup
  - Loader start/stop
- Simplified CanScan.dispose() to call disposeAllResourcesOnExit(), ensuring:
  - All preview and resize workers are properly cancelled
  - All timers are stopped
  - All QR code images and icons are freed
- Improves maintainability, reduces duplicated code, and prevents memory leaks.
- Maintains asynchronous UI responsiveness and correct EDT updates for preview and resize tasks.

([09e5c6c6a077c0f](https://github.com/Lob2018/CanScan/commit/09e5c6c6a077c0f6266a1ce910ab8593cb445ff6))

♻️ refactor CanScan, QrCodePreview, QrCodeResize, QrCodeColor: simplify QR code color, preview, and resize management

- Removed unnecessary Runnable &#x60;onColorChange&#x60; parameter from QrCodeColor.chooseColor()
- Simplified color selection logic with direct button update
- Improved readability and reduced method coupling in QrCodeColor

- Added constant &#x60;PREVIEW_DEBOUNCE_DELAY_MS&#x60; to centralize debounce delay configuration
- Added new method &#x60;updateQrCodePreview(QrInput)&#x60; for debounced and efficient QR preview updates
- Added helper &#x60;resetAndStartPreviewWorker()&#x60; to handle icon reset and background regeneration
- Replaced &#x60;qrCodeResize.updateQrCodeSize()&#x60; with clearer &#x60;updateQrCodeResize()&#x60;
- Ensured clean cancellation and restart behavior by stopping existing timers before update
- Improved asynchronous QR generation lifecycle consistency and UI responsiveness

- Updated QrCodeResize to improve timer lifecycle safety:
  - &#x60;updateResizeDebounceTimer()&#x60; now calls &#x60;stop()&#x60; before assigning a new timer
  - Renamed &#x60;updateQrCodeSize()&#x60; → &#x60;updateQrCodeResize()&#x60; for better consistency
  - Ensured previous timers are properly cleared before reuse
  - Minor internal cleanups and improved naming consistency with other UI components

-Tests pass

([31e0bb436f900a7](https://github.com/Lob2018/CanScan/commit/31e0bb436f900a776a81f0875cf5d0f7d8aa61dc))

📚 docs Doxygen

([e8d21aa04efb585](https://github.com/Lob2018/CanScan/commit/e8d21aa04efb5859d148043aace9fded40c9ce61))

♻️ refactor Checker: Simplify null/blank validation and centralize popup handling
- Removed redundant static method &#x60;checkStaticNPE&#x60;.
- Refactored &#x60;checkNullOrBlankInternal&#x60; to use a single errorType variable.
- Eliminated parent parameter; now always uses &#x60;FrameHelper.INSTANCE.getParentFrame()&#x60;.
- Streamlined logic: returns true if invalid, false otherwise, with concise popup call.
- Updated JavaDoc to be concise, professional, and consistent with enum singleton usage.
-Tests pass

([85ad5d8b8b4a210](https://github.com/Lob2018/CanScan/commit/85ad5d8b8b4a210ce83ecc16374db27b9679b42c))

✨ feat QrCodeBufferedImage, CanScan: Display warning for unsupported logo formats on preview and save (only PNG, JPG, JPEG), and specifies it in the filechooser description
-Specifies (PNG, JPG, ou JPEG) in the README and in the mainpage.dox
-Tests pass

([5bc651c6b5bd432](https://github.com/Lob2018/CanScan/commit/5bc651c6b5bd432d6c03609fbb2add56e156957c))

♻️ refactor CanScan, QrCodeColor, CanScanTest: Migrate QR code color handling from CanScan to QrCodeColor
-Test pass

([94175058f72dfc0](https://github.com/Lob2018/CanScan/commit/94175058f72dfc02655be2dcb73250ccfb9e5075))

♻️ refactor natif.cmd: Add empty line before [ERROR] Configuration simulation failed

([03ec782befcad18](https://github.com/Lob2018/CanScan/commit/03ec782befcad18d52ce156d6e1da3e78e3255c4))

♻️ refactor natif.cmd: Simplify and document native-image compilation options

- Remove obsolete flags: --no-server, --verbose, --enable-preview
- Remove redundant config file options (covered by ConfigurationFileDirectories)
- Remove duplicate -J-D* options and -Dsun.java2d.noddraw
- Remove unused -Dflatlaf.uiScale and -H:IncludeResources
- Remove -H:+ReportUnsupportedElementsAtRuntime and -H:+ReportExceptionStackTraces
- Add inline echo documentation for each java agent option
- Add inline echo documentation for each native-image compilation option
- Simplify error message to English for consistency

Reduces command complexity from 22 to 10 options while maintaining full functionality and eliminating all GraalVM warnings.

([02a5303c02fcc2f](https://github.com/Lob2018/CanScan/commit/02a5303c02fcc2f8dca3b592a6cc6517f4ad7aa4))

♻️ refactor Loader: Moved from Enum to full class
-Tests pass

([cc4c664de014f14](https://github.com/Lob2018/CanScan/commit/cc4c664de014f14dcaa4fc1aea0b71ebf2295a09))

♻️ refactor QrCodeBufferedImage, QrCodePreview, QrCodeResize: Moved from enum to full class

([23c8a78e636ef09](https://github.com/Lob2018/CanScan/commit/23c8a78e636ef09dcaa4dc207fc2070c23630265))

📚 docs Doxygen

([c8f48a4d09028f5](https://github.com/Lob2018/CanScan/commit/c8f48a4d09028f5abc01b58a2d9fc11eca4e8c10))

♻️ refactor: Remove unused transient modifiers
-Tests pass

([07c4cbb9a5fe87f](https://github.com/Lob2018/CanScan/commit/07c4cbb9a5fe87f679e9c7f3a5c404f49ef658b1))

♻️ refactor CanScan: Rename validateAndGet methods for size, ratio, margin for consistency
-Rename from marge to margin
-Tests pass

([78a8f5ddc57ebc7](https://github.com/Lob2018/CanScan/commit/78a8f5ddc57ebc70df558803fcf3091bd5786218))

♻️ refactor CanScan,IntConstants, StringConstants: Extract calculateAvailableQrHeight method and replace constants with enums

([76707d3b2becfff](https://github.com/Lob2018/CanScan/commit/76707d3b2becfff4a9c086bc99a863412b1fd436))

♻️ refactor CanScan, ModuleContext, QrConfig, QrInput, QrCodeBufferedImage, QrCodePreview, QrCodeResize, UseLucioleFont: Move QR code preview and resize logic to QrCodePreview and QrCodeResize
- Complete QrInput with all necessary fields
- All tests pass
- Bump version to 0.9.0.7

([9e99c59997cadb6](https://github.com/Lob2018/CanScan/commit/9e99c59997cadb643b3660863f42a8b6b0b02efb))

🐛 fix CanScan: Marge maximum value is 10

([58dd6f6138dcb88](https://github.com/Lob2018/CanScan/commit/58dd6f6138dcb88bcb239bd697dab68dd279c4e9))

♻️ refactor QrCodeBufferedImage: qrOriginal as transient

([f0e629e0b4b6eac](https://github.com/Lob2018/CanScan/commit/f0e629e0b4b6eac1bded8da0234d5c4dc9b1891b))

♻️ refactor: Move QR code classes to ui package

([3c7743cf7080d61](https://github.com/Lob2018/CanScan/commit/3c7743cf7080d618d15b39f48b3371f84b66a9e8))

📚 docs Doxygen

([f12df2b0f9a3b8e](https://github.com/Lob2018/CanScan/commit/f12df2b0f9a3b8ee8a6263a37b4d132874c74bf7))

📚 docs CanScan_in_action updated

([54dba88369ed332](https://github.com/Lob2018/CanScan/commit/54dba88369ed3326b58c58ff571105df82b585ee))

✅ test UseLucioleFontTest added

([0f6145395d7a099](https://github.com/Lob2018/CanScan/commit/0f6145395d7a0996dbe524cd3efbbd391bc2d492))

📝 style UseLucioleFont: Run automatic code formatter

([4ae116262f02e5e](https://github.com/Lob2018/CanScan/commit/4ae116262f02e5e15f0f32ce0db5f519e5b7bc41))

♻️ refactor NativeImageConfigSimulator: nameTypingSimulation without case sensitivity

([4b2121996e03d2a](https://github.com/Lob2018/CanScan/commit/4b2121996e03d2ae48d056f0c0a980c115fbedd3))

♻️ refactor UseLucioleFont: Use a constant for deafultFont

([44983118a4de2a4](https://github.com/Lob2018/CanScan/commit/44983118a4de2a403ddbc7727e350ead2b7a0948))

🐛 fix UseLucioleFont: Catch IllegalStateException when Luciole font resource is missing

([af39be089bbccc2](https://github.com/Lob2018/CanScan/commit/af39be089bbccc27a30c17eb0b0f24a649bacd17))

✨ feat UseLucioleFont: Moved from default font to Luciole

([faff10641593b9e](https://github.com/Lob2018/CanScan/commit/faff10641593b9e33e0d958e76010911e0f7de83))

♻️ refactor BrowserHelper: Update popup message

([4f36c2e874e8f87](https://github.com/Lob2018/CanScan/commit/4f36c2e874e8f8750653c461eb7b6659f52cb818))

♻️ refactor VersionService: Update popup messages and tooltips

([5dd3d980bbdbb77](https://github.com/Lob2018/CanScan/commit/5dd3d980bbdbb77855fa49a8d42297d5855894a9))

📚 docs README: Update video link and picture

([ed71d76729759b2](https://github.com/Lob2018/CanScan/commit/ed71d76729759b2c5199e7214cc27a6abec6030a))

📚 docs Doxygen

([043251bdee5498c](https://github.com/Lob2018/CanScan/commit/043251bdee5498c5d846a42c8010496580885ee4))

🐛 fix CanScan: Correct available memory calculation to prevent negative values

([4964e9579a3648d](https://github.com/Lob2018/CanScan/commit/4964e9579a3648db4e078be66d62d25aacfb20a6))

📝 style CanScan_Doxygen.xml: Run automatic code formatter

([b8fe57096b85154](https://github.com/Lob2018/CanScan/commit/b8fe57096b851540dc19b3d4028b3634c8c8a632))

📚 docs Doxygen

([a06fc029de66a76](https://github.com/Lob2018/CanScan/commit/a06fc029de66a764914397adc4c878422cc80499))

✨ feat CanScan: Align radio buttons left and update button right in QR type select

([7494f9b52aecde9](https://github.com/Lob2018/CanScan/commit/7494f9b52aecde98c0470c2cdfaaaf2796041851))

📝 style CanScan: Run automatic code formatter

([80ada815bd8bcc5](https://github.com/Lob2018/CanScan/commit/80ada815bd8bcc58f9327e9fa180f7fd505e7615))

✨ feat VersionService: Replace update button visibility toggle with enable/disable logic

([8f9afe7fb564a08](https://github.com/Lob2018/CanScan/commit/8f9afe7fb564a085aca5a13951514866fe8488d2))

🐛 fix CanScan: Ensure QR code label resizes correctly by enforcing a minimum size constraint.

([412620fe386e2ab](https://github.com/Lob2018/CanScan/commit/412620fe386e2ab292398ec78093efbb9d1e626f))

♻️ refactor natif.cmd: Prepare for future versions of GraalVM

([dc84d8865b156cf](https://github.com/Lob2018/CanScan/commit/dc84d8865b156cf189805b33abe3ff5931f5c13b))

✨ feat CanScan: Align color buttons horizontally

([02fff51dbe947c5](https://github.com/Lob2018/CanScan/commit/02fff51dbe947c51bd67c18a61f503f8a8efed93))

📝 style CanScan_Doxygen.xml: Run automatic code formatter

([54a79166de4728f](https://github.com/Lob2018/CanScan/commit/54a79166de4728fb57936cfd18ff8a577423d4f9))

📚 docs Doxygen mainpage: In french

([89727aaec9cefd6](https://github.com/Lob2018/CanScan/commit/89727aaec9cefd6778a1591ecd6e7dc2a6e5a99b))

📚 docs README: Adds the Doxygen documentation link

([ff02f14e1b0c652](https://github.com/Lob2018/CanScan/commit/ff02f14e1b0c652a9a40030d30464332d7dab13c))

Initial commit

([46c41b9f0d01886](https://github.com/Lob2018/CanScan/commit/46c41b9f0d018865ea054f55a0690a8ae84a9000))
