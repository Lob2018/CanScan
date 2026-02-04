; ============================================================================
; CanScan - Inno Setup Winget Edition Script
; Architecture: x64 only
; Version: Standard install with registry, without VC Redist
; ============================================================================

#ifndef AppName
  #define AppName "CanScan"
#endif

#ifndef AppVersion
  #define AppVersion "0.0.0.0"
#endif

#ifndef Organization
  #define Organization "Soft64.fr"
#endif

[Setup]
; Informations de l'application
AppId={{AA74CA9F-E961-4A51-A0CB-228B63029F74}}
AppName={#AppName}
AppVersion={#AppVersion}
AppPublisher={#Organization}
AppPublisherURL=https://{#Organization}
AppSupportURL=https://{#Organization}
AppUpdatesURL=https://github.com/Lob2018/{#AppName}/releases/latest
VersionInfoVersion={#AppVersion}.0
VersionInfoCompany={#Organization}
VersionInfoDescription={#AppName} (Winget Edition)
VersionInfoCopyright=Copyright (C) 2025 {#Organization}

; Gestion des processus en cours
CloseApplications=yes

; STRATÉGIE WINGET : Installation utilisateur avec traces registre pour tracking
PrivilegesRequired=lowest
DefaultDirName={localappdata}\{#Organization}\{#AppName}
DefaultGroupName={#Organization}\{#AppName}
DisableProgramGroupPage=yes

; Activation de la désinstallation système (Indispensable pour Winget)
CreateUninstallRegKey=yes
UninstallDisplayName={#AppName}
UninstallDisplayIcon={app}\{#AppName}.ico
UpdateUninstallLogAppName=yes
Uninstallable=yes

; Répertoires de sortie
OutputDir=../../output
OutputBaseFilename={#AppName}-{#AppVersion}-x64-Winget

; Compression
Compression=lzma2/max
SolidCompression=yes

; Architecture
ArchitecturesAllowed=x64compatible
ArchitecturesInstallIn64BitMode=x64compatible

; Interface utilisateur
WizardStyle=modern
SetupIconFile=../images/{#AppName}.ico

; Divers
AllowNoIcons=yes
DisableWelcomePage=no

[Languages]
Name: "french"; MessagesFile: "compiler:Languages\French.isl"

[Tasks]
Name: "desktopicon"; Description: "Créer un raccourci sur le &Bureau"; GroupDescription: "Tâches supplémentaires :"; Flags: unchecked

[Files]
; Application principale
Source: "../../dist/{#AppName}.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "../images/{#AppName}.ico"; DestDir: "{app}"; Flags: ignoreversion

; DLLs (Nécessaires pour le runtime GraalVM)
Source: "../../dist/*.dll"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs

; Fichiers de documentation
Source: "../../README.md"; DestDir: "{app}"; DestName: "README.txt"; Flags: ignoreversion
Source: "../../LICENSE.txt"; DestDir: "{app}"; Flags: ignoreversion

[Icons]
Name: "{group}\{#AppName}"; Filename: "{app}\{#AppName}.exe"; IconFilename: "{app}\{#AppName}.ico"
Name: "{group}\Désinstaller {#AppName}"; Filename: "{uninstallexe}"
Name: "{userdesktop}\{#AppName}"; Filename: "{app}\{#AppName}.exe"; IconFilename: "{app}\{#AppName}.ico"; Tasks: desktopicon

[Run]
; Lancer l'application après installation
Filename: "{app}\{#AppName}.exe"; Description: "Lancer {#AppName}"; Flags: nowait postinstall skipifsilent

; Afficher le fichier README
Filename: "{app}\README.txt"; Description: "Afficher le fichier README"; Flags: postinstall shellexec skipifsilent unchecked

[InstallDelete]
; Nettoyage propre avant réinstallation
Type: filesandordirs; Name: "{app}\*"

[Code]
// ============================================================================
// Vérifications pré-installation
// ============================================================================
function InitializeSetup(): Boolean;
var
  VCRuntimeVersion: String;
begin
  // 1. Vérification de l'architecture 64-bit
  if not Is64BitInstallMode then
  begin
    MsgBox('Cette application requiert un système Windows 64 bits.', mbError, MB_OK);
    Result := False;
    Exit;
  end;

  // 2. Vérification du VC++ Redistributable 2015-2022 (Famille 14.0)
  // La détection se fait via la clé de registre partagée x64
  if not RegQueryStringValue(HKEY_LOCAL_MACHINE, 'SOFTWARE\Microsoft\VisualStudio\14.0\VC\Runtimes\x64', 'Version', VCRuntimeVersion) then
  begin
    MsgBox('Erreur : Le composant "Microsoft Visual C++ Redistributable (x64)" est requis pour exécuter {#AppName}.' + #13#10#13#10 +
           'Veuillez l''installer avant de relancer ce programme.' + #13#10#13#10 +
           'Téléchargement : https://aka.ms/vc14/vc_redist.x64.exe', mbCriticalError, MB_OK);
    Result := False;
    Exit;
  end;

  Result := True;
end;