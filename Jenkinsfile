pipeline {
    agent any
    stages{
        stage('Run Regression tests'){
            steps {
                sh "mvn test -Pregression"
            }
        }
        stage('Run errorHandling tests'){
            steps {
                sh "mvn test -PerrorHandling"
            }
        }
        stage('Run purchase tests'){
            steps {
                sh "mvn test -Ppurchase"
            }
        }
        post{
            always {
            archiveArtifacts artifacts: 'reports/index.html', followSymlinks: false
            }
        }
    }
}