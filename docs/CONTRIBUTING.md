# Contributing

### Issues, Bugs, Feature or Component Requests

While we don't accept issues from people outside the Adevinta Platform to this repo currently, we
welcome [discussions and questions here](https://github.com/adevinta/spark-android/discussions/categories/general)!

## If you're part of the Adevinta Platform ⬇️

### Requirements

#### [git-lfs](https://git-lfs.com/)

This repository uses [cashapp/paparazzi](https://github.com/cashapp/paparazzi) for screenshot
testing purposes.  
If you introduce visible changes, you'll likely have to update screenshots files for the test to
pass.

```bash
# Install
brew install git-lfs
# Check
git lfs install
```

#### [java 17](https://github.com/adevinta/spark-android/issues/74)

We use AGP 8.1.0 which requires developers to use JDK 17 on Gradle JDK
If you're on macOS, you can install it with [brew](https://github.com/mdogan/homebrew-zulu/)

```bash
brew tap mdogan/zulu
brew install zulu-jdk17
```

or install it directly from Studio

[//]: # (https://files.slack.com/files-pri/T0182J7UXEH-F04RH9F5U2G/image.png)

[//]: # (https://files.slack.com/files-pri/T0182J7UXEH-F04RTEHLJQH/image.png)

### How do I make a proper pull request?

- Fork the project on GitHub
- Create a new branch
- Upload the changes to your branch
- Check the [style guidelines](https://github.com/akyoto/quality/blob/master/STYLE.md)
- Create a pull request

### What if I already made a pull request but want to add more commits?

If you correctly created a new branch for your changes, you can simply upload the new commits to
your fork and they will automatically appear in the PR.

## Pull Requests

The best way to make an impact is by creating code submissions called pull requests. Pull requests
should be ‘solutions’ to GitHub issues.

To make a pull request:

1. Make sure there’s a GitHub issue for the change you’re proposing.
2. [Fork](https://help.github.com/articles/fork-a-repo/) the repo for the platform your code works
   in.
3. Write code on a branch in your fork.
4. [Create a pull request](https://help.github.com/articles/creating-a-pull-request/) to merge your
   branch’s contributions into the corresponding Spark repo by following the .
5. The pull request will be triaged by a #spark-dev member and code reviewed by a
   #spark-contributors-android member.
6. If the pull request is accepted, the accepting #spark-dev member will merge the pull request for
   you.

### Code review

Regardless of language or platform, all code goes through code review before it can be merged into
main branches.

We use a set of tools to ensure that the code quality stays high and that the code is consistent
across the codebase.

So you might see :

- Some comments on your review from bots like automatic highlighting of lint warnings/errors
  introduced.
- We're using screenshot testing to ensure that the UI is not broken by changes. If you introduce
  visible changes, you'll likely have to update screenshots files for the test to pass.
- We're using commit convention for the PR title you can find more
  information [here](https://www.conventionalcommits.org/en/v1.0.0/).
