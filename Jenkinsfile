pipeline{
    agent any
    stages{
        stage('Run regression tests'){
            steps{
                sh 'mvn test -Pregression'
            }
        }
       stage('Run Regression Tests'){
            steps{
                sh 'mvn test -Pregression'
            }
            post{
                always{
                   archiveArtifacts artifacts: 'reports/index.html', followSymlinks: false 
                }
            }
        }
    }
}