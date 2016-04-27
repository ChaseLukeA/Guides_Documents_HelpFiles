#Unix File System

##`/`

root directory of whole file system hierarchy


##`/bin`

essential binaries for single user mode (e.g. `cat`, `ls`, `cp`)


##`/boot`

boot loader files (kernals, initrd)


##`/dev`

- interface to peripheral devices, disk partitions, etc

**Essential Devices:**

- block (`brw-rw----`) devices
	- disks, large fixed disks (e.g. bytes written at certain offsets are still there later)
- character (`crw-rw----`) devices
	- writing a byte has immediate effect (e.g. serial line, serial port); provide unbuffered, direct access to hardware device, also known as 'raw devices'
- link (`lrw-rw----`)
	- symbolic links
- socket (`srw-rw---`)
	- emit log messages [/dev/log]

**Pseudo Devices:**

- `/dev/null`
	- writing and reading never has effect (use in shell scripts to ignore output from command [>/dev/null] or run without input [</dev/null]); returns end-of-file indication on read
- `/dev/zero`
	- accepts/discards all in put; continuous stream of NUL (zero value) bytes
- `/dev/full`
	- continuous stream of NUL (zero value) bytes when read, returns "disk full" message when written to
- `/dev/random` && `/dev/urandom`
	- variable-length stream of pseudo-random numbers

**Naming Conventions:**

- `lp` - line printers
- `pt` - pseudo-terminals (virtual terminals)
- `tty` - terminals
- `ttyS` - serial port driver
- `ttyUSB` - usb serial converters, modems
- `fb` - frame buffer
- `fd` - floppy disks / file descriptors
- `hd` - 'classic' ide driver (ATA hdd, ATAPI odd)
- `hda` - master device on first ATA channel (major 3, minor 0)
- `hdb` - slave device on first ATA channel
- `hdc` - master device on second ATA channel
- `hdd` - slave device on second ATA channel
- `parport` && `pp` - parallel ports


##`/etc`

host-specific system-wide config files

**`/etc/opt`**

- config files for add-on packages stored in `/opt/`

**`/etc/sgml`**

- config files for catalogs and software processing SGML

**`/etc/x11`**

- config files for X Window System, version 11

**`/etc/xml`**

- config files for catalogs and software processing XML


##`/home`

user's home directories, personal files, personal settings, etc


##`/lib`

**libraries** essential for the binaries in `/bin/` and `/sbin/`

**`/lib<qual>`**

- alternate format essential libraries (optional)


##`/media`

mount points for removable media (e.g. CD-ROMS)


##`/mnt`

temporarily mounted filesystems


##`/opt`

optional application software packages (package managed)


##`/proc`

virtual filesystem providing process and kernel info such as files

- corresponds to a `procfs` mount in Linux


##`/root`

home director for the `root` user


##`/run`

run-time variable data - info about running system since last boot (currently logged-in users and running daemons)

- **daemon** - computer program that runs a background process rather than be in direct control of an interative user
	- process names of a daemon typically end in `d` to clarify it is a daemon
	- in Unix, parent process of daemon usually the `init` process
	- usually started at boot time to function as responding to network requests, hardware activity, etc
		- configure hardware (`udevd`), run scheduled tasks (`cron`), etc


##`/sbin`

essential system binaries (`fsck`, `init`, `route`)


##`/srv`

site-specific data for services provided by system


##`/tmp`

temp files, often not preserved between reboots


##`/usr`

secondary hierarchy for read-only user data; contains the majority of (multi-)user utilities and applications

**`/usr/bin`**

- non-essential command binaries (not needed in single user mode); for all users

**`/usr/include`**

- standard include files

**`/usr/lib`**

- libraries for the binaries in /usr/bin/ and /usr/sbin/

**`/usr/lib<qual>`**

- alternate format libraries (optional)

**`/usr/local`**

- tertiary hierarchy for local data, specific to this host; ypically has further subdirectories (e.g. `bin/`, `lib/`, `share/`)

**`/usr/sbin`**

- non-essential system binaries (e.g. daemons for various network-services)

**`/usr/share`**

- architecture-independent (shared) data

**`/usr/src`**

- source code (e.g. the kernel source code with its header files)

**`/usr/X11R6`**

- X Window System, Version 11, Release 6 (up to FHS-2.3, optional)


##`/var`

variable files (whose content is expected to continually change during normal system operation, e.g. logs, spools, temp email files)

**`/var/cache`**

- app cache data, generated as result of time-consuming I/O or calculation
	- files can be deleted without loss of data

**`/var/lib`**

- state information - persistent data modified by programs as they run (e.g. databases, packaging system metadata)

**`/var/lock`**

- lock files: keeping track of resources currently in use

**`/var/log`**

- log files

**`/var/mail`**

- user's mailboxes

**`/var/opt`**

- variable data from add-on packages stored in `/opt/`

**`/var/run`**

- run-time variable data: system info data describing system since booted
	- replaced by `/run` in FHS 3.0; symblink `/var/run` to `/run` for backward compatability

**`/var/spool`**

- spool for taskes waiting to be processed (e.g. print and outgoing mail queues)

**`/var/tmp`**

- temp files to be preserved between reboots


##Other Unix:

**Disassemble binary to get assembly code:**

	- GNU development tool `objdump` takes a `-d/--disassemble` flag:
		- `objdump -d </path/to/binary>`

####LINKS

	- http://stackoverflow.com/questions/5125896/how-to-disassemble-a-binary-executable-in-linux-to-get-the-assembly-code
	- http://www.mathemainzel.info/files/x86asmref.html

**Kernal Version:**

	- `uname -a`
	
**Distribution Information:**

	- `lsb_release -a` (Linux Standard Base)
	- `cat /etc/lsb-release`
	- `cat /etc/issue.net` >> 'Welcome to <distro>'
	- `ls /etc/ | grep release` >> list distro release file(s)
		- Example: `SuSE Linux Enterprise Server 11 (x86_64) >> Version 11 >> PatchLevel 3`
