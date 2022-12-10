pipeline{
    agent {
        docker {image 'asuhail8/ecomm'}
    }
    stages{
        stage('Run regression tests'){
            steps{
                sh 'mvn test -Pregression'
            }
        }
       stage('Run error validation Tests'){
            steps{
                sh 'mvn test -PerrorHandling'
            }
            post{
                always{
                   archiveArtifacts artifacts: 'reports/index.html', followSymlinks: false 
                }
            }
        }
    }
}