#Setup Guides
---

https://sourceforge.net/projects/pdfsam/?source=navbar

---

##vim : Vundle

#####Execute in terminal:
		git clone https://github.com/VundleVim/Vundle.vim.git ~/.vim/bundle/Vundle.vim

#####Add to vimrc:
		" /--- VUNDLE ---------------------------------------\
		
		" Set filetype for Vundle (required)
		filetype off
		
		" Set runtime path for Vundle & initialize it
		set rtp+=~/.vim/bundle/Vundle.vim
		call vundle#begin()
		
		" Set Vundle to manage Vundle (required)
		Plugin 'VundleVim/Vundle.vim'
		
		" PLUGINS GO HERE IN 'Plugin 'pluginName'' format
		
		" Turn vundle runtime off (required)
		call vundle#end()
		
		" Set filetype back to normal
		filetype plugin indent on
		
		" \--- VUNDLE ---------------------------------------/

#####Install plugins:

- From within vim:

		`vim > :PluginInstall`

- From terminal:

		`vim +PluginInstall +qall`


#####Vundle URL:

- https://github.com/VundleVim/Vundle.vim

---

##vim : Pathogen

####Execute in terminal:

		mkdir -p ~/.vim/autoload ~/.vim/bundle && \
		curl -LSso ~/.vim/autoload/pathogen.vim https://tpo.pe/pathogen.vim
####Add to vimrc:

		execute pathogen#infect()
    
####Add plugins to vim directory:

		~/.vim/bundle/

		cd ~/.vim/bundle && \
		git clone [giturl]

---

##vim : Plugins

- link: http://benmccormick.org/2014/07/21/learning-vim-in-2014-getting-more-from-vim-with-plugins/

###nerdtree

#####Execute in terminal:

		cd ~/.vim/bundle
		git clone https://github.com/scrooloose/nerdtree.git

#####Get help in vim:

- load vim and run `:Helptags` and check out `:help NERD_tree.txt`

#####NerdTree URL:

- https://github.com/scrooloose/nerdtree

---

##YouCompleteMe

#####YouCompleteMe URL:

- https://github.com/Valloric/YouCompleteMe

---
---


##Eclipse Setup
####Install:
- Color Themes Plugin
	- RecognEyes theme 
- Jeeeyul's Theme Plugin
	- Default Presets > Minimalist
	- Custom CSS:
		- `Tree, List, Table { background-color: #cccccc; color: #000000; }`
- Fonts:
	- Input-Font
	- Source-Code-Pro
	- Droid-Sans-Mono
	- Ubuntu-Mono


---
---
##Notepad++ Setup
####Install:
- Compare
- Converter
- TextFX Characters
- ViSimulator

####http://beebom.com/2015/10/notepad-for-mac-os-x

VisualStudioCode
Komodo Edit
TextMate
jEdit




####Links:
- http://stackoverflow.com/questions/3866471/eclipses-package-explorer-background-color-follows-windows-theme-i-want-to-cha

---
---

##LINKS
**Markdown-PDF Converter** - http://www.markdowntopdf.com/

**iText 1.2.3**
	- https://www.versioneye.com/java/com.lowagie:itext/1.2.3
	- http://mvnrepository.com/artifact/com.lowagie/itext/1.2.3