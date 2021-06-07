pipeline {
    agent any
    parameters {
        string(name: 'testClass', defaultValue: '', description: 'Which Script should I launch')   
    }

    stages {
        stage('Test') {
            script {
            def userInput = input(
                            id: 'userInput', message: 'Enter path of test reports:?',
                            parameters: [

                                    string(defaultValue: 'None',
                                            description: 'Path of config file',
                                            name: 'Config'),
                                    string(defaultValue: 'None',
                                            description: 'Test Info file',
                                            name: 'Test'),
                            ])
            }
            steps {
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
