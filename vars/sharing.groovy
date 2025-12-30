def download(repo)
{
  git 'https://github.com/IntelliqDevops/${repo}'
}

def build()
{
  sh 'mvn package'
}

def deploy(name, ip, aname)
{
  sh 'scp /var/lib/jenkins/workspace/${name}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat10/${aname}.war'
}
def selinium(name)
{
  sh 'java -jar /var/lib/jenkins/workspace/${name}/testing.jar'
}
