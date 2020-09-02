@ECHO ON
echo %1
echo %2
echo %3
echo %4
SET arg1=%1
SET arg2=%2
SET arg3=%3
SET arg4=%4

Powershell -ExecutionPolicy Bypass -Command "& ./prepare/prepare-test-environment.ps1 '%arg1%' '%arg2%' '%arg3%' '%arg4%'"
EXIT /B