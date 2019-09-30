# hlaGenotypeEvaluator Development

Development requires three items:

* Java 8 or later (Java 11 suggested) JDK

* Maven (version 3.2+ suggested)

* The `haplObserve` JAR.

You may get haplObserve from one of two methods:

1. Check out the haplObserve repo, and run `mvn install` inside it.

   This method gets you the latest haplObserve, locally installed.  The
   downside is that you are running a potentially-unreleased version.

2. Download the haplObserve JAR file, and install that with this command:

       mvn install:install-file -Dfile=hapl-obs.jar -Dpackaging=jar -DgroupId=workshop.haplotype -DartifactId=hapl-obs -Dversion=X

   Replace `X` with the version number of the JAR file you have downloaded.
   And change `hapl-obs.jar` to the correct JAR file name.

Once all three items have been installed, development can proceed as normal
with a Java/Maven project.

# Automated Test and Release

This repository is configured to use Travis-CI for testing of commits.  It can
also be configured to generate release JAR files.  Testing is done by running
`mvn test` with Java 8 and 11.  The release JAR file is created using Java 11.

To enable Travis-CI for testing commits, first go to https://travis-ci.com, and
log in using GitHub.

Once you have logged in using GitHub, you should see your hlaGenotypeEvaluator
repository in the list.  Select the hlaGenotypeEvaluator repository, go to
_More options_, and choose _Settings_.

On the settings page, add two environment variables:

* Add a variable named `HAPL_OBS_URL`.  The value should be the URL to download
  a haplObs JAR file.

* Add a variable named `HAPL_OBS_VERSION`.  The value should be the version
  number of the haplObs JAR file that is being downloaded.

For both variables, _display value in build log_ should be turned on.  That
way, when you look at logs, you will know which version of haplObs was used for
the build.

At this point, configuration is complete.  The next time you do a push,
Travis-CI will see it, and run tests.  There will be two jobs: One job will
test with openjdk 8; the other job will test with openjdk 11.

## Configuring automated release

Travis-CI can also be configured to create a GitHub release every time you
create a new tag.

To enable releases, first you need to give Travis-CI a token to perform GitHub
actions as you.  To do this, go to https://github.com/settings/tokens and log
in.  Click the _Generate new token_ button.

When creating the token, you only need to provide access to the `public_repo`
scope.  All of the other checkboxes should be turned off.  This will give
Travis-CI access to make changes to your public repositories.  This is
required, because Travis-CI will be pushing files to GitHub for you.

Now that you have the token, go back to https://travis-ci.com, and log in.  Go
to your hlaGenotypeEvaluator repository, and go back to the _Settings_ page.
You will need to add a new environment variable:

* Add a variable named `GITHUB_OAUTH_TOKEN`.  The value should be the GitHub
  token.

For this variable, _display value in build log_ **must be turned off**.  This
is because the token is secret; anyone who has the token do things on your
GitHub account, without your permission.  The token should only be entered into
Travis-CI.  It should not be written down, or used anywhere else.

At this point, configuration is complete.  To make a release, you need to make
and push an annotated tag.

An annotated tag is a Git tag that has a message attached.  If you are using
the Git command line, the command is `git tag -a TAG_NAME`.  The `TAG_NAME`
should be the version number of the release (for example, `0.1.2`).  The tag's
message should be an explanation of what has changed in the release.

Once the annotated tag has been created, you should push it to GitHub.  If you
are using the Git command line, the command is `git push --tags`.  Travis-CI
will see that you have pushed a new tag, and run tests.

If the tests pass, Maven and openjdk11 will be used to create a release JAR
file, and a GitHub release will be created.  The release JAR file will contain
all dependencies, so users do not need to download anything else.

NOTE: Before the JAR file is created, Travis-CI will modify `pom.xml`, changing
the version number from `0.0.1-SNAPSHOT` to the version number you used as the
tag name.
