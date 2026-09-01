pipeline {
    agent any

    parameters {
    choice(
        name: 'BRANCH_NAME',
        choices: ['main', 'develop', 'release','std1_branch'],
        description: 'Select the branch to test'
    )
}
    stages {
        stage('Nexus_HealthCheck') {
            steps {
               bat 'ping 82.197.92.72 -n 5'
            }
        }
         stage('Download_Code_From_Github') {
            steps {
                git branch: params.BRANCH_NAME, url: 'https://github.com/sudheermca51/npulserepo.git'
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
