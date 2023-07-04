REM set JAVA_HOME=C:\Program Files\Java\jdk-11.0.12
REM set JAVA_HOME=C:\Prog\java\eclipse\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_17.0.6.v20230204-1729\jre
set JAVA_HOME=C:\Program Files\Java\jdk-17
set MVN_HOME=C:\Prog\apache-maven-3.8.4
set PATH="%JAVA_HOME%/bin";"%MVN_HOME%/bin";%PATH%
java -version
git --version
REM mvn --version
java -jar jenkins.war --httpPort=8585
REM http://localhost:8585 au premier démarrage
REM copier/coller le code au premier démarrage et installer les plugins suggérés
REM créer le compte administrateur (admin,admin123)
REM choisir l'URL http://localhost:8585
pause