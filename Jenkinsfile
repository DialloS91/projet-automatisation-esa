pipeline {
    agent any
    parameters {
        string(name: 'testClass', defaultValue: 'None', description: 'Which Script should I launch')   
    }

    stages {
        stage('Test') {
            steps {
                bat "gradlew.bat clean test --tests ${params.testClass}"
            }
        }
    }
    post {
        always {
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: false, reportDir: 'build/reports/tests/test/', reportFiles: 'index.html', reportName: 'Test Report', reportTitles: ''])
        }
    }
}
