# Releasing

## Pre-release

Before each release we will publish a Snapshot version of it and use it to create a pre release on [Github Release page](https://github.com/adevinta/spark-android/releases)

During a period of ~2 weeks consumers will be able to test it for bugs that can be fixed before it’s considered stable.

Using Github pre-release feature will allow Spark users to create a hook to notice that a new release has been made and test against it.
For example they could hook to it to make a bot post this changelog in their monitoring slack channel or trigger a CI build to certify that this new release doesn’t break their build.

1. First create a draft release that by creating a `*.*.*-SNAPSHOT` version tag.
2. Use this new tag to use the change log generation tool from GitHub.
3. Remove logs from Dependabot except if they mention big version upgrade for libraries used by our consumers (like Compose or Kotlin version upgrade).
5. 🪄 Format the logs to be close to the format we use for our [CHANGELOG%20STYLE%20GUIDE](./docs/CHANGELOG%20STYLE%20GUIDE.md).
6. If we’re satisfied with the draft now release it but as a ⚠️ **pre-release**.
7. Wait at ==least 2 weeks== for feedback from consumers on the stability of he release.
8. ???
9. Profit! 💹

## Release

1. Update the `version` in [gradle.properties](https://github.com/adevinta/spark-android/blob/main/gradle.properties) to a non-`SNAPSHOT`.
2. Update [CHANGELOG.md](https://github.com/adevinta/spark-android/blob/main/CHANGELOG.md)
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
6. Update the `version` in [gradle.properties](https://github.com/adevinta/spark-android/blob/main/gradle.properties) to the next `SNAPSHOT` version.
7. Commit and push the changes to a new PR
  ```bash
  git commit -am "chore: prepare next development version"
  ```
8. Go to [Sonatype Nexus](https://s01.oss.sonatype.org/) to promote ([docs & detailed steps](https://central.sonatype.org/publish/release/))
   ##### If there is a problem! and you wanna dismiss it just hit `Drop`
   #### If all looks good:
    1. `close` then wait till it completes
    2. `release` the artifact
9. Trigger the manual workflow [![📋 Publish Dokka to GitHub Pages](https://github.com/adevinta/spark-android/actions/workflows/dokka.yml/badge.svg)](https://github.com/adevinta/spark-android/actions/workflows/dokka.yml) with the version tag.
10. Draft a [new release](https://github.com/adevinta/spark-android/releases/new) with the version tag, add the corresponding [CHANGELOG.md](https://github.com/adevinta/spark-android/blob/main/CHANGELOG.md) entries, and publish it when ready.

---

## Hotfix

Hotfixes can sometimes be a bit tricky to do right. Please follow these steps carefully:

1. Create the hotfix remote branch (the `hotfix` prefix is important)
   ```bash
   git branch hotfix/X.Y.Z+1 refs/tags/X.Y.Z
   git push origin hotfix/X.Y.Z+1
   ```
2. Create a local hotfix PR branch
   ```bash
   git switch --create patch-hotfix-X.Y.Z+1 refs/tags/X.Y.Z
   ```
3. Commit the necessary changes and open a PR targeting the hotfix branch.
4. Once the PR is merged, you can continue with the regular release process described above.
5. Finally, merge these changes back to the main branch with a new PR
   ```bash
   git merge --no-ff refs/tags/X.Y.Z+1
   ```
