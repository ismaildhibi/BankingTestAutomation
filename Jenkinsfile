pipeline{
    agent any
    stages {
        
        stage('compile project') {
          steps {
   
                  
                  sh 'mvn clean compile'

          }
       }
        stage('test project') {
          steps {
                  
                  sh 'mvn test'
              }
        }
        stage('Report') {
        
        steps{
            
            	 echo 'Publish Allure report'
        publishHTML(
                target: [
                        allowMissing         : false,
                        alwaysLinkToLastBuild: false,
                        keepAll              : true,
                        reportDir            : 'target/',
                        reportFiles          : 'index.html',
                        reportName           : "Allure Report"
                ]
        )
            
        }

   				 
   			
  }
       }
       
       }
    

