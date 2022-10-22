pipeline{
    agent any
    stages{
        stage('Run errorHandling tests'){
            steps{
                sh 'mvn test -PerrorHandling'
            }
        }
        stage('Run regression tests'){
            steps{
                sh 'mvn test -Pregression'
            }
        }
        stage('Run purchase tests'){
            steps{
                sh 'mvn test -Ppurchase'
            }
        }
    }
}