Note that I haven't looked at other established CONTRIBUTING.md files for reference, so this file might be weird. I'll eventually look at more and update this if needed.
## Simple workflow
1. Choose an issue from the project board
2. Assign yourself to it
3. Branch from the feature's team branch (ex. 26.2-M if feature is related to Mech)
4. Make your changes
5. Open a pull request
  - If the PR closes an issue, put `Closes #123` where 123 is the issue number
    - Closes is a keyword which causes it to automatically close the issue when the PR is merged. There are other keywords that do this, but I just stick to `closes`.


## Creating issues
- The name may lead you to think issues are only for bugs and things that need to be fixed, but they're also used for ideas and features!
- **Features** (blocks, items, machines): Make a parent issue for the feature, with sub-issues for each piece (base implementation, recipe additions, texture/model, etc.)
  - Sub-issues should have their parent in their name (`parent: base implementation`) 
  - ex. To add a Basin block, the parent issue would be named `Basin block`, and a sub-issue would be `basin: add recipes`
- Be sure to always set a type and team when creating an issue. Use labels when needed.
  - Teams indicate what team it's designated to, which is used to determine what board it should be listed in for the project board.

## Branches

## Commits
- Commit small and often

## Pull requests
- Link the issue in the description with `Closes #12` (the specific sub-issue, not the parent).


 
