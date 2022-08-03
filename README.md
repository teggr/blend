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

TODO: edit links
TODO: link of the day

TODO: search titles for links (general search?)

TODO: bookshelf

TODO: blog
TODO: generate link bundle for blogging entry

TODO: rss feeds

TODO: individual tags

TODO: front page / tags aggregated view 
  * implemented union view + immutable entity
  * single index that tracks all content?
    * id + date_added?
    * mappedsuperclass?

@MappedSuperclass
class Content {
    @OneToOne
    private DocumentIndex index;
    private Instant dateAdded;
}

// extends on a per table basis - common attribute index_id (move dateadded to super class?)
class Podcast extends Content {

} 

// has own repository
class DocumentIndex {
    @Id
    private Long id;
    @OneToOne
    private Content content;
}