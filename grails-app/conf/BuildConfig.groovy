grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.repos.intelligrape.url = "http://plugin-repo.qa3.intelligrape.net/artifactory/plugins-release-local"
grails.project.repos.default = "intelligrape"
grails.project.repos.intelligrape.type = "maven"
grails.project.repos.intelligrape.username = "admin"
grails.project.repos.intelligrape.password = "password"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        //mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.13'

        plugins {
            build(":release:1.0.1") {
                excludes "svn"
            }
        }

        // Required for the Release Plugin (JAR) - must be COMPILE scope.
        compile "org.tmatesoft.svnkit:svnkit:1.2.3.5521"
    }
}
