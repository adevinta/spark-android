# Releasing

1. Update the `version` in [gradle.properties](gradle.properties) to a non-`SNAPSHOT`.
2. Update [CHANGELOG.md](CHANGELOG.md)
  - Add the new version section and move the *unreleased changes* into it.
  - Update the links at the end of the page.
3. Commit and push the changes to a new PR
  ```bash
  git commit -am "chore: prepare version X.Y.X"
  git push
  ```
4. Once the PR is merged, tag the release on the `main` branch
  ```bash
  git fetch
  git tag X.Y.Z origin/main
  git push origin X.Y.Z
  ```
5. Wait for the [publishing workflow](https://github.com/adevinta/spark-android/actions/workflows/publish.yml) to build and publish the release.
6. Update the `version` in [gradle.properties](gradle.properties) to the next `SNAPSHOT` version.
7. Commit and push the changes to a new PR
 ```bash
 git commit -am "chore: prepare next development version"
 ```
8. Go to [Sonatype Nexus](https://s01.oss.sonatype.org/) to promote (close then release) the artifact ([docs & detailed steps](https://central.sonatype.org/publish/release/)). Or drop it if there is a problem!
9. Trigger the manual workflow [![📋 Publish Dokka to GitHub Pages](https://github.com/adevinta/spark-android/actions/workflows/dokka.yml/badge.svg)](https://github.com/adevinta/spark-android/actions/workflows/dokka.yml) with the version tag.
10. Draft a [new release](https://github.com/adevinta/spark-android/releases/new) with the version tag, add the corresponding [CHANGELOG.md](CHANGELOG.md) entries, and publish it when ready.
