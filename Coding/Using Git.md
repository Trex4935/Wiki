# Using Git in Trex #

* Please note all values in `<>` are meant to be replace with the relevant values without the `<>`.
* `<name>-<task>` becomes `bob-newdrivetrain`

We use github.com to store all of the code for Trex4935.  This allows us the ability to roll back code, securely store code, maintain a backup, etc.  Use the following information to perform the various tasks needed for working with git and Trex.

## Cloning a Repository ##
To work on a repository you first need to download all of the code locally.

`git clone https://github.com/trex4935/<project>`

This will make a copy of the code locally on the machine.

## Branching ##
Any new work done should be done on a seperate branch of the code.  We don't want any changes being made to the main branch directly.  If you are starting work on a new set of code you will need to create a branch to do the work.  If you are continuing work that others have started you might need to download and checkout the branch.

### List Branches on the Computer ###
To list all branches that exist on a computer run:

`git branch`

The current checkedout branch will be marked with an * and will be green in color.

### List Remote Branches ###
To list all of the branches that are in the github that can be checked out:

`git branch --remote`

### New Branch ###
To create a new branch do the following:

`git branch <Name>-<Task>`

To verify the branch was created run:

`git branch`

The new branch should be listed in the output.

### Checkout and work on a local branch ###
As long as the branch appears in the output of `git branch` it can be checked out and modified using:

`git checkout <Branch Name>`

### Work on a remote branch ###
To checkout an existing remote branch we need to check it out and pull it local.

`git checkout –b <branch name> --track origin/<branch nane>`

Then ensure you have the latest copy of the branch

`git pull`

### Remove a local Branch ###
When a remote branch has been merged the local branch will remain on the system.
To remove the local branch:

`git checkout main`

To switch to the main branch

`git branch <branch name> -D`

To remove the branch