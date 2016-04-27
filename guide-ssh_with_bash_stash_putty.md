#Setting up SSH to work with Git Bash & Stash & Putty
**At a Bash terminal:**

  - `ssh-keygen -t rsa`
    - Press `Enter` to use default file name
    - Create your *passcode*
    - It auto-generates `~/.ssh/id_rsa.pub` and `~/.ssh/id_rsa`
  - `ssh-add ~/.ssh/id_rsa`
    - Enter *passcode*

**Open puTTYgen**

  - Select type of key to generate: `SSH-2 RSA`
  - Click 'Generate' (move your mouse!)
  - Leave 'Key comment:' as the default value
  - Enter and confirm a *passphrase* in the next two fields
  - Click 'Save public key' and save to `~/.ssh/public`
  - Click 'Save private key' to `~/.ssh/private`

**Copy shortcut of Pageant from PuTTY Start Menu folder to user Startup folder**

  - Right-Click > Properties on Pageant.lnk
  - Modify 'Target' - append ` private.ppk` to the end after `pageant.exe"`
  - Modify 'Start in:' - change contents to 'C:\Users\<yourUserAccount>\.ssh'

**Open Stash in a browser:**

  - Manage Account > SSH keys
  - Open the file `~.ssh/id_rsa.pub` in a text editor and copy the entire text
  - Click 'Add key' and paste the key into the text field. Remove any newlines if they are created
  - Click 'Save'
  
**Edit your `~/.bash_profile` file add add the following line(s) to the *top*:**

		#!/bin/bash
		if [ -f ~/.bashrc ]; then . ~/.bashrc; fi

**Edit (or create) your `~/.bashrc` file and add the following code:**
		#!/bin/bash
		
		SSH_ENV=$HOME/.ssh/environment
		
		# start the ssh-agent
		function start_agent {
		   echo "Initializing new SSH agent..."
		   # spawn ssh-agent
		   /usr/bin/ssh-agent | sed 's/^echo/#echo/' > "${SSH_ENV}"
		   echo succeeded
		   chmod 600 "${SSH_ENV}"
		   . "${SSH_ENV}" > /dev/null
		   /usr/bin/ssh-add
		}
		
		if [ -f "${SSH_ENV}" ]; then
		   . "${SSH_ENV}" > /dev/null
		   ps -ef | grep ${SSH_AGENT_PID} | grep ssh-agent$ > /dev/null || {
		  start_agent;
		   }
		else
		   start_agent;
		fi

**Finally, you'll have to make sure you have a local %HOME% system variable set:**

  - In command prompt type `echo %HOME%`
  - If it literally outputs '%HOME%' you'll need to set your HOME variable
  - Open the folder 'Development Guide' > 'Resources' and run 'System variables.exe'
  - Type 'HOME' in the drop-down box, then type 'C:\Users\<yourUserAccount>' in the text field below that
  - Click 'Set Variable'. The box on the right turns from red to green.
  - In command prompt type `echo %HOME%` again
  - It should now output 'C:\Users\<yourUserAccount>'

**Log off your Windows user**

**Now when you login to your Windows account, Pageant will ask for your *passcode* once. And your first session login to Bash will ask for your 'passcode' once too.**

**For each individual git project, from the terminal:**

  - `git remote -v` - lists current fetch & pull urls
  - Copy the Clone SSH url for the project in Stash, or just use the format `ssh://git@<git-repo-url>/<project_url_plus_project_name.git>`
  - `git remote set-url origin <paste the url here>`
  - `git remote -v` - verify both fetch & pull urls are now the one provided by Stash

---

##Bash Script for Changing Clone URLs
		
		clear
		echo ".--------------------------------------------."
		echo "|                                            |"
		echo "|    Set up git repository for remote ssh    |"
		echo "|                                            |"
		echo "'--------------------------------------------'"
		echo
		echo "Enter your github username:"
		read UNAME
		echo
		echo "Current remote urls:"
		echo "--------------------------------------------------------------------------------"
		git remote -v
		echo "--------------------------------------------------------------------------------"
		echo
		URLS="$(git remote -v)"
		echo
		echo "Parsing/updating git remote origin from username '$UNAME'..."
		echo
		echo "Success!"
		echo
		URLS=$(echo $URLS | sed 's/origin //g')
		URLS=(${URLS[@]})
		URLS=$(echo "${URLS[0]}")
		URLS=$(echo $URLS | sed 's/http:/ssh:/g')
		URLS=$(echo $URLS | sed 's/'$UNAME'@[[[old-repo-url]]]/git@[[[new-repo-url]]]/g')
		echo
		git remote set-url origin $URLS
		echo "New remote urls:"
		echo "--------------------------------------------------------------------------------"
		git remote -v
		echo "--------------------------------------------------------------------------------"
		echo