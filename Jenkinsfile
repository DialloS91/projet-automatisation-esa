pipeline {
    agent any
    parameters {
        string(name: 'option', defaultValue: '', description: 'option for gradle')  
    }

    stages {
        stage('Test') {
            steps {
                bat "gradlew.bat clean test ${params.option}"
            }
        }
    }
    post {
        always {
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: false, reportDir: 'build/reports/tests/test/', reportFiles: 'index.html', reportName: 'Test Report', reportTitles: ''])
        }
    }
}
