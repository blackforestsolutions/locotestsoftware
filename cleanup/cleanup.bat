@ECHO ON
SET PSScript=%~p1cleanup.ps1

powershell.exe -ExecutionPolicy Bypass -Command "& ./cleanup/cleanup.ps1"
EXIT /B
