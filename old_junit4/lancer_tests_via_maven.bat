set JAVA_HOME=C:\Program Files\Java\jdk-17
set MVN_HOME=C:\Prog\apache-maven-3.8.4

set PATH=%JAVA_HOME%/bin;%MVN_HOME%/bin;%PATH%

REM mvn test -Dtest=FastTestsSuite > resTest.txt 2>&1
REM dans jenkins "build_rapide_jour" avec "mvn test -Dtest=FastTestsSuite"

mvn test -Dtest=FastAndSlowTestsSuite > resTest.txt 2>&1
REM REM dans jenkins "build_complet_nuit" avec "mvn test -Dtest=FastAndSlowTestsSuite"
