# Blend

A host your own homepage for blogging, collecting and sharing books, podcasts and links

# Run dependency check

Check the latest dependencies

`mvn versions:display-dependency-updates -DprocessDependencyManagement=false`

# Heroku

Upload to Heroku using the CLI

```
heroku login

heroku plugins:install java

heroku create --no-remote --region=eu teggr-some-app-name

heroku config --app=teggr-some-app-name

heroku config:set --app=teggr-some-app-name COM_ROBINTEGG_SOME_VALUE=a value

mvn package -Pproduction

heroku deploy:jar target\some-app-name-1.0-SNAPSHOT.jar --app 
teggr-some-app-name

heroku logs --tail teggr-some-app-name

heroku addons:create heroku-postgresql -a teggr-some-app-name

```