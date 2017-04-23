echo off
cls
cd src
echo Starting compile...
javac %1
echo The end of compile
java %2
echo The end
pause