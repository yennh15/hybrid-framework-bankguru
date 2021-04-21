set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath% 
set p=%PATH%
java -javaagent:"%ProjectPath%libAllureReport\aspectjweaver-1.8.10.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllureReport\*;%ProjectPath%libAllureReport\*;%ProjectPath%libLog4j\*;%ProjectPath%libraries\*;%ProjectPath%libTestNGReport\*;%ProjectPath%libWebDriverManager\*" org.testng.TestNG "%ProjectPath%bin\runnopCommerceTestcasesFull.xml"
allure serve ./allure-results

