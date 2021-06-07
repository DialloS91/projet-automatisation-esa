pipeline {
    agent any
    parameters {
        string(name: 'testClass', defaultValue: '', description: 'Which Script should I launch')   
    }

    stages {
        stage('Test') {
            steps {
                def userInput = input(
                            id: 'userInput', message: 'inptu options and class to execute',
                            parameters: [

                                    string(defaultValue: '--tests',
                                            description: 'options',
                                            name: 'Option'),
                                    string(defaultValue: 'None',
                                            description: 'test script to execute',
                                            name: 'testClass'),
                            ])
                bat "gradlew.bat clean test ${userInput.Option} ${userInput.testClass}"
            }
        }
    }
    post {
        always {
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: false, reportDir: 'build/reports/tests/test/', reportFiles: 'index.html', reportName: 'Test Report', reportTitles: ''])
        }
    }
}
