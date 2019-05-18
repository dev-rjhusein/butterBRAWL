
# butterBRAWL-Spring
<img src="http://butterbrawl.sytes.net/bblogo-small.png" alt="ButterBRAWL Logo">
<h4>Weight-loss competition web app with Spring</h4>

I built this web app to support a friendly weight-loss competition my family decided to have. As I began to build it,
I relized the potential it had and decided to build more features into the app. Originally built using the LAMP stack, 
I decided to focus on building my experience with Java and the Spring Framework. I re-built it with these technologies
and packaged it into a war file to be deployed on a Tomcat server. This is a work in progress.

Take a gander at the work in progress! http://butterbrawl.sytes.net:8080 (<strike>The 8080 port features the Java Spring rebuild. Port 80 [default HTTP] hosts the LAMP version, which has some bugs and is not as stable</strike>)
The original (port 80) now redirects to the Spring version. No one was using it anymore.
http://butterbrawl.sytes.net

<i><b>Please be patient as this is hosted on a 1.4GHz 64-bit quad-core processor (Raspberry Pi 3 B+) and will load slowly</b></i>

<b>Create your own group and account, or test it out with the default credentials:</b>
<ul>
    <li>Group: 'test.group.1'</li>
    <li>Username: 'user'</li>
    <li>Password: 'password'</li>
</ul>

Download the .war file and execute the current SNAPSHOT version from your own machine! Visit: http://butterbrawl.sytes.net/download_spring_war.html
Requires Java 8 or higher.


This is a re-build of my original butterBRAWL web app, built with PHP, now powered with the Java Spring Framework. 

New Features:

	-Email confirmation on user creation

    -Record new weight logs

    -Delete user account with confirmation

    -Group Initialization - User rankings are relative to the group they are in.
  
    -Password encryption - Passwords are no longer stored as plain text
  
    -Few .css updates allow for better user experience both on desktop and mobile devices
  
  
Planned Features (To be added):
  
    -Reset password if forgotten
  
    -Statistical graph on user's progress in weight-loss journey
  
    -Group vs Group rankings
  
    -Excercise and Diet tips and reminder notifications (Email or Text)
  
