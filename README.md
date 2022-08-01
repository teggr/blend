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

heroku create --no-remote --region=eu teggr-blend

heroku config --app=teggr-blend

# set config
heroku config:set --app=teggr-blend SPRING_SECURITY_USER_NAME=
heroku config:set --app=teggr-blend SPRING_SECURITY_USER_PASSWORD=

mvn package -Pproduction

heroku deploy:jar --app=teggr-blend --jdk=17 target\some-app-name-1.0-SNAPSHOT.jar

heroku logs --tail --app=teggr-blend

heroku addons:create heroku-postgresql -a teggr-blend

```

TODO: tags for links
TODO: pagination for links
TODO: search titles for links
TODO: import pocket opml
