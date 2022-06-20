# spring-boot-seed
A skeleton Spring Boot project that can be used as a seed for new projects to further reduce time to get started

## Creating a fork from the seed project

1. Create a new repository - `<forked-repo>`
2. Clone your fork
   `git clone https://github.com/<username>/<forked-repo>.git`
3. Add your original repository as an Upstream Remote
   ```
   cd <forked-repo>
   git remote add seed https://github.com/teggr/spring-boot-seed.git
   ```
4. Update your fork
   `git pull seed main`
5. Push
   `git push origin master`

## Updating a fork from the seed project

1. Update your fork
   `git pull seed main`
2. Resolve any merge conflicts
   * Common merge conflicts to resolve - Readme.md, pom.xml, application.properties