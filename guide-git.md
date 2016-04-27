#Git
---

##Branch Naming Convention

- Bugfix
- Feature
- Hotfix
- Release
- Custom


##Git Ignore `.gitignore`

**A list of files for git to ignore**

- A typical .gitignore list:

		/target
		/logs
		/bin
		/.settings
		/.classpath


##Git Config `.gitconfig`
	
	[user]
		name = <username>
		email = <email>
	
	[alias]
	#GENERAL
		# status
		s = status
		st = status
		# short status
		ss = status -s
		# log
		l = log
		ll = log
		# short log
		ls = !echo && git log --pretty=oneline --abbrev-commit
		# list aliases
		alias = !git config -l | grep alias | cut -c 7- | sed 's/=/\t-> /'
		
	#BRANCH
		# checkout
		co = checkout
		# list branches
		b = branch
		br = branch
		# create and checkout branch
		bc = checkout -b
		# delete branch
		bd = branch -D
		# rename branch [usage: git bmv <old_name> <new_name>]
		bmv = branch -m
		
	#COMMIT
		# add all
		aa = add -A
		# commit with message
		c = commit -m
		# commit changed with message
		cc = commit -am
		# ammend last commit message
		ca = commit --amend
		# add new and commit all changed
		cnc = !git aa && git cc
		
	#STASH
		# stash
		stc = stash
		# stash list
		stl = stash list
		# stash pop
		stp = stash pop
		# stash apply
		sta = stash apply
		
	# REMOTE
		# clone repository
		cl = clone
		# pull
		pp = pull
		# push
		p = push
		# fetch
		f = fetch
		# show remotes
		rem = remote -v
	[push]
		default = upstream
	[core]
		autocrlf = input
	[diff]
		tool = vimdiff
	[difftool]
		prompt = false
	[merge]
		tool = vimdiff
	[sendpack]
		sideband = false
		


##Commands

`gitk` - open GUI version to compare files

`git remote -v` - see remote location url

`git commit --amend` - ammend the last message

---
---

##Troubleshooting

- **https://github.com/blog/2019-how-to-undo-almost-anything-with-git**

**Allow git to stop hanging:**

`git config --global sendpack.sideband false`

- Fix is for https://github.com/msysgit/git/issues/101 in release https://github.com/msysgit/msysgit/releases/tag/Git-1.9.4-preview20140611

**Issues with origin and local:**

`git pull --rebase`

**Revert a commit (saving new commit with reverted changes):**

`git revert <sha1>`

**Reset repo to a previous commit:**

`git reset <last_good_sha1>`

---
---


Using Eclipse for Git Projects:
Eclipse:
	Window > Open Perspective > Other > Git
Browser:
	http://git.menards.net/projects > IS Tools Project > Repo
	*** > Create Branch > Select <type> > Enter <username> > Create Branch
	*** > Clone > Copy URL
Eclipse (Git Perspective):
	Clone Button (middle of folder-like ones)
	Paste URL
	Enter username, password
	Next through tracking all other branches
	Local Destination > working directory
		Initial Branch > feature branch created > Finish
	Right-click Git repo in Eclipse > Import Projects... > Import Existing Projects
	Select Java Perspective
