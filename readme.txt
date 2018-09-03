config jndi @Tomcat
===================
add line to context.xml: 
    <Resource auth="Container" driverClassName="com.mysql.jdbc.Driver" maxActive="100" maxIdle="30" maxWait="10000" name="jdbc/MySqlEpatrolDB" password="PeppaPig0513" type="javax.sql.DataSource" url="jdbc:mysql://localhost:3306/epatrol" username="root"/>    
    <Resource auth="Container" driverClassName="com.mysql.jdbc.Driver" maxActive="100" maxIdle="30" maxWait="10000" name="jdbc/MySqlGamblingDB" password="PeppaPig0513" type="javax.sql.DataSource" url="jdbc:mysql://localhost:3306/rabbit_gamble" username="root"/> 
config using log4j @Tomcat
==========================
1. copy log4j.properties to $CATALINA_HOME\conf
2. edit log4j.properties to specify the logging location
	log4j.appender.file.File=./gamblehub.log
3. @Project/extra_libs/libs, copy (original name) tomcat-extras-juli-8.5.2.jar to (replace) $CATALINA_HOME/bin/tomcat-juli.jar (target name)
4. @Project/extra_libs/libs, copy all files including tomcat-extras-juli-adapters-8.5.2.jar to $CATALINA_HOME/lib

5. add line to tomcat start script:
	-Dlog4j.configuration="file:C:\apache-tomcat-8.5.31\conf\log4j.properties"
	-Dlog4j.configuration="file:/Library/Tomcat/conf/log4j.properties"
	-Dlog4j.configuration="file:C:\apache-tomcat-8.5.31\conf\log4j.properties" -Djava.awt.headless=true -Dfile.encoding=UTF-8 
	-server -Xms1536m -Xmx1536m
	-XX:NewSize=256m -XX:MaxNewSize=256m -XX:PermSize=256m 
	(if for eclipse, stop tomcat server, double click Tomcat v8.5 Server at localhost, @Open launch configuration, click Arguments tag and append line to the argument
	
remark:
===========
for some git hub client, it will have problem, solved it by:
In Eclipse Help -> Install New Software Work with: http://download.eclipse.org/mpc/releases/1.5.1a Select the "EPP Marketplace Client" Proceed with defaults
	
tomcat user (optional):
=======================
add the following lines to tomcat-users.xml

<role rolename="admin"/>
<role rolename="admin-gui"/>
<role rolename="manager-gui"/>
<user username="tomcat" password="tomcat" roles="admin,admin-gui,manager-gui"/>

Additional add (optional):
============================
aspect J
Eclipse Java EE Developer Tools 3.10
Error Log