# Releasing

1. Update the `version` in [gradle.properties](gradle.properties) to a non-`SNAPSHOT`.
2. Update [CHANGELOG.md](CHANGELOG.md)
  - Add the new version section and move the *unreleased changes* into it.
  - Update the links at the end of the page.
3. Update [README.md](README.md) with the new version.
4. Commit and push the changes to a new PR
  ```bash
  git commit -am "chore: prepare version X.Y.X"
  git push
  ```
5. Once the PR is merged, tag the release on the `main` branch
  ```bash
  git fetch
  git tag X.Y.Z origin/main
  git push origin X.Y.Z
  ```
6. Wait for the [publishing workflow](https://github.com/adevinta/spark-android/actions/workflows/publish.yml) to build and publish the release.
7. Update the `version` in [gradle.properties](gradle.properties) to the next `SNAPSHOT` version.
8. Commit and push the changes to a new PR
 ```bash
 git commit -am "chore: prepare next development version"
 ```
9. Check [Sonatype Nexus](Sonatype Nexus) to promote (close then release) the release. Or drop it if there is a problem!
