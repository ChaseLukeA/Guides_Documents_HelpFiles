#Bash Scripting
---

##Making Executable Bash Scripts
- http://tldp.org/LDP/Bash-Beginners-Guide/html/sect_02_01.html

#####Top of .sh file:

		#!/bin/bash

#####Save .sh file to:

		~/scripts/

#####Terminal prompt:

		export PATH="$PATH:~/scripts"
		cd ~/scripts
		chmod u+x script_name.sh

#####Running scripts:
- If saved in ~/scripts and is executable:

		script_name.sh

- If not saved in ~/scripts and is executable:

		./script_name.sh

- Executed by a given shell:

		rbash script_name.sh
		sh script_name.sh
		bash script_name.sh

- Executed in current shell (no execute permission needed, any changes stay visible when script finishes execution:

		source script_name.sh    

---

#####Running scripts in current shell (not sub-shell):

	source scriptName.sh

---

##Bash Profile `.bash_profile`

	#!/bin/bash
	if [ -f ~/.bashrc ]; then . ~/.bashrc; fi
	alias lsa="ls -alh | less"
	cd ~/

---

##Bash RC `.bashrc`

	#!/bin/bash
	
	PATH="$PATH:<yourScriptsPath>"
	
	
	# SSH Stuff
	#-----------
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

##Links

- http://www.linuxtopia.org/online_books/advanced_bash_scripting_guide/special-chars.html

- http://www.grymoire.com/Unix/Sed.html


---
---