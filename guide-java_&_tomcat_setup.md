#Install Tomcat and Java

##Manual (all OS's):

###Java:

	- Install latest version of Java JDK from http://www.oracle.com/technetwork/java/javase/downloads/index.html
	
###Tomcat:

	- Download Apache Tomcat Binary Distribution from http://tomcat.apache.org/
	- Decompress the contents to your computer:
		- Unix: `/opt/tomcat/`
		- Windows: `C:\tomcat\`
		- OS X: `/Applications/tomcat/`

---

##Mac:

###Links:
	- https://www.ntu.edu.sg/home/ehchua/programming/howto/MacUsers_HowTo.html

---

##Ubuntu:

###Java:

	- `java -version`
	- `apt-get install default-jdk`
	
###Tomcat:

**With apt-get:**

	- `apt-get install tomcat#`
	
**From binary:**

	- Download: `wget http://mirror.cc.columbia.edu/pub/software/apache/tomcat/tomcat-#/v#.#.##/bin/apache-tomcat-#.#.##.tar.gz`
	- Decompress: `tar xvzf apache-tomcat-#.*.**.tar.gz`
	- Move: `mv apache-tomcat-#.#.## /opt/tomcat`
	
###Configure `.bashrc`:

	- `vim ~/.bashrc`
	- Add to end of file:
		- `export JAVA_HOME=/usr/lib/jvm/default-java`
		- `export CATALINA_HOME-/opt/tomcat`
	- Save & exit, then make changes effective:
		- `. ~/.bashrc`
		
###Test & Run:

	- `$CATALINA_HOME/bin/startup.sh`
	- Verify by visiting <yourServerIpAddress>:8080
		- Example: http://127.0.0.1:8080

###Links:
	- http://www.liquidweb.com/kb/how-to-install-apache-tomcat-7-on-ubuntu-14-04/


##Stout:
**To take:**
	- CS-144 Computer Science I
	- CS-145 Computer Science II [p-144]
	- CS-244 Data Structures [p-145]
	- CS-245 Intro to Computer Organization [p-145]
		- (previously CS-241 [354-241] Assembly Language Programming)
		- Assembly Language for x96 Processors, 6th Ed., by Irvine (adopted Spring 12)
		- Guide to Assembly Language Programming in Linux, 1st Ed., by Dandamudi (adopted Spring 08)
		- Previous:
			- Assembly Language for Intel-Based Computers, 4th Ed., by Irvine (adopted S05)
			- Introduction to 80x86 Assembly Language, 1st Ed., by Detmer (adopted S03)
			- Assembly Language for Intel-Based Computers, 3rd Ed., by Irvine (adopted F99)
			- Assembly Language Programming, 2nd Ed., by Lemone (previously used)
	- CS-441 Computer Architecture [p-244]
	- CS-442 Systems Programming [p-441]
	
	- http://www.uwstout.edu/mscs/upload/cs-###.pdf