pipeline {
    agent any
    stages {
        stage('Nexus_HealthCheck') {
            steps {
               bat 'ping 82.197.92.72 -n 5'
            }
        }
         stage('Download_Code_From_Github') {
            steps {
                git branch: params.BRANCH, url: 'https://github.com/sudheermca51/npulserepo.git'
            }
        }
          stage('Execute_Selenium_Tests') {
            steps {
                 dir('nexuspulse') {
                    bat 'mvn clean test'
                }
            }
        }
    }
}
