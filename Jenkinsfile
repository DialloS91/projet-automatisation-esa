pipeline {
    agent any

    stages {
        stage('Execution rights') {
            steps {
                bat "gradlew.bat clean test --tests ${params.testClass}"
            }
        }
        stage('Test') {
            steps {
                sh './gradlew clean test'
            }
        }
    }
    post {
        always {
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: false, reportDir: 'build/reports/tests/test/', reportFiles: 'index.html', reportName: 'Test Report', reportTitles: ''])
        }
    }
}
