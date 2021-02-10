pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    triggers {
        pollSCM 'H/2 * * * *'
    }

    stages {
            stage('Build and Test') {
                steps {
                    echo 'Building and testing ...'
                    sh 'mvn clean test'
                }
            }

            stage('Test Reporting') {
                steps {
                    echo 'Reporting....'
                    junit keepLongStdio: true, testResults: '**/target/surefire-reports/*.xml'
                    publishCoverage adapters: [jacocoAdapter('**/target/site/jacoco/jacoco.xml')]
                }
            }
    }

    post{
        unstable{
              mail to: 'sebastian_buege@gmx.de', from: 'jenkins@pi-data.com',
              subject: "Example Build: ${env.JOB_NAME} - Failed",
              body: "Job Failed - \"${env.JOB_NAME}\" build: ${env.BUILD_NUMBER}\n\nView the log at:\n ${env.BUILD_URL}\n\nBlue Ocean:\n${env.RUN_DISPLAY_URL}"
              }

        failure{
              mail to: 'sebastian_buege@gmx.de', from: 'jenkins@pi-data.com',
              subject: "Example Build: ${env.JOB_NAME} - Failed",
              body: "Job Failed - \"${env.JOB_NAME}\" build: ${env.BUILD_NUMBER}\n\nView the log at:\n ${env.BUILD_URL}\n\nBlue Ocean:\n${env.RUN_DISPLAY_URL}"
              }
    }
}
