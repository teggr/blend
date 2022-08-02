@ECHO OFF
ECHO "[STARTING BUILD]"
call mvn clean package
ECHO "[STARTING DEPLOY]"
call heroku deploy:jar --app=teggr-blend --jdk=17 target\blend-platform-0.0.1-SNAPSHOT.jar
ECHO "[DONE]"