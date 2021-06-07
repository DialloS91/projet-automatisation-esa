pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                bat "gradlew.bat clean test --tests "SearchProductTest.searchArticleAutocomplete""
            }
        }
    }
    post {
        always {
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: false, reportDir: 'build/reports/tests/test/', reportFiles: 'index.html', reportName: 'Test Report', reportTitles: ''])
        }
    }
}
